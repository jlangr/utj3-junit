package scratch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import util.ExpectToFail;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.Month.MAY;
import static java.util.regex.Pattern.compile;
import static org.assertj.core.api.Assertions.assertThat;

public class SomeAssertJExamples {
    String name = "my big fat acct";

    @Nested
    class StringMatching {
        @Test
        void equality() {
            // START:equality
            assertThat(name).isEqualTo("my big fat acct");
            // END:equality
        }

        @Test
        void notEqual() {
            // START:notEqual
            assertThat(name).isNotEqualTo("plunderings");
            // END:notEqual
        }

        @Test
        void type() {
            // START:type
            assertThat(name).isInstanceOf(String.class);
            // END:type
        }

        @Test
        void regex() {
            // START:regex
            assertThat(name).containsPattern(
                compile("\\s+(big fat|small)\\s+"));
            // END:regex
        }

        @Test
        void chainedMatchers() {
            // START:chained
            assertThat(name)
                .startsWith("my")
                .endsWith("acct");
            // END:chained
        }

        @ExpectToFail
        @Test
        public void matchesFailure() {
            // START:failure
            assertThat(name).containsPattern(
                compile("\\s+(large|little)\\s+"));
            // END:failure
        }
    }

    @Nested
    class ListContainmentAndSubsetPredicates {
        // START:lists
        @Test
        public void simpleListTests() {
            var names = List.of("Moe", "Larry", "Curly");

            assertThat(names).contains("Curly");
            assertThat(names).contains("Curly", "Moe");
            assertThat(names).anyMatch(name -> name.endsWith("y"));
            assertThat(names).allMatch(name -> name.length() < 6);

            // END:lists
            // START:listsFailure
            assertThat(names).allMatch(name -> name.length() < 5);
            // END:listsFailure
            // START:lists
        }
        // END:lists
    }

    @Nested
    class Extraction {
        private List<Flight> flights;

        // START:SegmentAndFlight
        record Segment(String origin, String destination, int distance) {
            // ...
            // END:SegmentAndFlight
            boolean includes(String airportCode) {
                return origin.equals(airportCode) || destination.equals(airportCode);
            }
            // START:SegmentAndFlight
        }

        record Flight(Segment segment, LocalDateTime dateTime) {
            Flight(String origin, String destination, int distance, LocalDateTime dateTime) {
                this(new Segment(origin, destination, distance), dateTime);
            }

            // ...
            // END:SegmentAndFlight
            boolean includes(String airportCode) {
                return segment.includes(airportCode);
            }
            // START:SegmentAndFlight
        }
        // END:SegmentAndFlight

        @BeforeEach
        void setup() {
            var dateTime = LocalDateTime.of(2025, MAY, 1, 9, 30);
            flights = List.of(
                new Flight("BWI", "ORD", 621, dateTime),
                new Flight("BWI", "DEN", 1487, dateTime),
                new Flight("BWI", "LGA", 185, dateTime),
                new Flight("BWI", "LAX", 2324, dateTime),
                new Flight("DEN", "ORD", 886, dateTime),
                new Flight("DEN", "LGA", 1615, dateTime),
                new Flight("DEN", "LAX", 861, dateTime)
            );
        }

        // START:filterAndExtract
        @Test
        void filterAndExtract() {
            // ...

            assertThat(flights).filteredOn(flight -> flight.includes("DEN"))
                .extracting("segment.distance")
                .allMatch(distance -> Integer.parseInt(distance.toString()) < 1700);
        }
        // END:filterAndExtract
    }
}

package scratch;

import java.util.HashMap;
import java.util.Map;

public class TimePool {
    private static Map<String, Time> times = new HashMap<>();

    static void reset() {
        times.clear();
    }

    public static Time get(byte hour, byte minute) {
        return times.computeIfAbsent(Time.key(hour, minute),
                k -> new Time(hour, minute));
    }
}

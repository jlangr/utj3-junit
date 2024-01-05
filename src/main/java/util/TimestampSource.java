package util;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class TimestampSource {
    private static final LinkedList<LocalDateTime> storedTimes = new LinkedList<>();

    public static void queueNextTime(LocalDateTime timestamp) {
        storedTimes.add(timestamp);
    }

    public static LocalDateTime now() {
        if (storedTimes.isEmpty())
            return LocalDateTime.now();
        return storedTimes.removeFirst();
    }

    public static boolean isExhausted() {
        return storedTimes.isEmpty();
    }

    public static void emptyQueue() {
        storedTimes.clear();
    }
}

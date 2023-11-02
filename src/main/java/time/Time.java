package time;

import static java.lang.String.format;

// START:TimePool
public record Time(byte hour, byte minute) {
    static String key(byte hour, byte minute) {
        return format("%d:%d", hour, minute);
    }

    @Override
    public String toString() {
        return key(hour, minute);
    }
}

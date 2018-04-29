package lowe.mike.timestampapp.model;

import java.util.Objects;

public class TimestampResponse {

    public static final TimestampResponse EMPTY = new TimestampResponse(null, null);

    private final Long unix;
    private final String natural;

    public TimestampResponse(Long unix, String natural) {
        this.unix = unix;
        this.natural = natural;
    }

    public Long getUnix() {
        return unix;
    }

    public String getNatural() {
        return natural;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimestampResponse that = (TimestampResponse) o;
        return Objects.equals(unix, that.unix) &&
                Objects.equals(natural, that.natural);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unix, natural);
    }

    @Override
    public String toString() {
        return "TimestampResponse{" +
                "unix=" + unix +
                ", natural='" + natural + '\'' +
                '}';
    }

}

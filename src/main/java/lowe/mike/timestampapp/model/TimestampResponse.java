package lowe.mike.timestampapp.model;

import java.util.Objects;

/**
 * Stores timestamp details.
 *
 * @author Mike Lowe
 */
public class TimestampResponse {

  public static final TimestampResponse EMPTY = new TimestampResponse(null, null);

  private final Long unix;
  private final String natural;

  /**
   * Creates a new {@code TimestampResponse}.
   *
   * @param unix    the unix value
   * @param natural the natural value
   */
  public TimestampResponse(final Long unix, final String natural) {
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
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final TimestampResponse that = (TimestampResponse) o;
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

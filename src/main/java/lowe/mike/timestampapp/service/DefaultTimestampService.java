package lowe.mike.timestampapp.service;

import lowe.mike.timestampapp.model.TimestampResponse;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static java.util.Objects.requireNonNull;

/**
 * Default implementation of {@link TimestampService}
 * that takes a date string and returns a {@link TimestampResponse}.
 *
 * @author Mike Lowe
 */
public class DefaultTimestampService implements TimestampService {

  private final DateTimeFormatter formatter;

  /**
   * Creates a new {@code DefaultTimestampService}.
   *
   * @param formatter the {@link DateTimeFormatter}
   * @throws NullPointerException if {@code formatter} is {@code null}
   */
  public DefaultTimestampService(final DateTimeFormatter formatter) {
    this.formatter = requireNonNull(formatter, "formatter cannot be null");
  }

  @Override
  public TimestampResponse convert(final String s) {
    if (s == null) {
      return TimestampResponse.EMPTY;
    }

    return isLong(s) ? parseUnix(s) : parseNatural(s);
  }

  private boolean isLong(final String s) {
    try {
      Long.parseLong(s);
      return true;
    } catch (final NumberFormatException e) {
      return false;
    }
  }

  private TimestampResponse parseUnix(final String s) {
    final long unix = Long.parseLong(s);
    try {
      final Instant instant = Instant.ofEpochSecond(unix);
      final String natural = formatter.format(instant);
      return new TimestampResponse(unix, natural);
    } catch (final DateTimeException e) {
      return TimestampResponse.EMPTY;
    }
  }

  private TimestampResponse parseNatural(final String natural) {
    try {
      final LocalDate localDate = LocalDate.parse(natural, formatter);
      final long unix = localDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC);
      return new TimestampResponse(unix, natural);
    } catch (final DateTimeParseException e) {
      return TimestampResponse.EMPTY;
    }
  }

}

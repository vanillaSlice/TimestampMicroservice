package lowe.mike.timestampapp.service;

import lowe.mike.timestampapp.model.TimestampResponse;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class DefaultTimestampServiceTests {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  private final DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("MMMM dd, yyyy").withZone(ZoneId.systemDefault());

  private final TimestampService service = new DefaultTimestampService(formatter);

  @Test
  public void constructor_nullFormatter_throwsNullPointerException() {
    expectedException.expect(NullPointerException.class);
    expectedException.expectMessage("formatter cannot be null");

    new DefaultTimestampService(null);
  }

  @Test
  public void convert_withNull_returnsEmptyTimestampResponse() {
    final TimestampResponse expected = TimestampResponse.EMPTY;
    final TimestampResponse actual = service.convert(null);

    assertEquals(expected, actual);
  }

  @Test
  public void convert_withUnixTimestamp_returnsTimestampResponse() {
    final TimestampResponse expected = new TimestampResponse(1450137600L, "December 15, 2015");
    final TimestampResponse actual = service.convert("1450137600");

    assertEquals(expected, actual);
  }

  @Test
  public void convert_withUnixTimestamp_returnsEmptyTimestampResponse() {
    final TimestampResponse expected = TimestampResponse.EMPTY;
    final TimestampResponse actual = service.convert("14501376001450137600");

    assertEquals(expected, actual);
  }

  @Test
  public void convert_withNaturalDate_returnsTimestampResponse() {
    final TimestampResponse expected = new TimestampResponse(1450137600L, "December 15, 2015");
    final TimestampResponse actual = service.convert("December 15, 2015");

    assertEquals(expected, actual);
  }

  @Test
  public void convert_withNaturalDate_returnsEmptyTimestampResponse() {
    final TimestampResponse expected = TimestampResponse.EMPTY;
    final TimestampResponse actual = service.convert("December 155 2015");

    assertEquals(expected, actual);
  }

}

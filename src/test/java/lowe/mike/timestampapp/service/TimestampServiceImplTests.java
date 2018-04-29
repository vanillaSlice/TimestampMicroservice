package lowe.mike.timestampapp.service;

import lowe.mike.timestampapp.model.TimestampResponse;
import org.junit.Test;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class TimestampServiceImplTests {

    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("MMMM dd, yyyy").withZone(ZoneId.systemDefault());

    private final TimestampService service = new TimestampServiceImpl(formatter);

    @Test
    public void convert_withUnixTimestamp_valid() {
        TimestampResponse expected = new TimestampResponse(1450137600L, "December 15, 2015");
        TimestampResponse actual = service.convert("1450137600");

        assertEquals(expected, actual);
    }

    @Test
    public void convert_withUnixTimestamp_invalid() {
        TimestampResponse expected = TimestampResponse.EMPTY;
        TimestampResponse actual = service.convert("14501376001450137600");

        assertEquals(expected, actual);
    }

    @Test
    public void convert_withNaturalDate_valid() {
        TimestampResponse expected = new TimestampResponse(1450137600L, "December 15, 2015");
        TimestampResponse actual = service.convert("December 15, 2015");

        assertEquals(expected, actual);
    }

    @Test
    public void convert_withNaturalDate_invalid() {
        TimestampResponse expected = TimestampResponse.EMPTY;
        TimestampResponse actual = service.convert("December 155 2015");

        assertEquals(expected, actual);
    }

}

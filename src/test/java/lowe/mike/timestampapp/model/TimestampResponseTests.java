package lowe.mike.timestampapp.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimestampResponseTests {

    @Test
    public void test_properties() {
        TimestampResponse response = new TimestampResponse(1450137600L, "December 15, 2015");

        assertEquals((Long) 1450137600L, response.getUnix());
        assertEquals("December 15, 2015", response.getNatural());
    }

    @Test
    public void test_equalsAndHashCode() {
        EqualsVerifier
                .forClass(TimestampResponse.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void test_toString() {
        TimestampResponse response = new TimestampResponse(1450137600L, "December 15, 2015");

        String expected = "TimestampResponse{unix=" + 1450137600L + ", natural='December 15, 2015'}";
        String actual = response.toString();

        assertEquals(expected, actual);
    }

}

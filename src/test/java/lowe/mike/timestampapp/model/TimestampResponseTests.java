package lowe.mike.timestampapp.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

/**
 * {@link TimestampResponse} tests.
 *
 * @author Mike Lowe
 */
public class TimestampResponseTests {

  @Test
  public void equalsAndHashCode() {
    EqualsVerifier.forClass(TimestampResponse.class)
        .usingGetClass()
        .verify();
  }

}

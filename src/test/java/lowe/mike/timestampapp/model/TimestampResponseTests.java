package lowe.mike.timestampapp.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class TimestampResponseTests {

  @Test
  public void equalsHashCodeContract() {
    EqualsVerifier.forClass(TimestampResponse.class)
        .usingGetClass()
        .verify();
  }

}

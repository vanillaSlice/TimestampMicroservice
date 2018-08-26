package lowe.mike.timestampapp.controller;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TimestampControllerTest {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void constructor_nullTimestampService_throwsNullPointerException() {
    expectedException.expect(NullPointerException.class);
    expectedException.expectMessage("timestamp service cannot be null");

    new TimestampController(null);
  }

}

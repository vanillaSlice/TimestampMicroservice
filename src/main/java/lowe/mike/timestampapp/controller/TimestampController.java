package lowe.mike.timestampapp.controller;

import lowe.mike.timestampapp.model.TimestampResponse;
import lowe.mike.timestampapp.service.TimestampService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.requireNonNull;

/**
 * Timestamp controller.
 *
 * @author Mike Lowe
 */
@RestController
public class TimestampController {

  private final TimestampService timestampService;

  /**
   * Creates a new {@code TimestampController}
   *
   * @param timestampService the {@link TimestampService}
   * @throws NullPointerException if {@code timestampService} is {@code null}
   */
  public TimestampController(final TimestampService timestampService) {
    this.timestampService = requireNonNull(timestampService, "timestamp service cannot be null");
  }

  @GetMapping(value = "/convert/{date}")
  public TimestampResponse convert(@PathVariable("date") final String date) {
    return timestampService.convert(date);
  }

}

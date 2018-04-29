package lowe.mike.timestampapp.controller;

import lowe.mike.timestampapp.model.TimestampResponse;
import lowe.mike.timestampapp.service.TimestampService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimestampController {

    private final TimestampService timestampService;

    public TimestampController(TimestampService timestampService) {
        this.timestampService = timestampService;
    }

    @RequestMapping(value = "/convert/{date}", method = RequestMethod.GET)
    public TimestampResponse convert(@PathVariable("date") String date) {
        return timestampService.convert(date);
    }

}

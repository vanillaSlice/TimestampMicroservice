package lowe.mike.timestampapp.service;

import lowe.mike.timestampapp.model.TimestampResponse;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimestampServiceImpl implements TimestampService {

    private final DateTimeFormatter formatter;

    public TimestampServiceImpl(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public TimestampResponse convert(String s) {
        return isLong(s) ? parseUnix(s) : parseNatural(s);
    }

    private boolean isLong(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private TimestampResponse parseUnix(String s) {
        long unix = Long.parseLong(s);
        try {
            Instant instant = Instant.ofEpochSecond(unix);
            String natural = formatter.format(instant);
            return new TimestampResponse(unix, natural);
        } catch (DateTimeException e) {
            return TimestampResponse.EMPTY;
        }
    }

    private TimestampResponse parseNatural(String natural) {
        try {
            LocalDate localDate = LocalDate.parse(natural, formatter);
            long unix = localDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC);
            return new TimestampResponse(unix, natural);
        } catch (DateTimeParseException e) {
            return TimestampResponse.EMPTY;
        }
    }

}

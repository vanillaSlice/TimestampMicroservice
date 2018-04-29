package lowe.mike.timestampapp.config;

import lowe.mike.timestampapp.service.TimestampService;
import lowe.mike.timestampapp.service.TimestampServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Configuration
public class TimestampConfig {

    @Bean
    public DateTimeFormatter dateTimeFormatter() {
        return DateTimeFormatter.ofPattern("MMMM dd, yyyy").withZone(ZoneId.systemDefault());
    }

    @Bean
    public TimestampService timestampService() {
        return new TimestampServiceImpl(dateTimeFormatter());
    }

}

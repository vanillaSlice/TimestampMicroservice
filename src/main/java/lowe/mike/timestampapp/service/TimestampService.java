package lowe.mike.timestampapp.service;

import lowe.mike.timestampapp.model.TimestampResponse;

public interface TimestampService {

    TimestampResponse convert(String date);

}

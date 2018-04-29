# Timestamp Microservice

A simple timestamp microservice built with Spring Boot. A deployed version can be viewed
[here](https://arcane-sands-42413.herokuapp.com/).

## About
The user can pass a string as a parameter, and it will check to see whether that string contains either a Unix timestamp 
or a natural language date (example: January 1, 2016). If it does, it returns both the Unix timestamp and the natural 
language form of that date. If it does not contain a date or Unix timestamp, it returns null for those properties.

### Example usage:
```
https://arcane-sands-42413.herokuapp.com/December%2015,%202015
https://arcane-sands-42413.herokuapp.com/1450137600
```

### Example output:
```
{ "unix": 1450137600, "natural": "December 15, 2015" }
```

## Running Locally
```
gradle bootRun
```

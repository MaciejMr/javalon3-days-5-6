package pl.sda.crime;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@RequiredArgsConstructor
public class CrimeMapper {
    private final String[] fields;

    public Optional<Crime> toCrime() {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
            return Optional.of(Crime.builder()
                    .time(LocalDateTime.parse(fields[2], dateTimeFormatter))
                    .incidentType(fields[3])
                    .street(fields[6])
                    .city(fields[8])
                    .parentIncidentType(fields[19])
                    .build());
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}

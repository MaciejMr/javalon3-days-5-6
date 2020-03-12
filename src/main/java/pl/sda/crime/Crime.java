package pl.sda.crime;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@ToString
@Builder
@Getter
public class Crime {
    private final LocalDateTime time;
    private final String incidentType;
    private final String city;
    private final String street;
    private final String parentIncidentType;
}

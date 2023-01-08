package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Passport {

    private String seriesNumber;
    private String given;
    private String givenDate;
    private String address;

}

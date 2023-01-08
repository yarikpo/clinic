package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Passport {

    private String seriesNumber;
    private String given;
    private Date givenDate;
    private String address;

}

package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Diploma {

    private String code;
    private int doctorId;
    private String name;
    private Date givenDate;

}

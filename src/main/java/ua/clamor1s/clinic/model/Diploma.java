package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Diploma {

    private String code;
    private Integer doctorId;
    private String name;
    private String givenDate;

}

package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Doctor {

    private int doctorId;
    private String seriesNumber;
    private String email;
    private String password;
    private String name;
    private String specialization;
    private String ITN;
    private String telNum;

}

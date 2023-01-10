package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Appointment {

    private Integer appointmentNumber;
    private Integer doctorId;
    private Integer clientId;
    private Integer favourId;
    private Integer workplaceId;
    private String date;

}

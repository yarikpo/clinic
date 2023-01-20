package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Check {

    private Integer appointmentNumber;
    private Integer doctorId;
    private String doctorName;
    private Integer clientId;
    private String clientName;
    private Integer favourId;
    private String favourName;
    private Integer favourCost;
    private Integer workplaceId;
    private String date;
}

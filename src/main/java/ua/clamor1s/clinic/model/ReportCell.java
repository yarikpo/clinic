package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReportCell {

    private Integer appointmentNumber;
    private Integer doctorId;
    private Integer favourId;
    private Integer favourCost;
    private String date;


}

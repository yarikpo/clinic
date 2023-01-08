package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Appointment {

    private int appointmentNumber;
    private int doctorId;
    private int clientId;
    private int favourId;
    private int workplaceId;
    private Date date;

}

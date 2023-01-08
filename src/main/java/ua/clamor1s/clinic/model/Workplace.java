package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Workplace {

    private int workplaceId;
    private int roomNumber;
    private int placeNumber;

}

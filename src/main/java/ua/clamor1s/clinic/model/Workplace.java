package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Workplace {

    private Integer workplaceId;
    private Integer roomNumber;
    private Integer placeNumber;

}

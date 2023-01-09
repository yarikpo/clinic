package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Favour {

    private Integer favourId;
    private String name;
    private Integer cost;

}

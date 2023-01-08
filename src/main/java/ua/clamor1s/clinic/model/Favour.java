package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Favour {

    private int favourId;
    private String name;
    private int cost;

}

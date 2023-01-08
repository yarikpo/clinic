package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Owner {

    private int ownerId;
    private String email;
    private String password;

}

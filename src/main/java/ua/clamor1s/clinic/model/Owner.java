package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Owner {

    private Integer ownerId;
    private String email;
    private String password;

}

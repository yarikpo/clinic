package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {

    private String login;
    private String password;
    private String type;

}

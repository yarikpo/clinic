package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Admin {

    private int adminId;
    private String seriesNumber;
    private String email;
    private String password;
    private String name;
    private String telNum;
    private String ITN;

}

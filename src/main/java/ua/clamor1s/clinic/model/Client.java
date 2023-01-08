package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Client {

    private Integer clientId;
    private String email;
    private String name;
    private String sex;
    private String birthDate;
    private String telNum;
    private String address;
    private String invalidityInfo;
    private Integer pensionCertificateNumber;

}

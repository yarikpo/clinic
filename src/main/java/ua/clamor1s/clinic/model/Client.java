package ua.clamor1s.clinic.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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

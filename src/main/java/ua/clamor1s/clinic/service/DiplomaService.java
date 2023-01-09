package ua.clamor1s.clinic.service;

import ua.clamor1s.clinic.model.Diploma;

import java.text.ParseException;
import java.util.List;

public interface DiplomaService {

    List<Diploma> getAllDiplomas();

    Diploma getDiplomaByCode(String code);

    void deleteDiplomaByCode(String code);

    void createDiploma(Diploma diploma) throws ParseException;

    void updateDiplomaByCode(String code, Diploma diploma) throws ParseException;

    List<Integer> getAllowedDoctorIds();

}

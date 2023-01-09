package ua.clamor1s.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.clinic.dao.DiplomaDao;
import ua.clamor1s.clinic.model.Diploma;

import java.text.ParseException;
import java.util.List;

@Service
@Transactional
public class DiplomaServiceImpl implements DiplomaService {

    @Autowired
    private DiplomaDao dao;

    @Override
    public List<Diploma> getAllDiplomas() {
        return dao.getAllDiplomas();
    }

    @Override
    public Diploma getDiplomaByCode(String code) {
        return dao.getDiplomaByCode(code);
    }

    @Override
    public void deleteDiplomaByCode(String code) {
        dao.deleteDiplomaByCode(code);
    }

    @Override
    public void createDiploma(Diploma diploma) throws ParseException {
        dao.createDiploma(diploma);
    }

    @Override
    public void updateDiplomaByCode(String code, Diploma diploma) throws ParseException {
        dao.updateDiplomaByCode(code, diploma);
    }

    @Override
    public List<Integer> getAllowedDoctorIds() {
        return dao.getAllowedDoctorIds();
    }
}

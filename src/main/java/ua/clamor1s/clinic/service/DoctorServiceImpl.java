package ua.clamor1s.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.clinic.dao.DoctorDao;
import ua.clamor1s.clinic.model.Doctor;

import java.util.List;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> getAllDoctors() {
        return dao.getAllDoctors();
    }

    @Override
    @Transactional(readOnly = true)
    public Doctor getDoctorById(int id) {
        return dao.getDoctorById(id);
    }

    @Override
    public void deleteDoctorById(int id) {
        dao.deleteDoctorById(id);
    }

    @Override
    public void createDoctor(Doctor doctor) {
        dao.createDoctor(doctor);
    }

    @Override
    public void updateDoctorById(int id, Doctor doctor) {
        dao.updateDoctorById(id, doctor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getAllowedSeriesNumbers(int id) {
        return dao.getAllowedSeriesNumbers(id);
    }
}

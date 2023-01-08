package ua.clamor1s.clinic.service;

import ua.clamor1s.clinic.model.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctors();

    Doctor getDoctorById(int id);

    void deleteDoctorById(int id);

    void createDoctor(Doctor doctor);

    void updateDoctorById(int id, Doctor doctor);

    List<String> getAllowedSeriesNumbers(int id);

}

package ua.clamor1s.clinic.service;

import ua.clamor1s.clinic.model.Appointment;
import ua.clamor1s.clinic.model.Client;
import ua.clamor1s.clinic.model.Doctor;

import java.util.List;

public interface AutomatizationService {

    List<Appointment> getTodayAppointmentsByDoctorId(int doctorId);

    Doctor getDoctorByEmail(String email);

}

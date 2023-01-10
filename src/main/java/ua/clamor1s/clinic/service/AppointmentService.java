package ua.clamor1s.clinic.service;

import ua.clamor1s.clinic.model.Appointment;

import java.text.ParseException;
import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(int id);

    void deleteAppointmentById(int id);

    void createAppointment(Appointment appointment) throws ParseException;

    void updateAppointmentById(int id, Appointment appointment) throws ParseException;

    List<Integer> getAllowedDoctorIds();

    List<Integer> getAllowedClientIds();

    List<Integer> getAllowedFavourIds();

    List<Integer> getAllowedWorkplaceIds();

}

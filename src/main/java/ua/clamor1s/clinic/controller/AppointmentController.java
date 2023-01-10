package ua.clamor1s.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.clamor1s.clinic.model.Appointment;
import ua.clamor1s.clinic.service.AppointmentServiceImpl;

import java.text.ParseException;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImpl service;

    @GetMapping
    public ModelAndView getAllAppointments() {
        return new ModelAndView("appointment/appointments")
                .addObject("appointments", service.getAllAppointments());
    }

    @GetMapping("/{id}")
    public ModelAndView getAppointmentById(@PathVariable int id) {
        return new ModelAndView("appointment/appointment")
                .addObject("appointment", service.getAppointmentById(id));
    }

    @GetMapping("/create")
    public ModelAndView createAppointment() {
        Appointment appointment = Appointment.builder().build();
        return new ModelAndView("appointment/appointmentEdit")
                .addObject("appointment", appointment)
                .addObject("allowedDoctorIds", service.getAllowedDoctorIds())
                .addObject("allowedClientIds", service.getAllowedClientIds())
                .addObject("allowedFavourIds", service.getAllowedFavourIds())
                .addObject("allowedWorkplaceIds", service.getAllowedWorkplaceIds());
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editAppointmentById(@PathVariable int id) {
        Appointment appointment = service.getAppointmentById(id);
        return new ModelAndView("appointment/appointmentUpdate")
                .addObject("appointment", appointment)
                .addObject("allowedDoctorIds", service.getAllowedDoctorIds())
                .addObject("allowedClientIds", service.getAllowedClientIds())
                .addObject("allowedFavourIds", service.getAllowedFavourIds())
                .addObject("allowedWorkplaceIds", service.getAllowedWorkplaceIds());
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteAppointmentById(@PathVariable int id) {
        service.deleteAppointmentById(id);
        return new ModelAndView("redirect:/appointments");
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateAppointmentById(@PathVariable int id, Appointment appointment) throws ParseException {
        service.updateAppointmentById(id, appointment);
        return new ModelAndView("redirect:/appointments");
    }

    @PostMapping("/save")
    public ModelAndView saveAppointment(Appointment appointment) throws ParseException {
        service.createAppointment(appointment);
        return new ModelAndView("redirect:/appointments");
    }

}

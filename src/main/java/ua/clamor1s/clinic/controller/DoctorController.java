package ua.clamor1s.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.clamor1s.clinic.model.Doctor;
import ua.clamor1s.clinic.service.DoctorService;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping
    public ModelAndView getAllDoctors() {
        return new ModelAndView("doctor/doctors")
                .addObject("doctors", service.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ModelAndView getDoctorById(@PathVariable int id) {
        return new ModelAndView("doctor/doctor")
                .addObject("doctor", service.getDoctorById(id));
    }

    @GetMapping("/create")
    public ModelAndView createDoctor() {
        Doctor doctor = Doctor.builder().build();
        return new ModelAndView("doctor/doctorEdit")
                .addObject("doctor", doctor)
                .addObject("allAllowed", service.getAllowedSeriesNumbers(0));
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editDoctor(@PathVariable int id) {
        Doctor doctor = service.getDoctorById(id);
        return new ModelAndView("doctor/doctorUpdate")
                .addObject("doctor", doctor)
                .addObject("allAllowed", service.getAllowedSeriesNumbers(id));
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteDoctor(@PathVariable int id) {
        service.deleteDoctorById(id);
        return new ModelAndView("redirect:/doctors");
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateDoctorById(@PathVariable int id, Doctor doctor) {
        service.updateDoctorById(id, doctor);
        return new ModelAndView("redirect:/doctors");
    }

    @PostMapping("/save")
    public ModelAndView saveDoctor(Doctor doctor) {
        service.createDoctor(doctor);
        return new ModelAndView("redirect:/doctors");
    }

}

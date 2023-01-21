package ua.clamor1s.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.clamor1s.clinic.model.Doctor;
import ua.clamor1s.clinic.model.User;
import ua.clamor1s.clinic.service.AutomatizationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private AutomatizationService service;

    @GetMapping
    public ModelAndView getHome(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null && user.getType().equals("doctor")) {
            Doctor doctor = service.getDoctorByEmail(user.getLogin());
            if (doctor != null) return new ModelAndView("home/homeDoc")
                    .addObject("appointments", service.getTodayAppointmentsByDoctorId(doctor.getDoctorId()));
        }

        return new ModelAndView("home/home");
    }

    @PostMapping
    public void logOut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.getSession().removeAttribute("user");
        res.setStatus(202);
        res.sendRedirect("login");
    }

}

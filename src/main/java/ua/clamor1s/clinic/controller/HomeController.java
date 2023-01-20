package ua.clamor1s.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public ModelAndView getHome() {
        return new ModelAndView("home/home");
    }

    @PostMapping
    public void logOut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.getSession().removeAttribute("user");
        res.setStatus(202);
        res.sendRedirect("login");
    }

}

package ua.clamor1s.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.clamor1s.clinic.model.User;
import ua.clamor1s.clinic.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService service;


    @GetMapping
    public ModelAndView getLoginPage() {
        User user = User.builder().build();
        return new ModelAndView("login/login")
                .addObject("user", user);
    }

    @PostMapping
    public void postLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println((req.getParameter("login") + " ===== " + req.getParameter("password")));
        User user = service.getUser(req.getParameter("login"), req.getParameter("password"));
        System.out.println(user);

        if (user == null) {
            res.setStatus(401);;
            res.sendRedirect("login");
            return;
        }

        req.getSession().setAttribute("user", user);
        res.setStatus(202);
        res.sendRedirect("home");
    }

}

package ua.clamor1s.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
//    @ResponseBody
    public ModelAndView hello() {
//        ModelAndView model = new ModelAndView("hello");
        return new ModelAndView("hello");
//        return "{message: 123}";
    }

}

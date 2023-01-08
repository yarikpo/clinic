package ua.clamor1s.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.clamor1s.clinic.model.Passport;
import ua.clamor1s.clinic.service.PassportServiceImpl;

import java.text.ParseException;

@Controller
@RequestMapping("/passports")
public class PassportController {

    @Autowired
    private PassportServiceImpl service;

    @GetMapping
    public ModelAndView getAllPassports() {
        return new ModelAndView("passport/passports")
                .addObject("passports", service.getAllPassports());
    }

    @GetMapping("/{seriesNumber}")
    public ModelAndView getPassportBySeriesNumber(@PathVariable String seriesNumber) {
        return new ModelAndView("passport/passport")
                .addObject("passport", service.getPassportBySeriesNumber(seriesNumber));
    }

    @GetMapping("/create")
    public ModelAndView createPassport() {
        Passport passport = Passport.builder().build();
        return new ModelAndView("passport/passportEdit")
                .addObject("passport", passport);
    }

    @GetMapping("/edit/{seriesNumber}")
    public ModelAndView editPassport(@PathVariable String seriesNumber) {
        Passport passport = service.getPassportBySeriesNumber(seriesNumber);
        return new ModelAndView("passport/passportUpdate")
                .addObject("passport", passport);
    }

    @PostMapping("/delete/{seriesNumber}")
    public ModelAndView deletePassportBySeriesNumber(@PathVariable String seriesNumber) {
        service.deletePassportBySeriesNumber(seriesNumber);
        return new ModelAndView("redirect:/passports");
    }

    @PostMapping("/update/{seriesNumber}")
    public ModelAndView updatePassportBySeriesNumber(@PathVariable String seriesNumber, Passport passport) throws ParseException {
        service.updatePassportBySeriesNumber(seriesNumber, passport);
        return new ModelAndView("redirect:/passports");
    }

    @PostMapping("/save")
    public ModelAndView savePassport(Passport passport) throws ParseException {
        service.createPassport(passport);
        return new ModelAndView("redirect:/passports");
    }

}

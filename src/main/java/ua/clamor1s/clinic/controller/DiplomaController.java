package ua.clamor1s.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.clamor1s.clinic.model.Diploma;
import ua.clamor1s.clinic.service.DiplomaService;

import java.text.ParseException;

@Controller
@RequestMapping("/diplomas")
public class DiplomaController {

    @Autowired
    private DiplomaService service;

    @GetMapping
    public ModelAndView getAllDiplomas() {
        return new ModelAndView("diploma/diplomas")
                .addObject("diplomas", service.getAllDiplomas());
    }

    @GetMapping("/{code}")
    public ModelAndView getDiplomaByCode(@PathVariable String code) {
        return new ModelAndView("diploma/diploma")
                .addObject("diploma", service.getDiplomaByCode(code));
    }

    @GetMapping("/create")
    public ModelAndView createDiploma() {
        Diploma diploma = Diploma.builder().build();
        return new ModelAndView("diploma/diplomaEdit")
                .addObject("diploma", diploma)
                .addObject("allAllowed", service.getAllowedDoctorIds());
    }

    @GetMapping("/edit/{code}")
    public ModelAndView editDiploma(@PathVariable String code) {
        Diploma diploma = service.getDiplomaByCode(code);
        return new ModelAndView("diploma/diplomaUpdate")
                .addObject("diploma", diploma)
                .addObject("allAllowed", service.getAllowedDoctorIds());
    }

    @PostMapping("/delete/{code}")
    public ModelAndView deleteDiplomaByCode(@PathVariable String code) {
        service.deleteDiplomaByCode(code);
        return new ModelAndView("redirect:/diplomas");
    }

    @PostMapping("/update/{code}")
    public ModelAndView updateDiplomaByCode(@PathVariable String code, Diploma diploma) throws ParseException {
        service.updateDiplomaByCode(code, diploma);
        return new ModelAndView("redirect:/diplomas");
    }

    @PostMapping("/save")
    public ModelAndView saveDiploma(Diploma diploma) throws ParseException {
        service.createDiploma(diploma);
        return new ModelAndView("redirect:/diplomas");
    }

}

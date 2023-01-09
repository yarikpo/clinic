package ua.clamor1s.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.clamor1s.clinic.model.Workplace;
import ua.clamor1s.clinic.service.WorkplaceServiceImpl;

@Controller
@RequestMapping("/workplaces")
public class WorkplaceController {

    @Autowired
    private WorkplaceServiceImpl service;

    @GetMapping
    public ModelAndView getAllWorkplaces() {
        return new ModelAndView("workplace/workplaces")
                .addObject("workplaces", service.getAllWorkplaces());
    }

    @GetMapping("/{id}")
    public ModelAndView getWorkplaceById(@PathVariable int id) {
        return new ModelAndView("workplace/workplace")
                .addObject("workplace", service.getWorkplaceById(id));
    }

    @GetMapping("/create")
    public ModelAndView createWorkplace() {
        Workplace workplace = Workplace.builder().build();
        return new ModelAndView("workplace/workplaceEdit")
                .addObject("workplace", workplace);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editWorkplace(@PathVariable int id) {
        Workplace workplace = service.getWorkplaceById(id);
        return new ModelAndView("workplace/workplaceUpdate")
                .addObject("workplace", workplace);
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteWorkplaceById(@PathVariable int id) {
        service.deleteWorkplaceById(id);
        return new ModelAndView("redirect:/workplaces");
    }

    @PostMapping("/save")
    public ModelAndView saveWorkplace(Workplace workplace) {
        service.createWorkplace(workplace);
        return new ModelAndView("redirect:/workplaces");
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateWorkplaceById(@PathVariable int id, Workplace workplace) {
        service.updateWorkplaceById(id, workplace);
        return new ModelAndView("redirect:/workplaces");
    }

}

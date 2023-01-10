package ua.clamor1s.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.clamor1s.clinic.model.Owner;
import ua.clamor1s.clinic.service.OwnerServiceImpl;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerServiceImpl service;

    @GetMapping
    public ModelAndView getAllOwners() {
        return new ModelAndView("owner/owners")
                .addObject("owners", service.getAllOwners());
    }

    @GetMapping("/{id}")
    public ModelAndView getOwnerById(@PathVariable int id) {
        return new ModelAndView("owner/owner")
                .addObject("owner", service.getOwnerById(id));
    }

    @GetMapping("/create")
    public ModelAndView createOwner() {
        Owner owner = Owner.builder().build();
        return new ModelAndView("owner/ownerEdit")
                .addObject("owner", owner);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editOwner(@PathVariable int id) {
        Owner owner = service.getOwnerById(id);
        return new ModelAndView("owner/ownerUpdate")
                .addObject("owner", owner);
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteOwnerById(@PathVariable int id) {
        service.deleteOwnerById(id);
        return new ModelAndView("redirect:/owners");
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateOwnerById(@PathVariable int id, Owner owner) {
        service.updateOwnerById(id, owner);
        return new ModelAndView("redirect:/owners");
    }

    @PostMapping("/save")
    public ModelAndView saveOwner(Owner owner) {
        service.createOwner(owner);
        return new ModelAndView("redirect:/owners");
    }

}

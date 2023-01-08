package ua.clamor1s.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.clamor1s.clinic.model.Admin;
import ua.clamor1s.clinic.service.AdminServiceImpl;

@Controller
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminServiceImpl service;

    @GetMapping
    public ModelAndView getAllAdmins() {
        return new ModelAndView("admin/admins")
                .addObject("admins", service.getAllAdmins());
    }

    @GetMapping("/{id}")
    public ModelAndView getAdminById(@PathVariable int id) {
        return new ModelAndView("admin/admin")
                .addObject("admin", service.getAdminById(id));
    }

    @GetMapping("/create")
    public ModelAndView createAdmin() {
        Admin admin = Admin.builder().build();
        return new ModelAndView("admin/adminEdit")
                .addObject("admin", admin)
                .addObject("allAllowed", service.getAllowedSeriesNumbers(0));
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editAdmin(@PathVariable int id) {
        Admin admin = service.getAdminById(id);
        return new ModelAndView("admin/adminUpdate")
                .addObject("admin", admin)
                .addObject("allAllowed", service.getAllowedSeriesNumbers(id));
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteAdmin(@PathVariable int id) {
        service.deleteAdminById(id);
        return new ModelAndView("redirect:/admins");
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateClientById(@PathVariable int id, Admin admin) {
        service.updateAdminById(id, admin);
        return new ModelAndView("redirect:/admins");
    }

    @PostMapping("/save")
    public ModelAndView saveAdmin(Admin admin) {
        service.createAdmin(admin);
        return new ModelAndView("redirect:/admins");
    }


}

package ua.clamor1s.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.clamor1s.clinic.model.Client;
import ua.clamor1s.clinic.service.ClientServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientServiceImpl service;

    @GetMapping
    public ModelAndView getAllClients() {
        ModelAndView model = new ModelAndView("client/clients");
        model.addObject("clients", service.getAllClients());
        return model;
    }

    @GetMapping("/{id}")
    public ModelAndView getClientById(@PathVariable int id) {
        ModelAndView model = new ModelAndView("client/client");
        model.addObject("client", service.getClientById(id));
        return model;
    }

    @GetMapping("/create")
    public ModelAndView createClient() {
        Client client = Client.builder().build();
        return new ModelAndView("client/clientEdit")
                .addObject("client", client);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editClient(@PathVariable int id) {
        Client client = service.getClientById(id);
        return new ModelAndView("client/clientUpdate")
                .addObject("client", client);
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteClientById(@PathVariable int id) {
        service.deleteClientById(id);
        return new ModelAndView("redirect:/clients");
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateClientById(@PathVariable int id, Client client) throws ParseException {
        service.updateClientById(id, client);
        return new ModelAndView("redirect:/clients");
    }

    @PostMapping("/save")
    public ModelAndView createClient(Client client) throws ParseException {
        service.createClient(client);
        return new ModelAndView("redirect:/clients");
    }

}

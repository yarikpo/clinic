package ua.clamor1s.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.clamor1s.clinic.model.Favour;
import ua.clamor1s.clinic.service.FavourServiceImpl;

@Controller
@RequestMapping("/favours")
public class FavourController {

    @Autowired
    private FavourServiceImpl service;

    @GetMapping
    public ModelAndView getAllFavours() {
        return new ModelAndView("favour/favours")
                .addObject("favours", service.getAllFavours());
    }

    @GetMapping("/{id}")
    public ModelAndView getFavourById(@PathVariable int id) {
        return new ModelAndView("favour/favour")
                .addObject("favour", service.getFavourById(id));
    }

    @GetMapping("/create")
    public ModelAndView createFavour() {
        Favour favour = Favour.builder().build();
        return new ModelAndView("favour/favourEdit")
                .addObject("favour", favour);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editFavour(@PathVariable int id) {
        Favour favour = service.getFavourById(id);
        return new ModelAndView("favour/favourUpdate")
                .addObject("favour", favour);
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteFavourById(@PathVariable int id) {
        service.deleteFavourById(id);
        return new ModelAndView("redirect:/favours");
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateFavourById(@PathVariable int id, Favour favour) {
        service.updateFavourById(id, favour);
        return new ModelAndView("redirect:/favours");
    }

    @PostMapping("/save")
    public ModelAndView saveFavour(Favour favour) {
        service.createFavour(favour);
        return new ModelAndView("redirect:/favours");
    }

}

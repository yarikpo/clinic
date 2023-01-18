package ua.clamor1s.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.clamor1s.clinic.service.StatisticService;

import java.util.ArrayList;

@Controller
@RequestMapping("/statistics")
public class StatisticController {

    @Autowired
    private StatisticService service;

    static class ClientId {
        private int clientId = 0;

        public int getClientId() {
            return clientId;
        }

        public void setClientId(int clientId) {
            this.clientId = clientId;
        }
    }

    @GetMapping
    public ModelAndView getStatistics(@RequestParam(required = false) String statement, @RequestParam(required = false) Integer clientId) {
        System.out.println(statement);
        System.out.println(service.getRequestBody(statement == null ? "select \"\";" : statement, clientId));
        System.out.println(service.getRequestHead(statement == null ? "select \"\";" : statement, clientId));
        ClientId cid = new ClientId();
        return new ModelAndView("statistic/statistic")
                .addObject("body", service.getRequestBody(statement == null ? "select \"\";" : statement, clientId))
                .addObject("head", service.getRequestHead(statement == null ? "select \"\";" : statement, clientId))
                .addObject("clientId", cid);
    }

    @PostMapping
    public ModelAndView redirectByClientId(ClientId clientId) {
        return new ModelAndView("redirect:/statistics?statement=favoursByPrice&clientId=" + clientId.getClientId());
    }

}

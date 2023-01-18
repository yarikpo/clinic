package ua.clamor1s.clinic.service;

import ua.clamor1s.clinic.model.Statistic;

import java.util.List;

public interface StatisticService {

    List<Statistic> getRequestBody(String statement, Integer clientId);

    Statistic getRequestHead(String statement, Integer clientId);

}

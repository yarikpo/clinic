package ua.clamor1s.clinic.service;

import ua.clamor1s.clinic.model.Workplace;

import java.util.List;

public interface WorkplaceService {

    List<Workplace> getAllWorkplaces();

    Workplace getWorkplaceById(int id);

    void deleteWorkplaceById(int id);

    void updateWorkplaceById(int id, Workplace workplace);

    void createWorkplace(Workplace workplace);

}

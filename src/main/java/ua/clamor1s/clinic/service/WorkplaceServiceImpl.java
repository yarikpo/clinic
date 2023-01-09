package ua.clamor1s.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.clinic.dao.WorkplaceDao;
import ua.clamor1s.clinic.model.Workplace;

import java.util.List;

@Service
@Transactional
public class WorkplaceServiceImpl implements WorkplaceService {

    @Autowired
    private WorkplaceDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Workplace> getAllWorkplaces() {
        return dao.getAllWorkplaces();
    }

    @Override
    @Transactional(readOnly = true)
    public Workplace getWorkplaceById(int id) {
        return dao.getWorkplaceById(id);
    }

    @Override
    public void deleteWorkplaceById(int id) {
        dao.deleteWorkplaceById(id);
    }

    @Override
    public void updateWorkplaceById(int id, Workplace workplace) {
        dao.updateWorkplaceById(id, workplace);
    }

    @Override
    public void createWorkplace(Workplace workplace) {
        dao.createWorkplace(workplace);
    }
}

package ua.clamor1s.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.clinic.dao.OwnerDao;
import ua.clamor1s.clinic.model.Owner;

import java.util.List;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerDao dao;

    @Override
    public List<Owner> getAllOwners() {
        return dao.getAllOwners();
    }

    @Override
    public Owner getOwnerById(int id) {
        return dao.getOwnerById(id);
    }

    @Override
    public void deleteOwnerById(int id) {
        dao.deleteOwnerById(id);
    }

    @Override
    public void createOwner(Owner owner) {
        dao.createOwner(owner);
    }

    @Override
    public void updateOwnerById(int id, Owner owner) {
        dao.updateOwnerById(id, owner);
    }
}

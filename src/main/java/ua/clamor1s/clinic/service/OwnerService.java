package ua.clamor1s.clinic.service;

import ua.clamor1s.clinic.model.Owner;

import java.util.List;

public interface OwnerService {

    List<Owner> getAllOwners();

    Owner getOwnerById(int id);

    void deleteOwnerById(int id);

    void createOwner(Owner owner);

    void updateOwnerById(int id, Owner owner);

}

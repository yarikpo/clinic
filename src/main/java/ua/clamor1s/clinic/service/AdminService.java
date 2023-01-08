package ua.clamor1s.clinic.service;

import ua.clamor1s.clinic.model.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> getAllAdmins();

    Admin getAdminById(int id);

    void deleteAdminById(int id);

    void createAdmin(Admin admin);

    void updateAdminById(int id, Admin admin);

    List<String> getAllowedSeriesNumbers(int adminId);

}

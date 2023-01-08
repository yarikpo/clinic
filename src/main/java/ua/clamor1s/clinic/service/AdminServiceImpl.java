package ua.clamor1s.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.clinic.dao.AdminDao;
import ua.clamor1s.clinic.model.Admin;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Admin> getAllAdmins() {
        return dao.getAllAdmins();
    }

    @Override
    @Transactional(readOnly = true)
    public Admin getAdminById(int id) {
        return dao.getAdminById(id);
    }

    @Override
    public void deleteAdminById(int id) {
        dao.deleteAdminById(id);
    }

    @Override
    public void createAdmin(Admin admin) {
        dao.createAdmin(admin);
    }

    @Override
    public void updateAdminById(int id, Admin admin) {
        dao.updateAdminById(id, admin);
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getAllowedSeriesNumbers(int adminId) {
        return dao.getAllowedSeriesNumbers(adminId);
    }
}

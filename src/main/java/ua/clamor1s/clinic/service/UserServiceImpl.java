package ua.clamor1s.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.clinic.dao.UserDao;
import ua.clamor1s.clinic.model.User;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public User getUser(String login, String password) {
        return dao.getUser(login, password);
    }
}

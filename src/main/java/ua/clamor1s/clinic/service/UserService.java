package ua.clamor1s.clinic.service;

import ua.clamor1s.clinic.model.User;

public interface UserService {

    User getUser(String login, String password);

}

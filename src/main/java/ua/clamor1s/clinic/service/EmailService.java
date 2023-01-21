package ua.clamor1s.clinic.service;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);

}

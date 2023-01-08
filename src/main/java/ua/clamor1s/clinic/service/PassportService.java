package ua.clamor1s.clinic.service;

import ua.clamor1s.clinic.model.Passport;

import java.text.ParseException;
import java.util.List;

public interface PassportService {

    List<Passport> getAllPassports();

    Passport getPassportBySeriesNumber(String seriesNumber);

    void updatePassportBySeriesNumber(String seriesNumber, Passport passport) throws ParseException;

    void createPassport(Passport passport) throws ParseException;

    void deletePassportBySeriesNumber(String seriesNumber);

}

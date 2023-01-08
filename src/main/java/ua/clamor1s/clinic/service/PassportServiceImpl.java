package ua.clamor1s.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.clinic.dao.PassportDao;
import ua.clamor1s.clinic.model.Passport;

import java.text.ParseException;
import java.util.List;

@Service
@Transactional
public class PassportServiceImpl implements PassportService {

    @Autowired
    private PassportDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Passport> getAllPassports() {
        return dao.getAllPassports();
    }

    @Override
    @Transactional(readOnly = true)
    public Passport getPassportBySeriesNumber(String seriesNumber) {
        return dao.getPassportBySeriesNumber(seriesNumber);
    }

    @Override
    public void updatePassportBySeriesNumber(String seriesNumber, Passport passport) throws ParseException {
        dao.updatePassportBySeriesNumber(seriesNumber, passport);
    }

    @Override
    public void createPassport(Passport passport) throws ParseException {
        dao.createPassport(passport);
    }

    @Override
    public void deletePassportBySeriesNumber(String seriesNumber) {
        dao.deletePassportBySeriesNumber(seriesNumber);
    }
}

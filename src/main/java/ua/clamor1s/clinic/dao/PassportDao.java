package ua.clamor1s.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.clamor1s.clinic.model.Passport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class PassportDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Passport> getAllPassports() {
        return jdbcTemplate.query("select * from passport;", (rs, rowNum) -> mapPassport(rs));
    }

    public Passport getPassportBySeriesNumber(String seriesNumber) {
        return jdbcTemplate.queryForObject("select * from passport where series_number = ?;",
                (rs, rowNum) -> mapPassport(rs),
                new Object[] {seriesNumber}
        );
    }

    public void deletePassportBySeriesNumber(String seriesNumber) {
        jdbcTemplate.update("delete from passport where series_number = ?;", seriesNumber);
    }

    public void createPassport(Passport passport) throws ParseException {
        jdbcTemplate.update("insert into passport (series_number, given, given_date, address)" +
                " values (?, ?, ?, ?);",
                passport.getSeriesNumber(),
                passport.getGiven(),
                new SimpleDateFormat("yyyy-MM-dd").parse(passport.getGivenDate()),
                passport.getAddress()
         );
    }
    public void updatePassportBySeriesNumber(String seriesNumber, Passport passport) throws ParseException {
        jdbcTemplate.update("update passport set series_number=?, given=?, given_date=?, address=? where series_number=?;",
                passport.getSeriesNumber(),
                passport.getGiven(),
                new SimpleDateFormat("yyyy-MM-dd").parse(passport.getGivenDate()),
                passport.getAddress(),
                seriesNumber
        );
    }

    private Passport mapPassport(ResultSet rs) throws SQLException {
        return Passport.builder()
                .seriesNumber(rs.getString("series_number"))
                .given(rs.getString("given"))
                .givenDate(rs.getDate("given_date").toString())
                .address(rs.getString("address"))
                .build();

    }

}

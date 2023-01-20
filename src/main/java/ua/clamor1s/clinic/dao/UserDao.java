package ua.clamor1s.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.clamor1s.clinic.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public User getUser(String login, String password) {
        User user = null;
        user = getDoctorUser(login, password);
        if (user != null) return user;
        user = getAdminUser(login, password);
        if (user != null) return user;
        user = getOwnerUser(login, password);
        return user;
    }

    private User getDoctorUser(String login, String password) {
        return jdbcTemplate.query("select doctor.email as login, doctor.password as password from doctor" +
                " where doctor.email = ? and doctor.password = ?;",
                (rs, rowNum) -> mapUserDoc(rs),
                new Object[] {login, password}
        ).stream().findAny().orElse(null);
    }

    private User getAdminUser(String login, String password) {
        return jdbcTemplate.query("select admin.email as login, admin.password as password from admin" +
                " where admin.email = ? and admin.password = ?;",
                (rs, rowNum) -> mapUserAdm(rs),
                new Object[] {login, password}
        ).stream().findAny().orElse(null);
    }

    private User getOwnerUser(String login, String password) {
        return jdbcTemplate.query("select owner.email as login, owner.password as password from owner" +
                " where owner.email = ? and owner.password = ?;",
                (rs, rowNum) -> mapUserOwn(rs),
                new Object[] {login, password}
        ).stream().findAny().orElse(null);
    }

    private User mapUserOwn(ResultSet rs) throws SQLException {
        return User.builder()
                .login(rs.getString("login"))
                .password(rs.getString("password"))
                .type("owner")
                .build();
    }

    private User mapUserAdm(ResultSet rs) throws  SQLException {
        return User.builder()
                .login(rs.getString("login"))
                .password(rs.getString("password"))
                .type("admin")
                .build();
    }

    private User mapUserDoc(ResultSet rs) throws SQLException {
        return User.builder()
                .login(rs.getString("login"))
                .password(rs.getString("password"))
                .type("doctor")
                .build();
    }

}

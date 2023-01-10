package ua.clamor1s.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.clamor1s.clinic.model.Owner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OwnerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Owner> getAllOwners() {
        return jdbcTemplate.query("select * from owner;", (rs, rowNum) -> mapOwner(rs));
    }

    public Owner getOwnerById(int id) {
        return jdbcTemplate.queryForObject("select * from owner where owner_id=?;",
                (rs, rowNum) -> mapOwner(rs),
                new Object[] {id}
        );
    }

    public void deleteOwnerById(int id) {
        jdbcTemplate.update("delete from owner where owner_id=?;", id);
    }

    public void createOwner(Owner owner) {
        jdbcTemplate.update("insert into owner (email, password) values (?, ?);",
                owner.getEmail(),
                owner.getPassword()
        );
    }

    public void updateOwnerById(int id, Owner owner) {
        jdbcTemplate.update("update owner set email=?, password=? where owner_id=?;",
                owner.getEmail(),
                owner.getPassword(),
                id
        );
    }

    private Owner mapOwner(ResultSet rs) throws SQLException {
        return Owner.builder()
                .ownerId(rs.getInt("owner_id"))
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .build();
    }

}

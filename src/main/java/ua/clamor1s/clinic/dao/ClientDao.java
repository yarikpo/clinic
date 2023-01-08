package ua.clamor1s.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.clamor1s.clinic.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class ClientDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Client> getAllClients() {
        return jdbcTemplate.query("select * from client;", (rs, rowNum) -> mapClient(rs));
    }

    public Client getClientById(int id) {
        return jdbcTemplate.queryForObject("select * from client where client_id = ?;",
                (rs, rowNum) -> mapClient(rs),
                new Object[] {id});
    }

    public void deleteClientById(int id) {
        jdbcTemplate.update("delete from client where client_id=?;", id);
    }

    public void updateClientById(int id, Client client) throws ParseException {
        jdbcTemplate.update("update client set email=?, name=?, sex=?, birth_date=?, tel_num=?, address=?, invalidity_info=?, pension_certificate_number=?" +
                " where client_id=?;",
                client.getEmail(),
                client.getName(),
                client.getSex(),
                new SimpleDateFormat("yyyy-MM-dd").parse(client.getBirthDate()),
                client.getTelNum(),
                client.getAddress(),
                client.getInvalidityInfo(),
                client.getPensionCertificateNumber(),
                id
        );
    }

    public void createClient(Client client) throws ParseException {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update("insert into client (email, name, sex, birth_date, tel_num, address, invalidity_info, pension_certificate_number)" +
                " values (? , ? , ? , ? , ? , ? , ? , ?);",
                client.getEmail(),
                client.getName(),
                client.getSex(),
                new SimpleDateFormat("yyyy-MM-dd").parse(client.getBirthDate()),
                client.getTelNum(),
                client.getAddress(),
                client.getInvalidityInfo(),
                client.getPensionCertificateNumber()
        );
//        client.setClientId(keyHolder.getKey().intValue());
    }

    private Client mapClient(ResultSet rs) throws SQLException {
        return Client.builder()
                .clientId(rs.getInt("client_id"))
                .email(rs.getString("email"))
                .name(rs.getString("name"))
                .sex(rs.getString("sex"))
                .birthDate(rs.getDate("birth_date").toString())
                .telNum(rs.getString("tel_num"))
                .address(rs.getString("address"))
                .invalidityInfo(rs.getString("invalidity_info"))
                .pensionCertificateNumber(rs.getInt("pension_certificate_number"))
                .build();
    }

}

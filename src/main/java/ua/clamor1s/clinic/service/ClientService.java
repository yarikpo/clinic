package ua.clamor1s.clinic.service;

import ua.clamor1s.clinic.model.Client;

import java.text.ParseException;
import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    Client getClientById(int id);

    void updateClientById(int id, Client client) throws ParseException;

    void createClient(Client client) throws ParseException;

    void deleteClientById(int id);

}

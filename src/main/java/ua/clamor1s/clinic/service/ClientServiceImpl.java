package ua.clamor1s.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.clinic.dao.ClientDao;
import ua.clamor1s.clinic.model.Client;

import java.text.ParseException;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Client> getAllClients() {
        return dao.getAllClients();
    }

    @Override
    @Transactional(readOnly = true)
    public Client getClientById(int id) {
        return dao.getClientById(id);
    }

    @Override
    public void updateClientById(int id, Client client) throws ParseException {
        dao.updateClientById(id, client);
    }

    @Override
    public void createClient(Client client) throws ParseException {
        dao.createClient(client);
    }

    @Override
    public void deleteClientById(int id) {
        dao.deleteClientById(id);
    }
}

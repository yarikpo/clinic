package ua.clamor1s.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.clinic.dao.FavourDao;
import ua.clamor1s.clinic.model.Favour;

import java.util.List;

@Service
@Transactional
public class FavourServiceImpl implements FavourService {

    @Autowired
    private FavourDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Favour> getAllFavours() {
        return dao.getAllFavours();
    }

    @Override
    @Transactional(readOnly = true)
    public Favour getFavourById(int id) {
        return dao.getFavourById(id);
    }

    @Override
    public void deleteFavourById(int id) {
        dao.deleteFavourById(id);
    }

    @Override
    public void createFavour(Favour favour) {
        dao.createFavour(favour);
    }

    @Override
    public void updateFavourById(int id, Favour favour) {
        dao.updateFavourById(id, favour);
    }
}

package ua.clamor1s.clinic.service;

import ua.clamor1s.clinic.model.Favour;

import java.util.List;

public interface FavourService {

    List<Favour> getAllFavours();

    Favour getFavourById(int id);

    void deleteFavourById(int id);

    void createFavour(Favour favour);

    void updateFavourById(int id, Favour favour);

}

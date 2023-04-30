package ru.skypro.hibernate.service;

import ru.skypro.hibernate.model.City;

import java.util.List;

public interface CityDAO {
    List<City> getAllCities();

    City getById(int id);

    void addCity(City city);

    void updateCity(int id, City city);

    void deleteCity (int id);

    boolean isContainsIdCity (int id);
}

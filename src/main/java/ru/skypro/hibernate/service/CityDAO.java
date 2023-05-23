package ru.skypro.hibernate.service;

import ru.skypro.hibernate.model.City;

import java.util.List;

public interface CityDAO {
    List<City> getAllCities();

    City getCityById(Long id);

    void addCity(City city);

    void updateCity(Long id, City city);

    void deleteCity(Long id);
}

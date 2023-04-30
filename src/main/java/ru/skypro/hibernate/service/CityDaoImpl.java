package ru.skypro.hibernate.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.skypro.hibernate.model.City;

import java.util.List;

public class CityDaoImpl implements CityDAO {
    @Override
    public List<City> getAllCities() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM City").list();
        }
    }

    @Override
    public City getById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(City.class, id);
        }
    }

    @Override
    public void addCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(city);
            transaction.commit();
        }
    }

    @Override
    public void updateCity(int id, City city) {
        if (isContainsIdCity(id)) {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.update(city);
                transaction.commit();
            }
        } else {
            System.out.println("cant update id " + id + " (City no found)");
        }
    }

    @Override
    public void deleteCity(int id) {
        if (isContainsIdCity(id)) {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                session.delete(getById(id));
            }
        } else {
            System.out.println("cant delete id " + id + " (City no found)");
        }
    }

    @Override
    public boolean isContainsIdCity(int id) {
        int count = 0;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            count = (int) session.createQuery("SELECT count (*) FROM City c WHERE c.cityId= :id").stream().count();
        }
        if (count >= 1) {
            return true;
        } else {
            return false;
        }
    }
}

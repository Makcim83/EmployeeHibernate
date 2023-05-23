package ru.skypro.hibernate.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.skypro.hibernate.model.City;

import java.util.List;

public class CityDaoImpl implements CityDAO {
    @Override
    public List<City> getAllCities() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM City ").list();
        }
    }

    @Override
    public City getCityById(Long id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return (City) session.get(City.class, id);
        } catch (NullPointerException e) {
            System.out.println("City id = " + id + " no found");
            return null;
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
    public void updateCity(Long id, City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(city);
            transaction.commit();
        } catch (NullPointerException e) {
            System.out.println("cant update id " + id + " (City no found)");
        }
    }

    @Override
    public void deleteCity(Long id) {
        if (id == null) {
            System.out.println("cant delete id " + id + " (City no found, null)");
        } else {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(getCityById(id));
                transaction.commit();
            }
        }
    }
}

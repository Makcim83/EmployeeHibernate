package ru.skypro.hibernate.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.skypro.hibernate.model.Employee;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {

    @Override
    public List getAllEmployee() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Employee").list();
        }
    }

    @Override
    public Employee getById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        Integer id;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            id = (Integer) session.save(employee);
            transaction.commit();
        }
//        return id;
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        if (isContainsId(id)) {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.update(employee);
                transaction.commit();
            }
        } else {
            System.out.println("cant update id " + id + " (no found)");
        }
    }

    @Override
    public void deleteEmployee(int id) {
        if (isContainsId(id)) {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                session.delete(getById(id));
            }
        } else {
            System.out.println("cant delete id " + id + " (no found)");
        }
    }

    @Override
    public boolean isContainsId(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            int count = (int) session.createQuery("SELECT count (*) FROM Employee e WHERE e.id= :id").stream().count();

            if (count == 1) {
                return true;
            } else {
                return false;
            }
        }
    }
}

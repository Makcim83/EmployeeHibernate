package ru.skypro.hibernate.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.skypro.hibernate.model.Employee;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {

    @Override
    public List<Employee> getAllEmployee() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Employee").list();
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        }
    }

    @Override
    public void updateEmployee(Long id, Employee empl) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(empl);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        if (id == null) {
            System.out.println("cant delete id " + id + " (City no found, null)");
        } else {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(getEmployeeById(id));
                transaction.commit();
            }
        }
    }
}
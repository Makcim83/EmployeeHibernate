package ru.skypro.hibernate.service;

import ru.skypro.hibernate.model.Employee;

import java.util.List;

interface EmployeeDAO {
    List<Employee> getAllEmployee();

    Employee getById(int id);

    void addEmployee(Employee employee);

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);

    boolean isContainsId (int id);
}
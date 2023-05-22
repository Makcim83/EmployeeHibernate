package ru.skypro.hibernate.service;

import ru.skypro.hibernate.model.Employee;

import java.util.List;

interface EmployeeDAO {
    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long id);

    void addEmployee(Employee employee);

    void updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);
}
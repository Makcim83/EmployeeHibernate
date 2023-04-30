package ru.skypro.hibernate.service;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDao = new EmployeeDaoImpl();

        System.out.println(((EmployeeDaoImpl) employeeDao).getAllEmployee());

//        employeeDao.addEmployee(new Employee("Ivan", "Ivanov", "male", 59, new City("Moscow")));



//        employeeDao.updateEmployee(, new Employee("Ivan", "Ivanov", "male", 59, new City("Moscow")));

//        employeeDao.deleteEmployee(10);


    }
}

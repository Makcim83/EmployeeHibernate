package ru.skypro.hibernate.service;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDao = new EmployeeDaoImpl();
        CityDAO cityDao = new CityDaoImpl();

        System.out.println(((EmployeeDaoImpl) employeeDao).getAllEmployee());
        System.out.println(((CityDaoImpl) cityDao).getAllCities());

//        employeeDao.addEmployee(new Employee("Ivan", "Ivanov", "male", 59, new City("Moscow")));
//        cityDao.addCity(new City("SomeCity"));

//        employeeDao.updateEmployee(11L, new Employee(11L, "Ivan", "Ivanov", "male", 47, new City("Kazan")));

        cityDao.deleteCity(16L);
        employeeDao.deleteEmployee(14L);
    }
}
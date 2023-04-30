package ru.skypro.hibernate.service;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDao = new EmployeeDaoImpl();
        CityDAO cityDao = new CityDaoImpl();

        System.out.println(((EmployeeDaoImpl) employeeDao).getAllEmployee());

        System.out.println(((CityDaoImpl) cityDao).getAllCities());


//        employeeDao.addEmployee(new Employee("Ivan", "Ivanov", "male", 59, new City("Moscow")));
//        cityDao.addCity(new City("Moscow"));

//        employeeDao.updateEmployee(, new Employee("Ivan", "Ivanov", "male", 59, new City("Moscow")));

//        employeeDao.deleteEmployee(12);
//        cityDao.deleteCity(10);


    }
}

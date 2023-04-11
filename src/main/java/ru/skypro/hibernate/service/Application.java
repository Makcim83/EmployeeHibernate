package ru.skypro.hibernate.service;

import ru.skypro.hibernate.model.Employee;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDao = new EmployeeDaoImpl();


//        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory();
//
//
//                Persistence.createEntityManagerFactory("myPersistanceUnit");
//        EntityManager manager = entityManager.createEntityManager();
//
//        Employee employee = entityManager.(Employee.class, 4);
//        System.out.println(employee);
//
//        manager.close();;
//        entityManager.close();


//        System.out.println(employeeDao.getById(6) + "\n");

//        selectAll(employeeDao);

//        int idToUpdate = 4;
//        Employee emp = new Employee(idToUpdate, "Ivan", "Ivanov", "male", 59, 3);
//        employeeDao.updateEmployee(idToUpdate, emp);

//        employeeDao.addEmployee(new Employee ("Ivan", "Ivanovovskiy" , "male" , 33, 2));
        selectAll(employeeDao);

        employeeDao.deleteEmployee(9);
        selectAll(employeeDao);

    }
    public static void selectAll(EmployeeDAO employeeDao) {
        for (Employee e : employeeDao.getAllEmployee()) {
            System.out.println(e);
        }
        System.out.println();
    }
}

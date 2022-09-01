package repository;

import module.Customer;
import module.Employee;

import java.util.List;

public interface IEmployeeRepository {

    List<Employee> findAll();

    boolean create(Employee employee);

    boolean deleteEmployee(int id);

    boolean updateEmployee(Employee employee);

    Employee findById(int id);

    List<Employee> find (String name , String address, String phone);
}

package repository;

import module.Employee;

import java.util.List;

public interface IEmployeeRepository {

    List<Employee> findAll();
}

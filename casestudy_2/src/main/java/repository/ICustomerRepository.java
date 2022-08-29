package repository;

import module.Customer;
import module.CustomerType;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findByAll();

    boolean create (Customer customer);
}

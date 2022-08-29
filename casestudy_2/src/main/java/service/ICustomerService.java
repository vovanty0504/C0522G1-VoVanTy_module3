package service;

import module.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findByAll();

    boolean create (Customer customer);
}

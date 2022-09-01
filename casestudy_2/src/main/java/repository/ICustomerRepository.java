package repository;

import module.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findByAll();

    boolean create (Customer customer);

    boolean deleteCustomer(int id);

    Customer findById(int id);

    boolean updateCustomer(Customer customer);

    List<Customer> find (String name , String address, String phone);



}

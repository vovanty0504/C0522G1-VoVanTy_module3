package service;

import module.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findByAll();

    boolean create (Customer customer);

    boolean deleteCustomer(int id);


    Customer findById(int id);

    boolean updateCustomer(Customer customer);

    List<Customer> findName(String name, String address,String phone);





}

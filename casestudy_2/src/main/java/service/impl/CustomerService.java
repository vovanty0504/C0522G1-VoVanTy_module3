package service.impl;

import module.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository iCustomerRepository = new CustomerRepository();

    @Override
    public List<Customer> findByAll() {
        return iCustomerRepository.findByAll();
    }

    @Override
    public boolean create(Customer customer) {
        return iCustomerRepository.create(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return iCustomerRepository.deleteCustomer(id);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return iCustomerRepository.updateCustomer(customer);
    }

    @Override
    public List<Customer> findName(String name, String address,String phone) {
        return iCustomerRepository.find(name, address,phone);
    }


}

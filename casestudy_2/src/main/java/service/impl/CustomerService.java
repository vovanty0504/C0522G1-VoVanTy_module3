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
}

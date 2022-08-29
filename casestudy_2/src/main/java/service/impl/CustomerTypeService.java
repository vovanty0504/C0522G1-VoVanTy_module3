package service.impl;

import module.CustomerType;
import repository.ICustomerRepository;
import repository.ICustomerTypeRepository;
import repository.impl.CustomerRepository;
import repository.impl.CustomerTypeRepository;
import service.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    private ICustomerTypeRepository iCustomerTypeRepository = new CustomerTypeRepository();

    @Override
    public List<CustomerType> findByAll() {
        return iCustomerTypeRepository.findByAll();
    }

    @Override
    public boolean create(CustomerType customerType) {
        return iCustomerTypeRepository.create(customerType);
    }
}

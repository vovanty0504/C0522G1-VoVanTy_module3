package service;

import module.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findByAll();

    boolean create (CustomerType customerType);
}

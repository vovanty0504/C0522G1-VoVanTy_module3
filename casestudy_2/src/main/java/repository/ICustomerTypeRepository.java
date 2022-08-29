package repository;

import module.CustomerType;

import java.util.List;

public interface ICustomerTypeRepository {
    List<CustomerType> findByAll();

    boolean create (CustomerType customerType);
}

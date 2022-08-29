package repository;

import module.Customer;
import module.Division;

import java.util.List;

public interface IDivisionRepository {

    List<Division> findAll();
}

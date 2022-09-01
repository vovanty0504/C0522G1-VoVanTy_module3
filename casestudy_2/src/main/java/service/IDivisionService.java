package service;

import module.Division;
import module.Employee;
import module.Position;

import java.util.List;

public interface IDivisionService {
    List<Division> findAll();

    boolean create(Division division);
}

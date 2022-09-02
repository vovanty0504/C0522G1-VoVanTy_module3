package repository;

import module.RentType;

import java.util.List;

public interface IRentTypeRepository {

    List<RentType> findAll();
}

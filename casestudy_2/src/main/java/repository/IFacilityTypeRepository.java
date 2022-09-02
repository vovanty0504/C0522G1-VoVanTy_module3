package repository;

import module.FacilityType;

import java.util.List;

public interface IFacilityTypeRepository {

    List<FacilityType> findAll();
}

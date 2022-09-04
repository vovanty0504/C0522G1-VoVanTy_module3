package repository;

import module.Facility;

import java.util.List;

public interface IFacilityRepository {

    List<Facility> findAll();

    boolean deleteFacility (int id);

    Facility findById(int id);

    boolean updateFacility (Facility facility);

    boolean create(Facility facility);

    List<Facility> search(String nameSearch, String facilityTypeSearch);

}


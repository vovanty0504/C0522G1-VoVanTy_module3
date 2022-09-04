package service;

import module.Facility;

import java.util.List;

public interface IFacilityService {

    List<Facility> findAll();

    boolean deleteFacility(int id);

    Facility findById(int id);

    boolean updateFacility (Facility facility);

    boolean create(Facility facility);

    List<Facility> search(String name, String facilityType);
}

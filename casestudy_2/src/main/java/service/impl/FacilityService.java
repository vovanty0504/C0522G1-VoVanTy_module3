package service.impl;

import module.Facility;
import repository.impl.FacilityRepository;
import service.IFacilityService;

import java.util.List;

public class FacilityService implements IFacilityService {
    private FacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public boolean deleteFacility(int id) {
        return facilityRepository.deleteFacility(id);
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public boolean updateFacility(Facility facility) {
        return facilityRepository.updateFacility(facility);
    }

    @Override
    public boolean create(Facility facility) {
        return facilityRepository.create(facility);
    }

    @Override
    public List<Facility> search(String name, String facilityType) {
        return facilityRepository.search(name,facilityType);
    }
}

package service.impl;

import module.FacilityType;
import repository.IFacilityTypeRepository;
import repository.impl.FacilityTypeRepository;
import service.IFacilityTypeService;

import java.util.List;

public class FacilityTypeService implements IFacilityTypeService {
    private IFacilityTypeRepository facilityTypeRepository = new FacilityTypeRepository();

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}

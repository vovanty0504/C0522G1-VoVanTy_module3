package service.impl;

import module.RentType;
import repository.IRentTypeRepository;
import repository.impl.RentTypeRepository;
import service.IRentTypeService;

import java.util.List;

public class RentTypeService implements IRentTypeService {
    private IRentTypeRepository rentTypeRepository = new RentTypeRepository();

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}

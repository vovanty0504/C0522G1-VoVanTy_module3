package service.impl;

import module.EducationDegree;
import repository.IEducationDegreeRepository;
import repository.impl.EducationDegreeRepository;
import service.IEducationDegreeService;

import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {
    private IEducationDegreeRepository iEducationDegreeRepository = new EducationDegreeRepository();

    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}

package service;

import module.EducationDegree;
import module.Position;
import service.impl.EducationDegreeService;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> findAll();
}

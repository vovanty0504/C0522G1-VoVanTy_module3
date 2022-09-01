package repository;

import module.Division;
import module.EducationDegree;

import java.util.List;

public interface IEducationDegreeRepository {
    List<EducationDegree> findAll();

    boolean create(EducationDegree educationDegree);



}

package repository;

import module.Division;
import module.Position;

import java.util.List;

public interface IPositionRepository {
    List<Position> findAll();

    boolean create(Position position);


}

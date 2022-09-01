package service;

import module.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();

    boolean create (Position position);
}

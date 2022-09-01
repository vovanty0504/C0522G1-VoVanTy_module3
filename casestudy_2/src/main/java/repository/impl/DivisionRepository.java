package repository.impl;

import module.Division;
import repository.IDivisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {
    private static final String SELECT_ALL_DIVISION = "select * from division;";
    private static final String INSERT_DIVISION = "insert into division(division_id,division_name) values (?,?)";


    @Override
    public List<Division> findAll() {
        List<Division> divisionList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DIVISION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("division_id");
                String name = resultSet.getString("division_name");
                divisionList.add(new Division(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisionList;
    }

    @Override
    public boolean create(Division division) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DIVISION);
            preparedStatement.setInt(1,division.getDivisionId());
            preparedStatement.setString(2,division.getDivisionName());
            int num = preparedStatement.executeUpdate();
            return (num==1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

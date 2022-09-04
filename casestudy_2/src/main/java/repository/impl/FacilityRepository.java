package repository.impl;

import module.Facility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements repository.IFacilityRepository {
    private static final String SELECT_ALL_FACILITY = "select * from facility where is_delete = 0";
    private static final String DELETE_FACILITY = "call facility_delete(?)";
    private static final String FIND_BY_ID_FACILITY = "select * from facility where facility_id = (?)";
    private static final String UPDATE_FACILITY = "call sp_update_facility (?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String INSERT_FACILITY_SQL = "insert into facility (facility_name, facility_area , facility_cost, " +
            "max_people, standard_room, description_other_convenience, pool_area, number_of_floors, facility_free," +
            "rent_type_id, facility_type_id)" +
            "values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SEARCH = "select * from facility f join facility_type t on f.facility_type_id = " +
            "t.facility_type_id where f.is_delete = 0 and f.facility_name like ? and t.facility_type_name like ?;";


    @Override
    public List<Facility> findAll() {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FACILITY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("facility_id");
                String name = resultSet.getString("facility_name");
                int area = resultSet.getInt("facility_area");
                double cost = resultSet.getDouble("facility_cost");
                int maxPeople = resultSet.getInt("max_people");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int facilityTypeId = resultSet.getInt("facility_type_id");
                facilityList.add(new Facility(id, name, area, cost, maxPeople, standardRoom, descriptionOtherConvenience,
                        poolArea, numberOfFloors, facilityFree, rentTypeId, facilityTypeId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return facilityList;
    }

    @Override
    public boolean deleteFacility(int id) {
        boolean rowDeleted = false;
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_FACILITY);
            callableStatement.setInt(1, id);
            rowDeleted = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public Facility findById(int id) {
        Facility facility = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_FACILITY);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idFacility = resultSet.getInt("facility_id");
                String name = resultSet.getString("facility_name");
                int area = resultSet.getInt("facility_area");
                double cost = resultSet.getDouble("facility_cost");
                int maxPeople = resultSet.getInt("max_people");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int facilityTypeId = resultSet.getInt("facility_type_id");
                facility = new Facility(idFacility, name, area, cost, maxPeople, standardRoom, descriptionOtherConvenience, poolArea,
                        numberOfFloors, facilityFree, rentTypeId, facilityTypeId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facility;
    }

    @Override
    public boolean updateFacility(Facility facility) {
        boolean rowUpdated;
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(UPDATE_FACILITY);
            callableStatement.setInt(1, facility.getFacilityId());
            callableStatement.setString(2, facility.getFacilityName());
            callableStatement.setInt(3, facility.getFacilityArea());
            callableStatement.setDouble(4, facility.getFacilityCost());
            callableStatement.setInt(5, facility.getFacilityMaxPeople());
            callableStatement.setString(6, facility.getFacilityStandardRoom());
            callableStatement.setString(7, facility.getFacilityDescriptionOtherConvenience());
            callableStatement.setDouble(8, facility.getFacilityPoolArea());
            callableStatement.setInt(9, facility.getFacilityNumberOfFloors());
            callableStatement.setString(10, facility.getFacilityFree());
            callableStatement.setInt(11, facility.getRentTypeId());
            callableStatement.setInt(12, facility.getFacilityTypeId());
            rowUpdated = callableStatement.executeUpdate() > 0;
            return rowUpdated;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean create(Facility facility) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FACILITY_SQL);
            preparedStatement.setString(1, facility.getFacilityName());
            preparedStatement.setInt(2, facility.getFacilityArea());
            preparedStatement.setDouble(3, facility.getFacilityCost());
            preparedStatement.setInt(4, facility.getFacilityMaxPeople());
            preparedStatement.setString(5, facility.getFacilityStandardRoom());
            preparedStatement.setString(6, facility.getFacilityDescriptionOtherConvenience());
            preparedStatement.setDouble(7, facility.getFacilityPoolArea());
            preparedStatement.setInt(8, facility.getFacilityNumberOfFloors());
            preparedStatement.setString(9, facility.getFacilityFree());
            preparedStatement.setInt(10, facility.getRentTypeId());
            preparedStatement.setInt(11, facility.getFacilityTypeId());
            int num = preparedStatement.executeUpdate();
            return (num == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Facility> search(String nameSearch, String facilityTypeSearch) {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + nameSearch + "%");
            preparedStatement.setString(2, "%" + facilityTypeSearch + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("facility_id");
                String name = resultSet.getString("facility_name");
                int area = resultSet.getInt("facility_area");
                double cost = resultSet.getDouble("facility_cost");
                int maxPeople = resultSet.getInt("max_people");
                String standard = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                int rentType = resultSet.getInt("rent_type_id");
                int facilityType = resultSet.getInt("facility_type_id");
                Facility facility = new Facility(id, name, area, cost, maxPeople, standard, description, poolArea, numberOfFloors,
                        facilityFree, rentType, facilityType);

                facilityList.add(facility);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return facilityList;
    }


}

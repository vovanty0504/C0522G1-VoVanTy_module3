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
}

package repository.impl;

import module.CustomerType;
import repository.ICustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    private static final String SELECT_ALL_CUSTOMER_TYPE = "select * from customer_type;";
    private static final String INSERT_CUSTOMER_TYPE_SQL = "INSERT INTO customer_type " +
            "(customer_type_id, customer_type_name) VALUES (?, ?);";

    public List<CustomerType> findByAll() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_type_name");
                customerTypeList.add(new CustomerType(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypeList;
    }

    @Override
    public boolean create(CustomerType customerType) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_TYPE_SQL);
            preparedStatement.setInt(1, customerType.getCustomerTypeId());
            preparedStatement.setString(2, customerType.getCustomerTypeName());
            int num = preparedStatement.executeUpdate();
            return (num == 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

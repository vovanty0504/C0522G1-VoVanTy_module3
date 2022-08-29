package repository.impl;

import module.Customer;
import repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String SELECT_ALL_CUSTOMER = "select * from customer where is_delete = 0;";
    private static final String INSERT_CUSTOMER_SQL = "insert into customer(customer_name, customer_birthday, customer_gender, " +
            "customer_id_card, customer_phone, customer_email, customer_address, customer_type_id)\n" +
            "values(?,?,?,?,?,?,?,?);";


    @Override
    public List<Customer> findByAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                String dayOfBirth = resultSet.getString("customer_birthday");
                int gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String numberPhone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                customerList.add(new Customer(id, name, dayOfBirth, gender, idCard, numberPhone, email, address, customerTypeId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean create(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerDateOfBirth());
            preparedStatement.setInt(3, customer.getCustomerGender());
            preparedStatement.setString(4, customer.getCustomerIdCard());
            preparedStatement.setString(5, customer.getCustomerPhoneNumber());
            preparedStatement.setString(6, customer.getCustomerEmail());
            preparedStatement.setString(7, customer.getCustomerAddress());
            preparedStatement.setInt(8, customer.getCustomerTypeId());
            int num = preparedStatement.executeUpdate();
            return (num == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

package repository.impl;

import module.Customer;
import repository.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String SELECT_ALL_CUSTOMER = "select * from customer where is_delete = 0;";
    private static final String INSERT_CUSTOMER_SQL = "insert into customer(customer_name, customer_birthday, customer_gender, " +
            "customer_id_card, customer_phone, customer_email, customer_address, customer_type_id)\n" +
            "values(?,?,?,?,?,?,?,?);";
    private static final String DELETE_CUSTOMER_SQL = "call customer_delete (?)";
    private static final String FIND_ID_CUSTOMER_SQL = "select * from customer where customer_id =(?)";
    private static final String UPDATE_CUSTOMER_SQL = "call sp_update_customer(?,?,?,?,?,?,?,?,?)";
    private static final String FIND_CUSTOMER_SQL = "select * from customer where customer_name like ? " +
            "and customer_address like ? and customer_phone like ? and is_delete = 0";
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

    @Override
    public boolean deleteCustomer(int id) {
        boolean rowDeleted = false;
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_CUSTOMER_SQL);
            callableStatement.setInt(1, id);
            rowDeleted = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID_CUSTOMER_SQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                int gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                customer = new Customer(idCustomer, name, birthday, gender, idCard, phone, email, address, customerTypeId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        boolean rowUpdated;
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(UPDATE_CUSTOMER_SQL);
            callableStatement.setInt(1, customer.getCustomerId());
            callableStatement.setString(2, customer.getCustomerName());
            callableStatement.setString(3, customer.getCustomerDateOfBirth());
            callableStatement.setInt(4, customer.getCustomerGender());
            callableStatement.setString(5, customer.getCustomerIdCard());
            callableStatement.setString(6, customer.getCustomerPhoneNumber());
            callableStatement.setString(7, customer.getCustomerEmail());
            callableStatement.setString(8, customer.getCustomerAddress());
            callableStatement.setInt(9, customer.getCustomerTypeId());
            rowUpdated = callableStatement.executeUpdate() > 0;
            return rowUpdated;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Customer> find(String name, String address, String phone) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CUSTOMER_SQL);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + address + "%");
            preparedStatement.setString(3, "%" + phone + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("customer_id");
                String nameCustomer = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                int gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String numberPhone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String addressCustomer = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                Customer customer = new Customer(idCustomer,nameCustomer,birthday,gender,idCard,numberPhone,email,addressCustomer,customerTypeId);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }


}

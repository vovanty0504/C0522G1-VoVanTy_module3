package repository.impl;

import module.Employee;
import repository.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee where is_delete = 0;";
    private static final String INSERT_EMPLOYEE = "insert into employee(employee_name,employee_birthday,employee_id_card," +
            "employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id) " +
            "values (?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_EMPLOYEE = "call employee_delete(?)";
    private static final String UPDATE_EMPLOYEE = "call sp_update_employee(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String FIND_BY_ID_EMPLOYEE = "select * from employee where employee_id = ?; ";
    private static final String FIND_EMPLOYEE_SQL = "select * from employee where employee_name like ? " +
            "and employee_address like ? and employee_phone like ? and is_delete = 0";


    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                employeeList.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean create(Employee employee) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeDateOfBirth());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhoneNumber());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            System.out.println(preparedStatement);
            int num = preparedStatement.executeUpdate();
            return (num == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {
        boolean rowDeleted = false;
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_EMPLOYEE);
            callableStatement.setInt(1, id);
            rowDeleted = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        boolean rowUpdated;
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(UPDATE_EMPLOYEE);
            callableStatement.setInt(1, employee.getEmployeeId());
            callableStatement.setString(2, employee.getEmployeeName());
            callableStatement.setString(3, employee.getEmployeeDateOfBirth());
            callableStatement.setString(4, employee.getEmployeeIdCard());
            callableStatement.setDouble(5, employee.getEmployeeSalary());
            callableStatement.setString(6, employee.getEmployeePhoneNumber());
            callableStatement.setString(7, employee.getEmployeeEmail());
            callableStatement.setString(8, employee.getEmployeeAddress());
            callableStatement.setInt(9, employee.getPositionId());
            callableStatement.setInt(10, employee.getEducationDegreeId());
            callableStatement.setInt(11, employee.getDivisionId());
            rowUpdated = callableStatement.executeUpdate() > 0;
            return rowUpdated;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_EMPLOYEE);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idEmployee = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int idPosition = resultSet.getInt("position_id");
                int idEducation = resultSet.getInt("education_degree_id");
                int idDivision = resultSet.getInt("division_id");
                employee = new Employee(idEmployee,name,birthday,idCard,salary,phone,email,address,idPosition,idEducation,idDivision);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> find(String name, String address, String phone) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_EMPLOYEE_SQL);
            preparedStatement.setString(1,"%" + name + "%");
            preparedStatement.setString(2,"%" + address + "%");
            preparedStatement.setString(3,"%" + phone+ "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idEmployee = resultSet.getInt("employee_id");
                String nameEmployee = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phoneEmployee = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String addressEmployee = resultSet.getString("employee_address");
                int idPosition = resultSet.getInt("position_id");
                int idEducation = resultSet.getInt("education_degree_id");
                int idDivision = resultSet.getInt("division_id");
                Employee employee = new Employee(idEmployee,nameEmployee,birthday,idCard,salary,phoneEmployee,email,
                        addressEmployee,idPosition,idEducation,idDivision);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}

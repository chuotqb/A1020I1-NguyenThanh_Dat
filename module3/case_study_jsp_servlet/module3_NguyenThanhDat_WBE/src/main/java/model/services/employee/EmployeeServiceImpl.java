package model.services.employee;

import model.bean.customer.Customer;
import model.bean.customer.TypeCustomer;
import model.bean.employee.Division;
import model.bean.employee.Education;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_POSITION = "select * from position";
    private static final String SELECT_ALL_DIVISION = "select * from division";
    private static final String SELECT_ALL_EDUCATION = "select * from education_degree";
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String SELECT_EMPLOYEE_BY_ID = "select employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id from employee where employee_id =?";
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee (employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id)" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,?,?);";
    private static final String UPDATE_EMPLOYEE = "update employee set employee_name =? , employee_birthday =?, employee_id_card =?, employee_salary =?, employee_phone =?, employee_email =?, employee_address =?,position_id =?,education_degree_id =?, division_id=? where employee_id = ?;";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id = ?;";
    private static final String SELECT_CUSTOMER_BY_NAME = "select * from employee where employee_name  like ?";


    @Override
    public List<Position> selectAllPosition() throws SQLException {
        List<Position> listPosition = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_POSITION);

            Position position = null;
            while (resultSet.next()) {
                position = new Position();
                position.setId(resultSet.getInt("position_id"));
                position.setName(resultSet.getString("position_name"));


                listPosition.add(position);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listPosition;
    }

    @Override
    public List<Education> selectAllEducation() throws SQLException {
        List<Education> listEducation = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_EDUCATION);

            Education education = null;
            while (resultSet.next()) {
                education = new Education();
                education.setId(resultSet.getInt("education_degree_id"));
                education.setName(resultSet.getString("education_degree_name"));


                listEducation.add(education);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listEducation;
    }

    @Override
    public List<Division> selectAllDevision() throws SQLException {
        List<Division> listDivision = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_DIVISION);

            Division division = null;
            while (resultSet.next()) {
                division = new Division();
                division.setId(resultSet.getInt("division_id"));
                division.setName(resultSet.getString("division_name"));


                listDivision.add(division);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listDivision;
    }

    @Override
    public List<Employee> selectAllEmployee() throws SQLException {
        List<Employee> listEmployee = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_EMPLOYEE);

            Employee employee = null;
            while (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("employee_name"));
                employee.setDayOfBirth(resultSet.getString("employee_birthday"));
                employee.setIdCard(resultSet.getString("employee_id_card"));
                employee.setSalary(resultSet.getDouble("employee_salary"));
                employee.setPhone(resultSet.getString("employee_phone"));
                employee.setEmail(resultSet.getString("employee_email"));
                employee.setAddress(resultSet.getString("employee_address"));
                employee.setIdPosition(resultSet.getInt("position_id"));
                employee.setIdEducation(resultSet.getInt("education_degree_id"));
                employee.setIdDivision(resultSet.getInt("division_id"));

                listEmployee.add(employee);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listEmployee;
    }

    @Override
    public boolean insertEmployee(Employee employee) throws SQLException {
        int row =0;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_EMPLOYEE_SQL);
            preparedStatement.setInt(1,employee.getId());
            preparedStatement.setString(2,employee.getName());
            preparedStatement.setString(3,employee.getDayOfBirth());
            preparedStatement.setString(4,employee.getIdCard());
            preparedStatement.setDouble(5,employee.getSalary());
            preparedStatement.setString(6,employee.getPhone());
            preparedStatement.setString(7,employee.getEmail());
            preparedStatement.setString(8,employee.getAddress());
            preparedStatement.setInt(9,employee.getIdPosition());
            preparedStatement.setInt(10,employee.getIdEducation());
            preparedStatement.setInt(11,employee.getIdDivision());
            row = preparedStatement.executeUpdate();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row>0;
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        try{
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("employee_name");
                String dayOfBirth = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int idPosition = resultSet.getInt("position_id");
                int idEducation = resultSet.getInt("education_degree_id");
                int idDivision = resultSet.getInt("division_id");

                employee = new Employee(id,name,dayOfBirth,idCard,salary,phone,email,address,idPosition,idEducation,idDivision);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated =false;
        try{
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(UPDATE_EMPLOYEE);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getDayOfBirth());
            preparedStatement.setString(3,employee.getIdCard());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5,employee.getPhone());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setInt(8,employee.getIdPosition());
            preparedStatement.setInt(9,employee.getIdEducation());
            preparedStatement.setInt(10,employee.getIdDivision());
            preparedStatement.setInt(11,employee.getId());
            rowUpdated = preparedStatement.executeUpdate()>0;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(DELETE_EMPLOYEE_SQL);
            preparedStatement.setInt(1,id);
            rowDeleted = preparedStatement.executeUpdate()>0;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public List<Employee> selectEmployeeByName(String name) throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_CUSTOMER_BY_NAME);
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();

            Employee employee = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String nameEmployee = resultSet.getString("employee_name");
                String dayOfBirth = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int idPosition = resultSet.getInt("position_id");
                int idEducation = resultSet.getInt("education_degree_id");
                int idDivision = resultSet.getInt("division_id");
                employee = new Employee(id,nameEmployee,dayOfBirth,idCard,salary,phone,email,address,idPosition,idEducation,idDivision);

                employeeList.add(employee);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }
}

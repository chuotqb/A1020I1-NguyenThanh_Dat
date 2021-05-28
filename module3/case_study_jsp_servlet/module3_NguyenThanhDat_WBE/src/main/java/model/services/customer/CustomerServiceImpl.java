package model.services.customer;

import model.bean.customer.Customer;
import model.bean.customer.TypeCustomer;
import model.repository.BaseRepository;
import model.services.customer.CustomerService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer (customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_TYPE_CUSTOMER = "SELECT * from customer_type";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String UPDATE_CUSTOMER = "update customer set customer_type_id= ?, customer_name =? , customer_birthday =?, customer_gender =?, customer_id_card =?, customer_phone =?, customer_email =?, customer_address =? where customer_id = ?;";
    private static final String SELECT_CUSTOMER_BY_ID = "select customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address from customer where customer_id =?";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    @Override
    public boolean insertCustomer(Customer customer) throws SQLException {
        int row =0;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setInt(1,customer.getId());
            preparedStatement.setInt(2,customer.getIdTypeCustomer());
            preparedStatement.setString(3,customer.getName());
            preparedStatement.setString(4,customer.getDayOfBirth());
            preparedStatement.setInt(5,customer.getGender());
            preparedStatement.setString(6,customer.getIdCard());
            preparedStatement.setString(7,customer.getPhone());
            preparedStatement.setString(8,customer.getEmail());
            preparedStatement.setString(9,customer.getAddress());
            row = preparedStatement.executeUpdate();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row>0;
    }

    @Override
    public List<TypeCustomer> selectAllTypeCustomers() {
        List<TypeCustomer> listTypeCustomers = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_TYPE_CUSTOMER);

            TypeCustomer typeCustomer = null;
            while (resultSet.next()) {
                typeCustomer = new TypeCustomer();
                typeCustomer.setIdTypeCustomer(resultSet.getInt("customer_type_id"));
                typeCustomer.setNameTypeCustomer(resultSet.getString("customer_type_name"));


                listTypeCustomers.add(typeCustomer);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listTypeCustomers;
    }

    @Override
    public List<Customer> selectAllCustomer() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CUSTOMER);

            Customer customer = null;
            while (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getInt("customer_id"));
                customer.setIdTypeCustomer(resultSet.getInt("customer_type_id"));
                customer.setName(resultSet.getString("customer_name"));
                customer.setDayOfBirth(resultSet.getString("customer_birthday"));
                customer.setGender(resultSet.getInt("customer_gender"));
                customer.setIdCard(resultSet.getString("customer_id_card"));
                customer.setPhone(resultSet.getString("customer_phone"));
                customer.setEmail(resultSet.getString("customer_email"));
                customer.setAddress(resultSet.getString("customer_address"));
                customerList.add(customer);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated =false;
        try{
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setInt(1,customer.getIdTypeCustomer());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getDayOfBirth());
            preparedStatement.setInt(4,customer.getGender());
            preparedStatement.setString(5,customer.getIdCard());
            preparedStatement.setString(6,customer.getPhone());
            preparedStatement.setString(7,customer.getEmail());
            preparedStatement.setString(8,customer.getAddress());
            preparedStatement.setInt(9,customer.getId());

            rowUpdated = preparedStatement.executeUpdate()>0;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        try{
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idTypeCustomer = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_name");
                String dayOfBirth = resultSet.getString("customer_birthday");
                int gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");

                customer = new Customer(id,idTypeCustomer,name,dayOfBirth,gender,idCard,phone,email,address);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(DELETE_CUSTOMER_SQL);
            preparedStatement.setInt(1,id);
            rowDeleted = preparedStatement.executeUpdate()>0;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }
}

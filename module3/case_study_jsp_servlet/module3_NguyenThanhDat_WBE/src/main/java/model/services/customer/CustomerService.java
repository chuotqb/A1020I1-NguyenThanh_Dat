package model.services.customer;

import model.bean.customer.Customer;
import model.bean.customer.TypeCustomer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    boolean insertCustomer (Customer customer) throws SQLException;
    List<TypeCustomer> selectAllTypeCustomers();
    List<Customer> selectAllCustomer() throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;
    Customer selectCustomer(int id);
    boolean deleteCustomer(int id) throws SQLException;
}

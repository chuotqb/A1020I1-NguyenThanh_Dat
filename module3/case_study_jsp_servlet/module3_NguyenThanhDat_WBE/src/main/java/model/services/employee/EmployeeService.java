package model.services.employee;

import model.bean.customer.Customer;
import model.bean.customer.TypeCustomer;
import model.bean.employee.Division;
import model.bean.employee.Education;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.bean.service.TypeRent;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    List<Position> selectAllPosition() throws SQLException;
    List<Education> selectAllEducation() throws SQLException;
    List<Division> selectAllDevision() throws SQLException;
    List<Employee> selectAllEmployee() throws SQLException;
    boolean insertEmployee (Employee employee) throws SQLException;
    Employee selectEmployee(int id);
    boolean updateEmployee(Employee employee) throws SQLException;
    boolean deleteEmployee(int id) throws SQLException;
    List<Employee> selectEmployeeByName(String name) throws SQLException;

}

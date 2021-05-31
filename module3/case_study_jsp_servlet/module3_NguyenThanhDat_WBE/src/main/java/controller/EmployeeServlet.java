package controller;

import model.bean.customer.Customer;
import model.bean.customer.TypeCustomer;
import model.bean.employee.Division;
import model.bean.employee.Education;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.services.customer.CustomerService;
import model.services.customer.CustomerServiceImpl;
import model.services.employee.EmployeeService;
import model.services.employee.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet" ,urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertEmployee(request, response);
                    break;
                case "edit":
                    updateEmployee(request,response);
                    break;
                case "delete":
                    deleteEmployee(request,response);
                    break;

            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try{
            switch (action) {
                case "create":
                    showNewForm(request,response);
                    break;
                case "edit":
                    showEditForm(request,response);
                    break;
                case "search":
                    searchByName(request,response);
                    break;
                default:
                    listEmployee(request,response);
                    break;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Employee> listEmployee = employeeService.selectAllEmployee();
        request.setAttribute("listEmployee",listEmployee);
        request.setAttribute("type","employee");
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        List<Employee> listEmployee = employeeService.selectAllEmployee();
        request.setAttribute("listEmployee",listEmployee);
        request.setAttribute("message","Employee Was Delete");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/list.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = employeeService.selectEmployee(id);
        request.setAttribute("employee",existingEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Position> positionList = employeeService.selectAllPosition();
        List<Education> educationList = employeeService.selectAllEducation();
        List<Division> divisionList = employeeService.selectAllDevision();
        request.setAttribute("positionList",positionList);
        request.setAttribute("educationList",educationList);
        request.setAttribute("divisionList",divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request,response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dayOfBirth");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idPosition = Integer.parseInt(request.getParameter("idPosition"));
        int idEducation = Integer.parseInt(request.getParameter("idEducation"));
        int idDivision = Integer.parseInt(request.getParameter("idDivision"));

        Employee editEmployee = new Employee(id,name,dayOfBirth,idCard,salary,phone,email,address,idPosition,idEducation,idDivision);
        employeeService.updateEmployee(editEmployee);
        request.setAttribute("message","New Customer Was Edited");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/edit.jsp");
        requestDispatcher.forward(request,response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dayOfBirth");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idPosition = Integer.parseInt(request.getParameter("idPosition"));
        int idEducation = Integer.parseInt(request.getParameter("idEducation"));
        int idDivision = Integer.parseInt(request.getParameter("idDivision"));

        Employee newEmployee = new Employee(id,name,dayOfBirth,idCard,salary,phone,email,address,idPosition,idEducation,idDivision);
        employeeService.insertEmployee(newEmployee);
        request.setAttribute("message","New Employee Was Created");
        List<Position> positionList = employeeService.selectAllPosition();
        List<Education> educationList = employeeService.selectAllEducation();
        List<Division> divisionList = employeeService.selectAllDevision();
        request.setAttribute("positionList",positionList);
        request.setAttribute("educationList",educationList);
        request.setAttribute("divisionList",divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request,response);
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("value");
        List<Employee> listEmployee = employeeService.selectEmployeeByName(name);
        request.setAttribute("listEmployee",listEmployee);
        System.out.println(listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request,response);
    }
}

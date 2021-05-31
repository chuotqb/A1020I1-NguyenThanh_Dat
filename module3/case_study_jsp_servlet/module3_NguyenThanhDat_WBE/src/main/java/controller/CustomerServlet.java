package controller;

import common.Validate;
import model.bean.customer.Customer;
import model.bean.customer.TypeCustomer;
import model.services.customer.CustomerService;
import model.services.customer.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "delete":
                    this.deleteCustomer(request, response);
                    break;
                case "create":
                    insertCustomer(request, response);
                    break;
                case "edit":
                    updateCustomer(request,response);
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
                case "delete":
                    deleteCustomer(request,response);
                    break;
                case "search":
                    searchByName(request,response);
                    break;
                default:
                    listCustomer(request,response);
                    break;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TypeCustomer> typeCustomerList = customerService.selectAllTypeCustomers();
        request.setAttribute("typeCustomerList",typeCustomerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerService.selectCustomer(id);
        request.setAttribute("customer",existingCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idTypeCustomer = Integer.parseInt(request.getParameter("typeCustomer"));
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dayOfBirth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String messageidCard = Validate.validateIdCard(idCard);
        String phone = request.getParameter("phone");
        String messagePhone = Validate.validatePhone(phone);
        String email = request.getParameter("email");
        String messageEmail = Validate.validateEmail(email);
        String address = request.getParameter("address");
        Customer customer = new Customer(id,idTypeCustomer,name,dayOfBirth,gender,idCard,phone,email,address);

        try {
            if (messageidCard == null && messagePhone == null && messageEmail == null) {
                customerService.insertCustomer(customer);
                customer = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<TypeCustomer> typeCustomerList = customerService.selectAllTypeCustomers();
        request.setAttribute("messageidCard", messageidCard);
        request.setAttribute("messagePhone", messagePhone);
        request.setAttribute("messageEmail", messageEmail);
        request.setAttribute("typeCustomerList",typeCustomerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Customer> listCustomer = customerService.selectAllCustomer();
        List<TypeCustomer> typeCustomerList = customerService.selectAllTypeCustomers();
        request.setAttribute("listCustomer",listCustomer);
        request.setAttribute("type","customer");
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request,response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idTypeCustomer = Integer.parseInt(request.getParameter("typeCustomer"));
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dayOfBirth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer editCustomer = new Customer(id,idTypeCustomer,name,dayOfBirth,gender,idCard,phone,email,address);
        customerService.updateCustomer(editCustomer);
        request.setAttribute("message","New Customer Was Edited");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/edit.jsp");
        requestDispatcher.forward(request,response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.deleteCustomer(id);
        List<Customer> listCustomer = customerService.selectAllCustomer();
        request.setAttribute("listCustomer",listCustomer);
        request.setAttribute("message","Customer Was Delete");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        requestDispatcher.forward(request,response);
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("value");
        List<Customer> listCustomer = customerService.selectCustomerByName(name);
        request.setAttribute("listCustomer",listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request,response);
    }


}

package servlet;

import bean.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(new Customer("Dat","1990-12-12","Quang Binh","../img/1.jpg"));
        customerList.add(new Customer("Tuan","1991-02-14","Ha Noi","../img/2.jpg"));
        customerList.add(new Customer("Linh","1995-05-04","Ho Chi Minh","../img/3.jpg"));
        customerList.add(new Customer("Trang","1993-01-30","Da Nang","../img/4.jpg"));

        request.setAttribute("listCustomer",customerList);
        request.getRequestDispatcher("list_customer.jsp").forward(request,response);
    }
}

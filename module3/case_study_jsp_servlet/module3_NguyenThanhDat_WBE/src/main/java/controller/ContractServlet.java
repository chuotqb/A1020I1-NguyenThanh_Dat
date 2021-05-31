package controller;

import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;
import model.bean.customer.Customer;
import model.bean.customer.TypeCustomer;
import model.services.contract.ContractService;
import model.services.contract.ContractServiceImpl;
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

@WebServlet(name = "ContractServlet",urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    ContractService contractService = new ContractServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try{
            switch (action) {
                case "create":
                    insertContract(request,response);
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
                    showNewFormContract(request,response);
                    break;
                default:
                    listContract(request,response);
                    break;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Contract> listContract = contractService.selectAllContract();
        request.setAttribute("listCustomer",listContract);
        request.setAttribute("type","contract");
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showNewFormContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> listContract = contractService.selectAllContract();
        request.setAttribute("listContract",listContract);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");
        dispatcher.forward(request,response);
    }

    private void insertContract(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        int idEmployee = Integer.parseInt(request.getParameter("idEmployee"));
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        int idService = Integer.parseInt(request.getParameter("idService"));

        Contract newContract = new Contract(id,startDate,endDate,deposit,totalMoney,idEmployee,idCustomer,idService);
        contractService.insertContract(newContract);
        request.setAttribute("message","New Contract Was Created");
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");
        dispatcher.forward(request,response);
    }
}

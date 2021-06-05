package controller;

import model.bean.Rent;
import model.bean.StatusRent;
import model.bean.TypeRent;
import model.services.RentService;
import model.services.impl.RentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MainServlet",urlPatterns = "/")
public class MainServlet extends HttpServlet {
    RentService rentService = new RentServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertRent(request, response);
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
        switch (action) {
            case "create":
                showNewForm(request,response);
                break;
            default:
                listRent(request,response);
                break;
        }
    }

    private void insertRent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String idRent = request.getParameter("idRent");
        int area = Integer.parseInt(request.getParameter("area"));
        int idStatus = Integer.parseInt(request.getParameter("idStatus"));
        int numOfFloor = Integer.parseInt(request.getParameter("numOfFloor"));
        int idType = Integer.parseInt(request.getParameter("idType"));
        int cost = Integer.parseInt(request.getParameter("cost"));
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");


        Rent rent = new Rent(idRent,area,idStatus,numOfFloor,idType,cost,startDate,endDate);
        rentService.insertRent(rent);
        request.setAttribute("message","New Rent Was Created");
        List<StatusRent> listStatus = rentService.selectAllStatusRent();
        request.setAttribute("listStatus",listStatus);
        RequestDispatcher dispatcher = request.getRequestDispatcher("rent/create.jsp");
        dispatcher.forward(request,response);

    }

    private void listRent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Rent> listRent = rentService.selectAllRent();
        request.setAttribute("listRent",listRent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("rent/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TypeRent> listType = rentService.selectAllTypeRent();
        List<StatusRent> listStatus = rentService.selectAllStatusRent();
        request.setAttribute("listType",listType);
        request.setAttribute("listStatus",listStatus);
        RequestDispatcher dispatcher = request.getRequestDispatcher("rent/create.jsp");
        dispatcher.forward(request,response);
    }
}

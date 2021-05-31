package controller;

import model.bean.customer.Customer;
import model.bean.customer.TypeCustomer;
import model.bean.service.Services;
import model.bean.service.TypeRent;
import model.bean.service.TypeService;
import model.services.service.ServiceManager;
import model.services.service.ServiceManagerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    ServiceManager serviceManager = new ServiceManagerImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertService(request, response);
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
                default:
                    listService(request,response);
                    break;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void listService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Services> listServices = serviceManager.selectAllService();
        request.setAttribute("listServices",listServices);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<TypeRent> typeRentList = serviceManager.selectAllTypeRent();
        List<TypeService> typeServiceList = serviceManager.selectAllTypeService();
        request.setAttribute("typeRentList",typeRentList);
        request.setAttribute("typeServiceList",typeServiceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
        dispatcher.forward(request,response);

    }

    private void insertService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int idTypeRent = Integer.parseInt(request.getParameter("typeRent"));
        int idTypeService = Integer.parseInt(request.getParameter("typeService"));
        String standardRoom = "";
        if (request.getParameter("standardRoom").isEmpty()){
            standardRoom="";
        }else {
           standardRoom = request.getParameter("standardRoom");
        }
        String desc = "";
        if (request.getParameter("desc").isEmpty()){
            desc = "";
        }else {
            desc = request.getParameter("desc");
        }
        double areaPool =0;
        if (request.getParameter("areaPool").isEmpty()){
            areaPool=0;
        }else {
            areaPool = Double.parseDouble(request.getParameter("areaPool"));
        }
        int numOfFloor=0;
        if (request.getParameter("numOfFloor").isEmpty()){
            numOfFloor =0;
        }else {
            numOfFloor = Integer.parseInt(request.getParameter("numOfFloor"));
        }
        Services services = new Services(id,name,area,cost,maxPeople,idTypeRent,idTypeService,standardRoom,desc,areaPool,numOfFloor);
        serviceManager.insertService(services);
        request.setAttribute("message","New Service Was Created");
        List<TypeRent> typeRentList = serviceManager.selectAllTypeRent();
        List<TypeService> typeServiceList = serviceManager.selectAllTypeService();
        request.setAttribute("typeRentList",typeRentList);
        request.setAttribute("typeServiceList",typeServiceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
        dispatcher.forward(request,response);
    }
}

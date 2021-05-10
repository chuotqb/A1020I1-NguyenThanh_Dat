package Servlet;

import Bean.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float numberOne= Integer.parseInt(request.getParameter("first-operand"));
        float numberTwo= Integer.parseInt(request.getParameter("second-operand"));
        char choose = request.getParameter("operator").charAt(0);


        try {
            float result = Calculator.calculate(numberOne,numberTwo,choose);
            request.setAttribute("result",result);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }catch (Exception ex) {
            request.setAttribute("msg",ex.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<h1>Result:<h1>");
//        try {
//            float result = Calculator.calculate(numberOne,numberTwo,choose);
//            writer.println(numberOne+""+choose+""+numberTwo+"="+result);
//        }catch (Exception ex) {
//            writer.println("Error: "+ex.getMessage());
//        }
//        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

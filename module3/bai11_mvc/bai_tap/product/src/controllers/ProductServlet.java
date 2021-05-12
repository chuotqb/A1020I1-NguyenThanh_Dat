package controllers;

import models.Product;
import services.ProductService;
import services.ProductServiceIImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceIImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
                updateCustomer(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "findByName":
                findByName(request,response);
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "viewByID":
                viewProductById(request,response);
                break;
            case "findByName":
                showFindByNameForm(request,response);
                break;
            default:
                listProducts(request,response);
                break;
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response){
        List<Product> products = productService.display();
        request.setAttribute("products",products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/display.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request,HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name= request.getParameter("name");
        double cost = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String supplier = request.getParameter("supplier");

        Product product = new Product(id,name,cost,description,supplier);
        this.productService.add(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message","New product was created");
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product==null){
            dispatcher = request.getRequestDispatcher("error=404.jsp");
        }else {
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String supplier = request.getParameter("supplier");
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product==null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            product.setId(id);
            product.setName(name);
            product.setCost(price);
            product.setDescription(description);
            product.setSponsor(supplier);
            this.productService.update(id,product);
            request.setAttribute("product",product);
            request.setAttribute("message","Product information was update");
            dispatcher=request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product==null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("product/delete.jsp");
        }
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request,HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product==null){
            dispatcher=request.getRequestDispatcher("error-404.jsp");
        }else {
            this.productService.remove(id);
            try {
                response.sendRedirect("/product");
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void viewProductById(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product==null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");

        }else {
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("product/view.jsp");
        }
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showFindByNameForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/findByName.jsp");
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameProduct");
        Product product = this.productService.findByName(name);
        RequestDispatcher dispatcher;
        if (product==null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");

        }else {
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("product/findByName.jsp");
        }
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}

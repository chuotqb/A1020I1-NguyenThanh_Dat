package Manager;

import Commons.FuncFileCSV;
import Models.Customer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ManagerCinema {
    static ArrayList<Customer> customerList = new ArrayList<>();
    public static void ticketCustomer(){
        customerList = FuncFileCSV.getFileCSVToListCustomer();
        Queue<Customer> ticketQueue = new LinkedList<>();
        ticketQueue.add(customerList.get(1));
        ticketQueue.add(customerList.get(0));
        ticketQueue.add(customerList.get(2));
        System.out.println("Danh sách khách hàng xem phim");
        Customer customer;
        while (!ticketQueue.isEmpty()){
            customer = ticketQueue.poll();
            customer.showInfor();
        }
    }
    public static void main(String[] args) {
        ticketCustomer();
    }

}

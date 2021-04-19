package Manager;

import Commons.FuncFileCSV;
import Controllers.MainController;
import Models.Customer;
import Models.Villa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class ManagerCustomer {


    static ArrayList<Customer> customerList = new ArrayList<>();

    public static void addNewCustomer() {
        customerList = FuncFileCSV.getFileCSVToListCustomer();
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        do {
            System.out.println("Name Customer: ");
            String nameCustomer = scanner.nextLine();
            if (Regex.validateCustomer(nameCustomer, "nameCustomer")) {
                customer.setNameCustomer(nameCustomer);
                break;
            } else {
                System.out.println("Tên khách hàng phải in hoa ký tự trong mỗi từ ");
            }
        } while (true);
        do {

            Date now = new Date();
            System.out.println("Day Of Birth: ");
            String birthdayCustomer = scanner.nextLine();
            if (Regex.validateCustomer(birthdayCustomer, "birthdayCustomer")) {
                String year = birthdayCustomer.substring(birthdayCustomer.lastIndexOf("/") + 1);
                int intYear = Integer.parseInt(year);
                if ((now.getYear() + 1900 - intYear) > 18 && intYear > 1900) {
                    customer.setDayOfBirth(birthdayCustomer);
                    break;
                } else {
                    System.out.println("Năm sinh phải >1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy");
                }
            } else {
                System.out.println("Năm sinh phải >1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy");
            }
        } while (true);

        do {
            System.out.println("Gender: ");
            String genderCustomer = scanner.nextLine();
            genderCustomer.toLowerCase();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Character.toUpperCase(genderCustomer.charAt(0)));
            for (int i = 1; i < genderCustomer.length(); i++) {
                stringBuilder.append(Character.toLowerCase(genderCustomer.charAt(i)));

            }
            if (Regex.validateCustomer(String.valueOf(stringBuilder), "genderCustomer")) {
                customer.setGender(String.valueOf(stringBuilder));
                break;
            } else {
                System.out.println("Giới tính không đúng với định dạng");
            }
        } while (true);
        do {
            System.out.println("iD Card: ");
            String idCardCustomer = scanner.nextLine();
            if (Regex.validateCustomer(idCardCustomer, "idCardCustomer")) {
                customer.setIdCard(idCardCustomer);
                break;
            } else {
                System.out.println("Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX");
            }
        } while (true);

        System.out.println("Phone Number: ");
        customer.setPhoneNumber(scanner.nextLine());
        do {
            System.out.println("Email: ");
            String emailCustomer = scanner.nextLine();
            if (Regex.validateCustomer(emailCustomer, "emailCustomer")) {
                customer.setEmail(emailCustomer);
                break;
            } else {
                System.out.println("Email phải đúng định dạng abc@abc.abc");
            }
        } while (true);
        System.out.println("Type Customer: ");
        customer.setTypeCustomer(scanner.nextLine());
        System.out.println("Address: ");
        customer.setAddress(scanner.nextLine());
        customerList.add(customer);
        FuncFileCSV.writeCustomerToFileCSV(customerList);
        System.out.println("Add new villa complete! Enter to countinue...");
        scanner.nextLine();
        MainController.displayMainMenu();
    }

    public static void showCustomer() {
        customerList = FuncFileCSV.getFileCSVToListCustomer();
        System.out.println("List Customer Below");
        YearCustomerComparator yearCustomerComparator = new YearCustomerComparator();
        Collections.sort(customerList,yearCustomerComparator);
        for (Customer customer : customerList) {
            customer.showInfor();
        }
    }
        public static void addNewBooking() {
            customerList.clear();
            customerList = FuncFileCSV.getFileCSVToListCustomer();
            showCustomer();
            Scanner scanner = new Scanner(System.in);
            int chooseCustomer;
            chooseCustomer = Integer.parseInt(scanner.nextLine());
            String idCard = customerList.get(chooseCustomer - 1).getIdCard();

            System.out.println("Choose: ");
            System.out.println("1.\t Booking Villa \n" +
                    "2.\t Booking House \n" +
                    "3.\t Booking Room \n");
            String chooseBooking;
            chooseBooking = scanner.nextLine();
            switch (chooseBooking) {
                case "1":
                    ManagerServices.showVilla();
                    int chooseVilla;

                    break;
                case "2":
                    ManagerServices.showHouse();
                    break;
                case "3":
                    ManagerServices.showRoom();
                    break;
                default:
                    System.out.println("Fail! Please choose again! Enter to continue...");
                    scanner.nextLine();
                    MainController.displayMainMenu();
            }
        }
    }

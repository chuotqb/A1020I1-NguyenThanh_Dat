package Controllers;

import Commons.FuncFileCSV;
import Manager.ManagerCustomer;
import Manager.ManagerEmployee;
import Manager.ManagerServices;
import Models.Villa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainController {
    Scanner scanner=new Scanner(System.in);
    public static void displayMainMenu() {
        System.out.println("1.\t Add New Services \n" +
                "2.\t Show Services \n" +
                "3.\t Add New Customer \n" +
                "4.\t Show Information of Customer \n" +
                "5.\t Add New Booking \n" +
                "6.\t Show Information of Employee \n" +
                "7.\t Exit \n");
    }

    public static void main(String[] args) {
        ManagerEmployee managerEmployee = new ManagerEmployee();
        ManagerCustomer managerCustomer = new ManagerCustomer();
        String chooseDisplay;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMainMenu();
            System.out.println("Choose:  ");
            chooseDisplay = scanner.nextLine();
            switch (chooseDisplay) {
                case "1":
                    addNewServices();
                    break;
                case "2":
                    showServices();
                    break;
                case "3":
                    managerCustomer.addNewCustomer();
                    break;
                case "4":
                    managerCustomer.showCustomer();
                    break;
                case "5":
                    managerCustomer.addNewBooking();
                    break;
                case "6":
                    managerEmployee.showEmployee();
                    break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Fail! Please choose again! Enter to continue...");
                    scanner.nextLine();
                    displayMainMenu();
            }
        }
    }

    public static void addNewServices() {
        ManagerServices managerServices = new ManagerServices();
        System.out.println("choose: ");
        System.out.println("1.\t Add New Villa \n" +
                "2.\t Add New House \n" +
                "3.\t Add New Room \n" +
                "4.\t Back to menu \n" +
                "5.\t Exit \n" );
        String chooseServices;
        Scanner scanner = new Scanner(System.in);
        chooseServices=scanner.nextLine();
        switch (chooseServices){
            case "1":
                managerServices.addNewVilla();
                break;
            case "2":
                managerServices.addNewHouse();
                break;
            case "3":
                managerServices.addnewRoom();
                break;
            case "4":
                displayMainMenu();
                break;
            case "5":
                System.exit(0);
            default:
                System.out.println("Fail! Please choose again! Enter to continue...");
                scanner.nextLine();
                displayMainMenu();

        }
    }

    private static void showServices(){
        ManagerServices managerServices = new ManagerServices();
        System.out.println("choose: ");
        System.out.println("1.\t Show all Villa \n" +
                "2.\t Show all House \n" +
                "3.\t Show all Room \n" +
                "4.\t Show All Name Villa Not Duplicate \n" +
                "5.\t Show All Name House Not Duplicate \n" +
                "6.\t Show All Name Room Not Duplicate \n" +
                "7.\t Back to menu \n" +
                "8.\t Exit \n" );
        String chooseShowServices;
        Scanner scanner = new Scanner(System.in);
        chooseShowServices=scanner.nextLine();
        switch (chooseShowServices){
            case "1":
                managerServices.showVilla();
                break;
            case "2":
                managerServices.showHouse();
                break;
            case "3":
                managerServices.showRoom();
                break;
            case "4":
                managerServices.showVillaNotDuplicate();
                break;
            case "5":
                managerServices.showHouseNotDuplicate();
                return;
            case "6":
                managerServices.showRoomNotDuplicate();
                return;
            case "7":
                displayMainMenu();
            case "8":
                System.exit(0);
            default:
                System.out.println("Fail! Please choose again! Enter to continue...");
                scanner.nextLine();
                displayMainMenu();

        }
    }
}



package Models;

import Commons.FuncFileCSV;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class FileCabinet {
    static ArrayList<Employee> employeeList = new ArrayList<>();

        private static Employee getFileOfEmployee (String id) {
            Stack<Employee> fileCabinetEmployee = new Stack<>();
            employeeList = FuncFileCSV.getFileCSVToListEmployee();
            for (Employee employee : employeeList) {
                fileCabinetEmployee.push(employee);
            }
            Employee employee = new Employee();
            while (!fileCabinetEmployee.isEmpty()) {
                employee = fileCabinetEmployee.pop();
                if (employee.getId().equals(id)) {
                    return employee;
                }
            }
            return employee;
        }

        public static void findFIleOfEmployee(){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please input employee id to get file: ");
            String id = scanner.nextLine();

            Employee employee = getFileOfEmployee(id);

            if (employee !=null){
                System.out.println("File employee: "+ employee.toString());
            }else {
                System.out.println("File employee is not found");
            }

        }

    public static void main(String[] args) {
        findFIleOfEmployee();
    }
}

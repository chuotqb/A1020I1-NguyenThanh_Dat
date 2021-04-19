package Manager;

import Commons.FuncFileCSV;
import Models.Employee;
import Models.Room;

import java.util.*;

public class ManagerEmployee {
    static ArrayList<Employee> employeeList = new ArrayList<>();
    public static void showEmployee(){
        employeeList = FuncFileCSV.getFileCSVToListEmployee();
        Map<String,Employee> mapEmployee = new TreeMap<>();
        for (int i=0;i<employeeList.size();i++){
                mapEmployee.put(employeeList.get(i).getId(),employeeList.get(i));

        }
        for (Map.Entry<String, Employee> employeeEntry : mapEmployee.entrySet()){
            System.out.println(employeeEntry.getKey() + " " + employeeEntry.getValue().toString());
        }
//        System.out.println("List Employee Below");
////        Set<Employee> set = mapEmployee.keySet();
//        for (Object key: set){
//            System.out.println(key+" "+mapEmployee.get(key));
//        }
//        for (Map.Entry<Integer,Employee> entry : mapEmployee.entrySet()){
//            System.out.println(entry.getKey()+":"+entry.getValue().showInfor(););
//        }
    }
}

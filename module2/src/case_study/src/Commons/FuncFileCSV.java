package Commons;

import Models.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FuncFileCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String fileVilla = "src/Data/Villa.csv";
    private static final String fileHouse = "src/Data/House.csv";
    private static final String fileRoom = "src/Data/Room.csv";
    private static final String fileCustomer = "src/Data/Customer.csv";
    private static final String fileEmployee = "src/Data/Employee.csv";
    //header file CSV
    private static final String FILE_HEADER_VILLA = "id,nameServices,areaUse,feeRent,numberMaxPeople,typeRent,standardRoom,descriptionOthers,areaPool,numberFloors";
    private static final String FILE_HEADER_HOUSE = "id,nameServices,areaUse,feeRent,numberMaxPeople,typeRent,freeServie";
    private static final String FILE_HEADER_ROOM = "id,nameServices,areaUse,feeRent,numberMaxPeople,typeRent,standardRoom,descriptionOthers,numberFloors";
    private static final String FILE_HEADER_CUSTOMER = "nameCustomer,dayOfBirth,gender,idCard,phoneNumber,email,typeCustomer,address";
    private static final String FILE_HEADER_EMPLOYEE = "nameCustomer,dayOfBirth,gender,idCard,phoneNumber,email,typeCustomer,address";


    public static void writeVillasToFileCSV(ArrayList<Villa> listVilla) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileVilla);
            fileWriter.append(FILE_HEADER_VILLA);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Villa villa : listVilla) {
                fileWriter.append(villa.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getNameServices());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getAreaUse()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getFeeRent()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getNumberMaxPeople()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getTypeRent());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getStandardRoom());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getDescriptionOthers());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getAreaPool()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getNumberFloors()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception ex) {
            System.out.println("Error in CsvFileVillaWriter !!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();

            } catch (Exception ex) {
                System.out.println("Error when flush or close");
            }
        }
    }
    public static void writeHouseToFileCSV(ArrayList<House> listHouse) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileHouse);
            fileWriter.append(FILE_HEADER_HOUSE);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (House house : listHouse) {
                fileWriter.append(house.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getNameServices());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getAreaUse()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getFeeRent()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getNumberMaxPeople()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getTypeRent());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getStandardRoom());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getDescriptionOthers());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getNumberFloors()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception ex) {
            System.out.println("Error in CsvFileHouseWriter !!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();

            } catch (Exception ex) {
                System.out.println("Error when flush or close");
            }
        }
    }
    public static void writeRoomToFileCSV(ArrayList<Room> listRoom) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileRoom);
            fileWriter.append(FILE_HEADER_ROOM);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Room room : listRoom) {
                fileWriter.append(room.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(room.getNameServices());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getAreaUse()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getFeeRent()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getNumberMaxPeople()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(room.getTypeRent());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(room.getFreeService());
                fileWriter.append(COMMA_DELIMITER);
            }
        } catch (Exception ex) {
            System.out.println("Error in CsvFileRoomWriter !!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();

            } catch (Exception ex) {
                System.out.println("Error when flush or close");
            }
        }
    }
    public static ArrayList<Villa> getFileCSVToListVilla() {
        BufferedReader br = null;
        ArrayList<Villa> listVilla = new ArrayList<Villa>();
        Path path= Paths.get(fileVilla);
        if (!Files.exists(path)){
            try{
                Writer writer = new FileWriter(fileVilla);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileVilla));
            while ((line=br.readLine())!=null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("id")) {
                    continue;
                }
                Villa villa = new Villa();
                villa.setId(splitData[0]);
                villa.setNameServices(splitData[1]);
                villa.setAreaUse(Double.parseDouble(splitData[2]));
                villa.setFeeRent(Double.parseDouble(splitData[3]));
                villa.setNumberMaxPeople(Integer.parseInt(splitData[4]));
                villa.setTypeRent(splitData[5]);
                villa.setStandardRoom(splitData[6]);
                villa.setDescriptionOthers(splitData[7]);
                villa.setAreaPool(Double.parseDouble(splitData[8]));
                villa.setNumberFloors(Integer.parseInt((splitData[9])));
                listVilla.add(villa);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return listVilla;
    }
    public static ArrayList<House> getFileCSVToListHouse() {
        BufferedReader br = null;
        ArrayList<House> listHouse = new ArrayList<House>();
        Path path= Paths.get(fileHouse);
        if (!Files.exists(path)){
            try{
                Writer writer = new FileWriter(fileHouse);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileHouse));
            while ((line=br.readLine())!=null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("id")) {
                    continue;
                }
                House house = new House();
                house.setId(splitData[0]);
                house.setNameServices(splitData[1]);
                house.setAreaUse(Double.parseDouble(splitData[2]));
                house.setFeeRent(Double.parseDouble(splitData[3]));
                house.setNumberMaxPeople(Integer.parseInt(splitData[4]));
                house.setTypeRent(splitData[5]);
                house.setStandardRoom(splitData[6]);
                house.setDescriptionOthers(splitData[7]);
                house.setNumberFloors(Integer.parseInt((splitData[8])));
                listHouse.add(house);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return listHouse;
    }
    public static ArrayList<Room> getFileCSVToListRoom() {
        BufferedReader br = null;
        ArrayList<Room> listRoom = new ArrayList<Room>();
        Path path= Paths.get(fileRoom);
        if (!Files.exists(path)){
            try{
                Writer writer = new FileWriter(fileRoom);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileRoom));
            while ((line=br.readLine())!=null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("id")) {
                    continue;
                }
                Room room = new Room();
                room.setId(splitData[0]);
                room.setNameServices(splitData[1]);
                room.setAreaUse(Double.parseDouble(splitData[2]));
                room.setFeeRent(Double.parseDouble(splitData[3]));
                room.setNumberMaxPeople(Integer.parseInt(splitData[4]));
                room.setTypeRent(splitData[5]);
                room.setFreeService(splitData[6]);
                listRoom.add(room);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return listRoom;
    }
    public static void writeCustomerToFileCSV(ArrayList<Customer> listCustomer){
        FileWriter fileWriter = null;
        try{
            fileWriter= new FileWriter(fileCustomer);
            fileWriter.append(FILE_HEADER_CUSTOMER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Customer customer : listCustomer){
                fileWriter.append(customer.getNameCustomer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getDayOfBirth());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getGender());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getIdCard());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getPhoneNumber());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getTypeCustomer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getAddress());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        }catch (Exception ex){
            System.out.println("Error in  CsvFileCustomerWriter");
        }finally {
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception ex){
                System.out.println("Error when flush or close");
            }
        }
    }
    public static ArrayList<Customer> getFileCSVToListCustomer(){
        BufferedReader br = null;
        ArrayList<Customer> listCustomer = new ArrayList<Customer>();
        Path path= Paths.get(fileCustomer);
        if (!Files.exists(path)){
            try{
                Writer writer = new FileWriter(fileCustomer);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileCustomer));
            while ((line=br.readLine())!=null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("nameCustomer")) {
                    continue;
                }
                Customer customer = new Customer();
                customer.setNameCustomer(splitData[0]);
                customer.setDayOfBirth(splitData[1]);
                customer.setGender(splitData[2]);
                customer.setIdCard(splitData[3]);
                customer.setPhoneNumber(splitData[4]);
                customer.setEmail(splitData[5]);
                customer.setTypeCustomer(splitData[6]);
                customer.setAddress(splitData[7]);
                listCustomer.add(customer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return listCustomer;

    }
    public static ArrayList<Employee> getFileCSVToListEmployee(){
        BufferedReader br = null;
        ArrayList<Employee> listEmployee = new ArrayList<Employee>();
        Path path= Paths.get(fileEmployee);
        if (!Files.exists(path)){
            try{
                Writer writer = new FileWriter(fileEmployee);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileEmployee));
            while ((line=br.readLine())!=null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("id")) {
                    continue;
                }
                Employee employee = new Employee();
                employee.setId(splitData[0]);
                employee.setNameEmployee(splitData[1]);
                employee.setAge(splitData[2]);
                employee.setAddress(splitData[3]);
                listEmployee.add(employee);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return listEmployee;
    }
}

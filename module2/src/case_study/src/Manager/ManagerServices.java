package Manager;

import Commons.FuncFileCSV;
import Models.House;
import Models.Room;
import Models.Villa;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class ManagerServices {
    public ManagerServices() {
    }
    static ArrayList<Villa> villaList=new ArrayList<>();
    static ArrayList<House> houseList=new ArrayList<>();
    static ArrayList<Room> roomList=new ArrayList<>();
    public static void addNewVilla() {
        villaList = FuncFileCSV.getFileCSVToListVilla();
        Scanner scanner=new Scanner(System.in);
        Villa villa=new Villa();
        do {
            System.out.println("ID: ");
            String id=scanner.nextLine();
            if (Regex.validateServices(id,"id")){
                villa.setId(id);
                break;
            }
        }while (true);

        do {
            System.out.println("Tên dịch vụ: ");
            villa.setNameServices(scanner.nextLine());
        }while (!Regex.validateServices(villa.getNameServices(),"nameServices"));

        do {
            System.out.println("Diện tích sử dụng: ");
            villa.setAreaUse(scanner.nextInt());
        }while (!(villa.getAreaUse()>0&&villa.getAreaUse()>30));
        scanner.nextLine();
        do {
            System.out.println("Chi phí thuê: ");
            villa.setFeeRent(scanner.nextInt());
        }while (!(villa.getFeeRent()>0));
        do {
            System.out.println("Số lượng người tối đa: ");
            villa.setNumberMaxPeople(scanner.nextInt());
        }while (!(villa.getNumberMaxPeople()>0&&villa.getNumberMaxPeople()<20));
        scanner.nextLine();
        do {
            System.out.println("Kiểu thuê: ");
            villa.setTypeRent(scanner.nextLine());
        }while (!Regex.validateServices(villa.getTypeRent(),"typeRent"));
        do {
            System.out.println("Tiêu chuẩn phòng: ");
            villa.setStandardRoom(scanner.nextLine());
        }while (!Regex.validateServices(villa.getStandardRoom(),"standarRoom"));
        do {
            System.out.println("Mô tả tiện nghi khác: ");
            villa.setDescriptionOthers(scanner.nextLine());
        }while (!Regex.validateServices(villa.getDescriptionOthers(),"decriptionOthers"));
        do {
            System.out.println("Diện tích hồ bơi: ");
            villa.setAreaPool(scanner.nextInt());
        }while (!(villa.getAreaPool()>0&&villa.getAreaPool()>30));
        do {
            System.out.println("Số tầng: ");
            villa.setNumberFloors(scanner.nextInt());
        }while (!(villa.getNumberFloors()>0));

        villaList.add(villa);
        FuncFileCSV.writeVillasToFileCSV(villaList);
        System.out.println("Add new villa complete! Enter to countinue...");
        scanner.nextLine();

    }
    public static void addNewHouse(){
        houseList = FuncFileCSV.getFileCSVToListHouse();
        Scanner scanner=new Scanner(System.in);
        House house=new House();
        do {
            System.out.println("ID: ");
            String id = scanner.nextLine();
            if (Regex.validateServices(id,"id")){
                house.setId(id);
                break;
            }
        }while (true);
        do {
            System.out.println("Tên dịch vụ: ");
            house.setNameServices(scanner.nextLine());
        }while (!Regex.validateServices(house.getNameServices(),"nameServices"));
        do {
            System.out.println("Diện tích sử dụng: ");
            house.setAreaUse(scanner.nextInt());
        }while (!(house.getAreaUse()>0&&house.getAreaUse()>30));
        do {
            System.out.println("Chi phí thuê: ");
            house.setFeeRent(scanner.nextInt());
        }while (!(house.getFeeRent()>0));
        do {
            System.out.println("Số lượng người tối đa: ");
            house.setNumberMaxPeople(scanner.nextInt());
        }while (!(house.getNumberMaxPeople()>0&&house.getNumberMaxPeople()<20));
        scanner.nextLine();
        do {
            System.out.println("Kiểu thuê: ");
            house.setTypeRent(scanner.nextLine());
        }while (Regex.validateServices(house.getTypeRent(),"typeRent"));
        do {
            System.out.println("Tiêu chuẩn phòng: ");
            house.setStandardRoom(scanner.nextLine());
        }while (!Regex.validateServices(house.getStandardRoom(),"standarRoom"));
        do {
            System.out.println("Mô tả tiện nghi khác: ");
            house.setDescriptionOthers(scanner.nextLine());
        }while (!Regex.validateServices(house.getDescriptionOthers(),"decriptionOthers"));
        do {
            System.out.println("Số tầng: ");
            house.setNumberFloors(scanner.nextInt());
        }while (!(house.getNumberFloors()>0));

        houseList.add(house);
        FuncFileCSV.writeHouseToFileCSV(houseList);
        System.out.println("Add new house complete! Enter to countinue...");
        scanner.nextLine();
    }
    public static void addnewRoom(){
        roomList = FuncFileCSV.getFileCSVToListRoom();
        Scanner scanner=new Scanner(System.in);
        Room room=new Room();
        do {
            System.out.println("ID: ");
            String id = scanner.nextLine();
            if (Regex.validateServices(id,"id")){
                room.setId(id);
                break;
            }
        }while (true);
        do {
            System.out.println("Tên dịch vụ: ");
            room.setNameServices(scanner.nextLine());
        }while (!Regex.validateServices(room.getNameServices(),"nameServices"));
        do {
            System.out.println("Diện tích sử dụng: ");
            room.setAreaUse(scanner.nextInt());
        }while (!(room.getAreaUse()>0&&room.getAreaUse()>30));
        do {
            System.out.println("Chi phí thuê: ");
            room.setFeeRent(scanner.nextInt());
        }while (!(room.getFeeRent()>0));
        do {
            System.out.println("Số lượng người tối đa: ");
            room.setNumberMaxPeople(scanner.nextInt());
        }while (!(room.getNumberMaxPeople()>0&&room.getNumberMaxPeople()<20));
        scanner.nextLine();
        do {
            System.out.println("Kiểu thuê: ");
            room.setTypeRent(scanner.nextLine());
        }while (!Regex.validateServices(room.getTypeRent(),"typeRent"));
           System.out.println("Dịch vụ miễn phí: ");
           room.setFreeService(scanner.nextLine());
        roomList.add(room);
        FuncFileCSV.writeRoomToFileCSV(roomList);
        System.out.println("Add new room complete! Enter to countinue...");
        scanner.nextLine();
    }
    public static void showVilla() {
        villaList = FuncFileCSV.getFileCSVToListVilla();
        System.out.println("List Villa Below");
        for (Villa villa: villaList){
            villa.showInfor();
        }
    }
    public static void showHouse(){
        houseList = FuncFileCSV.getFileCSVToListHouse();
        System.out.println("List House Below");
        for (House house: houseList){
            house.showInfor();
        }
    }
    public static void showRoom(){
        roomList = FuncFileCSV.getFileCSVToListRoom();
        System.out.println("List Room Below");
        for (Room room: roomList){
            room.showInfor();
        }
    }
    public static void showVillaNotDuplicate(){
        villaList = FuncFileCSV.getFileCSVToListVilla();
        Set<String> villaSet = new TreeSet<>();
        for (Villa villa: villaList){
            villaSet.add(villa.getNameServices());
        }
        System.out.println(villaSet);
    }
    public static void showRoomNotDuplicate(){
        roomList = FuncFileCSV.getFileCSVToListRoom();
        Set<String> roomSet = new TreeSet<>();
        for (Room room: roomList){
            roomSet.add(room.getNameServices());
        }
        System.out.println(roomSet);
    }
    public static void showHouseNotDuplicate(){
        houseList = FuncFileCSV.getFileCSVToListHouse();
        Set<String> houseSet = new TreeSet<>();
        for (House house: houseList){
            houseSet.add(house.getNameServices());
        }
        System.out.println(houseSet);
    }
}

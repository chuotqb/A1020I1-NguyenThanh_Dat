package Models;

public class ShowService {
    public static void main(String[] args) {
        Villa villa= new Villa("1","villa",12,13,
                14,"ngày","pro","none",12,3);
        House house = new House("2","house",13,14,3,
                "tháng","Simple","none",4);
        Room  room = new Room("3","room",14,100,
                200,"năm","Swim");

        villa.showInfor();
        house.showInfor();
        room.showInfor();
    }
}
package Models;

public class Room extends Services{
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String id, String nameServices, double areaUse, double feeRent, int numberMaxPeople, String typeRent, String freeService) {
        super(id, nameServices, areaUse, feeRent, numberMaxPeople, typeRent);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
    @Override
    public void showInfor() {
        System.out.println("Room{" +
                "id=" + super.getId() +
                ", nameServices='" + super.getNameServices() + '\'' +
                ", areaUse=" + super.getAreaUse() +
                ", feeRent=" + super.getFeeRent() +
                ", numberMaxPeople=" + super.getNumberMaxPeople() +
                ", typeRent='" + super.getTypeRent() + '\'' +
                "freeService='" + this.getFreeService() + '\'' +
                '}');
    }
    @Override
    public String toString() {
        return "Room{" +
                "id=" + super.getId() +
                ", nameServices='" + super.getNameServices() + '\'' +
                ", areaUse=" + super.getAreaUse() +
                ", feeRent=" + super.getFeeRent() +
                ", numberMaxPeople=" + super.getNumberMaxPeople() +
                ", typeRent='" + super.getTypeRent() + '\'' +
                ", freeService='" + this.getFreeService() + '\'' +
                '}';
    }
}
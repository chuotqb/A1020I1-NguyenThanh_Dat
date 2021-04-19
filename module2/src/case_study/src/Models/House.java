
package Models;

public class House extends Services {
    private String standardRoom;
    private String descriptionOthers;
    private int numberFloors;

    public House() {
    }

    public House(String standardRoom, String descriptionOthers, int numberFloors) {
        this.standardRoom = standardRoom;
        this.descriptionOthers = descriptionOthers;
        this.numberFloors = numberFloors;
    }

    public House(String id, String nameServices, double areaUse, double feeRent, int numberMaxPeople, String typeRent, String standardRoom, String descriptionOthers, int numberFloors) {
        super(id, nameServices, areaUse, feeRent, numberMaxPeople, typeRent);
        this.standardRoom = standardRoom;
        this.descriptionOthers = descriptionOthers;
        this.numberFloors = numberFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOthers() {
        return descriptionOthers;
    }

    public void setDescriptionOthers(String descriptionOthers) {
        this.descriptionOthers = descriptionOthers;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }
    @Override
    public void showInfor() {
        System.out.println("House{" +
                "id=" + super.getId() +
                ", nameServices='" + super.getNameServices() + '\'' +
                ", areaUse=" + super.getAreaUse() +
                ", feeRent=" + super.getFeeRent() +
                ", numberMaxPeople=" + super.getNumberMaxPeople() +
                ", typeRent='" + super.getTypeRent() + '\'' +
                ", standardRoom='" + this.getStandardRoom() + '\'' +
                ", descriptionOthers='" + this.getDescriptionOthers() + '\'' +
                ", numberFloors=" + this.getNumberFloors() +
                '}');
    }
    @Override
    public String toString() {
        return "House{" +
                ", id=" + super.getId() +
                ", nameServices='" + super.getNameServices() + '\'' +
                ", areaUse=" + super.getAreaUse() +
                ", feeRent=" + super.getFeeRent() +
                ", numberMaxPeople=" + super.getNumberMaxPeople() +
                ", typeRent='" + super.getTypeRent() + '\'' +
                "standardRoom='" + this.getStandardRoom() + '\'' +
                ", descriptionOthers='" + this.getDescriptionOthers() + '\'' +
                ", numberFloors=" + this.getNumberFloors() +
                '}';
    }
}
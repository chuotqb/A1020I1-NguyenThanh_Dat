package Models;

public class Villa extends Services {
    protected String standardRoom;
    protected String descriptionOthers;
    protected double areaPool;
    protected int numberFloors;

    public Villa() {
    }

    public Villa(String standardRoom, String descriptionOthers, double areaPool, int numberFloors) {
        this.standardRoom = standardRoom;
        this.descriptionOthers = descriptionOthers;
        this.areaPool = areaPool;
        this.numberFloors = numberFloors;
    }

    public Villa(String id, String nameServices, double areaUse, double feeRent, int numberMaxPeople, String typeRent, String standardRoom, String descriptionOthers, double areaPool, int numberFloors) {
        super(id, nameServices, areaUse, feeRent, numberMaxPeople, typeRent);
        this.standardRoom = standardRoom;
        this.descriptionOthers = descriptionOthers;
        this.areaPool = areaPool;
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

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public void showInfor() {
        System.out.println("Villa{" +
                "id=" + super.getId() +
                ", nameServices='" + super.getNameServices() + '\'' +
                ", areaUse=" + super.getAreaUse() +
                ", feeRent=" + super.getFeeRent() +
                ", numberMaxPeople=" + super.getNumberMaxPeople() +
                ", typeRent='" + super.getTypeRent() + '\'' +
                ", standardRoom='" + this.getStandardRoom() + '\'' +
                ", descriptionOthers='" + this.getDescriptionOthers() + '\'' +
                ", areaPool=" + this.getAreaPool() +
                ", numberFloors=" + this.getNumberFloors() +
                '}');
    }

    @Override
    public String toString() {
        return "Villa{" +
                "id=" + super.getId() +
                ", nameServices='" + super.getNameServices() + '\'' +
                ", areaUse=" + super.getAreaUse() +
                ", feeRent=" + super.getFeeRent() +
                ", numberMaxPeople=" + super.getNumberMaxPeople() +
                ", typeRent='" + super.getTypeRent() + '\'' +
                ", standardRoom='" + this.getStandardRoom() + '\'' +
                ", descriptionOthers='" + this.getDescriptionOthers() + '\'' +
                ", areaPool=" + this.getAreaPool() +
                ", numberFloors=" + this.getNumberFloors() +
                '}';
    }
}
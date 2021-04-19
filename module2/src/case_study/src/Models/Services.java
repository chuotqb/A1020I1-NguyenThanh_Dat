package Models;

public abstract class Services {
    private String id;
    private String nameServices;
    private double areaUse;
    private double feeRent;
    private int numberMaxPeople;
    private String typeRent;
    public Services() {
    }

    public Services(String id, String nameServices, double areaUse, double feeRent, int numberMaxPeople, String typeRent) {
        this.id = id;
        this.nameServices = nameServices;
        this.areaUse = areaUse;
        this.feeRent = feeRent;
        this.numberMaxPeople = numberMaxPeople;
        this.typeRent = typeRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public double getFeeRent() {
        return feeRent;
    }

    public void setFeeRent(double feeRent) {
        this.feeRent = feeRent;
    }

    public int getNumberMaxPeople() {
        return numberMaxPeople;
    }

    public void setNumberMaxPeople(int numberMaxPeople) {
        this.numberMaxPeople = numberMaxPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }
    public abstract void showInfor();
    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", nameServices='" + nameServices + '\'' +
                ", areaUse=" + areaUse +
                ", feeRent=" + feeRent +
                ", numberMaxPeople=" + numberMaxPeople +
                ", typeRent='" + typeRent + '\'' +
                '}';
    }
}
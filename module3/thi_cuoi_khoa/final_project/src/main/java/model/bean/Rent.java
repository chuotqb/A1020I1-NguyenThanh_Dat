package model.bean;

public class Rent {
    private String idRent;
    private int area;
    private int idStatus;
    private int numOfFloor;
    private int idType;
    private int cost;
    private String startDate;
    private String endDate;

    public Rent() {
    }

    public Rent(String idRent, int area, int idStatus, int numOfFloor, int idType, int cost, String startDate, String endDate) {
        this.idRent = idRent;
        this.area = area;
        this.idStatus = idStatus;
        this.numOfFloor = numOfFloor;
        this.idType = idType;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getIdRent() {
        return idRent;
    }

    public void setIdRent(String idRent) {
        this.idRent = idRent;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(int numOfFloor) {
        this.numOfFloor = numOfFloor;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

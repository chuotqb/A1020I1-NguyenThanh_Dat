package model.bean.customer;

public class TypeCustomer {
    private int idTypeCustomer;
    private String nameTypeCustomer;

    public TypeCustomer() {
    }

    public TypeCustomer(int idTypeCustomer, String nameTypeCustomer) {
        this.idTypeCustomer = idTypeCustomer;
        this.nameTypeCustomer = nameTypeCustomer;
    }

    public int getIdTypeCustomer() {
        return idTypeCustomer;
    }

    public void setIdTypeCustomer(int idTypeCustomer) {
        this.idTypeCustomer = idTypeCustomer;
    }

    public String getNameTypeCustomer() {
        return nameTypeCustomer;
    }

    public void setNameTypeCustomer(String nameTypeCustomer) {
        this.nameTypeCustomer = nameTypeCustomer;
    }
}

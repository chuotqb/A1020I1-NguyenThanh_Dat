package Models;

public class Customer implements Comparable<Customer>{
    private String nameCustomer;
    private String dayOfBirth;
    private String gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String typeCustomer;
    private String address;
    private Services services;
    private String yearOfBirth;

    public Customer() {
    }

    public Customer(String nameCustomer, String dayOfBirth, String gender, String idCard, String phoneNumber, String email, String typeCustomer, String address, Services services) {
        this.nameCustomer = nameCustomer;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getYearOfBirth() {
        return getDayOfBirth().substring(getDayOfBirth().lastIndexOf("/")+1);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
    public void showInfor() {
        System.out.println("Customer{" +
                "name='" + this.nameCustomer + '\'' +
                ", dayOfBirth='" + this.dayOfBirth + '\'' +
                ", gender='" + this.gender + '\'' +
                ", idCard=" + this.idCard +
                ", phoneNumber=" + this.phoneNumber +
                ", email='" + this.email + '\'' +
                ", typeCustomer='" + this.typeCustomer + '\'' +
                ", address='" + this.address + '\'' +
                '}');
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nameCustomer='" + this.nameCustomer + '\'' +
                ", dayOfBirth='" + this.dayOfBirth + '\'' +
                ", gender='" + this.gender + '\'' +
                ", idCard=" + this.idCard +
                ", phoneNumber=" + this.phoneNumber +
                ", email='" + this.email + '\'' +
                ", typeCustomer='" + this.typeCustomer + '\'' +
                ", address='" + this.address + '\'' +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        return this.getNameCustomer().compareTo(o.getNameCustomer());
    }
}

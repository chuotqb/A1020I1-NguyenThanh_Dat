package Models;

public class Employee {
    private String id;
    private String nameEmployee;
    private String age;
    private String address;

    public Employee() {
    }

    public Employee(String id, String nameEmployee, String age, String address) {
        this.id = id;
        this.nameEmployee = nameEmployee;
        this.age = age;
        this.address = address;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

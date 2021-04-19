package bai12_java_colection_framework.thuc_hanh.test_compara;

import bai12_java_colection_framework.bai_tap.product.Product;

public class Student implements Comparable<Student> {
    String name;
    int age;
    int grade;

    public Student() {
    }

    public Student(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }

//    // so sanh int va string bang comparable
//    @Override
//    public int compareTo(Student o) {
//        if (this.grade>o.grade){
//            return 1;
//        }else if (this.grade==o.grade) {
//            return this.name.compareTo(o.name);
//        }else{
//            return -1;
//        }
//    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    //  so sanh int
//@Override
//public int compareTo(Student o) {
//    if (this.age<o.age) {
//        return -1;
//    } else if (this.age == o.age ){
//        return 0;
//    } else {
//        return 1;
//    }
//}
}

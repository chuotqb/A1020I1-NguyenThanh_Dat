package bai12_java_colection_framework.thuc_hanh.test_compara;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainStudent {
    public static void main(String[] args) {
//        int ten1=1;
//        int ten2=3;
//        int ten3=2;

        ArrayList<Student> arr= new ArrayList();
//        arr.add(ten1);
//        arr.add(ten2);
//        arr.add(ten3);
        Student student1 = new Student("Dat",42,18);
        Student student2 = new Student("Anh",3,15);
        Student student3 = new Student("Bi",2,15);
        arr.add(student1);
        arr.add(student2);
        arr.add(student3);
        System.out.println("before: ");
        for (Student ar :arr){
            System.out.println(ar.toString());
        }
        Collections.sort(arr);
        System.out.println("after: ");
        for (Student ar :arr){
            System.out.println(ar.toString());
        }
        AgeComparator ageComparator = new AgeComparator();
        System.out.println("Sort theo tuoi");
        Collections.sort(arr,ageComparator);
        for (Student ar :arr){
            System.out.println(ar.toString());
        }
    }
}

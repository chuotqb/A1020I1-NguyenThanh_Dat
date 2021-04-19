package bai10_array_list.bai_tap.array_list;

public class TestMyArrayList {
    static class Person{
        String name;
        int age;
        Person(String name,int age){
            this.name=name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        MyArrayList<Person> myArrayList=new MyArrayList<>();
        MyArrayList<Person> myArrayList1=new MyArrayList<>(4);
        myArrayList1.ensureCapaccity(5);
    }
}

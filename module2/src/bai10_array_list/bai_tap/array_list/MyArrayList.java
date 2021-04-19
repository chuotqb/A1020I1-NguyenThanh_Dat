package bai10_array_list.bai_tap.array_list;

import java.util.Arrays;

public class MyArrayList<E> {
//    Số lượng phần tử trong MyArrayList
    private int size = 0;
//    Sức chứa mặc định trong MyArrayList
    private static final int DEFAULT_CAPACITY = 10;
//    Mảng đối tượng elements chứa các phần tử trong MyArrayList
    private Object[] elements;
//    phương thức khởi tạo không tham số;
//    Mặc định khi khởi tạo sẽ tạo ra mảng object có kích thước là DEFAULT_CAPACCITY
    public MyArrayList(){
        System.out.println("khởi tạo thành công MyArrayList có kích thước là: " + DEFAULT_CAPACITY);
        elements = new Object[DEFAULT_CAPACITY];
//        phương thức khởi tạo với kích thước mảng được truyền vào là tham số
    }
    public MyArrayList(int capacity){
        if (capacity>0){
            System.out.println("khởi tạo thành công với kích thước là: "+capacity);
            elements=new Object[capacity];
        }else {
            System.out.println("Lỗi tham số truyền vào");
            throw new IllegalArgumentException("capacity: "+capacity);
        }
    }
    public void ensureCapaccity(int minCapacity){
        if (minCapacity>=0){
            int newSize = this.elements.length + minCapacity;
            elements= Arrays.copyOf(elements,newSize);
            System.out.println("Khởi tạo thành công với kích thước là :"+elements.length);
        }else {
            throw new IllegalArgumentException("minCapacity: "+minCapacity);
        }
    }
    public int size(){
        return size;
    }
    public int length(){
        return elements.length;
    }
    public E get(int index){
        return (E) elements[index];
    }
    public boolean add(E e){
        if (size==elements.length){
            ensureCapaccity(1);
        }
        elements[size]=e;
        size++;
        return true;
    }
    public void add(E e, int index){
        if (index>elements.length){
            throw new IllegalArgumentException("Lỗi index: "+index);
        }else if (elements.length==index+1){
            ensureCapaccity(1);
        }
        if (elements[index]==null){
            size++;
            elements[index]=e;
        }else{
            if (size==elements.length){
                ensureCapaccity(1);
            }
            System.arraycopy(elements,index,elements,index+1,size-index);
            elements[index]=e;
            size++;
        }
    }
}

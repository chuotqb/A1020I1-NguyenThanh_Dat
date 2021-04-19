package bai14_sorting_algorithm.bai_tap.cai_dat_insertion_sort;

import java.util.Arrays;

public class InsertionSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    public static void insertionSort(int[] list){
        for (int i=1;i<list.length;i++){
            int curElement = list[i];
            int j;
            for (j=i-1;j>=0;j--){
                if (curElement<list[j]){
                    list[j+1]=list[j];
                }else {
                    break;
                }
            }
            list[j+1]=curElement;
        }
        System.out.println(Arrays.toString(list));
    }

    public static void main(String[] args) {
        insertionSort(list);
    }
}

package ky2lab3;

import java.util.Arrays;
import java.util.List;

public class bai1c2 {
    public static void main(String[] args) {
    	// Lấy phần tử đầu tiên của một mảng
    	String[] arr = { "Java_First", "Java_2", "Java_3", "Java_4", "Java_Last" };
    	String firstElementOfArray = arr[0];
    	System.out.println(firstElementOfArray);

    	// Lấy phần tử đầu tiên của một danh sách
    	List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    	Integer firstElementOfList = list.get(0);
    	System.out.println(firstElementOfList);

    }
}
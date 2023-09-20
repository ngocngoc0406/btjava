package ky2lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bai2c2 {
    public static void main(String[] args) {
    	List<Integer> list = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
    	List<Integer> duplicates = new ArrayList<>();
    	for (int i = 0; i < list.size(); i++) {
    	    for (int j = i + 1; j < list.size(); j++) {
    	        if (list.get(i).equals(list.get(j))) {
    	            if (!duplicates.contains(list.get(i))) {
    	                duplicates.add(list.get(i));
    	            }
    	        }
    	    }
    	}
    	System.out.println(duplicates);
    }
}
package ky2lab3;

import java.util.ArrayList;
import java.util.List;

public class bai3c2 {
    public static void main(String[] args) {
    	String str = "Hello";
    	char c = 'l';
    	List<Character> list = new ArrayList<Character>();
    	for (char ch : str.toCharArray()) {
    	    list.add(ch);
    	}
    	long count = list.stream().filter(ch -> ch == c).count();
    	System.out.println(count);
    }
}
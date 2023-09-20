package ky2lab3;

public class bai3 {
    public static void main(String[] args) {
    	String str = "Hello";
    	char c = 'l';
    	long count = str.chars().filter(ch -> ch == c).count();
    	System.out.println(count);
    }
}
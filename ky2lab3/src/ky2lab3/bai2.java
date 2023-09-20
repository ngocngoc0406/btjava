package ky2lab3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class bai2 {
	    public static void main(String[] args) {
	    	Set<Integer> items = new HashSet<>();
	    	List<Integer> list = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
	    	List<Integer> result = list.stream()
	    	    .filter(n -> !items.add(n))
	    	    .collect(Collectors.toList());
	    	System.out.println(result);
	    }
	}




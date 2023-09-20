package ky2lab3;
import java.util.stream.Stream;

	public class bai1 {
	    public static void main(String[] args) {
	        Stream<String> stream1 = Stream.of("Java_First", "Java_2", "Java_3", "Java_4", "Java_Last");
	        String firstElement1 = stream1.findFirst().orElse(null);
	        System.out.println(firstElement1);

	        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6, 7);
	        Integer firstElement2 = stream2.findFirst().orElse(null);
	        System.out.println(firstElement2);
	    }
	}



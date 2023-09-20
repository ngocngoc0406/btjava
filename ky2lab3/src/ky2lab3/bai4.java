package ky2lab3;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class bai4 {
	public static void main(String[] args) {
		Stream<Character> stream = Stream.of('G', 'e', 'e', 'k', 's', 'F', 'o', 'r', 'G', 'e', 'e', 'k', 's');
		Map<Integer, Character> map = new HashMap<>();
		stream.forEachOrdered(ch -> map.put(map.size(), ch));
		System.out.println(map);
}
}
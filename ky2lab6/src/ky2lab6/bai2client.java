package ky2lab6;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;
public class bai2client {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try (var s = new Socket(InetAddress.getLocalHost(), 8189);
				var in = new Scanner(s.getInputStream(), StandardCharsets.UTF_8))
					{
					  while (in.hasNextLine())
					  {
						String line = in.nextLine();
						System.out.println(line);
					  }
					}
	}

}

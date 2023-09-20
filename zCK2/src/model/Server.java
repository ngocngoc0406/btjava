package model;
import java.io.*;
import java.net.*;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Server {
    public static void main(String[] args) {
        int port = 3000;

        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            // Accept client connections
            Socket clientSocket1 = serverSocket.accept();
            System.out.println("Connected to client 1: " + clientSocket1.getInetAddress().getHostAddress());
            
            // Create input and output streams for client 1
            BufferedReader chatIn1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));
            PrintWriter chatOut1 = new PrintWriter(clientSocket1.getOutputStream(), true);

            Socket clientSocket2 = serverSocket.accept();
            System.out.println("Connected to client 2: " + clientSocket2.getInetAddress().getHostAddress());
            // Create input and output streams for client 2
            BufferedReader chatIn2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
            PrintWriter chatOut2 = new PrintWriter(clientSocket2.getOutputStream(), true);
            
//            Receiver receiver1 = new Receiver(chatIn1, chatOut2);
//            Receiver receiver2 = new Receiver(chatIn2, chatOut1);
//            Thread attackHandleThread = new AttackHandler(receiver1, receiver2);
//            attackHandleThread.start();
            String message1, attackCommand1 = null;
            Thread tR1 = new Thread(() -> {
				try {
					while((message1 = chatIn1.readLine()) != null) {
						JSONObject obj = (JSONObject) JSONValue.parse(message1);
						if(obj.containsKey("message")) {
							chatOut2.println((String)obj.get("message"));		
						} else if(obj.containsKey("attack")){
							System.out.println("attack found");
							attackCommand1 = (String) obj.get("attack");
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			tR1.start();
			String message2, attackCommand2 = null;
            Thread tR2 = new Thread(() -> {
				try {
					while((message1 = chatIn2.readLine()) != null) {
						JSONObject obj = (JSONObject) JSONValue.parse(message1);
						if(obj.containsKey("message")) {
							chatOut1.println((String)obj.get("message"));		
						} else if(obj.containsKey("attack")){
							System.out.println("attack found");
							attackCommand1 = (String) obj.get("attack");
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			tR2.start();
			
            Thread t1 = new Thread(() -> {
            	while(attackCommand1 != null && attackCommand2 != null) {
        			System.out.println("hadasdasd");
        			chatOut1.println(attackCommand1);
        			chatOut1.println(attackCommand2);
        			chatOut2.println(attackCommand1);
        			chatOut2.println(attackCommand2);
        		}
            });
            t1.start();
            
        } catch (SocketException e) {
//        	System.out.println("Connection reset");
			e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
    }
}


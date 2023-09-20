package model;
import java.io.*;
import java.net.*;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Server2 {
	private Receiver receiver1, receiver2;
	private AttackHandler attackHandleThread;
	public Server2() {
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
            
            receiver1 = new Receiver(chatIn1, chatOut2);
            receiver2 = new Receiver(chatIn2, chatOut1);
            attackHandleThread = new AttackHandler(this);
            attackHandleThread.start();
            
            
            
        } catch (SocketException e) {
//        	System.out.println("Connection reset");
			e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
    public Receiver getReceiver1() {
		return receiver1;
	}


	public Receiver getReceiver2() {
		return receiver2;
	}


	public static void main(String[] args) {
        new Server2();
    }
}


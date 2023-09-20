package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Receiver extends Thread{
	private String message, attackCommand = null;
	private BufferedReader in; 
	private PrintWriter out;

	public Receiver(BufferedReader in, PrintWriter out) {
		this.in = in;
		this.out = out;
		run();
	}
	public void run() {
		
			Thread t = new Thread(() -> {
				try {
					while((message = in.readLine()) != null) {
						JSONObject obj = (JSONObject) JSONValue.parse(message);
						if(obj.containsKey("message")) {
							sendMessageToClient((String)obj.get("message"));		
						} else if(obj.containsKey("attack")){
							System.out.print("attack ");
							attackCommand = (String) obj.get("attack");
							System.out.println(this.attackCommand);
						} else if(obj.containsKey("id")) {
							sendFoePkmID((String)obj.get("id"));
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			t.start();
	}
	public String getAttackCommand() {
		return attackCommand;
	}
	public void setAttackCommand(String attackCommand) {
		this.attackCommand = attackCommand;
	}
	public void sendMessageToClient(String message) {
		JSONObject obj = new JSONObject();
		obj.put("message", message);
		out.println(obj.toString());
	}
	public void sendHPToClient(String message) {
		JSONObject obj = new JSONObject();
		obj.put("reduceHP", message);
		out.println(obj.toString());
	}
	public void sendFoePkmID(String id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		out.println(obj.toString());
	}
}

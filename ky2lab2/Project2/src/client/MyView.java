/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

/**
 *
 * @author HP
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class MyView {
	public static JFrame f;
	JButton[][] bt;
	static boolean flat = false;// Kiem tra button click
	boolean winner;
	Timer thoigian;
	Integer second, minute;
	JLabel demthoigian;
	// module chat va label
	JTextArea textout, textin;
	JButton send;
	JScrollPane jscroll1, jscroll2;
	JLabel label1, label2, label3;
	JPanel p;
	int x = 15, y = 15;
	int[][] matran;// danh dau vi tri doi thu danh
	int[][] matrandanh;// danh dau vi tri minh danh
	// Server Socket
	ServerSocket serversocket;
	Socket socket;
	OutputStream os;
	InputStream is;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	JLabel denluot;
	MenuBar menubar;
	JTextArea content;
	JTextField nhap, enterchat;
	String temp = "";
	MenuItem newItem, exit, helpItem, about;
	JButton pn ;
	public static int c,d;
//	public int a,b;
	public MyView() {
		initFrame();
	}

	public void initFrame() {
		f = new JFrame();
		f.setTitle("Server");
		f.setSize(750, 550);
	}

	public void initComponents(int x, int y) {
		f.getContentPane().setLayout(null);
		f.getContentPane().setBackground(Color.DARK_GRAY);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		//
		matran = new int[x][y];// ma tran ban co
		matrandanh = new int[x][y];// ma tran danh dau vi tri danh
		menubar = new MenuBar();
		p = new JPanel();
		p.setBackground(Color.BLUE);
		p.setBounds(10, 30, 400, 430);
		p.setLayout(new GridLayout(x, y));
		f.add(p);
		ImageIcon icon = new ImageIcon("C:\\Users\\HP\\eclipse-workspace2\\Project3\\src\\lib\\waiting1.png");
		//Icon icon = new ImageIcon(getClass().getResource("C:\\Users\\DELL\\Desktop\\winner1.gif"));
		pn = new JButton(icon);
		pn.setBounds(430 ,30 ,300,150);
		pn.setBackground(Color.WHITE);
		f.add(pn);
		Font fo = new Font("Arial", Font.BOLD, 15);
		content = new JTextArea();
		content.setFont(fo);
		content.setBackground(Color.white);

		content.setEditable(false);
		JScrollPane sp = new JScrollPane(content);
		sp.setBounds(430, 220, 290, 170);
		send = new JButton("Gửi");
		send.setBounds(640, 420, 70, 40);

		enterchat = new JTextField("");
		enterchat.setFont(fo);
		enterchat.setBounds(430, 420, 200, 40);
		enterchat.setBackground(Color.WHITE);
		f.add(enterchat);
		f.add(send);
		f.add(sp);
		f.setVisible(true);
		demthoigian = new JLabel("Thời Gian:");
		demthoigian.setFont(new Font("TimesRoman", Font.ITALIC, 16));
		demthoigian.setForeground(Color.GREEN);
		f.add(demthoigian);
		demthoigian.setBounds(430, 170, 300, 50);
		
		
		
		denluot = new JLabel("");
		denluot.setFont(new Font("TimesRoman", Font.ITALIC, 16));
		denluot.setBounds(580,170,200,50);
		denluot.setForeground(Color.GREEN);
		f.add(denluot);
		
		f.setMenuBar(menubar);
		Menu game = new Menu("Game");
		menubar.add(game);
		Menu help = new Menu("Help");
		menubar.add(help);
		helpItem = new MenuItem("Help");
		help.add(helpItem);
		about = new MenuItem("About");
		help.add(about);
		help.addSeparator();
		newItem = new MenuItem("New Game");
		game.add(newItem);
		exit = new MenuItem("Exit");
		game.add(exit);
		game.addSeparator();

	}
	public void addButton() {
		bt = new JButton[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				bt[i][j] = new JButton();
				bt[i][j].setBackground(Color.WHITE);
				p.add(bt[i][j]);
				p.setVisible(false);
				p.setVisible(true);
			}
		}
			
	}
	public void addActionListenerForButtons(ActionListener ex) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < bt[i].length; j++) {
				final int a = i; final int b = j;
				bt[a][b].addActionListener(ex);
				c = a ; d = b;
			}
		}

	}
	public void newgame() {
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {
				// bt[i][j].setBackground(Color.WHITE);
				bt[i][j].setIcon(null);
				matran[i][j] = 0;
				matrandanh[i][j] = 0;
			}
		setEnableButton(true);
		second = 0;
		minute = 0;
		thoigian.stop();
	}
	public void updateButtons(int[][] numbers) {
		for (int i = 0; i < bt.length; i++) {
			for (int j = 0; j < bt[i].length; j++) {
				bt[i][j].setText(String.valueOf(numbers[i][j]));
			}
		}
	}
	public void setEnableButton(boolean b) {
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {
				if (matrandanh[i][j] == 0)
					bt[i][j].setEnabled(b);
			}
	}

	public void setVisiblePanel(JPanel pHienthi) {
		f.add(pHienthi);
		pHienthi.setVisible(true);
		pHienthi.updateUI();// ......
	}
	public void addActionListenerTime(ActionListener ex) {
		thoigian = new Timer(2000,ex);
		thoigian.addActionListener(ex);
	}
	public void addActionListenerForNewgame(ActionListener ex) {
		newItem.addActionListener(ex);
	}

	public void addActionListenerForExit(ActionListener ex) {
		exit.addActionListener(ex);
	}

	public void addActionListenerForHelp(ActionListener ex) {
		helpItem.addActionListener(ex);
	}

	public void addActionListenerForAbout(ActionListener ex) {
		about.addActionListener(ex);
	}

	public void addActionListenerForSend(ActionListener ex) {
		send.addActionListener(ex);
	}

	public int getZOrderOfButton(JButton button) {
		return p.getComponentZOrder(button);
	}

}



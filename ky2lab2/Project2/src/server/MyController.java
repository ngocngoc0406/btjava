/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

/**
 *
 * @author HP
 */
import java.awt.Color;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MyController {
	private MyModel model;
	private MyView view;
	ServerSocket serversocket;
	Socket socket;
	OutputStream os;
	InputStream is;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	String temp = "";
	Integer second = 0 , minute = 0;
	public MyController(MyModel model, MyView view) {
		this.model = model;
		this.view = view;
		this.view.initComponents(model.getRows(), model.getCols());
		this.view.addButton();

		ActionListener ac1 = new ChangeItem1ClickListener();
		ActionListener ac2 = new ChangeItemClickListener();
		ActionListener ac3 = new ChangeItem2ClickListener();
		ActionListener ac4 = new ChangeItem3ClickListener();
		ActionListener ac5 = new ChangeButtonGuiClickListener();
		ActionListener ac6 = new ChangeClickListener();
		ActionListener ac7 = new ChangeTimer();
		this.view.addActionListenerForNewgame(ac2);
		this.view.addActionListenerForExit(ac1);
		this.view.addActionListenerForHelp(ac3);
		this.view.addActionListenerForAbout(ac4);
		this.view.addActionListenerForSend(ac5);
		this.view.addActionListenerForButtons(ac6);
		this.view.addActionListenerTime(ac7);
		
		model.initMatran();
		try {
			serversocket = new ServerSocket(1234);
			System.out.println("Dang doi client...");
			socket = serversocket.accept();
			System.out.println("Client da ket noi!");
			os = socket.getOutputStream();
			is = socket.getInputStream();
			oos = new ObjectOutputStream(os);
			ois = new ObjectInputStream(is);
			while (true) {
				String stream = ois.readObject().toString();
				String[] data = stream.split(",");
				if (data[0].equals("chat")) {
					temp += "Đối thủ: " + data[1] + "\n";
					view.content.setText(temp);
				} else if (data[0].equals("caro")) {
					view.thoigian.start();
					caro(data[1], data[2]);
					view.setEnableButton(true);
					if (view.winner == false)
						view.setEnableButton(true);
				} else if (data[0].equals("newgame")) {
					int k = JOptionPane.showConfirmDialog(view.f, "Bên kia muốn chơi lại bạn có đồng ý chứ",
							"Thông báo", JOptionPane.YES_NO_OPTION);
					if (k == JOptionPane.YES_OPTION) {
						// setVisiblePanel(p);
						view.newgame();
						model.initMatran();
						view.second = 0;
						view.minute = 0;
					} else if (k == JOptionPane.NO_OPTION) {
						view.thoigian.stop();
					}
				} else if (data[0].equals("checkwinn")) {
					view.thoigian.stop();
					JOptionPane.showConfirmDialog(view.f, "Bạn đã thua do bạn đã hết thời gian chơi ", "Thông báo",
							JOptionPane.CLOSED_OPTION);

				} else if (data[0].equals("checkwin")) {
					view.thoigian.stop();
					JOptionPane.showConfirmDialog(view.f, "Bạn đã thắng ", "Thông báo", JOptionPane.CLOSED_OPTION);

				} else if (data[0].equals("thoat")) {
					int k = JOptionPane.showConfirmDialog(view.f, "Bên kia đã thoát game bạn có muốn chơi lại không",
							"Thông báo", JOptionPane.YES_NO_OPTION);
					if (k == JOptionPane.YES_OPTION) {
						new TestServer();

					} else if (k == JOptionPane.NO_OPTION) {
						// thoigian.stop();
					}
				} else if (data[0].equals("thoigian")) {
					second = 0;
					minute = 0;
				}

			}
		} catch (Exception ie) {

		} finally {
			try {
				socket.close();
				serversocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	class ChangeTimer implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String temp = minute.toString();
			String temp1 = second.toString();
			if (temp.length() == 1) {
				temp = "0" + temp;
			}
			if (temp1.length() == 1) {
				temp1 = "0" + temp1;
			}
			if (second == 10) {
				view.demthoigian.setText("Thời gian:" + temp + ":" + temp1);
				minute++;
				second = 0;
				try {
					oos.writeObject("checkwinn,123");
				} catch (IOException ex) {

				}
				int m = JOptionPane.showConfirmDialog(view.f, "Bạn đã thắng , bạn có muốn chơi lại không", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (m == JOptionPane.YES_OPTION) {
					second = 0;
					minute = 0;
					view.setVisiblePanel(view.p);
					view.newgame();
					model.initMatran();
					try {
						oos.writeObject("newgame,123");
					} catch (IOException ie) {
						//
					}
				} else if (m == JOptionPane.NO_OPTION) {
					view.thoigian.stop();

				}
			} else {
				view.demthoigian.setText("Thời gian:" + temp + ":" + temp1);
				second++;
			}

		}
			
		}
		
	
	class ChangeItemClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// e -> đối tượng lưu thông tin sự kiện
			// e.getSource() -> đối tượng gây ra sự kiện
			MenuItem aMenuItem = (MenuItem) e.getSource();
			view.newgame();
			model.initMatran();
			try {
				oos.writeObject("newgame,123");
			} catch (IOException ie) {
				//
			}
		}
	}

	class ChangeItem1ClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MenuItem aMenuItem = (MenuItem) e.getSource();
			int k = JOptionPane.showConfirmDialog(view.f, "Bạn muốn thoát game ", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (k == JOptionPane.YES_OPTION) {
				try {
					oos.writeObject("thoat,123");
				} catch (IOException ie) {
					//
				}
				System.exit(0);
//				second = 0;
//				minute = 0;

			} else if (k == JOptionPane.NO_OPTION) {

			}

		}
	}

	class ChangeItem2ClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MenuItem aMenuItem = (MenuItem) e.getSource();
			JOptionPane.showConfirmDialog(view.f,
					"Bạn hãy đánh 5 ô liên tiếp nhau\n"
							+ "Theo hàng ngang hoặc hàng dọc hoặc hàng chéo là bạn sẽ  thắng" + "Chúc bạn may mắn",
					"Hướng dẫn", JOptionPane.CLOSED_OPTION);

		}
	}

	class ChangeItem3ClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MenuItem aMenuItem = (MenuItem) e.getSource();
			JOptionPane.showConfirmDialog(view.f, "Họ tên: Cao Đức Tâm\n Mã SV: 22IT257\nLớp sinh hoạt: 22GIT2\nLớp học phần: Lập trình Java(2) TA ", "Information",
					JOptionPane.CLOSED_OPTION);

		}

	}

	class ChangeButtonGuiClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton aButton = (JButton) e.getSource();
			if (e.getSource().equals(view.send)) {
				try {

					temp += "Bạn: " + view.enterchat.getText() + "\n";
					view.content.setText(temp);
					oos.writeObject("chat," + view.enterchat.getText());
					view.enterchat.setText("");
					// temp = "";
					view.enterchat.requestFocus();
					view.content.setVisible(false);
					view.content.setVisible(true);

				} catch (Exception r) {
					r.printStackTrace();
				}
			}

		}

	}

	boolean flat = false;

	class ChangeClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int row = -1, col = -1;
			JButton aButton = (JButton) e.getSource();
			int z = view.getZOrderOfButton(aButton);
			row = z/model.getCols();
			col = z%model.getCols();
			//tăng data.getNumber(i, j)
			view.bt[row][col].setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace2\\Project3\\src\\lib\\nought.png"));
			view.denluot.setText("Đang đợi...");
			flat = true;// server da click
			view.thoigian.start();
			view.matrandanh[row][col] = 1;
			view.bt[row][col].setEnabled(false);
			view.second = 0;
			view.minute = 0;
			try {
				oos.writeObject("thoigian,123");
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if (MyView.flat) {
				view.setEnableButton(true);
			} else {
				view.setEnableButton(false);
			}
			try {
				oos.writeObject("caro," +row + "," + col);
			} catch (IOException ie) {
				ie.printStackTrace();
			}			
		}
		

	}
	int xx,yy;
	public void caro(String x, String y) {
		xx = Integer.parseInt(x);
		yy = Integer.parseInt(y);
		// danh dau vi tri danh
		model.matran[xx][yy] = 1;
		view.matrandanh[xx][yy] = 1;
		view.denluot.setText("Đến lượt bạn đánh... ");
		view.bt[xx][yy].setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace2\\Project3\\src\\lib\\crosss.png"));
		view.bt[xx][yy].setEnabled(false);
		// Kiem tra thang hay chua
		System.out.println("CheckH:" + model.checkHang());
		System.out.println("CheckC:" + model.checkCot());
		System.out.println("CheckCp:" + model.checkCheoPhai());
		System.out.println("CheckCt:" + model.checkCheoTrai());
		view.winner = (model.checkHang() == 1 || model.checkCot() == 1 || model.checkCheoPhai() == 1
				|| model.checkCheoTrai() == 1);
		if (model.checkHang() == 1 || model.checkCot() == 1 || model.checkCheoPhai() == 1
				|| model.checkCheoTrai() == 1) {
			view.setEnableButton(false);
			view.thoigian.stop();
			try {
				oos.writeObject("checkwin,123");
			} catch (IOException ex) {

			}
			Object[] options = { "Dong y", "Huy bo" };
			int m = JOptionPane.showConfirmDialog(view.f, "Bạn đã thua bạn có muốn chơi lại không ?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (m == JOptionPane.YES_OPTION) {
				view.second = 0;
				view.minute = 0;
				// view.setVisiblePanel(p);
				view.newgame();
				model.initMatran();
				try {
					oos.writeObject("newgame,123");
				} catch (IOException ie) {

				}

			} else if (m == JOptionPane.NO_OPTION) {
				view.thoigian.stop();
			}
		}
	}
	

}

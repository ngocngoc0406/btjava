package View;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.DAOStudent;
import model.Student;

public class GUI extends JFrame {
	private DAOStudent dbCon;
	private JTable tabel;
	private DefaultTableModel dtm;
	public GUI() {
		super("Quan li sinh vien");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 dbCon = new DAOStudent();
		
		
		
		JPanel pn = new JPanel();  //panel chính (pn) chứa các panel con
		pn.setLayout(new BorderLayout()); //định dạng các panel con được thêm vào pn
		
		
		JPanel pnCenter = new JPanel(); //tạo panel để thêm vào trung tâm của pn
		pnCenter.setLayout(new BorderLayout());//định dạng các panel con được thêm vào pnCenter
		Border border = BorderFactory.createLineBorder(Color.red);
		TitledBorder tborder = BorderFactory.createTitledBorder(border, "Input form");
		pnCenter.setBorder(tborder);
		
		
		JPanel pnEast = new JPanel(); //tạo panel để thêm vào bên phải của pn
		pnEast.setLayout(new GridLayout(5, 1));//các thành phần được thêm vào pnEast theo 5 hàng 
		Border borderEast = BorderFactory.createLineBorder(Color.green);
		TitledBorder tborderEast = BorderFactory.createTitledBorder(borderEast, "Control");
		pnEast.setBorder(tborderEast);
		
		
		JSplitPane x = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnCenter, pnEast);
		x.setOneTouchExpandable(true);
		x.setDividerLocation(250);

		JPanel pnCenter1 = new JPanel(); //tạo panel để thêm vào bên trái của panel trung tâm (pnCenter)
		pnCenter1.setLayout(new GridLayout(4,1));//thiết lập định dạng các thành phần thêm vào pnCenter1 theo 4 hàng 1 cột 
		JPanel pnCenter2 = new JPanel(); //tạo panel để thêm vào trung tâm của pnCenter
		pnCenter2.setLayout(new GridLayout(4,1)); 
		
		JLabel jlbID = new JLabel("ID");
		pnCenter1.add(jlbID);
		
		JTextField jtfID = new JTextField(25);
		pnCenter2.add(jtfID);
//		JComboBox cboID = new JComboBox();
		
//	ResultSet rs1 = dbCon.selectAll("student");
//	try {
//		while(rs1.next()) {
//			String id = rs1.getString(1);
	//		String name = rs1.getString(2);
	//		double gba = Double.parseDouble(rs1.getString(3));
		//	String lop = rs1.getString(4);
			
	//	cboID.addItem(id);
		
	//	}
	//} catch (SQLException e1) {
		// TODO Auto-generated catch block
	//	e1.printStackTrace();
		//}
	
//	pnCenter2.add(cboID);
		
		JLabel jlbName = new JLabel("Name");
		pnCenter1.add(jlbName);
		JTextField jtfName = new JTextField(25);
		pnCenter2.add(jtfName);
		JLabel jlbGBA = new JLabel("GBA");
		pnCenter1.add(jlbGBA);
		JTextField jtfGBA = new JTextField(25);
		pnCenter2.add(jtfGBA);
		JLabel jlbClass = new JLabel("Class");
		pnCenter1.add(jlbClass);
		JTextField jtfClass = new JTextField(25);
		pnCenter2.add(jtfClass);
		pnCenter.add(pnCenter1, BorderLayout.WEST);
		pnCenter.add(pnCenter2, BorderLayout.CENTER);
		JButton jbnAdd = new JButton("Add");
		pnEast.add(jbnAdd);
		JButton jbnUpdate = new JButton("Update");
		pnEast.add(jbnUpdate);
		JButton jbnDelete = new JButton("Delete");
		pnEast.add(jbnDelete);
		JButton jbnDisplay = new JButton("Display");
		pnEast.add(jbnDisplay);
		JButton jbnExit = new JButton("Exit");
		pnEast.add(jbnExit);
		jbnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = jtfID.getText();
				String name = jtfName.getText();
				Double gba = Double.parseDouble(jtfGBA.getText());
				String lop = jtfClass.getText();
				Student x = new Student(id, name, lop, gba);
				dbCon.insertToStudent(x);
				//String x = (String)cboID.getSelectedItem();
				System.out.println(x);
				
			}
		});
		
		jbnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
		//pn.add(pnCenter, BorderLayout.CENTER);
		//pn.add(pnEast, BorderLayout.EAST);
		pn.add(x, BorderLayout.NORTH);
		
		
		JPanel jpnTable = new JPanel();
		jpnTable.setLayout(new BorderLayout());
		Border bdTable = BorderFactory.createLineBorder(Color.cyan);
		TitledBorder tbTable = BorderFactory.createTitledBorder(bdTable, "Danh sach");
		jpnTable.setBorder(tbTable);
		
		dtm = new DefaultTableModel();
		dtm.addColumn("id");
		dtm.addColumn("name");
		dtm.addColumn("gba");
		dtm.addColumn("lop");
		
		final JTable table = new JTable(dtm);
		ResultSet rs = dbCon.selectAll("student");
		try {
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				double gba = rs.getFloat(3);
				String lop = rs.getString(4);
				dtm.addRow(new String[] {id,name,lop, gba+""});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JScrollPane sp = new JScrollPane(table);

		jpnTable.add(sp, BorderLayout.CENTER);
		
		pn.add(jpnTable, BorderLayout.CENTER);
		
		Container con = getContentPane();
		con.add(pn);
	}
	public void reloadData() {
		ResultSet rs = dbCon.selectAll("student");
		try {
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				double gba = rs.getFloat(3);
				String lop = rs.getString(4);
				dtm.addRow(new String[] {id,name,lop, gba+""});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void main(String args[]) {
		GUI x = new GUI();
		x.setSize(400,400);
		x.setLocationRelativeTo(null);
		x.setVisible(true);
	}}

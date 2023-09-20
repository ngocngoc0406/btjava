package model;

public class Student {

	
	private String  id,name, y_class;
	private double gba;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getY_class() {
		return y_class;
	}
	public void setY_class(String y_class) {
		this.y_class = y_class;
	}
	
	public double getGba() {
		return gba;
	}
	public void setGba(double gba) {
		this.gba = gba;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", y_class=" + y_class + ", gba=" + gba + "]";
	}
	
	public Student(String id, String name,String y_class,  double gba) {
		super();
		this.id = id;
		this.name = name;
		this.y_class = y_class;
		this.gba = gba;
	}
	public Student() {
		
	}
	
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

/**
 *
 * @author HP
 */
public class TestServer {
	public static void main(String[] args) {
		MyModel model = new MyModel();
		MyView view = new MyView();
		MyController controller = new MyController(model, view);
		view.f.setVisible(true);
	}
}

package client;
public class TestClient {
	public static void main(String[] args) {
		MyModel model = new MyModel();
		MyView view = new MyView();
		MyController controller = new MyController(model, view);
		view.f.setVisible(true);
	}
}

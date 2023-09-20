package model;

public class UserService {
	public boolean checkLogin(User user) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("123456")) {
       	 return true;
	     }
        return false;
   }
}

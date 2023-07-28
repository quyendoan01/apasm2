import java.util.Objects;

public class Account {
    protected String username;
    protected String password;
    protected static Schedule schedule;
    public static void ChangeInformation(){

    }
    public void setInformation(String username, String password){
        this.username = username;
        this.password = password;
    }
    public static String Login(String username, String password){
        if (username.equals("admin") && password.equals("admin")){
            System.out.println("You are logged as admin");
            return "admin";
        } else if (username.equals("user") && password.equals("user")) {
            System.out.println("You are logged as user");
            return "user";
        } else if (username.equals("manage") && password.equals("manage")) {
            System.out.println("You are logged as manage");
            return "manage";
        } else {
            System.out.println("Login failed!!");
            return "false";
        }
    }
    public static void Logout(){

    }
}

import java.util.List;
import java.util.Scanner;

public class StaffAccount extends Account {
    private String managerBy;
    static Scanner sc = new Scanner(System.in);
    public StaffAccount (String username, String password, List<Schedule> schedules, String managerBy){
        this.username = username;
        this.password = password;
        this.schedules = schedules;
        this.managerBy = managerBy;
    }
    public void removeAccount(){
        username = null;
        password = null;
        schedules = null;
        managerBy = null;
    }
}

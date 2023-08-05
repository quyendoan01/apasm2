import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerAccount extends Account{
    public List<StaffAccount> staffAccounts;
    static Scanner sc = new Scanner(System.in);
    public ManagerAccount (String username, String password, List<Schedule> schedules, List<StaffAccount> staffAccounts){
        this.username = username;
        this.password = password;
        this.schedules = schedules;
        this.staffAccounts = staffAccounts;
    }
    public List<StaffAccount> getStaffAccounts() {
        return staffAccounts;
    }
    public void setStaffAccounts(List<StaffAccount> staffAccounts) {
        this.staffAccounts = staffAccounts;
    }
    public void removeAccount() {
        username = null;
        password = null;
        schedules = null;
        staffAccounts = null;
    }
}

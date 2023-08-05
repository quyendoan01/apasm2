import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Color color = new Color();
    private static Scanner sc = new Scanner(System.in);
    static Admin admin = new Admin();

    public static void main(String[] args) {
        boolean running = true;
        while (running){
            System.out.println(color.PURPLE + "Admin/Menu" + color.RESET);
            System.out.println(color.BLUE + "1. Account");
            System.out.println("2. Schedule");
            System.out.println("3. Exit");
            int chooseAdmin = sc.nextInt();
            switch (chooseAdmin){
                case 1:
                    adminMenuAccount();
                    break;
                case 2:
                    adminMenuSchedule();
                    break;
                default:
                    running = false;
                    break;
            }
        }
    }
    private static void adminMenuAccount() {
        System.out.println(color.PURPLE + "Admin/Menu/Account" + color.RESET);
        if (!admin.getManagerAccounts().isEmpty() && !admin.getStaffAccounts().isEmpty()){
            for (ManagerAccount managerAccount : admin.getManagerAccounts()){
                System.out.println(managerAccount.getUsername() + " (Manager)");
                if (!managerAccount.getStaffAccounts().isEmpty())
                for (StaffAccount staffAccount : managerAccount.getStaffAccounts()){
                    System.out.println("    "+ staffAccount.getUsername() + " (Staff)");
                }
            }
        }
        else{
            System.out.println(color.YELLOW+"Account is None" + color.RESET);
        }
        System.out.println(color.BLUE + "1. Create Account");
        System.out.println("2. Modify Account");
        System.out.println("3. Remove Account");
        System.out.println("4. Back" + color.RESET);
        int chooseAdminAccount = sc.nextInt();
        switch (chooseAdminAccount){
            case 1:
                admin.addAccount();
                break;
            case 2:
                admin.modifyAccount();
                break;
            case 3:
                admin.removeAccount();
            default:
                break;
        }
    }
    private static void adminMenuSchedule() {
        System.out.println(color.PURPLE + "Admin/Menu/Schedule" + color.RESET);
        System.out.println(color.BLUE + "1. Schedule for Manager");
        System.out.println("2. Schedule for Staff");
        System.out.println("3. Back" + color.RESET);
        int chooseAdminAccount = sc.nextInt();
        switch (chooseAdminAccount){
            case 1:
                admin.ScheduleForManager();
                break;
            case 2:
                admin.ScheduleForStaff();
                break;
            default:
                break;
        }
    }
}
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Account account = new Account();
        while (true){
            System.out.println("1. Login");
            System.out.println("2. Quit");
            System.out.printf("Choose your option: ");
            int choose = sc.nextInt();
            switch (choose){
                case 1:
                    System.out.printf("Username: ");
                    String username = sc.next();
                    System.out.printf("Password: ");
                    String password = sc.next();
                    if(Account.Login(username,password).equals("admin")){
                        adminMenu();
                    } else if (Account.Login(username,password).equals("user")) {
                        userMenu();
                    } else if (Account.Login(username,password).equals("manage")) {
                        manageMenu();
                    }
                    break;
                default:
                    break;
            }
        }
    }
    public static void adminMenu(){

    }
    private static void userMenu() {
        UserAccount userAccount = new UserAccount();
        while (true) {
            System.out.println("1. Create Schedule");
            System.out.println("2. Modify Schedule");
            System.out.println("3. Remove Schedule");
            System.out.println("4. View Schedule");
            System.out.println("5. Logout");
            int chooseUser = sc.nextInt();
            switch (chooseUser){
                case 1:
                    userAccount.createSchedule();
                    break;
                case 2:
                    userAccount.modifySchedule();
                    break;
                case 3:
                    userAccount.removeSchedule();
                    break;
                default:
                    break;
            }
        }
    }
    private static void manageMenu() {
    }
}
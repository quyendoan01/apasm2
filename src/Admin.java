import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class Admin {
    static Color color = new Color();
    Scanner sc = new Scanner(System.in);
    protected List<ManagerAccount> managerAccounts = new ArrayList<>();
    protected List<StaffAccount> staffAccounts = new ArrayList<>();
    public List<ManagerAccount> getManagerAccounts() {
        return managerAccounts;
    }
    public void setManagerAccounts(List<ManagerAccount> managerAccounts) {
        this.managerAccounts = managerAccounts;
    }
    public List<StaffAccount> getStaffAccounts() {
        return staffAccounts;
    }
    public void setStaffAccounts(List<StaffAccount> staffAccounts) {
        this.staffAccounts = staffAccounts;
    }
    public void addAccount(){
        System.out.println(color.PURPLE + "Manager account or Staff account ?" + color.RESET);
        System.out.println(color.BLUE + "1. Manager account");
        System.out.println("2. Staff account");
        System.out.println("3. Back" + color.RESET);
        int adchoose = sc.nextInt();
        switch (adchoose) {
            case 1:
                System.out.println(color.BLUE + "Username: " + color.RESET);
                String mname = sc.next();
                System.out.println(color.BLUE + "Password: " + color.RESET);
                String mpass = sc.next();
                ManagerAccount maccount = new ManagerAccount(mname, mpass, new ArrayList<>(), new ArrayList<>());
                List<ManagerAccount> managerAccountList = getManagerAccounts();
                managerAccountList.add(maccount);
                setManagerAccounts(managerAccountList);
                break;
            default:
                break;
            case 2:
                if (getManagerAccounts() != null) {
                    System.out.println(color.BLUE + "Username: " + color.RESET);
                    String uname = sc.next();
                    System.out.println(color.BLUE + "Password: " + color.RESET);
                    String upass = sc.next();
                    for (ManagerAccount managerAccount : getManagerAccounts()) {
                        System.out.println(managerAccount.getUsername() + " (Manager)");
                    }
                    System.out.println(color.BLUE + "Choose the manager of this staff: " + color.RESET);
                    String sManager = sc.next();
                    StaffAccount sAccount = new StaffAccount(uname, upass, new ArrayList<>(), sManager);
                    List<StaffAccount> StaffAccountAdmin = getStaffAccounts();
                    StaffAccountAdmin.add(sAccount);
                    setStaffAccounts(StaffAccountAdmin);
                    for (int i = 0; i < getManagerAccounts().size(); i++) {
                        ManagerAccount managerAccount = managerAccounts.get(i);
                        if (managerAccount.getUsername().equals(sManager)) {
                            List<StaffAccount> StaffAccountList = managerAccount.getStaffAccounts();
                            StaffAccountList.add(sAccount);
                            managerAccount.setStaffAccounts(StaffAccountList);
                            break;
                        }
                    }
                }
                break;
        }
    }
    public void modifyAccount(){
        System.out.println(color.BLUE + "Choose name: " + color.RESET);
        String fName = sc.next();
        for (Account account : getStaffAccounts()){
            if (account.getUsername().equals(fName)){
                System.out.println(color.BLUE + "Change name: " + color.RESET);
                String cName = sc.next();
                account.setUsername(cName);
                break;
            }
            else {
                for (Account account1 : getManagerAccounts()){
                    if (account1.getUsername().equals(fName)){
                        System.out.println(color.BLUE + "Change name: "+ color.RESET);
                        String cName = sc.next();
                        account1.setUsername(cName);
                        break;
                    }
                }
            }
        }
    }
    public void removeAccount(){
        System.out.println(color.BLUE + "Choose name: "+ color.RESET);
        String fName = sc.next();
        for (Account account : getManagerAccounts()){
            if (account.getUsername().equals(fName)){
                System.out.println(color.RED + "You are deleting " + account.getUsername() + "'s account, are you sure ?"+ color.RESET);
                System.out.println(color.YELLOW + "1. Yes");
                System.out.println("2. No" + color.RESET);
                int confirm = sc.nextInt();
                if (confirm == 1){
                    account.removeAccount();

                    List<ManagerAccount> newMngList = getManagerAccounts();
                    newMngList.remove(account);
                    setManagerAccounts(newMngList);
                }
                break;
            }
            else {
                for (Account account1 : getStaffAccounts()){
                    if (account1.getUsername().equals(fName)){
                        System.out.println(color.RED +"You are deleting " + account1.getUsername() + "'s account, are you sure ?"+ color.RESET);
                        System.out.println(color.YELLOW + "1. Yes");
                        System.out.println("2. No"+ color.RESET);
                        int confirm = sc.nextInt();
                        if (confirm == 1){
                            account1.removeAccount();

                            List<StaffAccount> newStaffList = getStaffAccounts();
                            newStaffList.remove(account1);
                            setStaffAccounts(newStaffList);
                        }
                        break;
                    }
                }
            }
        }
    }
    public void ScheduleForManager() {
        int checkSchedules = 0;
        for (Account account : getManagerAccounts()) {
            if (account.getSchedules() != null) {
                checkSchedules++;
            }
        }
        if (checkSchedules == 0){
            System.out.println(color.YELLOW + "Schedule for Manager is None" + color.RESET);
        }
        else {
            for (Account account : getManagerAccounts()) {
                if (!account.getSchedules().isEmpty()) {
                    System.out.println(account.getUsername()+": ");
                    for (Schedule schedule : account.getSchedules()){
                        schedule.showSchedule();
                    }
                }
            }
        }
        menuSchedule("Manager");
    }
    public void ScheduleForStaff(){
        int checkSchedules = 0;
        for (Account account : getStaffAccounts()) {
            if (!account.getSchedules().isEmpty()) {
                checkSchedules++;
            }
        }
        if (checkSchedules == 0){
            System.out.println(color.YELLOW + "Schedule for Staff is None" + color.RESET);
        }
        else {
            for (Account account : getStaffAccounts()) {
                if (!account.getSchedules().isEmpty()) {
                    System.out.println(account.getUsername()+": ");
                    for (Schedule schedule : account.getSchedules()){
                        schedule.showSchedule();
                    }
                }
            }
        }
        menuSchedule("Staff");
    }
    public void menuSchedule(String type){
        System.out.println(color.BLUE + "1. Add Schedule");
        System.out.println("2. Remove Schedule");
        System.out.println("3. Back" + color.RESET);
        int scheduleChoose = sc.nextInt();
        switch (scheduleChoose){
            case 1:
                addSchedule(type);
                break;
            case 2:
                removeSchedule(type);
                break;
            default:
                break;
        }
    }
    public void addSchedule(String type){
        if (type.equals("Manager")){
            for (ManagerAccount managerAccount : getManagerAccounts()){
                System.out.println(managerAccount.getUsername() + " (Manager)");
            }
            System.out.println(color.BLUE + "Choose name of manager to add schedule: " + color.RESET);
            String mngName = sc.next();
            for (ManagerAccount managerAccount : getManagerAccounts()){
                if (managerAccount.getUsername().equals(mngName)){
                    Schedule schedule = createNotification();

                    List<Schedule> mngScheduleList = managerAccount.getSchedules();
                    mngScheduleList.add(schedule);
                    managerAccount.setSchedule(mngScheduleList);
                }
            }
        }
        else{
            for (StaffAccount staffAccount : getStaffAccounts()){
                System.out.println(staffAccount.getUsername() + " (Staff)");
            }
            System.out.println(color.BLUE +"Choose name of staff to add schedule: "+ color.RESET);
            String staffName = sc.next();
            for (StaffAccount staffAccount : getStaffAccounts()){
                if (staffAccount.getUsername().equals(staffName)){
                    Schedule schedule = createNotification();

                    List<Schedule> staffScheduleList = staffAccount.getSchedules();
                    staffScheduleList.add(schedule);
                    staffAccount.setSchedule(staffScheduleList);
                }
            }
        }

    }
    public void removeSchedule(String type){
        if (type.equals("Manager")){
            for (ManagerAccount managerAccount : getManagerAccounts()){
                System.out.println(managerAccount.getUsername() + " (Manager)");
            }
            System.out.println(color.BLUE + "Choose name of manager to remove schedule: " + color.RESET);
            String mngName = sc.next();
            for (ManagerAccount managerAccount : getManagerAccounts()) {
                if (managerAccount.getUsername().equals(mngName) && !managerAccount.getSchedules().isEmpty()) {
                    for (int i = 0; i < managerAccount.getSchedules().size(); i++){
                        int j = i + 1;
                        System.out.print(color.CYAN + j + color.RESET + ". ");
                        managerAccount.getSchedules().get(i).showSchedule();
                    }
                    System.out.println(color.BLUE +"Choose index of schedule you want remove: "+color.RESET);
                    int scheduleIndex = sc.nextInt();
                    scheduleIndex -= 1;
                    if (scheduleIndex >= 0 && scheduleIndex < managerAccount.getSchedules().size()){
                        managerAccount.getSchedules().get(scheduleIndex).removeSchedule();
                    }
                }
            }
        }
        else{
            for (StaffAccount staffAccount : getStaffAccounts()){
                System.out.println(staffAccount.getUsername() + " (Staff)");
            }
            System.out.println(color.BLUE +"Choose name of staff to remove schedule: "+color.RESET);
            String staffName = sc.next();
            for (StaffAccount staffAccount : getStaffAccounts()) {
                if (staffAccount.getUsername().equals(staffName) && !staffAccount.getSchedules().isEmpty()) {
                    for (int i = 0; i < staffAccount.getSchedules().size(); i++){
                        int j = i +1;
                        System.out.print(color.CYAN + j + color.RESET + ". ");
                        staffAccount.getSchedules().get(i).showSchedule();
                    }
                    System.out.println(color.BLUE +"Choose index of schedule you want remove: "+color.RESET);
                    int scheduleIndex = sc.nextInt();
                    scheduleIndex -= 1;
                    if (scheduleIndex >= 0 && scheduleIndex < staffAccount.getSchedules().size()){
                        staffAccount.getSchedules().get(scheduleIndex).removeSchedule();
                    }
                }
            }
        }
    }
    public Schedule createNotification(){
        System.out.println(color.BLUE +"Day start (dd/MM/yyyy): "+color.RESET);
        String dayStart = sc.next();
        System.out.println(color.BLUE +"Time start (HH:mm:ss):  "+color.RESET);
        String timeStart = sc.next();
        System.out.println(color.BLUE +"Day end (dd/MM/yyyy): "+color.RESET);
        String dayEnd = sc.next();
        System.out.println(color.BLUE +"Time end (HH:mm:ss): "+color.RESET);
        String timeEnd = sc.next();
        System.out.println(color.BLUE +"Content: "+color.RESET);
        String content = sc.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime newStartTime = LocalTime.parse(timeStart, formatter);
        LocalTime newNotiTime = newStartTime.minusMinutes(5);

        String notiTime = dayStart + " "+ newNotiTime;
        String scheduleStart = dayStart + " " + newStartTime;
        String scheduleEnd = dayEnd + " " + timeEnd;

        Notification notification = new Notification(notiTime, content);
        Schedule schedule = new Schedule(scheduleStart, scheduleEnd, notification);
        return schedule;
    }
}

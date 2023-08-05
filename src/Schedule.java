public class Schedule {
    protected String startTime;
    protected String endTime;
    protected Notification notification;
    public String getStartTime(){
        return startTime;
    }
    public String getEndTime(){
        return endTime;
    }
    public Notification getNotification(){
        return notification;
    }
    public void setNotification(Notification notification){
        this.notification = notification;
    }
    public Schedule(String startTime, String endTime, Notification notification){
        this.startTime = startTime;
        this.endTime = endTime;
        this.notification = notification;
    }
    public void showSchedule(){
        System.out.println("Content: " + notification.notiContent);
        System.out.println("Start: " + startTime.toString());
        System.out.println("End: " + endTime.toString());
    }
    public void removeSchedule(){
        startTime = null;
        endTime = null;
        notification = null;
    }
}

public class Notification {
    protected String notiTime;
    protected String notiContent;
    public Notification(String notiTime, String notiContent){
        this.notiTime = notiTime;
        this.notiContent = notiContent;
    }
    public String getNotiTime() {
        return notiTime;
    }
    public void setNotiTime(String notiTime) {
        this.notiTime = notiTime;
    }
    public String getNotiContent() {
        return notiContent;
    }
    public void setNotiContent(String notiContent) {
        this.notiContent = notiContent;
    }
    public void ShowNoti(){
        if (notiTime == null){
            System.out.println("Notification of this schedule is turn off !!");
        }
        else{
        System.out.println(notiTime.toString() + " " + notiContent);
        }
    }
    public void RemoveNoti(){
        notiTime = null;
        notiContent = null;
    }
}

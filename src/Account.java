import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    protected String username;
    protected String password;
    protected List<Schedule> schedules;
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public List<Schedule> getSchedules(){
        return schedules;
    }
    public void setSchedule(List<Schedule> schedules){
        this.schedules = schedules;
    }
    public void removeAccount(){
        username = null;
        password = null;
        schedules = null;
    }
}

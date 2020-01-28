package sample.pojo;

public class Schedule {
    private int id;
    private String  subject;
    private String  room;
    private Boolean  change;
    private Boolean  week;
    private String   group;
    private String   day;


    public Schedule() {
    }


    public Schedule(int id, String subject, String room, Boolean change, Boolean week, String group, String day) {
        this.id = id;
        this.subject = subject;
        this.room = room;
        this.change = change;
        this.week = week;
        this.group = group;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Boolean getChange() {
        return change;
    }

    public void setChange(Boolean change) {
        this.change = change;
    }

    public Boolean getWeek() {
        return week;
    }

    public void setWeek(Boolean week) {
        this.week = week;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}

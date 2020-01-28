package sample.pojo;

import java.sql.Date;

public class Student extends Account {
    private String group ;
    public Student(){
        super();

    }


    public Student(int id, String name, String surname, String numPhone, String password, String login, Date date, String photos, String group) {
        super(id, name, surname, numPhone, password, login, date,photos);
        this.group = group;
    }

    public Student(Student another)
    {
        super(another);
        this.group=another.group;
    }


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}

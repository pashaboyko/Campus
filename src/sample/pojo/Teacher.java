package sample.pojo;

import java.sql.Date;

public class Teacher extends Account {
     private  String yourGroup;

    public Teacher(int id, String name, String surname, String numPhone, String password, String login, Date date, String photos,  String yourGroup) {
        super(id, name, surname, numPhone, password, login, date,photos);

        this.yourGroup = yourGroup;
    }

    public Teacher(Teacher account) {
        super(account);

        this.yourGroup = account.yourGroup;
    }

    public Teacher() {

    }


    public String getYourGroup() {
        return yourGroup;
    }

    public void setYourGroup(String yourGroup) {
        this.yourGroup = yourGroup;
    }
}

package sample.pojo;


import java.sql.Date;

public class Account {
    private int id;
    private String name;
    private String surname;
    private String numPhone;
    private String password;
    private String login;
    private Date date;
    private String photos;

    public Account(){

    }


    public Account(Account account) {
        this.numPhone = account.numPhone;
        this.name = account.name;
        this.surname = account.surname;
        this.id = account.id;
        this.password = account.password;
        this.login = account.login;
        this.date = account.date;
        this.photos=account.photos;
    }

    public Account(int id, String name, String surname, String numPhone, String password, String login, Date date, String photos) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.numPhone = numPhone;
        this.password = password;
        this.login = login;
        this.date = date;
        this.photos=photos;
    }
    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", numPhone='" + numPhone + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", date=" + date +
                '}';
    }
}

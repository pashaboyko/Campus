package sample.pojo;

public class Marrks {
    private int id;
    private String subject;
    private String name;
    private String surname;
    private int mark;


    public Marrks() {
    }

    public Marrks(int id, String name, String surname, String subject, int mark) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.subject = subject;
        this.mark = mark;

    }
    public Marrks(Marrks another) {
        this.id =another.id;
        this.name = another.name;
        this.surname = another.surname;
        this.subject = another.subject;
        this.mark =another.mark;

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

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }
    public void  setm(){
        System.out.println("1");
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
}

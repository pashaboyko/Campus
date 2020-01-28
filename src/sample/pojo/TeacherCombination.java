package sample.pojo;

import sample.Connectionn;

public class TeacherCombination {
    private int id;
    private int subject;
    private String group;

    public TeacherCombination() {
    }

    public TeacherCombination(int id, int subject, String group) {
        this.id = id;
        this.subject = subject;
        this.group = group;
    }
    public TeacherCombination(TeacherCombination another) {
        this.id = another.id;
        this.subject = another.subject;
        this.group = another.group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return   Connectionn.stringKA72[subject] +
                ", " + group ;
    }
}

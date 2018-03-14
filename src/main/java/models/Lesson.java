package models;

public class Lesson {

    private int id;
    private String title;
    private int classroom_number;

    public Lesson() {
    }

    public Lesson(String title, int classroom_number) {
        this.title = title;
        this.classroom_number = classroom_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getClassroom_number() {
        return classroom_number;
    }

    public void setClassroom_number(int classroom_number) {
        this.classroom_number = classroom_number;
    }
}

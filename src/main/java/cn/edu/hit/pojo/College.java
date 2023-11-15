package cn.edu.hit.pojo;

public class College {
    private String id;
    private String name;
    private Integer studentNumber;
    private String director;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public College(String id, String name, Integer studentNumber, String director) {
        this.id = id;
        this.name = name;
        this.studentNumber = studentNumber;
        this.director = director;
    }
}

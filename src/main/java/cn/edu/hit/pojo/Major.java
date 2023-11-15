package cn.edu.hit.pojo;

public class Major {
    private String id;
    private String name;
    private Integer studentNum;

    public Major(String id, String name, Integer studentNum) {
        this.id = id;
        this.name = name;
        this.studentNum = studentNum;
    }

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

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }
}

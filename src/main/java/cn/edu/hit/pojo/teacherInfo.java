package cn.edu.hit.pojo;

public class teacherInfo {
    private String id;
    private String name;
    private String title;
    private String collegeName;
    private String courseName;
    private String courseCredit;
    private String courseLocation;

    public teacherInfo(String id, String name, String title, String collegeId, String courseName, String courseCredit, String courseLocation) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.collegeName = collegeId;
        this.courseName = courseName;
        this.courseCredit = courseCredit;
        this.courseLocation = courseLocation;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(String courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }
}

package cn.edu.hit.pojo;

public class StudentClub {
    private String id;
    private String name;
    private String clubs;

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

    public String getClubs() {
        return clubs;
    }

    public void setClubs(String clubs) {
        this.clubs = clubs;
    }

    public StudentClub(String id, String name, String clubs) {
        this.id = id;
        this.name = name;
        this.clubs = clubs;
    }
}

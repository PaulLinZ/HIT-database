package cn.edu.hit.pojo;

public class Domitory {
    private String id;
    private Integer space;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSpace() {
        return space;
    }

    public void setSpace(Integer space) {
        this.space = space;
    }

    public Domitory(String id, Integer space) {
        this.id = id;
        this.space = space;
    }
}

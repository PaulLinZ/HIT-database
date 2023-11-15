package cn.edu.hit.pojo;

import java.io.Serializable;

/**
 *
 * @TableName student
 */
public class Student implements Serializable {
    private String id;
    private String name;
    private Integer age;
    private String sex;
    private String grade;
    private String majorId;
    private String dormitoryId;
    private String collegeId;
    private String phoneNumber;
    public Student(String id, String name, Integer age, String sex, String grade, String majorId, String dormitoryId, String collegeId, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.grade = grade;
        this.majorId = majorId;
        this.dormitoryId = dormitoryId;
        this.collegeId = collegeId;
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     */
    private void setId(String id){
        this.id = id;
    }

    /**
     *
     */
    private void setName(String name){
        this.name = name;
    }

    /**
     *
     */
    private void setAge(Integer age){
        this.age = age;
    }

    /**
     *
     */
    private void setSex(String sex){
        this.sex = sex;
    }

    /**
     *
     */
    private void setGrade(String grade){
        this.grade = grade;
    }

    /**
     *
     */
    private void setMajorId(String majorId){
        this.majorId = majorId;
    }

    /**
     *
     */
    private void setDormitoryId(String dormitoryId){
        this.dormitoryId = dormitoryId;
    }

    /**
     *
     */
    private void setCollegeId(String collegeId){
        this.collegeId = collegeId;
    }

    /**
     *
     */
    private void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }


    /**
     *
     */
    public String getId(){
        return this.id;
    }

    /**
     *
     */
    public String getName(){
        return this.name;
    }

    /**
     *
     */
    public Integer getAge(){
        return this.age;
    }

    /**
     *
     */
    public String getSex(){
        return this.sex;
    }

    /**
     *
     */
    public String getGrade(){
        return this.grade;
    }

    /**
     *
     */
    public String getMajorId(){
        return this.majorId;
    }

    /**
     *
     */
    public String getDormitoryId(){
        return this.dormitoryId;
    }

    /**
     *
     */
    public String getCollegeId(){
        return this.collegeId;
    }

    /**
     *
     */
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

}

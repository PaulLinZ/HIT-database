package cn.edu.hit.service;

import cn.edu.hit.pojo.Student;
import cn.edu.hit.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{

    @Override
    public List<Student> getAll(String sql) throws SQLException {
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.executeQuery(sql);
        List<Student> students = new ArrayList<>();
        String id,name,sex,grade,major_id,dormitory_id,college_id,phone_number;
        Integer age;
        while (rs.next()) {
            id = rs.getString("id");
            name = rs.getString("name");
            sex = rs.getString("sex");
            age = rs.getInt("age");
            grade = rs.getString("grade");
            major_id = rs.getString("major_id");
            dormitory_id = rs.getString("dormitory_id");
            college_id = rs.getString("college_id");
            phone_number = rs.getString("phone_number");
            students.add(new Student(id, name, age,sex, grade, major_id, dormitory_id, college_id, phone_number));
        }
        dbUtil.close();
        return students;
    }

    @Override
    public void add(Student student) {
        DBUtil dbUtil = new DBUtil();
        String id = student.getId();
        String name = student.getName();
        Integer age = student.getAge();
        String sex = student.getSex();
        String grade = student.getGrade();
        String majorId = student.getMajorId();
        String dormitoryId = student.getDormitoryId();
        String collegeId = student.getCollegeId();
        String phoneNumber = student.getPhoneNumber();

        String sql = "INSERT INTO student(id, name, age, sex, grade, major_id, dormitory_id, college_id, phone_number) " +
                "VALUES ('" + id + "', '" + name + "', " + age + ", '" + sex + "', '" + grade + "', '" + majorId + "', " +
                "'" + dormitoryId + "', '" + collegeId + "', '" + phoneNumber + "')";

        dbUtil.executeUpdate(sql);
        dbUtil.close();
    }

    @Override
    public void remove(String id) {
        DBUtil dbUtil = new DBUtil();
        dbUtil.executeUpdate("delete from student where id = '"+id+"'");
        dbUtil.close();
    }

    @Override
    public Student getById(String id) throws SQLException {
        DBUtil dbUtil = new DBUtil();
        String sql = "SELECT * FROM student WHERE id = '" + id + "'";
        ResultSet rs = dbUtil.executeQuery(sql);
        String name, sex, grade, majorId, dormitoryId, collegeId, phoneNumber;
        Integer age;
        Student student = null;
        while (rs.next()) {
            id = rs.getString("id");
            name = rs.getString("name");
            sex = rs.getString("sex");
            age = rs.getInt("age");
            grade = rs.getString("grade");
            majorId = rs.getString("major_id");
            dormitoryId = rs.getString("dormitory_id");
            collegeId = rs.getString("college_id");
            phoneNumber = rs.getString("phone_number");
            student = new Student(id, name, age, sex, grade, majorId, dormitoryId, collegeId, phoneNumber);
        }
        dbUtil.close();
        return student;

    }

}

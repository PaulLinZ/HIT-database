package cn.edu.hit.service;

import cn.edu.hit.pojo.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    List<Student> getAll(String sql) throws SQLException;
    void add(Student student);

    void remove(String sid);

    Student getById(String sid) throws SQLException;
}

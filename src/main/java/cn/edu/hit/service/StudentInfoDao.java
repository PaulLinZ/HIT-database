package cn.edu.hit.service;

import cn.edu.hit.pojo.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentInfoDao {
    List<Student> getAll(String sql) throws SQLException;

}


package cn.edu.hit.service;

import cn.edu.hit.pojo.College;

import java.sql.SQLException;
import java.util.List;

public interface CollegeDao {
    List<College> getAll(String sql)throws SQLException;
}

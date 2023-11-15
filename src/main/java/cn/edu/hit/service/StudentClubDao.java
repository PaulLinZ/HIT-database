package cn.edu.hit.service;

import cn.edu.hit.pojo.StudentClub;

import java.sql.SQLException;
import java.util.List;

public interface StudentClubDao {
    List<StudentClub> getAll(String sql) throws SQLException;
}

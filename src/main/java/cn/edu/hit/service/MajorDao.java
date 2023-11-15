package cn.edu.hit.service;

import cn.edu.hit.pojo.Major;

import java.sql.SQLException;
import java.util.List;

public interface MajorDao {
    List<Major> getAll(String sql) throws SQLException;
}

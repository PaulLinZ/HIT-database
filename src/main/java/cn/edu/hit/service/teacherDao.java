package cn.edu.hit.service;

import cn.edu.hit.pojo.teacherInfo;

import java.sql.SQLException;
import java.util.List;

public interface teacherDao {
    List<teacherInfo> getAll(String sql) throws SQLException;
}

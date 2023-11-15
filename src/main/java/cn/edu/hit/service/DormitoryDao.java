package cn.edu.hit.service;

import cn.edu.hit.pojo.Domitory;
import cn.edu.hit.pojo.Major;

import java.sql.SQLException;
import java.util.List;

public interface DormitoryDao {
    List<Domitory> getAll(String sql) throws SQLException;
}

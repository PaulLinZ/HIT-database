package cn.edu.hit.service;

import cn.edu.hit.pojo.Domitory;
import cn.edu.hit.pojo.Major;
import cn.edu.hit.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DormitoryDaoImpl implements DormitoryDao{
    @Override
    public List<Domitory> getAll(String sql) throws SQLException {
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.executeQuery(sql);
        List<Domitory> domitories = new ArrayList<>();
        String id;
        Integer space;
        while (rs.next()) {
            id = rs.getString(1);
            space = rs.getInt(2);
            domitories.add(new Domitory(id, space));
        }
        dbUtil.close();
        return domitories;
    }
}

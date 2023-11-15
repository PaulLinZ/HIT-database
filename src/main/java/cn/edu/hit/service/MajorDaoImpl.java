package cn.edu.hit.service;

import cn.edu.hit.pojo.Major;
import cn.edu.hit.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MajorDaoImpl implements MajorDao{

    @Override
    public List<Major> getAll(String sql) throws SQLException {
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.executeQuery(sql);
        List<Major> majorList = new ArrayList<>();
        String id, name;
        Integer studentNum;
        while (rs.next()) {
            id = rs.getString(1);
            name = rs.getString(2);
            studentNum = rs.getInt(3);
            majorList.add(new Major(id, name,studentNum));
        }
        dbUtil.close();
        return majorList;
    }
}

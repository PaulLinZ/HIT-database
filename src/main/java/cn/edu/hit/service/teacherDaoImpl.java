package cn.edu.hit.service;

import cn.edu.hit.pojo.teacherInfo;
import cn.edu.hit.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class teacherDaoImpl implements teacherDao{
    @Override
    public List<teacherInfo> getAll(String sql) throws SQLException {
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.executeQuery(sql);
        List<teacherInfo> teacherInfos = new ArrayList<>();

        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String title = rs.getString("title");
            String collegeName = rs.getString("collegeName");
            String courseName = rs.getString("courseName");
            String courseCredit = rs.getString("courseCredit");
            String courseLocation = rs.getString("courseLocation");

            teacherInfos.add(new teacherInfo(id, name, title, collegeName, courseName, courseCredit, courseLocation));
        }

        dbUtil.close();
        return teacherInfos;
    }

}

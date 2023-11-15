package cn.edu.hit.service;

import cn.edu.hit.pojo.College;
import cn.edu.hit.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollegeDaoImpl implements CollegeDao{
    @Override
    public List<College> getAll(String sql) throws SQLException {
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.executeQuery(sql);
        List<College> colleges = new ArrayList<>();
        String id;
        String name;
        Integer studentNumber;
        String director;

        while (rs.next()) {
            id = rs.getString("id");
            name = rs.getString("name");
            studentNumber = rs.getInt("student_number");
            director = rs.getString("director");

            College college = new College(id, name, studentNumber, director);
            colleges.add(college);
        }

        dbUtil.close();
        return colleges;
    }
}

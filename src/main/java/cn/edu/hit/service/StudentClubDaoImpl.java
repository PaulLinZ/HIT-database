package cn.edu.hit.service;

import cn.edu.hit.pojo.StudentClub;
import cn.edu.hit.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentClubDaoImpl implements StudentClubDao{
    @Override
    public List<StudentClub> getAll(String sql) throws SQLException, SQLException {
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.executeQuery(sql);
        List<StudentClub> studentClubs = new ArrayList<>();

        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String clubs = rs.getString("clubs");
            studentClubs.add(new StudentClub(id, name, clubs));
        }

        dbUtil.close();
        return studentClubs;
    }
}

package cn.edu.hit.service;

import cn.edu.hit.pojo.Student;
import cn.edu.hit.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentInfoDaoImpl implements StudentInfoDao{
    @Override
    public List<Student> getAll(String sql) throws SQLException {
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.executeQuery(sql);
        List<Student> students = new ArrayList<>();
        String id,name,sex,grade,mname,dormitory_id,cname,phone_number;
        Integer age;
        while (rs.next()) {
            id = rs.getString("id");
            name = rs.getString("sname");
            sex = rs.getString("sex");
            age = rs.getInt("age");
            grade = rs.getString("grade");
            mname = rs.getString("mname");
            dormitory_id = rs.getString("dormitory_id");
            cname = rs.getString("cname");
            phone_number = rs.getString("phone_number");
            students.add(new Student(id, name, age,sex, grade, mname, dormitory_id, cname, phone_number));
        }
        dbUtil.close();
        return students;
    }


}

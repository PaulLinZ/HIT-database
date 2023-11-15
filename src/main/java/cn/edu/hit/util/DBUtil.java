package cn.edu.hit.util;

import java.sql.*;

public class DBUtil {
    private Connection con;
    private Statement stmt;
    public DBUtil(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_lab1","root","123456");
            stmt=con.createStatement();
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void close(){
        try{
            if(!stmt.isClosed()){
                stmt.close();
            }
            if(!con.isClosed()){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public void executeUpdate(String sql){
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public ResultSet executeQuery(String sql){
        try {
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws SQLException {
        DBUtil dbUtil = new DBUtil();
        String sid, sname;
        ResultSet rs = dbUtil.executeQuery("select * from student");
        System.out.println(rs);
        while (rs.next()) {
            sid = rs.getString("id");
            sname = rs.getString("name");
            System.out.println(sid+sname);
        }
    }
}
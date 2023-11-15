package cn.edu.hit.sevlet;

import cn.edu.hit.service.StudentDao;
import cn.edu.hit.service.StudentDaoImpl;
import cn.edu.hit.util.DBUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "deleteStudentServlet", value = "/deleteStudentServlet")
public class deleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List<String> strings = new ArrayList<>();
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.executeQuery("select * from student_club where student_id = "+id);
        while(true){
            try {
                if (!rs.next()) break;
                String cid = rs.getString("club_id");
                strings.add(cid);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        for(String s : strings){
            dbUtil.executeUpdate("delete from student_club where club_id = " + s);
        }
        dbUtil.close();
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.remove(id);
        response.sendRedirect("student.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

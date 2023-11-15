package cn.edu.hit.sevlet;

import cn.edu.hit.pojo.ClubNum;
import cn.edu.hit.pojo.Student;
import cn.edu.hit.service.StudentDao;
import cn.edu.hit.service.StudentDaoImpl;
import cn.edu.hit.service.StudentInfoDao;
import cn.edu.hit.service.StudentInfoDaoImpl;
import cn.edu.hit.util.DBUtil;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "selectStudentServlet", value = "/selectStudentServlet")
public class selectStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String sql = null;
        String num = request.getParameter("num");
        System.out.println(num);
        sql = "SELECT club.name as name, COUNT(*) AS count FROM club,student_club " +
                "WHERE club.id=student_club.club_id GROUP BY club_id HAVING count >= "+num;
        System.out.println(sql);
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.executeQuery(sql);
        System.out.println(rs);
        List<ClubNum> clubNums = new ArrayList<>();
        String id;
        Integer count;
        while(true){
            try {
                if (!rs.next()) break;
                id = rs.getString("name");
                count = rs.getInt("count");
                System.out.println(id+" "+count);
                clubNums.add(new ClubNum(id,count));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println(JSON.toJSONString(clubNums));
        out.print(JSON.toJSONString(clubNums));
    }
}

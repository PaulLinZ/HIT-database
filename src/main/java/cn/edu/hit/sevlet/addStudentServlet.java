package cn.edu.hit.sevlet;

import cn.edu.hit.pojo.Student;
import cn.edu.hit.service.StudentDao;
import cn.edu.hit.service.StudentDaoImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "addStudentServlet", value = "/addStudentServlet")
public class addStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao studentDao = new StudentDaoImpl();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String ageStr = request.getParameter("age");
        String grade = request.getParameter("grade");
        String majorId = request.getParameter("majorId");
        String dormitoryId = request.getParameter("dormitoryId");
        String collegeId = request.getParameter("collegeId");
        String phoneNumber = request.getParameter("phoneNumber");

        // 先尝试从数据库中获取学生对象
        Student student = null;
        try {
            student = studentDao.getById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (student == null) {
            // 如果学生对象不存在，则创建一个新的学生对象并添加到数据库
            try {
                Integer age = Integer.valueOf(ageStr);
                student = new Student(id, name, age, sex, grade, majorId, dormitoryId, collegeId, phoneNumber);
                studentDao.add(student);
            } catch (NumberFormatException e) {
                // 处理年龄转换为整数时的异常
                e.printStackTrace();
                // 可以在此处添加错误处理逻辑，例如返回一个错误页面或信息
            }
        }else{
            request.setAttribute("msg","id:'"+id+"' exits!!!");
            request.getRequestDispatcher("addStudent.jsp").forward(request, response);;
        }
        response.sendRedirect("student.jsp");
    }

}

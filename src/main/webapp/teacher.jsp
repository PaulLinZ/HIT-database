<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2023/11/12
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="cn.edu.hit.pojo.*"%>
<%@ page import="java.util.List" %>
<jsp:useBean id="teacherInfoDao" class="cn.edu.hit.service.teacherDaoImpl" scope="session"></jsp:useBean>
<html>
<head>
    <title>教师信息</title>
    <link href="./style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>教师信息</h1>
    </div>
    <div class="nav-links">
        <a href="student.jsp">学生页面</a>
        <a href="teacher.jsp">教师页面</a>
        <a href="studentClub.jsp">俱乐部页面</a>
    </div>
    <div class="content">
        <table>
            <tr>
                <th>工号</th><th>姓名</th><th>职称</th><th>学院</th><th>所教课程</th><th>课程学分</th><th>课程地点</th>
            </tr>

            <%
                //"select student.id,student.name,student.age,student.sex,student.grade,major.name as mname,dormitory_id,college.name as cname,student.phone_number\n" +
                //"from student,major,college\n" +
                //        "where student.major_id = major.id and student.college_id = college.id;"

//                "select teacher.id,teacher.name,title,college.name as collegeName,\n" +
//                        "       course.name as courseName,course.credit as courseCredit,teaching_building.name as courseLocation\n" +
//                        "from teaching_building,college,teacher FULL JOIN course ON teacher.id=course.teacher_id\n" +
//                        "where course.location_id = teaching_building.id and teacher.college_id = college.id;"

                List<teacherInfo> teacherInfos = teacherInfoDao.getAll("select teacher.id,teacher.name,title,college.name as collegeName," +
                        "course.name as courseName," +
                        "course.credit as courseCredit,teaching_building.name as courseLocation\n" +
                        "from college,teacher LEFT JOIN course ON teacher.id=course.teacher_id " +
                        "LEFT JOIN teaching_building ON course.location_id = teaching_building.id\n" +
                        "where teacher.college_id = college.id");
                String id = null,name,title,collegeName,courseName,credit,courseLocation;
                for(teacherInfo teacherInfo:teacherInfos){
                    id = teacherInfo.getId();
                    name = teacherInfo.getName();
                    title = teacherInfo.getTitle();
                    collegeName = teacherInfo.getCollegeName();
                    courseName = teacherInfo.getCourseName();
                    credit = teacherInfo.getCourseCredit();
                    courseLocation = teacherInfo.getCourseLocation();
                    if(courseName==null){
                        courseName="未教课";
                        credit="无";
                        courseLocation="无";
                    }
            %>
            <tr>
                <td><%=id%></td><td><%=name%></td><td><%=title%></td><td><%=collegeName%></td><td><%=courseName%></td><td><%=credit%></td><td><%=courseLocation%></td>
            </tr>

            <%
                }
            %>

        </table>
    </div>
</div>









</body>
</html>

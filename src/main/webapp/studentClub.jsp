<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2023/11/12
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="cn.edu.hit.pojo.*"%>
<%@ page import="java.util.List" %>
<jsp:useBean id="studentClubDao" class="cn.edu.hit.service.StudentClubDaoImpl" scope="session"></jsp:useBean>
<html>
<head>
    <title>俱乐部信息</title>
    <link href="./style.css" rel="stylesheet" type="text/css"/>
</head>
<script src="js/jquery-3.6.4.min.js"></script>
<script>
    function select(){
        $.ajax({
            type: "post",
            url: "selectStudentServlet",
            data: $('#form').serialize(),
            success: function (data) {
                let result="";
                for(let i =0;i<data.length;i++){
                    result+="<tr>"+"<td>"+data[i].id+"</td>"+"<td>"+data[i].num+"</td>"+"<tr>";
                }
                $("#selectResult").html(result)
                alert("查询成功");
            },
            error: function (err) {
                alert("查询失败");
            }
        })
        return false;
    }
</script>
<body>
<div class="container">
    <div class="header">
        <h1>俱乐部信息</h1>
    </div>
    <div class="nav-links">
        <a href="student.jsp">学生页面</a>
        <a href="teacher.jsp">教师页面</a>
        <a href="studentClub.jsp">俱乐部页面</a>
    </div>
    <div class="content">
        <table>
            <tr>
                <th>学号</th><th>姓名</th><th>参加的俱乐部</th>
            </tr>

            <%
                //"select student.id,student.name,student.age,student.sex,student.grade,major.name as mname,dormitory_id,college.name as cname,student.phone_number\n" +
                //"from student,major,college\n" +
                //        "where student.major_id = major.id and student.college_id = college.id;"
                List<StudentClub> studentClubs = studentClubDao.getAll("SELECT student.id, student.name, (\n" +
                        "    SELECT GROUP_CONCAT(club.name SEPARATOR ', ')\n" +
                        "    FROM club\n" +
                        "             JOIN student_club ON club.id = student_club.club_id\n" +
                        "    WHERE student_club.student_id = student.id\n" +
                        ") AS clubs\n" +
                        "FROM student;");
                String id = null,name,clubs;
                for(StudentClub studentClub:studentClubs){
                    id = studentClub.getId();
                    name = studentClub.getName();
                    clubs = studentClub.getClubs();
            %>
            <tr>
                <td><%=id%></td><td><%=name%></td><td><%=clubs%></td>
            </tr>

            <%
                }
            %>

        </table>
        <p>查询俱乐部成员数量大于该数量的所有俱乐部:</p>
        <form id="form">
            <select name="num" id="num">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
            </select>
            <button type="button" onclick="select()">查询</button>
        </form>
        <table id="selectResult"></table>
        <p id="tips"></p>
    </div>
</div>
</body>
</html>

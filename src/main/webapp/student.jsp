<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2023/11/12
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="studentDao" class="cn.edu.hit.service.StudentDaoImpl" scope="session"/>
<jsp:useBean id="studentInfoDao" class="cn.edu.hit.service.StudentInfoDaoImpl" scope="session"/>
<%@ page import="java.util.List,cn.edu.hit.pojo.Student"%>
<%@ page import="cn.edu.hit.pojo.Major" %>
<%@ page import="cn.edu.hit.pojo.Domitory" %>
<%@ page import="cn.edu.hit.pojo.College" %>
<jsp:useBean id="majorDao" class="cn.edu.hit.service.MajorDaoImpl" scope="session"></jsp:useBean>
<jsp:useBean id="dormitoryDao" class="cn.edu.hit.service.DormitoryDaoImpl" scope="session"></jsp:useBean>
<jsp:useBean id="collegeDao" class="cn.edu.hit.service.CollegeDaoImpl" scope="session"></jsp:useBean>
<html>
<head>
    <title>学生信息</title>
    <link href="./style.css" rel="stylesheet" type="text/css"/>
</head>
<script src="js/jquery-3.6.4.min.js"></script>
<script>
    function select(){
        $.ajax({
            type: "post",
            url: "selectStudentServlet",
            data: $('#selectform').serialize(),
            success: function (data) {
                let result="";
                for(let i =0;i<data.length;i++){
                    result+="<tr>"+"<td>"+data[i].id+"</td>"+"<td>"+data[i].sname+"</td>"+"<td>"+data[i].age+
                        "</td>"+"<td>"+data[i].sex+"</td>"+data[i].grade+"</td>"+"<td>"+data[i].mname+
                        "</td>"+"<td>"+data[i].dormitory_id+"</td>"+"<td>"+data[i].cname+"</td>"+"<td>"+data[i].phone_number+"</td>"+"<tr>";
                }
                $("#selectResult").html(result)
                $("#tips").innerHTML(查询成功)
            },
            error: function (err) {
                alert("查询失败");
            }
        })
    }
</script>
<body>
<div class="container">


    <div class="header">
        <h1>学生信息</h1>
    </div>
    <div class="nav-links">
        <a href="student.jsp">学生页面</a>
        <a href="teacher.jsp">教师页面</a>
        <a href="studentClub.jsp">俱乐部页面</a>
        <a href="ER.pdf">ER图</a>
    </div>
    <div class="content">
        <table>
            <tr>
                <th>学号</th><th>姓名</th><th>年龄</th><th>性别</th><th>年级</th><th>专业</th><th>宿舍</th><th>学院</th><th>电话号码</th><th>删除</th>
            </tr>

            <%
                List<Student> studentList = studentInfoDao.getAll("select * from student_info");
                String id = null,name,sex,grade,majorName,dormitoryId,collegeName,phoneNumber;
                Integer age;
                for(Student student:studentList){
                    id = student.getId();
                    name = student.getName();
                    age = student.getAge();
                    sex = student.getSex();
                    grade = student.getGrade();
                    majorName = student.getMajorId();
                    dormitoryId = student.getDormitoryId();
                    collegeName = student.getCollegeId();
                    phoneNumber = student.getPhoneNumber();
            %>
            <tr>
                <td><%=id%></td><td><%=name%></td><td><%=age%></td><td><%=sex%></td><td><%=grade%></td><td><%=majorName%></td><td><%=dormitoryId%></td><td><%=collegeName%></td><td><%=phoneNumber%></td><td><div class="delete-links"><a onclick="return confirm('确定要删除<%=name%>同学嘛?')" href="deleteStudentServlet?id=<%=id%>">删除</a></div></td>
            </tr>

            <%
                }
            %>

        </table>
        <div class="nav-links">
            <a href="addStudent.jsp">新增学生</a>
        </div>
    </div>
</div>
</body>
</html>

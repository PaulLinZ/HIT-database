<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2023/11/12
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.edu.hit.service.*,cn.edu.hit.pojo.*,java.util.List" %>
<%@ page import="java.awt.desktop.SystemEventListener" %>
<jsp:useBean id="studentDao" class="cn.edu.hit.service.StudentDaoImpl" scope="session"></jsp:useBean>
<jsp:useBean id="majorDao" class="cn.edu.hit.service.MajorDaoImpl" scope="session"></jsp:useBean>
<jsp:useBean id="dormitoryDao" class="cn.edu.hit.service.DormitoryDaoImpl" scope="session"></jsp:useBean>
<jsp:useBean id="collegeDao" class="cn.edu.hit.service.CollegeDaoImpl" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
    <title>新增学生</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; }
        .container { max-width: 600px; margin: auto; padding: 20px; background-color: white; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        table { width: 100%; border-collapse: collapse; }
        th, td { padding: 8px; text-align: left; }
        input[type="text"], input[type="number"], select { width: 100%; padding: 8px; margin: 5px 0; box-sizing: border-box; }
        input[type="submit"] { background-color: #4CAF50; color: white; padding: 10px 15px; border: none; border-radius: 5px; cursor: pointer; }
        input[type="submit"]:hover { background-color: #45a049; }
        .error { color: red; margin-top: 15px; }
        .nav-links a {
            margin: 0 10px;
            text-decoration: none;
            color: #0056b3; /* 默认颜色 */
            font-size: 16px;
            transition: color 0.3s, background-color 0.3s; /* 平滑过渡 */
        }

        .nav-links a:hover, .nav-links a:focus {
            color: #004085; /* 悬停时颜色 */
            background-color: cornflowerblue; /* 悬停时背景色 */
            text-decoration: none; /* 移除悬停时的下划线 */
        }

        .nav-links a:active {
            color: cornflowerblue; /* 点击时的颜色 */
        }

        .nav-links a:visited {
            color: #0056b3; /* 已访问的链接颜色 */
        }
    </style>
    <script src="js/jquery-3.6.4.min.js"></script>
    <script>
        function test() {
            let id = document.forms["myform"]["id"].value;
            let name = document.forms["myform"]["name"].value;
            let age = document.forms["myform"]["age"].value;
            let sex = document.forms["myform"]["sex"].value;
            let grade = document.forms["myform"]["grade"].value;
            let majorId = document.forms["myform"]["majorId"].value;
            let dormitoryId = document.forms["myform"]["dormitoryId"].value;
            let collegeId = document.forms["myform"]["collegeId"].value;
            let phoneNumber = document.forms["myform"]["phoneNumber"].value;

            if (id === "" || name === "" || age === "" || sex === "" || grade === "" || majorId === "0" || dormitoryId === "请选择宿舍" || collegeId === "0" || phoneNumber === "") {
                alert("请填写完整的学生信息！");
                return false;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h2>新增学生</h2>
    <form id="myform" action="addStudentServlet" method="post">
        <table border="1">
            <tr>
                <td>学号</td>
                <td><input type="text" name="id" id="id"/></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name" id="name"/></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input type="radio" name="sex" value="male" checked="true"/>男
                    <input type="radio" name="sex" value="female">女
                </td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="number" name="age" id="age"/></td>
            </tr>
            <tr>
                <td>年级</td>
                <td><input type="text" name="grade" id="grade"/></td>
            </tr>
            <tr>
                <td>专业</td>
                <td>
                    <select name="majorId" id="majorId">
                        <%
                            List<Major> majorList = majorDao.getAll("select * from major");
                            String majorId, majorName;
                            majorId="0";
                            majorName="请选择专业";
                        %>
                        <option value="<%=majorId%>"><%=majorName%></option>
                        <%
                            for (Major major : majorList) {
                                majorId = major.getId();
                                majorName = major.getName();

                        %>
                        <option value="<%=majorId%>"><%=majorName%></option>
                        <%
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>宿舍</td>
                <td>
                    <select name="dormitoryId" id="dormitoryId">
                        <%
                            List<Domitory> domitories = dormitoryDao.getAll("select * from dormitory");
                            String dormitoryId;
                            dormitoryId = "请选择宿舍";
                        %>
                        <option value="<%=dormitoryId%>"><%=dormitoryId%></option>
                        <%
                            for (Domitory domitory : domitories) {
                                dormitoryId = domitory.getId();
                        %>
                        <option value="<%=dormitoryId%>"><%=dormitoryId%></option>
                        <%
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>学院</td>
                <td>
                    <select name="collegeId" id="collegeId">
                        <%
                            List<College> colleges = collegeDao.getAll("select * from college");
                            String collegeId = "0";
                            String collegeName = "请选择学院";
                        %>
                        <option value="<%=collegeId%>"><%=collegeName%></option>
                        <%
                            for (College college : colleges) {
                                collegeId = college.getId();
                                collegeName = college.getName();
                        %>
                        <option value="<%=collegeId%>"><%=collegeName%></option>
                        <%
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>电话号码</td>
                <td><input type="text" name="phoneNumber" id="phoneNumber"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="提交" onclick="return test()"/></td>
            </tr>
        </table>
    </form>
    <%
        if(request.getAttribute("msg")!=null){
            String msg = request.getAttribute("msg").toString();
    %>
    <h style="color: red"><%=msg%></h>
    <%
        }
    %>
    <div class="nav-links">
        <a href="student.jsp">学生页面</a>
    </div>
</div>

</body>
</html>


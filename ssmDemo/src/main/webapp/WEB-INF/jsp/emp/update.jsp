<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/07
  Time: 07:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增员工</title>
    <style>
        table{
            width:600px;
            height:300px;
            list-style: none;
            border-collapse: collapse;
            background-color: aqua;
        }
        td{
            border:1px solid black;
            text-align: center;
        }
        input[type="text"]{
            width:220px;
            height:30px;
            float:left;
        }
        input[type="submit"]{
            width:100px;
            height:30px;
        }
    </style>
</head>
<body>
<center>
    <form action = "updateEmp.do?pageNo=${pageNo}" method="post">
        <table>
            <%--<c:forEach items="${empInfo}" var="emp">--%>
                <tr>
                    <td><input type = "hidden" name ="empNo" value="${empInfo.EMPNO}"/></td>
                </tr>
                <tr>
                    <td>员工姓名：</td>
                    <td><input type = "text" name ="eName"value="${empInfo.ENAME}"/></td>
                </tr>
                <tr>
                    <td>职位：</td>
                    <td><input type = "text" name ="job"value="${empInfo.JOB}"/></td>
                </tr>
                <tr>
                    <td>薪酬：</td>
                    <td><input type = "text" name = "sal"value="${empInfo.SAL}"/></td>
                </tr>
                <tr>
                    <td>奖金：</td>
                    <td><input type = "text" name = "comm"value="${empInfo.COMM}"/></td>
                </tr>
                <tr>
                    <td>部门编号：</td>
                    <td><input type = "text" name = "deptNo"value="${empInfo.DEPTNO}"/></td>
                </tr>
            <%--</c:forEach>--%>
            <tr>
                <td colspan="2" style ="text-align: center"><input type = "submit" value = "修改"/></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>

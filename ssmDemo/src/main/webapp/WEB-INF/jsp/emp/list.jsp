<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/07
  Time: 04:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工列表</title>
    <script src="/js/jquery-3.3.1.min.js"></script>
    <style>
        table{
            width:1000px;
            min-height:200px;
            list-style: none;
            border-collapse: collapse;
            background-color: aqua;
        }
        td{
            border:1px solid black;
            text-align: center;
            line-height: 40px;
        }
        input[type="text"]{
            height: 30px;
        }
        input[type="button"]{
            height: 30px;
            width:50px;
        }
    </style>
    <script>
        function sel(){
            var sel = $("#sel").val();
            window.location.href="/emp/list.do?sel="+sel;
        }
    </script>
</head>
<body>
    <center>
        <h3>用户列表</h3>
        <a href="toAdd.do" style=padding-right:740px;>新增</a>
        <input type="text" name ="sel" id ="sel" value="${sel}"/><input type="button" value="查询"  onclick="sel()"/>
    </center>
    <center>
        <table>
            <tr>
                <td>员工编号</td>
                <td>员工姓名</td>
                <td>职位</td>
                <td>薪酬</td>
                <td>奖金</td>
                <td>入职时间</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${empList}" var="emp">
                <tr>
                    <td>${emp.EMPNO}</td>
                    <td>${emp.ENAME}</td>
                    <td>${emp.JOB}</td>
                    <td>${emp.SAL}</td>
                    <td>${emp.COMM}</td>
                    <td>${emp.HIREDATE}</td>
                    <td><a href="/emp/getById.do?empNo=${emp.EMPNO}&pageNo=${pageNo}">修改</a>&nbsp;&nbsp;<a href="/emp/deleteEmp.do?empNo=${emp.EMPNO}&pageNo=${pageNo}">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="7">
                    ${stringPage}
                </td>
            </tr>

        </table>
    </center>
</body>
</html>

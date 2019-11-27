<%--
  Created by IntelliJ IDEA.
  User: DFG
  Date: 2019/11/26
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户列表</title>
</head>
<link rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.css">
<script src="/static/js/jquery-3.3.1.js"></script>
<script src="/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<body>
<div class="container">
    <br>
    <form action="/sys/list" method="post">
        <input type="text" placeholder="请输入查找的账号" name="account" value="${account}">
        <input type="submit" value="查询" class="btn btn-primary">

        <a href="/addUser.jsp" class="btn btn-success" style="float: right">添加</a><br>
    </form>

    <table class="table table-bordered table-hover table-striped">
        <tr>
            <th>序号</th>
            <th>账号</th>
            <th>真实姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>创建日期</th>
            <th>操作</th>
        </tr>

        <c:forEach var="user" items="${users}" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${user.account}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>
                    <c:if test="${user.sex==1}">男</c:if>
                    <c:if test="${user.sex==0}">女</c:if>
                </td>
                <td>
                    <fmt:parseDate var="birthDate" value="${user.birthDate}" pattern="yyyy-MM-dd"></fmt:parseDate>
                    <fmt:formatDate value="${birthDate}" pattern="yyyy年MM月dd日"></fmt:formatDate>
                </td>
                <td>
                    <fmt:parseDate var="createTime" value="${user.createTime}"
                                   pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
                    <fmt:formatDate value="${createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                </td>
                <td><a href="/sys/toUpdate?id=${user.id}" class="btn btn-info">修改</a>
                    <a href="/sys/delete?id=${user.id}" class="btn btn-danger">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a class="btn btn-info" href="/sys/list?page=1&account=${account}">首页</a>
    <a class="btn btn-info" href="/sys/list?page=${(pageBean.page-1)>0?pageBean.page-1:1}&account=${account}">上一页</a>
    <a class="btn btn-info" href="/sys/list?page=${(pageBean.page+1)<pageBean.pageTotal?pageBean.page+1:pageBean.pageTotal}&account=${account}">下一页</a>
    <a class="btn btn-info" href="/sys/list?page=${pageBean.pageTotal}&account=${account}">尾页</a>
    当前页：${pageBean.page} 总页数：${pageBean.pageTotal} 总数据数：${pageBean.count}
</div>
</body>
</html>

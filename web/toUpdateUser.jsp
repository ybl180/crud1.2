<%--
  Created by IntelliJ IDEA.
  User: DFG
  Date: 2019/11/26
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加用户</title>
</head>
<link rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.css">
<script src="/static/js/jquery-3.3.1.js"></script>
<script src="/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<body>
<div class="container" style="width: 400px">

<h1>修改信息</h1>
    <form action="/sys/update" method="post">
        <input type="text" value="${user.id}" style="display: none" name="id">
        <div class="form-group">
            <label>账号:</label>
            <input type="text" class="form-control" name="account" value="${user.account}">
        </div>
        <div class="form-group">
            <label>真实姓名:</label>
            <input type="text" class="form-control" name="name" value="${user.name}">
        </div>
        <div class="form-group">
            <label>年龄:</label>
            <input type="text" class="form-control" name="age" value="${user.age}">
        </div>
        <div class="form-group">
            <label>性别:</label>
            <input type="radio" name="sex" value="1" <c:if test="${user.sex==1}">checked</c:if> >男
            <input type="radio" name="sex" value="0" <c:if test="${user.sex==0}">checked</c:if> >女
        </div>
        <div class="form-group">
            <label>出生日期:</label>
            <input type="date" class="form-control" name="birthDate" value="${user.birthDate}">
        </div>
        <input type="submit" value="确认修改" class="btn btn-info center-block">
    </form>
</div>
</body>
</html>

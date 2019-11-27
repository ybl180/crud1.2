<%--
  Created by IntelliJ IDEA.
  User: DFG
  Date: 2019/11/26
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<link rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.css">
<script src="/static/js/jquery-3.3.1.js"></script>
<script src="/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<body>
<div class="container" style="width: 400px">

<h1>添加用户</h1>
    <form action="/sys/add" method="post">
        <div class="form-group">
            <label>账号:</label>
            <input type="text" class="form-control" name="account">
        </div>
        <div class="form-group">
            <label>真实姓名:</label>
            <input type="text" class="form-control" name="name">
        </div>
        <div class="form-group">
            <label>年龄:</label>
            <input type="text" class="form-control" name="age">
        </div>
        <div class="form-group">
            <label>性别:</label>
            <input type="radio" name="sex" value="1">男
            <input type="radio" name="sex" value="0">女
        </div>
        <div class="form-group">
            <label>出生日期:</label>
            <input type="date" class="form-control" name="birthDate">
        </div>
        <input type="submit" value="添加" class="btn btn-success center-block">
    </form>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: znakarik
  Date: 11/1/20
  Time: 5:08 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Домашняя страница по работе с пользователями</h1>
Введите id пользователя (0 - вывод всего списка)
<br/>
<%@page import="ru.appline.logic.user.Model" %>
Доступно:
<% Model model = Model.getInstance();
    out.print(model.getFromList().size());
%>
<form method="get" action="get">
    <label>ID</label>
    <input type="text" name="id"></br>
    <button type="submit">Поиск</button>
</form>
<a href="addUser.html">Создать нового пользователя</a></br>
<a href="updateUser.html">Обновить пользователя</a></br>
<a href="deleteUser.html">Удалить пользователя</a>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<body>
<form action="/filetest3" method="post">
    <label for="name">이름:</label>
    <input type="text" id="name" name="name">
    <br>
    <label for="email">이메일:</label>
    <input type="email" id="email" name="email">
    <br>
    <input type="submit" value="제출">
</form>

</body>
</html>

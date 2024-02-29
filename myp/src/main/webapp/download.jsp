<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>File Download</title>
</head>
<body>
    <form action="/download" method="post">
        <input type="text" name="fileName" placeholder="Enter file name to download" />
        <input type="submit" value="Download" />
    </form>
</body>
</html>
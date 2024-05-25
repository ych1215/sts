<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>


<!DOCTYPE html>
<html>
<head>
    <title>File Upload</title>
</head>
<body>
    <h1>Upload Files</h1>
    <form method="post" action="filetest" enctype="multipart/form-data">
        <label for="username">Username:</label>
        <input type="text" name="username" id="username" required />
        <br><br>
        <label for="file">Choose files:</label>
        <input type="file" name="file" id="file" multiple required />
        <br><br>
        <input type="submit" value="Upload" />
    </form>
</body>
</html>

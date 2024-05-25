<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>File Upload</title>
    <script>
        function addFileInput() {
            const fileInputsContainer = document.getElementById('fileInputsContainer');
            const inputCount = fileInputsContainer.getElementsByTagName('input').length + 1;
            const newInput = document.createElement('input');
            newInput.type = 'file';
            newInput.name = 'file' + inputCount;
            newInput.id = 'file' + inputCount;
            newInput.multiple = true;
            newInput.required = true;
            const label = document.createElement('label');
            label.htmlFor = newInput.id;
            label.innerText = `Choose files for upload ${inputCount}:`;
            fileInputsContainer.appendChild(label);
            fileInputsContainer.appendChild(newInput);
            fileInputsContainer.appendChild(document.createElement('br'));
        }
    </script>
</head>
<body>
    <h1>Upload Files</h1>
    <form method="post" action="filetest2" enctype="multipart/form-data">
        <label for="username">Username:</label>
        <input type="text" name="username" id="username" required />
        <br><br>
        <div id="fileInputsContainer">
            <label for="file1">Choose files for upload 1:</label>
            <input type="file" name="file1" id="file1" multiple required />
            <br>
        </div>
        <button type="button" onclick="addFileInput()">Add Another File Input</button>
        <br><br>
        <input type="submit" value="Upload" />
    </form>
</body>
</html>

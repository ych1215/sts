<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Summernote</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>


<script>
    function test() {
        var markupStr = $('#summernote').summernote('code');
         alert(markupStr);
        
    }
    
       function test2() {
       
       var markupStr = 'hello world 유처로11';
		$('#summernote').summernote('code', markupStr);

        
    }
    
    
    
</script>


<body>

  <div id="summernote"><p>Hello Summernote</p></div>
  
  <script>
    $(document).ready(function() {
        $('#summernote').summernote(
        
        {
		  airMode: false
		}
        
        );
    });
  </script>
  
  
  
   <input name="btnSave"  type="BUTTON" value="썸머노트읽기1" onClick="test()">
   <input name="btnSave"  type="BUTTON" value="썸머노트쓰기2" onClick="test2()">
   
   
</body>
</html>
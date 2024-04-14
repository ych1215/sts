<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
String alllist = (String)request.getAttribute("Alllist");
//out.println(alllist);
%>



<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">﻿
  <title>Summernote</title>
  
  <link href="summernote-0.8.18-dist/bootstrap3.4.1.min.css" rel="stylesheet">
  <script src="summernote-0.8.18-dist/jquery-3.5.1.min.js"></script>
  <script src="summernote-0.8.18-dist/bootstrap3.4.1.min.js"></script>
  <link href="summernote-0.8.18-dist/summernote.min.css" rel="stylesheet">
  <script src="summernote-0.8.18-dist/summernote.min.js"></script>
  <script src="summernote-0.8.18-dist/lang/summernote-ko-KR.js"></script>
  
  <!--
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  -->
  
</head>


<script>

	// 읽어 오기 
    function test() {
        var markupStr = $('#summernote').summernote('code');
         alert(markupStr);
        
    }
    
    	// 쓰기 
       function test2() {
       
       var markupStr = '<p><b>Hello Summernote</b></p><blockquote><b>THAJDLEK</b></blockquote><blockquote><b>GGG</b></blockquote><p><b><br></b></p>';
		$('#summernote').summernote('code', markupStr);

        
    }
    
    	// 툴바 없애기 
       function test3() { 
       $('#summernote').summernote('destroy');

        
    }


    // 툴바 없애기 
    function save() { 
      var frm = document.form;
      frm.action = 'saveSummernoteBord';
      frm.method  = "post";

      var markupStr = $('#summernote').summernote('code');

      frm.BORD.value = markupStr;

      debugger;

      frm.submit();
    }
    
   
    
    
</script>


<body>
  <form id="form" name="form">

  <div id="summernote"><p>Hello Summernote</p></div>
   <div id="summernote2"><p>Hello Summernote2</p></div>
  
  <script>
    $(document).ready(function() {
        $('#summernote').summernote(
        
        {
		  airMode: false , // 툴바 안생기게.. 즉 읽기 전용 , 기본이 true 이므로 {} 없으면 툴바 생김.
		   lang: 'ko-KR' , // default: 'en-US' 
		    height: null,                 // set editor height // 높이를 주지 않고 글 내용 다 나오게..
			  minHeight: null,             // set minimum height of editor
			  maxHeight: null,             // set maximum height of editor
			  focus: true                  // set focus to editable area after initializing summe
		}
        
        );
        
        
          $('#summernote2').summernote(
        
        {
		    airMode: false , // 툴바 안생기게.. 즉 읽기 전용 , 기본이 true 이므로 {} 없으면 툴바 생김.
		   lang: 'ko-KR', // default: 'en-US' 
		    height: 100,                 // set editor height
			  minHeight: null,             // set minimum height of editor
			  maxHeight: null,             // set maximum height of editor
			  focus: true                  // set focus to editable area after initializing summe
		}  
        );
        
        $('#summernote').summernote('code', '<%=alllist%>');
        
        
    });
  </script>
  
  
  
   <input name="btnSave"  type="BUTTON" value="썸머노트읽기11" onClick="test()">
   <input name="btnSave"  type="BUTTON" value="썸머노트쓰기22" onClick="test2()">
   <input name="btnSave"  type="BUTTON" value="툴바없애기2" onClick="test3()">
   <input name="btnSave"  type="BUTTON" value="저장" onClick="save()">

   <input name="BORD" id="BORD" type="input" value="" onClick="save()">
   
  </form>

</body>
</html>
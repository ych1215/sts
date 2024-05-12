<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Summernote</title>
  
  <link href="summernote-0.8.18-dist/bootstrap3.4.1.min.css" rel="stylesheet">
  <script src="summernote-0.8.18-dist/jquery-3.5.1.min.js"></script>
  <script src="summernote-0.8.18-dist/bootstrap3.4.1.min.js"></script>
  <link href="summernote-0.8.18-dist/summernote.min.css" rel="stylesheet">
  <script src="summernote-0.8.18-dist/summernote.min.js"></script>
  <script src="summernote-0.8.18-dist/lang/summernote-ko-KR.js"></script>
    
</head>

<style type="text/css">
#sch {
  width: 900;
  padding: 10px;
  border: 1px solid #2dd218;
  margin-bottom: 10px;
  font-family: "굴림";
  font-size: 12px;
}

#war {
  width: 1200px;
}

</style>

<script>
  $(document).ready(function() {
      $('#summernote').summernote (
      
      {
        airMode: false ,             // 툴바 안생기게.. 즉 읽기 전용 , 기본이 true 이므로 {} 없으면 툴바 생김.
        lang: 'ko-KR' ,              // default: 'en-US' 
        height: null,                 // set editor height // 높이를 주지 않고 글 내용 다 나오게..  height: 590,    
        minHeight: null,             // set minimum height of editor
        maxHeight: null,             // set maximum height of editor
        focus: true                  // set focus to editable area after initializing summe
      }
      
      );
   
      $('#summernote').summernote('code', "내용 입력" );
      
  });
</script>

<script>

      // 저장
      function saveClob() { 

        var frm = document.form;
        frm.action = 'pgm_bord_dtl_save';
        frm.method  = "post";

        var markupStr = $('#summernote').summernote('code');

        frm.contents.value = markupStr;

        frm.submit();
    }
    
    // 목록 
    function fnList() { 
      location.href = "pgm_bord";
    }
    
</script>


<body>
  <form id="form" name="form">

     <!-- <DIV style="position: absolute; top: 10%; left: 50%; transform: translate(-50%, -50%);"> -->
    <div id="war" style="position: absolute;  left: 50%; transform: translate(-50%);">

      <br>
      <div id="sch">
        게시판구분
        <SELECT style="width:200px" name="bordType" id="bordType"  class="comboAppr" onchange="changeType(this.value)">       
          <OPTION value="JAVA">JAVA</OPTION>
          <OPTION value="ORACLE">오라클</OPTION>
          <OPTION value="JAVASCRIPT">자바크립트</OPTION>
        </SELECT>
        &nbsp;&nbsp;&nbsp;제목 : 
        <input name="title" id="title"  style="width:300PX" type="input"  value="">
        
        &nbsp;&nbsp;&nbsp;키워드 : 
        <input name="keyWord" id="keyWord"  style="width:200px" type="input"  value="">

      </div>

      <input name="btnSave"  type="BUTTON" value="목록" onClick="fnList()">
      &nbsp;&nbsp;&nbsp;<input name="btnSave"  type="BUTTON" value="저장" onClick="saveClob()">

      <input name="contents" id="contents" type="hidden" value="">
      
      <div id="summernote"></div>

    </div>
  </form>

</body>
</html>
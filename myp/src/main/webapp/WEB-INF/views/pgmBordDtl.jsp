<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>

<%

  Map<String, Object> pgmBordDtl = (Map<String, Object>)request.getAttribute("pgmBordDtl");

  String contents = (String)pgmBordDtl.get("CONTENTS");

  String seq      = (String)pgmBordDtl.get("SEQ");
  String title    = (String)pgmBordDtl.get("TITLE");
  String bordType = (String)pgmBordDtl.get("BORD_TYPE");
  String keyWord  = (String)pgmBordDtl.get("KEYWORD");

%>



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
  
  <!--
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  -->
  
</head>

<style>
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
      $('#summernote').summernote(
      
      {
    airMode: false , // 툴바 안생기게.. 즉 읽기 전용 , 기본이 true 이므로 {} 없으면 툴바 생김.
     lang: 'ko-KR' , // default: 'en-US' 
      height: 400,                 // set editor height // 높이를 주지 않고 글 내용 다 나오게..
      minHeight: null,             // set minimum height of editor
      maxHeight: null,             // set maximum height of editor
      focus: true                  // set focus to editable area after initializing summe
  }
      
      );

      var contents = `<%=contents%>`;
      $('#summernote').summernote('code', contents);
      
      
  });
</script>


<script>

	// 내용 읽기
    function test() {
        var markupStr = $('#summernote').summernote('code');
         alert(markupStr);
        
    }
    
    	// 내용 쓰기
       function test2() {
       
       var markupStr = '<p><b>Hello Summernote</b></p><blockquote><b>THAJDLEK</b></blockquote><blockquote><b>GGG</b></blockquote><p><b><br></b></p>';
		$('#summernote').summernote('code', markupStr);

        
    }
    
    	// 툴바 없애기 
       function test3() { 
       $('#summernote').summernote('destroy');

        
    }

      // CLOB 저장
      function saveClob() { 
      var frm = document.form;
      frm.action = 'pgm_bord_dtl_update';
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

    <DIV id="war" style="position: absolute; top:40%; left: 50%; transform: translate(-50%, -50%);">


      <br>
      <div id="sch">
        게시판구분
        <SELECT style="width:200px" name="bordType" id="bordType"  class="comboAppr" onchange="changeType(this.value)">       
          <OPTION value="JAVA">JAVA</OPTION>
          <OPTION value="ORACLE">오라클</OPTION>
          <OPTION value="JAVASCRIPT">자바크립트</OPTION>
        </SELECT>
        &nbsp;&nbsp;&nbsp;제목 : 
        <input name="title" id="title" type="input"  style="width:300PX" value="<%=title%>">
        
        &nbsp;&nbsp;&nbsp;키워드 : 
        <input name="keyWord" id="keyWord" type="input"  style="width:200px" value="<%=keyWord%>">

      
        <input name="seq" id="keyWord" type="hidden"  style="width:50px" value="<%=seq%>">

      </div>

      <input name="btnSave"  type="BUTTON" value="목록" onClick="fnList()">
       &nbsp;&nbsp;&nbsp;<input name="btnSave"  type="BUTTON" value="저장" onClick="saveClob()">
     

        <input name="contents" id="contents" type="hidden" value="" >


  <div id="summernote"><p>Hello Summernote</p></div>

  </DIV>

  </form>

</body>
</html>
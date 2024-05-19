<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>


<%
  Map<String, Object> ct = (Map<String, Object>)request.getAttribute("clob");

  String clob2 = (String)ct.get("cont");
  
%>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">


  <style>

    body {
        font-family: Arial, sans-serif;
    }
    
    .container {          
        border: 1px solid #000;
    }
    .header {
        text-align: center;
        margin-bottom: 20px;
    }
    .header h1 {
        margin: 0;
        font-size: 24px;
    }
    .header p {
        margin: 0;
        font-size: 18px;
    }

    .content {          
        margin-bottom: 20px;
        padding: 20px;
    }
    .content h2 {
        text-align: center;
        font-size: 20px;
    }
    .content p {
        margin: 10px 0;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    th {
        background-color: #f2f2f2;
    }

    th, td {
        border: 1px solid #000;
        padding: 8px;
           
    }       

    .appr-table th, .appr-table td {           
        text-align: center;
    }
  
    .appr-table td.opinion {
        text-align: left;
    }


</style>

</head>

<style type="text/css">

</style>

<script>
</script>

<script>

      // 저장
      function save() { 

        var frm = document.form;
        frm.action = 'clob_save';
        frm.method  = "post";

        frm.submit();
    }
    
    // 목록 
    function fnList() { 
      location.href = "pgm_bord";
    }
    
</script>


<body>
  <form id="form" name="form">
    
 
  
      <input name="btnSave"  type="BUTTON" value="클릭" onClick="save()">
      <textarea name="clob" rows="15" cols="40"></textarea>
  </form>



  
  <div class="header">
    <h1><u>[ 품의서 ]</u></h1>
</div>


<table class="info-table">
    <tr>
        <th style="width:25%;">문서번호</th>
        <td style="width:25%;">20240234343476</td>
        <th style="width:25%;">요청일</th>
        <td style="width:25%;">2024-02-29</td>
    </tr>
    
    <tr>
        <th>기안자</th>
        <td>송석훈</td>
        <th>기안부서</th>
        <td>고객1팀</td>
    </tr>
    <tr>
        <th>부서내공개</th>
        <td>공개</td>
        <th>보존연한</th>
        <td>1년</td>
    </tr>
    <tr>
        <th>참조자 지정</th>
        <td>김섭, 이한정, 이기성, 이미기</td>
        <th>통보 지정</th>
        <td> 1</td>
    </tr>
    <tr>
        <th>문서 제목</th>
        <td colspan="3">[대여]  예외 요청 숙 의 件</td>
    </tr>
</table>

<div class="container">
    <div class="content">
       <!-- 내용  -->
       <%=clob2 %>
    </div>
</div>
<h1></h1>

<h3 style="margin-bottom: 5px;">▣ 결재의견</h3>
<table class="appr-table">
    <tr>
        <th style="width:10%;">결재유형</th>
        <th style="width:10%;">결재결과</th>
        <th style="width:10%;">결재자</th>
        <th style="width:15%;">부서</th>
        <th style="width:10%;">결재일시</th>
        <th style="width:35%;">의견</th>
    </tr>
     <!-- 결재의견 -->
    <tr>  
        <td>합의</td>
        <td>합의</td>
        <td>송석훈</td>
        <td>부산1팀</td>
        <td>2024-05-05</td>
        <td class="opinion">합의 합니다</td>
    </tr>
    <tr>
        <td>합의</td>
        <td>합의</td>
        <td>송석훈</td>
        <td>부산1팀</td>
        <td>2024-05-05</td>
        <td class="opinion">합의 합니다</td>
    </tr>
    <tr>
        <td>결재</td>
        <td></td>
        <td>송석훈</td>
        <td>부산1팀</td>
        <td>2024-05-05</td>
        <td class="opinion">합의 합니다합의 합니다합의 합니다합의 합니다합의 합니다합의 합니다합의 합니다합의 합니다합의 합니다합의 합니다합의 합니다합의 합니다</td>
    </tr>

</table>

</body>
</html>
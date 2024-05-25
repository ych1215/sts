<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.Map" %>
      <%@ page import="java.util.List" %>
        <%@ page import="java.util.HashMap" %>       

          <% 
          
            List<Map<String, Object>> pmgBordList = (List<Map<String, Object>>)request.getAttribute("pgmBordList");
          %>

              <!DOCTYPE html>
              <html lang="en">

              <head>
                <meta charset="UTF-8">
                <title>프로그램 게시판</title>

                <script src="js/jquery3.7.1.js"></script>


                <style type="text/css">
                  .party_tbl_new {
                    border-top: 1px solid #bbbbbb;
                  }

                  .party_tbl_new tr td {
                    font-family: "굴림";
                    font-size: 12px;
                    color: #666666;
                    text-align: center;
                    border-bottom: 1px solid #bbbbbb;
                    border-left: 1px solid #bbbbbb;
                  }

                  .party_tbl_new tr th {
                    font-family: "굴림";
                    font-size: 12px;
                    color: #333333;
                    font-weight: bold;
                    text-align: center;
                    border-bottom: 1px solid #bbbbbb;
                    border-left: 1px solid #bbbbbb;
                    background-color: #f3f3f3;
                  }

                  .border_last {
                    border-right: 1px solid #bbbbbb;
                  }

                  #sch {
                    width: 900;
                    padding: 10px;
                    border: 1px solid #2dd218;
                    margin-bottom: 10px;
                    font-family: "굴림";
                    font-size: 12px;
                  }

                  .seq {
                    text-decoration: underline; 
                  }

                </style>

              </head>

              <script type="text/javascript">

                $(document).ready(function () {

                    $(".seq").click(function () {

                     var seq = this.innerText;

                     location.href = "pgm_bord_dtl?seq="+seq;

                    });
                });
            </script>


              <script>
              
                //  서버에서 보내 해더 읽고 서버로 해더 보내기 
				function call() {
				  console.log('Function call started');
				  fetch('/pgm_bord', {
				    method: 'GET',
				    headers: {
				      'ychcilnet-aaa': 'your-header-value' // 해더 보내기
				    }
				  })
				  .then(function(response) {
				    if (response.ok) {
				      response.headers.forEach(function(value, key) {
				        console.log(key + ': ' + value); // 해더 읽기 
				      });
				    } else {
				      console.error('Request failed with status: ' + response.status);
				    }
				  })
				  .catch(function(error) {
				    console.error('Fetch error:', error);
				  });
				  console.log('Function call finished');
				}
  

                 // 조회
                 function fnSch() {
                  var frm = document.form;
                  frm.action = 'pgm_bord';
                  frm.method = "post";
                  frm.submit();
                 }

                 function fnNew() {
                  var frm = document.form;
                  frm.action = 'pgm_bord_new';
                  frm.method = "post";
                  frm.submit();
                 }

              </script>

              <body>
                <form id="form" name="form">

                  <!-- <DIV style="position: absolute; top: 10%; left: 50%; transform: translate(-50%, -50%);"> -->
                  <DIV style="position: absolute;  left: 50%; transform: translate(-50%);">
                  
                    <div id="sch">
                      게시판구분
                      <SELECT style="width:150px" name="bordType" id="bordType" class="comboAppr" onchange="changeType(this.value)">
                        <OPTION value="">All</OPTION>
                        <OPTION value="JAVA">JAVA</OPTION>
                        <OPTION value="ORACLE">오라클</OPTION>
                        <OPTION value="JAVASCRIPT">자바크립트</OPTION>
                      </SELECT>
                      제목 : 
                      <input name="title" id="title" type="input" size="50" value="">                      
                      키워드 : 
                      <input name="keyWord" id="keyWord" type="input" size="50" value="">
                      <input name="schButton" id="schButton" type="BUTTON" value="검색" onClick="fnSch()">
                       <input name="schButton2" id="schButton2" type="BUTTON" value="해더보내기" onClick="call()">
                    </div>

                    <input name="new" id="new" type="BUTTON" value="등록" onClick="fnNew()">

                    <table class="party_tbl_new" width="1200" cellspacing="0" cellpadding="0">
                      <tr height="40">
                        <th width="5%" height="20">순번</td>
                        <th width="10%">구분</td>
                        <th width="20%">키워드</td>
                        <th width="55%">제목</td>
                        <th width="15%" class="border_last">등록일자</td>
                      </tr>

                      <% 
                      HashMap bordMap = new HashMap(); 

                      if (pmgBordList !=null) { 
                        for (int i=0; i < pmgBordList.size(); i++) {
                          bordMap=(HashMap) pmgBordList.get(i); 
                      %>

                        <tr>
                          <td height="20" class="seq">
                            <a href="#" >
                            <%=bordMap.get("SEQ")%> 
                            </a>
                          </a> 
                          </td>
                          <td>
                            <%=bordMap.get("BORD_TYPE")%>
                          </td>
                          <td>
                            <%=bordMap.get("KEYWORD")%>
                          </td>
                          <td style="text-align: left;">
                            <%=bordMap.get("TITLE")%>
                          </td>
                          <td class="border_last">
                            <%=bordMap.get("CREATE_DT")%>
                          </td>
                        </tr>

                      <% 
                        } 
                      }
                      %>

                    </table>
                  </DIV>
                </form>
              </body>
              </html>
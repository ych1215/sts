<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.Map" %>
      <%@ page import="java.util.List" %>
        <%@ page import="java.util.HashMap" %>
        
        <%
        	 out.println( request.getParameter("aaa"));
        %>



          <% List<Map<String, Object>> pmgBordList = (List<Map<String, Object>>)request.getAttribute("pmgBordList");

              %>

              <!DOCTYPE html>
              <html lang="en">

              <head>
                <meta charset="UTF-8">
                <title>Summernote</title>


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
                </style>

              </head>

              <script>

                function saveClob() {  
                  var frm = document.form;
                  frm.action = 'saveSummernoteBordClob';
                  frm.method = "post";

                  var markupStr = $('#summernote').summernote('code');

                  frm.BORD.value = markupStr;

                  debugger;

                  frm.submit();
                }

		          function test1(type) {
                  alert(type);
                }
                

                function changeType(type) {
                
                document.title = "xxxxxxx"; // 넘겨줄 값 셋팅, 동일하면 안듬
                 // alert(type);
                // debugger
                // document.all();
                }


              </script>

              <body>
                <form id="form" name="form">

                  <DIV style="position: absolute; top: 10%; left: 50%; transform: translate(-50%, -50%);">


                    <div id="sch">
                      게시판구분
                      <SELECT style="width:100px" name="comboAppr2" class="comboAppr" onchange="changeType(this.value)">
                        <OPTION value="JAVA">JAVA</OPTION>
                        <OPTION value="ORACLE">오라클</OPTION>
                        <OPTION value="JAVASCRIPT">자바크립트</OPTION>
                      </SELECT>
                      <input name="schNm" id="schNm" type="input" size="50" value="1215">
                      <input name="apprSchNm" id="apprSchNm" type="BUTTON" value="검색" onClick="">

                    </div>

                    <table class="party_tbl_new" width="900" cellspacing="0" cellpadding="0">
                      <tr height="40">
                        <th width="10%" height="20">순번</td>
                        <th width="20%">구분</td>
                        <th width="60%">제목</td>
                        <th width="10%" class="border_last">등록일자</td>
                      </tr>


                      <% HashMap bordMap=new HashMap(); if (pmgBordList !=null) { for (int i=0; i < pmgBordList.size();
                        i++) { bordMap=(HashMap) pmgBordList.get(i); %>

                        <tr>
                          <td height="20">
                            <%=bordMap.get("SEQ")%>
                          </td>
                          <td>
                            <%=bordMap.get("BORD_TYPE")%>
                          </td>
                          <td style="text-align: left;">
                            <%=bordMap.get("TITLE")%>
                          </td>
                          <td class="border_last">
                            <%=bordMap.get("CREATE_DT")%>
                          </td>
                        </tr>

                        <% } } %>

                    </table>
                  </DIV>
                </form>
              </body>
              </html>
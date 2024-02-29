<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
String alllist = (String)request.getAttribute("Alllist");
out.println(alllist);
%>

<script src="js/jquery-3.3.1.js"></script>
<SCRIPT LANGUAGE="JavaScript">
var parsedJSON = JSON.parse($.trim('<%=(String)request.getAttribute("Alllist")%>'));
alert("irm페이지의::"+parsedJSON.Alllist);



  // 부모 페이지에서 자식 함수 호출 할수 있다.
  function myFunction() {
        alert('부모에서 날 호출 했다');
    }
    
    
 // 이벤트 리스너: 부모 페이지에서의 메시지 수신
    window.addEventListener('message', function (event) {
        // origin을 검증하여 신뢰할 수 있는 소스에서만 메시지를 수락
        if (event.origin !== window.location.origin) return;

        // 수신한 메시지를 사용하여 부모 페이지의 함수 호출
        alert("부모가보낸메시지는::"+event.data);
    });
    
 // 함수를 iframe에게 전송하는 함수
    function sendMessageToIframe() {
        var iframe = document.getElementById('iframe1');
         window.parent.postMessage("알겟당", '*');
    }
    
</SCRIPT>


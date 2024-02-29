<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>

<script src="js/jquery-3.3.1.js"></script>

<link rel="stylesheet" href="css/my_css.css">

<title>1</title>
<body>
 
<BODY leftmargin=0 topmargin=0 scroll="no" onload="fn_Load();">
<SCRIPT LANGUAGE="JavaScript">



    function fn_Load() {
    };

    function fn_submit() {
    // http://smtapst.lghv.net/eam/gportal/approval/approvalProxyFORM.jsp?http://gwpdev.lghv.net/ikep-webapp/rest/comb/listappr/getApprLineList
    const json = "{ \"FORM_ID\": \"120000110403\", \"USER_ID\": \"highsens\" }";
 
// JSON 문자열을 JSON 오브젝트로 변환합니다.
const object = JSON.parse(json);
		    $.ajax({
		      //  url: "/eam/gportal/approval/approvalProxyFORM.jsp?http://gwpdev.lghv.net/ikep-webapp/rest/comb/listappr/getApprLineList",
		        url: "/proxy",
		        type: 'POST',
		       //   contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		         contentType: "application/json; charset=UTF-8",
		       // data:  JSON.parse(json),
		        data: $("form[name=form]").serialize(),
		        async: false,
		        error: function (e) {
		            alert(e.responseText);
		        },
		        beforeSend: function(){
		        },
				success: function(data) {
		        	var parsedJSON = JSON.parse($.trim(data));
		        	if(parsedJSON.staus == "S"){
		        		//alert("USER_ID::" + parsedJSON.USER_ID);
		        		console.log("USER_ID::" + parsedJSON.USER_ID);
		        		fnFormSubmit();
		        	}
		        },
		        complete: function() {
		        }
		    }); 
      }
      
      
	function fnFormSubmit() {
	
		var frm = document.form;
  		frm.target = 'iframe1';
 		frm.action = 'formSubmit';
 		frm.method  = "post";
 		frm.submit();
	
    };

      
    // 아이프레임의 데이터 핸들링
	function fnIrmRead() {
		
		///////////////////////아이프레임의 text 읽어서 json으로 파싱하기 stat //////////////////////////////
		var iframe = document.getElementById('iframe1');

        // iframe 내부의 document 객체에 접근
        var iframeDocument = iframe.contentDocument || iframe.contentWindow.document;

        // 내용을 읽어오기 (예: body 내의 텍스트)
        var iframeContent = iframeDocument.body.innerText;

        // 콘솔에 출력 또는 원하는 다른 작업 수행
        //alert(iframeContent);
        
        var parsedJSON = JSON.parse(iframeContent);
        alert(parsedJSON.Alllist);
        ///////////////////////아이프레임의 text 읽어서 json으로 파싱하기 end //////////////////////////////
        
        
        
        ///////////////////////아이프레임의 함수 호출 start  //////////////////////////////
         var iframe2 = document.getElementById('iframe1');

        // iframe2 내부의 window 객체에 접근
        var iframeWindow = iframe2.contentWindow;

        try {
            // iframe2 내부의 함수 호출
            iframeWindow.myFunction();
        } catch (error) {
            console.error('Error calling function in iframe2:', error);
        }
        //////////////////////////////아이프레임의 함수 호출 end ///////////////////////
	}
	
	/////////////////////////// postMessage start /////////////////////////////////////
 	// iframe에게 메시지 전송 함수 
    function sendMessageToIframe() {
        var iframe = document.getElementById('iframe1');
        var message = '자식아 밥묵자';
        
        // iframe으로 postMessage를 사용하여 메시지 전송
        iframe.contentWindow.postMessage(message, '*');
    }
    
	// 이벤트 리스너: iframe에서 보낸 메시지 수신
    window.addEventListener('message', function (event) {
        // origin을 검증하여 신뢰할 수 있는 소스에서만 메시지를 수락
        if (event.origin !== window.location.origin) return;
          alert('자식이 보낸 메시지 : ' + event.data);
        
    });
    //////////////////////////  postMessage end //////////////////////////////////////
     function fnCors() {
       var frm = document.form;
 		frm.action = 'https://www.phpschool.com/gnuboard4/bbs/board.php?bo_table=teach&wr_id=3219&page=1';
 		frm.method  = "post";
 		frm.submit();
 		
    }
    
    
    
      
</SCRIPT>


<form id="form" name="form">
<br> <br>
<input type = "button" name="button1" value="전송(아이프레임으로 target)" onclick="fn_submit()" />
<input type = "text" name="FORM_ID" value="120000110403" />
<input type = "text" name="USER_ID" value="highsens" />
</form>	
<img src="images/tet.jpg" alt="My image">

<br><br>
<input type = "button" name="button1" value="아이프레임의 html을 json으로 파싱해서 읽어오기(전송 버튼 클릭후 가능)" onclick="fnIrmRead()" /> <br> <br>



<button onclick="sendMessageToIframe()">아이프레임으로 post메시지 전송</button>

<br><br><br>
<iframe name="iframe1" id="iframe1" width="500" height="200"   src="/temp.html"></iframe>

<button onclick="fnCors()">cors </button>

<img class="img-concert" src="https://www.phpschool.com/skin/blue/images/common/background.gif" />


<form name="frm01" action="https://www.phpschool.com/gnuboard4/bbs/board.php?bo_table=teach&wr_id=3219&page=1"  method="post">
<input type="hidden" name="idx" value="a" />
<input type="submit" value="전송" />
</form>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html>

    <head>
        <!--  /views/jquery3.7.1.js 에 잇는것은 스프링에서 접근이 안되므로  /myp/src/main/resources/static/js/jquery3.7.1.js  것을 사용함  -->
        <script src="js/jquery3.7.1.js"></script>

        <style type="text/css">
            #sch {
                width: 800px;
                padding: 10px;
                border: 1px solid #c02727;
            }

            .psrsonList {
                width: 600px;
                padding: 10px;
                border: 1px solid #5b20c1;
            }

            #apprList {
                width: 800px;
                padding: 10px;
                height: 300px;
                border: 1px solid #298049;
                overflow: auto;
            }
        </style>
        <script>

            var cnt = 0;

            $(document).ready(function () {

                //	alert();

                var a = jQuery("input");
                var a1 = $("input"); // 위와 동일하고 jquery 객체가 리턴 된다

                var c = $('input')[0];  //form 의 1번째 input 돔오브잭트 를 가르긴다.

                var b = $('<input>')[0]; // 이건 c와 같을 거라고 착각할수 있는대 그냥 'input' 태그 이다. b.vlaue해도 '' 이다.


                $("#apprSchNm").on("click", function (e) {

                    $(this).css('color', 'green');
                    fnApprSch();

                });

                // 삭제 이베튼  , 동적으로 생성한은 여기 안탐.
                $("input[name='del']").on("click", function (e) {

                    $(this).css('color', 'green');
                    //alert();

                });

                // 콤보 이벤트 , 동적으로 생성한은 여기 안탐.
                $(".comboAppr").on("change", function () {
                    //selected value

                    /*
                    alert();
                    alert($(this).val());
                    alert($("option:selected", this).attr("value"));

                    //selected option element
                    alert($("option:selected", this));
                    alert($("option:selected", this).text());
                    alert($(this).find("option:selected").text());
                    */
                });
            });

            function setIframUrl() {
                debugger;
                var iframe = document.getElementById("iframe1"); // 아이프레임 요소 가져옴
                iframe.src = "report1"; // src 속성에 새로운 주소 설정
            }

            function fnSend() {
                frm.action = "appr";
                frm.submit();
            }

            // 승인자 검색 
            function fnApprSch() {
                var shcNm = $("#schNm").val();

                $.ajax({
                    type: 'post',           // 타입 (get, post, put 등등)    
                    url: '/schApprUser',    // 요청할 서버url    
                    async: true,            // 비동기화 여부 (default : true)    

                    /*
                    headers: {              // Http header      
                        "Content-Type": "application/json",
                        "X-HTTP-Method-Override": "POST"
                    },
                    */

                    contentType: "application/json",  // 서버에 전달할 타임 , 기본이 application/x-www-form-urlencoded 이다, data:a=112&z=442 이런식으로하고 리퀘스트겟파라미터로 받아아함.    // 위와 동일함.

                    dataType: 'json',       // 서버에서 받을 데이터 타입 (html, xml, json, text 등등)   

                    data: JSON.stringify({  // 보낼 데이터 (Object , String, Array) 
                        "no": 1, "shcNm": shcNm, "nick": "nick"
                    }),

                    success: function (result) { // 결과 성공 콜백함수  

                        console.log(result);

                        fnSetApprUser(result);
                    },

                    error: function (request, status, error) {
                        // 결과 에러 콜백함수      
                        alert(error);
                        console.log(error)
                    }
                });

            };

            function fnSetApprUser(result) {
                //alert(result.USER_NAME);

                var name = `<div class="psrsonList">
                    <SELECT style="width:100px" name="comboAppr2" class="comboAppr">
                        <OPTION value="1">기안자</OPTION>
                        <OPTION value="2">승인자</OPTION>
                        <OPTION value="3">합의자</OPTION>
                    </SELECT>
                    <span>` + result.USER_NAME + `</span>
                    <input name="del" type="BUTTON" value="삭제" onClick="fnDelList()">

                </div>` ;
                $("#apprList").append(name);

            }

            
            // 삭제 이벤트 , 동적으로 추가된것은 이렇게 해야함.
            $(document).on("click", "input[name='del']", function (e) {

                $(this).css('color', 'green');
                $(this).parent().css("border", "4px solid #f00");
                $(this).parent().remove(); 

            });


            // 콤보 동적 으로 생성된 이벤트 걸기
            $(document).on("change", ".comboAppr", function (e) {

                /*
                alert();
                alert($(this).val());
                alert($("option:selected", this).attr("value"));

                //selected option element
                alert($("option:selected", this));
                alert($("option:selected", this).text());
                alert($(this).find("option:selected").text());
                */

                // 승인자는 1명만 선택 가능하게 체크
                // 각 .psrsonList 클래스 요소에 대해 반복

                var cnt = 0;
                $('.psrsonList').each(function() {

                    // 현재 요소에서 SELECT 요소를 찾아서 선택된 옵션의 값을 가져와서 출력
                    var selectedValue = $(this).find('select').val();
                    console.log("선택된 값: " + selectedValue);
                    //alert(selectedValue);
                    
                    if (selectedValue == 2) {
                        cnt++;
                    }

                    if (cnt > 1) {
                        alert("승인자는 1명만 추가 가능 합니다.");
                        $(this).find('select').val("1");
                        cnt = 0;                        
                    }
                });
            });

            function fnTriJson() {

                var form = document.getElementById('frm');
                var formData = new FormData(form);
                var jsonObject = {};

                formData.forEach(function(value, key) {
                    jsonObject[key] = value;
                });

                var jsonString = JSON.stringify(jsonObject, null, 2);
                console.log(jsonString);
                alert(jsonString);

            }

            function fnTriJson2() {
                var data2 = $("form").serialize();  
            alert(data2);

            }

            
            function fnTriJson3() {
                var data2 = $("form").serializeArray();  
           

            var json_str = JSON.stringify(data2);
            alert(json_str);

            }

            // 아이프레임 값 읽기
            function fnIfrm() {
                // 아이프레임 요소 가져오기
            const iframe = document.getElementById('iframe1');

            // 아이프레임 내부 문서의 input 요소 가져오기
            const inputElement = iframe.contentWindow.document.getElementById('test1');

            // input 값 읽기
            alert ( inputElement.value );

        
            }

            // jquery 원리 
            function fnTest1() {

                debugger;
                var a = $("#apprList");

                /*

                콘솔에 a를 찍으면 jquery 배열 객체가 나온다 <--- 이게 핵심, 배열 갯수는 그 안에 태그가 여러개면  0,1,2,3.. 나온다. length 가 보임.
                그리고 0번째 배열에 있는것을 열어서 보이는것은 일반 js인 돔오브잭트인 속성이 보인다. 이건 jqury 가 아닌 일반 돔이다. <--- 이게 핵심
                jquery 의 함수를 보려면 프로토타입을 열어서 보면 jquery함수가 보인다. <--- 이게 핵심
                */

                var b = $("#apprList > .psrsonList");
                var c = $("#apprList > .psrsonList > #tt");
                
                var d = $("#apprList > .psrsonList > .comboAppr"); // 콤보박스 
                //alert( d[0].value ) ; // [0] 하면 돔오브젝트이름로 일반 자바스크립처럼 할수 잇다.
                //alert( d.val() ) ; // jquery 함수를 이용한것이다.
                
                var e = $("#apprList > .psrsonList > span"); // span                 
                alert(e[0].innerText); // 세종   // [0] 하면 돔오브젝트이름로 일반 자바스크립처럼 할수 잇다.
                alert(e.html());       // 세종   // jquery 함수를 이용한것이다.


                //alert(  $("span").htm() ); // 바로 찾아도 됨.
                //$("span")[0].in // vs코드 툴에서 어시스트 보면 js인 둠 함수가 보인다.
                //$("span").ht   // vs코드에서 보면 jqueyr 함수가 보인다.

            
            }
            

            

        </script>
    </head>

    <body>
        <form name="frm" id="frm">

            <input name="test1" id="test1" type="input" value="aa">
            <input name="btnSave" type="BUTTON" value="아이프레임 호출" onClick="setIframUrl()">
            <input name="btnSave" type="BUTTON" value="서버전송" onClick="fnSend()">
            <input name="btnSave" type="BUTTON" value="아이프레임값" onClick="fnIfrm()">
            <input name="btnSave" type="BUTTON" value="from json변환" onClick="fnTriJson()">
            <input name="btnSave" type="BUTTON" value="from json변환2" onClick="fnTriJson2()">
            <input name="btnSave" type="BUTTON" value="from json변환3" onClick="fnTriJson3()"> <br>
            <input name="btnSave" type="BUTTON" value="jquery개념" onClick="fnTest1()">


            <br><br><br>

            <div id="sch">
                <input name="schNm" id="schNm" type="input" size="50" value="">
                <input name="apprSchNm" id="apprSchNm" type="BUTTON" value="검색" onClick="">
            </div>

            <br>

            <div id="apprList">
                <div class="psrsonList">
                    <SELECT style="width:100px" name="comboAppr2" class="comboAppr">
                        <OPTION value="1">기안자</OPTION>
                        <OPTION value="2">승인자</OPTION>
                        <OPTION value="3">합의자</OPTION>
                    </SELECT>
                    <span>세종</span>
                    <input name="del" type="BUTTON" value="삭제">
                    <input name="tt" id="tt" type="input" value="zrz">

                </div>
                
            </div>

        </form>
        <br>

        <iframe name="iframe1" id="iframe1" style="width:820px" height="150" src=""> </iframe>

    </body>

    </html>
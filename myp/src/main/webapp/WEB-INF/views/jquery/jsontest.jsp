<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html>

    <head>
        <!-- WEB-INF 하위 폴더에서는  /views/jquery3.7.1.js 에 잇는것은 스프링에서 접근이 안되므로  /myp/src/main/resources/static/js/jquery3.7.1.js  것을 사용함  -->
        <script src="js/jquery3.7.1.js"></script>

        <style type="text/css">
         
        </style>
        <script>

           

            function test() {
                var shcNm = $("#schNm").val();

                $.ajax({
                    type: 'post',           // 타입 (get, post, put 등등)    
                    url: '/restapi',    // 요청할 서버url    
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


                        $.each(result, function(idx, obj){
                            console.log(obj["Jane Doe"]);
                        });

                        //fnSetApprUser(result);
                    },

                    error: function (request, status, error) {
                        // 결과 에러 콜백함수      
                        alert(error);
                        console.log(error)
                    }
                });

            }

            

            

        </script>
    </head>

    <body>
        <form name="frm" id="frm">11

            <input name="btnSave"  type="BUTTON" value="클릭" onClick="test()">


        </form>

    </body>

    </html>
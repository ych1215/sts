<template>
  <div>
    <h2>사원관리</h2>

  <div class="empSch">
  사원명 <input name="empSch" v-model="empNm" type="text" value="" >     
  <input name="btnSave"  type="BUTTON" value="조회" @click="fnEmpSch"> 
    <input name="btnSave"  type="BUTTON" value="조회_get방식" @click="fnEmpSch_GET">
  </div>
  <h1></h1>
  
  <div class="empSch">
  사원명<input name="empSch" v-model="gubun" type="text" value="" >  
  성별 <input name="empSch" v-model="keyword" type="text" value="" >   <br>
  직급<input name="empSch" v-model="title" type="text" value="" >  
  입사일자 <input name="empSch" v-model="datea" type="text" value="" >   <br> <br>
    
    <div id="empButton">
    
    <input name="btnSave"  type="BUTTON" value="저장" @click="fnSave">
     <input name="btnAdd"  type="BUTTON" value="추가" @click="fnAdd">
     <input name="btnNew"  type="BUTTON" value="신규등록" @click="fnNew">     
    
     </div>
  </div>

  <div>
  사원목록
   <table class="party_tbl_new" width="100%" cellspacing="0" cellpadding="0">
                        <tr height="40">
                        <th width="5%" height="20">순번</th>
                        <th width="10%">사원명</th>
                        <th width="20%">성별</th>
                        <th width="40%">직급</th>
                        <th width="15%" class="">입사일자</th>
                        <th width="10%" class="border_last">로우타임</th>
                      </tr>
                             <tr class="trtr" v-for="(emp, index) in empList" :key="emp.SEQ" @click="selectEmp(emp)">
                          <td height="20" class="seq">
                            <a href="#" >
                           {{emp.SEQ}}
                            </a>
                        
                          </td>
                          <td>
                            {{emp.NAME}}
                          </td>
                          <td>
                          {{emp.RDO}}
                          </td>
                          <td style="text-align: left;">
                            {{emp.SELECTV}}
                          </td>
                          <td class="">
                            {{emp.ENTERING_DATE}}
                          </td>
                           <td class="border_last">
                            {{emp.ROWTYPE}}
                          </td>
                        </tr>
                    </table>
  </div>

  </div>
</template>


<script>
import axios from "axios";

export default {
  data() {
    return {
      empNm: "",
      list_m: [{a: 'aa', b: 'bbb'}, {a: 'aa', b: 'bbb'}],
      gubun: "",
      keyword: "",
      title: "",
      empOjb: {a: 'aa', b: 'bbb'},
      empList : [],

    };
  },

   mounted() {

   
    const yourParameter = this.$route.query.pram1;
    console.log(yourParameter); // 받은 파라미터 출력
   // alert(yourParameter);
    this.fnEmpSch();
    
   
  } ,

  methods: {
    
  
    fnEmpSch_GET(event) {
      var emp_list = this;

      // 데이터를 JSON 문자열로 변환하고 URL 인코딩
      let params = {
        empNm: emp_list.empNm,
        list_m: encodeURIComponent(JSON.stringify(emp_list.list_m)),
        empOjb: encodeURIComponent(JSON.stringify(emp_list.empOjb))
      };

      axios
        .get("http://localhost:8089/empSch_GET", { params: params })
        .then(function (response) {
          console.log(response.data);
          emp_list.empList = response.data;
        })
        .catch(function (error) {
          console.log(error);
        });
    },

      fnEmpSch(event) {
      var emp_list = this;

      // JSON 형식의 데이터를 요청 본문에 포함
      let data = {
        empNm: emp_list.empNm,
        list_m: emp_list.list_m,
        empOjb: emp_list.empOjb
      };

      axios
        .post("http://localhost:8089/empSch", data)
        .then(function (response) {
          console.log(response.data);
          emp_list.empList = response.data;
        })
        .catch(function (error) {
          console.log(error);
          alert("에러메시지::"+ error);
        });
    },
    

    fnSave() {
     
     var emp_list = this;

      // JSON 형식의 데이터를 요청 본문에 포함
      let data = {       

        empList: emp_list.empList
      };

      axios
        .post("http://localhost:8089/insertEmp", data)
        .then(function (response) {
          console.log(response.data);
          emp_list.empList = response.data;
          emp_list.fnEmpSch();
        })
        .catch(function (error) {
          console.log(error);
          alert(error);
        });

    },

     fnAdd() {
        var size = this.empList.length;

      this.empList.push({ SEQ: size +1 , NAME: '홍길동'+size , RDO: 'M'  , SELECTV: 'A'  , ENTERING_DATE: '2024-06-09 12:00', ROWTYPE:'I'});
      console.log(this.empList);
    } ,

     selectEmp(emp) {
      this.gubun = emp.NAME;
      this.keyword = emp.RDO;
      this.title = emp.SELECTV;
      this.datea = emp.ENTERING_DATE;
    },

     fnNew() {
       // window.location.href = '/EmpNew';
       this.$router.push('/EmpNew');
     } ,

  },
   


};
</script>


<style scoped>
h2 {
  color: green;
}

.empSch {
  width: 99%;
  padding: 5px;

  border: 1px solid #44df25;
  text-align: left;
  position: relative;

}

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


#empButton {  
  border: 1px solid #15d335;
  position: absolute; 
  right: 0px;  
  top: 54px;
}

.trtr {
  height: 30px; /* 원하는 높이 설정 */
}



</style>

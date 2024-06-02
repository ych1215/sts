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
  구분<input name="empSch" v-model="gubun" type="text" value="" >  
  키워드 <input name="empSch" v-model="keyword" type="text" value="" >   <br>
  제목<input name="empSch" v-model="title" type="text" value="" >  
  등록일자 <input name="empSch" v-model="title" type="text" value="" >   <br> <br>
    <input name="btnSave"  type="BUTTON" value="저장" @click="fnSave">
     <input name="btnSave"  type="BUTTON" value="추가" @click="fnAdd">
  </div>

  <div>
  사원목록
   <table class="party_tbl_new" width="100%" cellspacing="0" cellpadding="0">
                        <tr height="40">
                        <th width="5%" height="20">순번</th>
                        <th width="10%">사원명</th>
                        <th width="20%">키워드</th>
                        <th width="45%">제목</th>
                        <th width="10%" class="">등록일자</th>
                        <th width="10%" class="border_last">로우타임</th>
                      </tr>
                             <tr v-for="(emp, index) in empList" :key="emp.SEQ" @click="selectEmp(emp)">
                          <td height="20" class="seq">
                            <a href="#" >
                           {{emp.SEQ}}
                            </a>
                        
                          </td>
                          <td>
                            {{emp.EMP_NM}}
                          </td>
                          <td>
                          {{emp.KEYWORD}}
                          </td>
                          <td style="text-align: left;">
                            {{emp.TITLE}}
                          </td>
                          <td class="">
                            {{emp.DATEA}}
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
          alert(error);
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
        })
        .catch(function (error) {
          console.log(error);
          alert(error);
        });

    },

     fnAdd() {

     
      var size = this.empList.length;

      this.empList.push({ SEQ: size +1 , EMP_NM: '홍길동'+size , KEYWORD: 'bb'  , TITLE: 'bb'  , DATEA: 'bb', ROWTYPE:'I'});
      console.log(this.empList);
    } ,

     selectEmp(emp) {
      this.gubun = emp.EMP_NM;
      this.keyword = emp.KEYWORD;
      this.title = emp.TITLE;
      this.datea = emp.DATEA;
    },

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


</style>

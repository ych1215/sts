<template>
  <div id="title">
    <h2>사원등록</h2>
    <div id="btnNew">
      <input name="btnNew" type="BUTTON" value="저장" @click="fnNew" />
    </div>
  </div>

  <div class="wagg">
    <div class="inline">
      <div class="wi1">이름</div>
      <div><input type="text" name="name" value=""  v-model="name" /></div>
      <div class="sex">성별</div>
      <div>
        남<input type="radio" name="sex2" v-model="rdo" value="M" />
        여<input type="radio" name="sex2" v-model="rdo" value="W" />
      </div>

      <div id="qqq">직급</div>
      <div>
        <select v-model="selectv">
          <option value="A">대리</option>
          <option value="B">과장</option>
          <option value="C">부장</option>
          <option value="D">대표이사</option>
        </select>
      </div>
    </div>
  </div>

  <div class="wagg">
    <div class="inline">
      <div class="wi1">입사일자</div>
      <div><input type="date" name="name" value="" v-model="data1" /></div><input type="time" name="study_time" v-model="data2">

      <div class="sex2">취미</div>
      <div>
        <input type="checkbox" v-model="chks" value="A" />
        <input type="checkbox" v-model="chks" value="B" />
        <input type="checkbox" v-model="chks" value="C" />
        <input type="checkbox" v-model="chks" value="D" />
      </div>

      <div id="qqq2">나이</div>
      <div>
        <input type="number" name="name" min="2" max="20" step="1" value=""  v-model="old" />
        
      </div>
    </div>
  </div>
  SEQ {{seq}}
  이름 {{name}}
  성별 {{rdo}}
  직급 {{selectv}}
   체크박스{{chks}}
   나이{{old}}
   입사일자 {{data1}}
     입사일자시간 {{data2}}
</template>


<script>



import axios from "axios";

export default {
  data() {
    return {

      seq:0,
       name: "",
       chks: [],
       rdo: "",
       selectv: "",
       old: 0,
       data1 : new Date().toISOString().substr(0, 10),
       data2: "12:00" ,

      objList: [{a: 'aa', b: 'bbb'}, {a: 'aa', b: 'bbb'}],     
      objMap: {a: 'aa', b: 'bbb'},
     
    };
  },

     mounted() {

   
    const SEQ = this.$route.query.SEQ;
    console.log(SEQ); // 받은 파라미터 출력
    
    this.fnEmpSch(SEQ);
    
   
  } ,

  methods: {

        fnEmpSch(SEQ) {

         // alert(SEQ);

        if (SEQ == '' || SEQ ==  undefined) {
          return ;
        }


      var emp_list = this;

      // 데이터를 JSON 문자열로 변환하고 URL 인코딩
      let params = {
        SEQ: SEQ,
      };

      axios
        .post("http://localhost:8089/empSchDtl", { params: params })
        .then(function (response) {
          console.log(response.data);

          
           emp_list.seq = response.data.SEQ;
          emp_list.name = response.data.NAME;
          emp_list.rdo = response.data.RDO;
          emp_list.selectv = response.data.SELECTV;
          emp_list.old = response.data.OLD;
           emp_list.data1 = response.data.ENTERING_DATE;
            emp_list.data2 = response.data.JOINING_TIME;
         
        })
        .catch(function (error) {
          console.log(error);
        });
    },


      fnCk(event) {
          if (this.name == "" ) {
              alert("이름은 필수 입력 항목 ");
              return false;

          }

            if (this.rdo == "" ) {
              alert("성별 필수 입력 항목 ");
              return false;

          }


          return true;
      },

      fnNew(event) {

        if ( this.fnCk() == false ) {
          return;
        }

        var emp_info = this;

        // JSON 형식의 데이터를 요청 본문에 포함     
        let data = {

           
             seq: emp_info.seq, 
            name: emp_info.name,
            chks: emp_info.chks,
            rdo: emp_info.rdo,
            selectv: emp_info.selectv,
            old: emp_info.old,           
            data1: emp_info.data1,
            data2: emp_info.data2,

        
            list: emp_info.objList,
            map: emp_info.objMap
        };

        axios
          .post("http://localhost:8089/empNewSave", data)
          .then(function (response) {
            console.log(response.data);
            //emp_list.empList = response.data;
           // emp_info.$router.push('/EmpMgmt');
           emp_info.$router.push({
            path: '/EmpMgmt',
            query: { pram1: 'aaaa' } ,
          
          });

          })
          .catch(function (error) {
            console.log(error);
            alert("에려 메시지::"  + error);
          });

    } ,

  },
};
</script>


 

<style scoped>
.wagg {
  border: 1px solid #44df25;
  margin-bottom: 10px;
}

.wagg .inline {
  text-align: left;
  padding: 5px;
}

.wagg .inline div {
  display: inline-block;

  margin: 3px;
  text-align: left;
  1border: 1px solid #d61198; 
}

/*
.wagg .inline div.sex { 
  // .wagg .inline div 마진이 이미 있어서 이렇게 구체적으로 적거나 !important 로 한다.
  margin-left: 40px;
}
 */

.sex {
  /* .wagg .inline div 마진이 이미 있어서  */
  margin-left: 80px !important;
}

.sex2 {
  /* .wagg .inline div 마진이 이미 있어서  */
  margin-left: 39px !important;
}

#qqq {
  margin-left: 43px;
  width: 60px;
}

#qqq2 {
  margin-left: 40px;
  width: 60px;
}

select {
  width: 150px;
}

.wi1 {
  width: 70px;
}

#title {
  position: relative;
}
#btnNew {
  text-align: right;
  position: absolute;
  top: 17px;
  right: 0px;
}

@font-face {
  font-family: "myFont";
  src: url("myFont.woff2");
}

div {
	 font-family: "myFont", "Bitstream Vera Serif", serif;
}

</style>

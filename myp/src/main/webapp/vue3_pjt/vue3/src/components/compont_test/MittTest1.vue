<template>
  <div>
    <h1>EMMIT1</h1>
 <div>
    <button @click="emitEvent">emmit2 로 데이터 1111 전달</button> <br>
    <button @click="fn_test">js파일 임포트해서 함수 , 변수 사용하기</button>
  </div>

   <p>받은데이터:{{ eventData2 }}</p>
  </div>
</template>

<script>

//import { testa , ff  } from '../../util'; // 일일이 다 쓰기 

import * as obj from '../../util'; //  객체로 받기 


export default {

   created() {

    /* // 일일이 다 쓰기 
    var a = testa;    
    alert(a);  // a 값을 출력
    ff(112111);
    */
   
   /*  // 객체로 받기 
   var a =  obj.testa;
   alert(a); 
   obj.ff(112111);
   */
   
  } ,


  data() {
    return {
      eventData2: ''
    };
  },

  methods: {
    emitEvent() {
      this.emitter.emit('custom-event', '11111111111');
    },

    fn_test() {

        var a =  obj.testa;
        alert(a); 
        obj.ff(888888);

    },

  },

  mounted() {

    this.emitter.on('custom-event2', (eventData) => {
      this.eventData2 = eventData;
    });
  }
}
</script>

<style scoped>
</style>
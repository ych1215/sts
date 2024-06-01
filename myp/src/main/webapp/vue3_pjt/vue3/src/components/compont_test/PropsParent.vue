
<template>

  props 예제 

   <div id="div_p">
  <br>
   부모컴포넌트 <br><br>

   자식에서 컴포넌트에서 보낸값표시 : {{ emitVlaue }}<br><br>

   <button @click="change">차일드컨퍼넌트값변경하기</button>

   <childCom1 v-bind:sendProps1="title" v-bind:sendProps2="createAt" v-bind:sendProps3="obj_data" v-on:fn_f="fnPc"/>

   </div>   
    

</template>

<script>

import childCom1 from './PropsParentChild.vue';

export default {

 components: {
  childCom1,
 } , 

 data()  {

      return {   
        title : '부모가 전달한 메시지 ',
        createAt : 2024,         
        obj_data: {
          id:2021,
          name:'john', 
        } ,
        emitVlaue : "",

      }

    },

      methods : {

       
        change() {
          this.title = "변경한당." ;
          this.createAt = 8888888 ;
        } ,


        fnPc : function(p) {              
                  this.emitVlaue = p;
                  // alert(p);
                  
        },

      }

  }

</script>

<style>

#div_p {
    width: 500px;
    height: 500px;
    background-color: rgb(0, 255, 17);   
}

</style>

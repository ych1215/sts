
<template>
   <div id="div_c">
   자식 컴퍼너트 <br><br>
   {{sendProps1}} /<br> {{sendProps2}}  /<br> 오브잭트전달받은값: {{sendProps3.name}}

    <div>   
   <button @click="fnEmit(11)">부모함수 호츨 </button>  <br>        
   </div>   


   </div>   



</template>

<script>


export default {

 props: {
    sendProps1:String,
    sendProps2:Number,
     sendProps3:Object,
 }
 , data()  {

      return {            
        }
      },

     methods: {
          fnEmit : function(p) {
                //alert(p);
                this.$emit('fn_f',  111);
            },
     }


  };

</script>

<style>

#div_c {
    width: 200px;
    height: 200px;
    background-color: rgb(189, 198, 72);   
    position: relative;
    left: 140px;
    top: 50px;
}

</style>


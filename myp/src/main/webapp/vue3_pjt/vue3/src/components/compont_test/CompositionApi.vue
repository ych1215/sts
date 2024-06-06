<template>
  <div>
   <button @click="change">count 증가</button>
    {{ count }}
  </div>
</template>

<script>

import {ref} from "vue"
  export default {

    setup(props) {

      var count  = ref(0);
    
      /*
      const change  = ()  => {
        count.value++;
      }
      */

     const change = function add() {
      count.value++;
     }
      return  {
        count,
        change
      };      
    }
    
  }
</script>

<style lang="scss" scoped>

</style>
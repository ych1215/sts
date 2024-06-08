
<template>

    <div id="jb-container">
      <div id="jb-header">
        <h1>V . U . E . 3</h1>
      </div>
      
      <div id="jb-content">
        <!-- 라우터 -->
        <router-view />

      </div>

      <div id="jb-sidebar">
        <!--메뉴 -->
        <Menu/>
      </div>
      <div id="jb-footer">
        <h5>Copyright</h5>
      </div>
    </div>
 
</template>



<script>

import Menu from './components/compont_test/Menu.vue';

export default {

 components: {
  Menu ,
 } , 

 data()  {

      return {   

      }

    },

      methods : {

      }

  }

</script>
<style>
      #jb-container {
        width: 1100px;
        margin: 0px auto; 
        padding: 10px;
        border: 1px solid #bcbcbc;
      }
      #jb-header {
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #bcbcbc;
      }
      #jb-content {
        width: 74%;
        padding: 10px;
        margin-bottom: 10px;
        float: right;
        border: 1px solid #bcbcbc;
      }
      #jb-sidebar {
        width: 19%;
        padding: 20px;
        margin-bottom: 10px;
        float: left;
        border: 1px solid #bcbcbc;
      }
      #jb-footer {
        clear: both;
        padding: 20px;
        border: 1px solid #bcbcbc;
      }

      #menu {
  text-align: left;
}


    </style>


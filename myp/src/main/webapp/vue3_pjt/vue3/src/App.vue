
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
        <h2>메뉴</h2>
        <ul>

          <div id="menu">
          <li><router-link to="/">Home</router-link></li>
          <li><router-link to="/ComponentSample">콤퍼넌트 예제</router-link></li>
          <li><router-link to="/EventSample">이벤트, bind 예제</router-link></li>
          <li><router-link to="/axios">axios 예제</router-link></li>
          <li><router-link to="/PropsParent">props , emits 예제</router-link></li>
          <li><router-link to="/EmpMgmt">사원관리</router-link></li>
         
          </div>

        </ul>
      </div>
      <div id="jb-footer">
        <h5>Copyright</h5>
      </div>
    </div>
 
</template>



<script>



export default {

 components: {
  
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
        margin-bottom: 20px;
        float: right;
        border: 1px solid #bcbcbc;
      }
      #jb-sidebar {
        width: 19%;
        padding: 20px;
        margin-bottom: 20px;
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
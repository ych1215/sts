
<template>
  <h2>메뉴</h2>
  <ul>
    <div id="menu">
      <li><router-link to="/">Home</router-link></li>
      <li><router-link to="/ComponentSample">콤퍼넌트 예제</router-link></li>
      <li><router-link to="/EventSample">이벤트, bind 예제</router-link></li>
      <li><router-link to="/axios">axios 예제</router-link></li>
      <li><router-link to="/PropsParent">props , emits 예제</router-link></li>
      <li>
        <router-link to="/CompositionApi">Composition Api 예제</router-link>
      </li>
      <li><router-link to="/EmpMgmt">사원관리</router-link></li>
      <li><router-link to="/EmpNew">사원신규등록</router-link></li>
    </div>
  </ul>
</template>


<script>
export default {
  data() {
    return {};
  },
};
</script>

<style>
</style>


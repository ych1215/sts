<template>
  <div>
    <h2>콤퍼넌트 사용법</h2>

    <div id="conts">

    input 박스 <br>
    <input type="text" v-model="input_text" /> {{input_text}}    
    <hr color='pink' size='3'></hr>

    textarea <br>
    <textarea v-model="textarea"></textarea>  {{textarea}}
    <hr color='pink' size='3'></hr>

    checkbox <br>
    <input type="checkbox" v-model="checkbox" /> {{checkbox}}
    <hr color='pink' size='3'></hr>

    checkbox 여러개 <br>
      <input type="checkbox" v-model="chks" value="A"/>
        <input type="checkbox" v-model="chks" value="B"/>
        <input type="checkbox" v-model="chks" value="C"/> <br>
        {{chks}}
         <hr color='pink' size='3'></hr>

    라디오 여러개 <br>
       <input type="radio" v-model="rdo" value="A"/>
        <input type="radio" v-model="rdo" value="B"/>
        <input type="radio" v-model="rdo" value="C"/> <br>
        {{rdo}}
        <hr color='pink' size='3'></hr>

      셀렉트 박스 <br>
          <select v-model="select" >
            <option value="AA">a</option>
            <option value="BB">b</option>
            <option value="CC">c</option>
        </select>

        {{select}}
        <hr color='pink' size='3'></hr>

         멀티 선택 셀렉트 박스 <br>
          <select v-model="selectm" multiple>
            <option value="AA">a</option>
            <option value="BB">b</option>
            <option value="CC">c</option>
        </select>

        {{selectm}}
         <hr color='pink' size='3'></hr>

        이미지 연결<br>
         <img v-bind:src="img" alt="">
          <hr color='pink' size='3'></hr>


    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      input_text: "인풋박스",
      textarea: "textarea",
      checkbox: true,
      chks: [],
      rdo: "",
      select: "",
      selectm: [],
      img: "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FnrNXH%2FbtrI3xs4jc3%2FxLSKTFXuKbnDnA40KUnyJ1%2Fimg.png",
    };
  },

  methods: {
    fnEmit: function () {},
  },
};
</script>

<style scoped>
h2 {
  color: green;
}

#conts {
  text-align: left;
}
</style>

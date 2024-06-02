<template>
  <div>
    <h2>이벤트 사용법</h2>

    <div id="conts">

    change 이벤트 <br>
    <input v-bind:value="message" v-on:change="handleInput">
    <hr color='pink' size='3'></hr>

    click 이벤트 <br>
   <button type="button" v-on:click="fnTest"> 버튼클릭이벤트</button> <br>
   <hr color='pink' size='3'></hr>

    keydown 이벤트 <br>
    <input v-bind:value="message2" v-on:keydown="keydown_up">    
    <hr color='pink' size='3'></hr>

    클릭하면서 쉬퍼트기 이벤트 <br>
    <button v-on:click.shift="doaaa"> 버튼 </button>
    <hr color='pink' size='3'></hr>

    mousemove 이벤트 <br>
    <div v-on:mousemove="trackingMouse" class="screen">
        {{ mouse.x }}, {{ mouse.y }}
      </div>
    <hr color='pink' size='3'></hr>

    :bind 로  size, maxlength 값 연결 <br>
    <input type="text"  v-bind:size="size" v-bind:maxlength="maxlength">
    <hr color='pink' size='3'></hr>

    </div>
  </div>
</template>

<script>


export default {

  data()  {

      return {   
       message: 'Hello Vue.js',
        message2: 'Hello Vue.js',
        size :  100,
        maxlength:  2,
        mouse: {
            x: 0,
            y: 0
          },
       
    }
  },

  methods: {

    handleInput: function (event) {

      this.message = event.target.value
      alert(this.message);

    }
    ,
    fnTest : function() {
      alert("click 이벤트");
    },
    keydown_up: function (event) {
          // 할당 전에 어떤 처리하기
          this.message = event.target.value
          alert(this.message);
        },
   doaaa: function (event) {
          // 할당 전에 어떤 처리하기
          this.message = event.target.value
          alert(this.message);
        },
         trackingMouse: function (event) {
          //debugger;
            this.mouse.x = event.clientX;
            this.mouse.y = event.clientY;
          } ,
        

  }


  };

</script>

<style scoped>
h2 {
  color: green;
}

#conts {
  text-align: left;
}

 .screen {
        width: 100%;
        height: 100px;
        background-color: #DDD;
      }

</style>

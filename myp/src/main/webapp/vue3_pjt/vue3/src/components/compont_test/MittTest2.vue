<template>
  <div>
    <h1>EMMIT2</h1>
  <div>

  <button @click="emitEvent2">emmit1 로 데이터 2222 전달</button>
    <p>받은데이터:{{ eventData }}</p>
  </div>
  </div>
</template>

<script>



export default {
  data() {
    return {
      eventData: ''
    };
  },

   methods: {

    emitEvent2() {

     this.emitter.emit('custom-event2', '2222222222');
    }
    , 
    fnTest(a)  {
      alert("emmit로 이벤트 전달하여 데이터를 보내고 함수도 호출 가능함" + a);
    } , 
  },

  mounted() {

    this.emitter.on('custom-event', (eventData) => {
      this.eventData = eventData;

      this.fnTest(eventData);

    });
  }
}
</script>

<style scoped>
</style>
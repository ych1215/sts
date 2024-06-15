<template>
  <div>
    <h1>EMMIT2</h1>
  <div>

  <button @click="emitEvent2">emmit1 로 데이터 전달</button>
    <p>받은데이터:{{ eventData }}</p>
  </div>
  </div>
</template>

<script>

import { EventBus } from '../../EventBus';

export default {
  data() {
    return {
      eventData: ''
    };
  },

   methods: {
    emitEvent2() {
      EventBus.emit('custom-event2', '2222222222');
    }
  },

  created() {
    EventBus.on('custom-event', eventData => {
      this.eventData = eventData;
    });
  }
}
</script>

<style scoped>
</style>
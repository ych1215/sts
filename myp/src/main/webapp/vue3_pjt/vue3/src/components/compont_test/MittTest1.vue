<template>
  <div>
    <h1>EMMIT1</h1>
 <div>
    <button @click="emitEvent">emmit2 로 데이터 전달</button>
  </div>

   <p>받은데이터:{{ eventData2 }}</p>
  </div>
</template>

<script>

import { EventBus } from '../../EventBus';

export default {

  data() {
    return {
      eventData2: ''
    };
  },

  methods: {
    emitEvent() {
      EventBus.emit('custom-event', '11111111111');
    }
  },

  created() {
    EventBus.on('custom-event2', eventData => {
      this.eventData2 = eventData;
    });
  }
}
</script>

<style scoped>
</style>
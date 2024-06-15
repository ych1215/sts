import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router'

import mitt from 'mitt'
let emitter = mitt();

const app = createApp(App)

app.config.globalProperties.emitter = emitter
app.provide('emitter', emitter) // emitter 제공

app.use(router).mount('#app')
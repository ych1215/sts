
// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'

import Home from '../components/compont_test/Home.vue'
import ComponentSample from '../components/compont_test/ComponentSample.vue'
import EventSample from '../components/compont_test/EventSample.vue'
import axios from '../components/compont_test/axios.vue'
import PropsParent from '../components/compont_test/PropsParent.vue'



const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  }
  ,
  {
    path: '/ComponentSample',
    name: 'ComponentSample',
    component: ComponentSample
  }
  ,
  {
    path: '/EventSample',
    name: 'EventSample',
    component: EventSample
  }
  ,
  {
    path: '/axios',
    name: 'axios',
    component: axios
  }
  ,
  {
    path: '/PropsParent',
    name: 'PropsParent',
    component: PropsParent
  }
  ,

  
  
]

const router = createRouter({
  history: createWebHistory('/'),
  routes
})

export default router
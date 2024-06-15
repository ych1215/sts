
// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'

import Home from '../components/compont_test/Home.vue'
import ComponentSample from '../components/compont_test/ComponentSample.vue'
import EventSample from '../components/compont_test/EventSample.vue'
import axios from '../components/compont_test/axios.vue'
import PropsParent from '../components/compont_test/PropsParent.vue'
import EmpMgmt from '../components/compont_test/EmpMgmt.vue'
import EmpNew from '../components/compont_test/EmpNew.vue'
import CompositionApi from '../components/compont_test/CompositionApi.vue'
import Menu from '../components/compont_test/Menu.vue'

import MittTestMain from '../components/compont_test/MittTestMain.vue'


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
  {
    path: '/EmpMgmt',
    name: 'EmpMgmt',
    component: EmpMgmt
  }
  ,
  {
    path: '/CompositionApi',
    name: 'CompositionApi',
    component: CompositionApi
  }
  ,
  {
    path: '/Menu',
    name: 'Menu',
    component: Menu
  }
  ,
  {
    path: '/EmpNew',
    name: 'EmpNew',
    component: EmpNew
  }
  ,
  {
    path: '/MittTestMain',
    name: 'MittTestMain',
    component: MittTestMain
  }
  ,

]

const router = createRouter({
  history: createWebHistory('/'),
  routes
})

export default router
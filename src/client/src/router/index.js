import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import('@/views/HomeView.vue'),
  },
  {
    path: '/join',
    name: 'join',
    component: () => import('@/views/JoinView.vue'),
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/LoginView.vue'),
  },
  {
    path: '/info',
    name: 'info',
    component: () => import('@/views/InfoView.vue'),
  },
  {
    path: '/list',
    name: 'list',
    component: () => import('@/views/ListView.vue'),
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router;

<template>
  <div id="app">
    <img alt="wonauth logo" src="./assets/wonauth.png" style="max-width: 20%; height: auto;">
    <router-view></router-view>
    <button @click="toggleLogin" style="position: fixed; top: 10px; right: 10px;">
      {{ isLoggedIn ? '로그아웃' : '로그인' }}
    </button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isLoggedIn: false,
    };
  },
  methods: {
    toggleLogin() {
      this.isLoggedIn = !this.isLoggedIn;
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

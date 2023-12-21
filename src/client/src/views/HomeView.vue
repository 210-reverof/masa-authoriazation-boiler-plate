<template>
  <div class="home">
    <button @click="goToMemberInfo">회원정보 페이지</button>
    <button @click="goToMemberList">회원관리 페이지</button>
  </div>
</template>

<script>
export default {
  name: "HomeView",
  methods: {
    goToMemberInfo() {
      this.$router.push("/info");
    },
    goToMemberList() {
      this.$router.push("/list");
    },
  },
  created() {
    console.log("HomeView component is created!");
  },
};
</script>

<template>
  <div class="user-list">
    <p>회원 목록</p>
    <user-list></user-list>
  </div>
</template>
  
<script>
import UserList from '@/components/UserList.vue'

export default {
  name: "UserView",
  components: {
    UserList
  }
};
</script>
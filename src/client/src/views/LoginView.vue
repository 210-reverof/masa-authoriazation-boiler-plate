<template>
  <div class="join">
    <p>로그인</p>
    <login-form></login-form>
  </div>
</template>
  
<script>
import LoginForm from '@/components/LoginForm.vue'

export default {
  name: "LoginView",
  components: {
    LoginForm
  }
};
</script>
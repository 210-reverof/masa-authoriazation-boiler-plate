<template>
  <div class="join">
    <p>회원가입</p>
    <join-form></join-form>
  </div>
</template>
  
<script>
import JoinForm from '@/components/JoinForm.vue'

export default {
  name: "JoinView",
  components: {
    JoinForm
  }
};
</script>
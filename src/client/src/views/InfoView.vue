<template>
  <div class="info">
    <p>회원 정보</p>
    <info-form></info-form>
  </div>
</template>
  
<script>
import InfoForm from '@/components/InfoForm.vue'

export default {
  name: "InfoView",
  components: {
    InfoForm
  }
};
</script>
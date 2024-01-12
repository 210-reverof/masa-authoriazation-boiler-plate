<template>
    <div class="login-form">
        <form @submit.prevent="submitForm">
            <div class="form-group">
                <label for="email">이메일:</label>
                <input type="text" id="email" v-model="email" required>
            </div>

            <div class="form-group">
                <label for="password">비밀번호:</label>
                <input type="password" id="password" v-model="password" required>
            </div>

            <button type="submit">로그인</button>
            <button type="button" @click="moveJoin">회원가입</button>
        </form>
    </div>
</template>
  
<script>
export default {
    name: "LoginForm",
    data() {
        return {
            email: "",
            password: "",
        };
    },
    methods: {
        submitForm() {
            console.log("로그인 정보", this.$data);
        },
        moveJoin() {
            console.log("회원가입");
        }
    },
};
</script>
  
<style scoped>
.form-group {
    margin-bottom: 15px;
}
</style>  
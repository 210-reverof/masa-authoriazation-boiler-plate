<template>
    <div class="join-form">
        <form @submit.prevent="submitForm">
            <div class="form-group">
                <label for="email">이메일:</label>
                <input type="email" id="email" v-model="email" required>
                <button type="button" @click="sendVerificationEmail">인증번호 발송</button>
            </div>

            <div class="form-group">
                <label for="emailVerification">이메일 인증:</label>
                <input type="text" id="emailVerification" v-model="emailVerification" required>
                <button type="button" @click="sendVerificationEmail">인증</button>
            </div>

            <div class="form-group">
                <label for="password">비밀번호:</label>
                <input type="password" id="password" v-model="password" required>
            </div>

            <div class="form-group">
                <label for="confirmPassword">비밀번호 확인:</label>
                <input type="password" id="confirmPassword" v-model="confirmPassword" required>
            </div>

            <div class="form-group">
                <label for="nickname">닉네임:</label>
                <input type="text" id="nickname" v-model="nickname" required>
            </div>

            <div class="form-group">
                <label for="gender">성별:</label>
                <select id="gender" v-model="gender" required>
                    <option value="male">남성</option>
                    <option value="female">여성</option>
                </select>
            </div>

            <div class="form-group">
                <label for="age">나이:</label>
                <input type="number" id="age" v-model="age" required>
            </div>

            <button type="submit">가입하기</button>
        </form>
    </div>
</template>
  
<script>
export default {
    name: "JoinForm",
    data() {
        return {
            email: "",
            emailVerification: "",
            password: "",
            confirmPassword: "",
            nickname: "",
            gender: "",
            age: null,
        };
    },
    methods: {
        submitForm() {
            console.log("회원가입 폼이 제출되었습니다.");
            console.log("회원가입 데이터:", this.$data);
        },

        sendVerificationEmail() {
            console.log("이메일 인증 이메일이 전송되었습니다.");
        }, 
    },
};
</script>
  
<style scoped>
.form-group {
    margin-bottom: 15px;
}
</style>  
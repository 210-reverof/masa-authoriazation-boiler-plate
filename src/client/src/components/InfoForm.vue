<template>
<div class="info-form">
    <form @submit.prevent="submitForm">
        <div class="form-group">
            <label for="email">이메일:</label>
            <input type="email" id="email" v-model="email" required>
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

        <button type="submit">수정하기</button>
        <button type="button" @click="changePassword">비밀번호 변경</button>
    </form>
</div>
</template>

<script>
export default {
    name: "InfoForm",
    data() {
        return {
            email: "",
            nickname: "",
            gender: "",
            age: null,
        };
    },
    created() {
        this.fetchUserInfo();
    },
    methods: {
        fetchUserInfo() {
            this.email = "tmp";
            this.nickname = "tmp";
            this.gender = "male";
            this.age = 0;
        },

        submitForm() {
            console.log("정보 수정 데이터:", this.$data);
        },

        changePassword() {
            console.log("비밀번호 변경");
        },
    },
};
</script>

<style scoped>
.form-group {
    margin-bottom: 15px;
}
</style>

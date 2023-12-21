<template>
<div class="user-list">
    <table class="table-styled">
        <thead>
            <tr>
                <th>이메일</th>
                <th>닉네임</th>
                <th>성별</th>
                <th>나이</th>
                <th>가입 시간</th>
                <th>탈퇴 시간</th>
                <th>동작</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="user in userList" :key="user.email">
                <td>{{ user.email }}</td>
                <td>{{ user.nickname }}</td>
                <td>{{ user.gender }}</td>
                <td>{{ user.age }}</td>
                <td>{{ user.signupTime }}</td>
                <td>{{ user.withdrawalTime }}</td>
                <td>
                    <button @click="terminateUser(user.id)" v-if="!user.withdrawalTime">
                        탈퇴시키기
                    </button>
                </td>
            </tr>
        </tbody>
    </table>
</div>
</template>

<script>
export default {
    name: "UserList",
    data() {
        return {
            userList: [],
        };
    },
    created() {
        this.fetchUserList();
    },
    methods: {
        fetchUserList() {
            this.userList = [{
                    id: 1,
                    email: "user1@example.com",
                    nickname: "User1",
                    gender: "male",
                    age: 30,
                    signupTime: "2023.12.13. 오후 10:23:32",
                    withdrawalTime: null,
                },
                {
                    id: 2,
                    email: "user2@example.com",
                    nickname: "User2",
                    gender: "female",
                    age: 25,
                    signupTime: "2023.12.09. 오후 10:23:32	",
                    withdrawalTime: null,
                },
            ];
        },
        terminateUser(userId) {
            const userIndex = this.userList.findIndex((user) => user.id === userId);
            if (userIndex !== -1) {
                this.$set(this.userList, userIndex, {
                    ...this.userList[userIndex],
                    withdrawalTime: new Date().toLocaleString(),
                });
            }
            // TODO: 탈퇴 API 호출
        },
        formatDate(date) {
            if (!date) return '';
            const options = {
                year: 'numeric',
                month: '2-digit',
                day: '2-digit',
                hour: 'numeric',
                minute: 'numeric'
            };
            return new Date(date).toLocaleString('en-US', options).replace(/\//g, '-');
        },
    },
};
</script>

<style scoped>
.table-styled {
    border-collapse: collapse;
    width: 100%;
    margin-bottom: 20px;
}

.table-styled th,
.table-styled td {
    padding: 10px;
    text-align: left;
    border: 1px solid #ddd;
}

.table-styled th {
    background-color: #f2f2f2;
    font-weight: bold;
}

.table-styled tr:nth-child(even) {
    background-color: #f5f5f5;
}
</style>

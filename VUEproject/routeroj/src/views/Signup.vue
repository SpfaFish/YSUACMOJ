<template>
    <body>
    <div class="login-box">
        <h2 style="text-align:center">注册</h2>
        <form  @submit.prevent="regist" >
            <label for="id">账号</label>
            <input type="text" id="id" v-model="id" placeholder="请输入账号" required>

            <label for="name">姓名</label>
            <input type="text" id="name" v-model="name" placeholder="请输入姓名" required>

            <label for="nickName">用户名</label>
            <input type="text" id="nickName" v-model="nickName" placeholder="请输入用户名" required>

            <label for="password">密码</label>
            <input type="password" id="password" v-model="password" placeholder="请输入密码" required>

            <button type="submit" id="submit-btn">确认注册</button>
        </form>
    </div>
    </body>
</template>

<script>
import axios from "axios";

export default {
    name: "Sign-up",
    data() {
        return {
            id: '',
            password: ''
        };
    },
    methods: {
        regist() {
            const data = {
                id: this.id,
                name: this.name,
                nickName: this.nickName,
                password: this.password
            };
            axios.post('http://10.136.132.34:9000/regist', data)
                .then((response) => {
                    const { code } = response.data;
                    if (code===1) {
                        alert('注册成功');
                        this.$router.push('/login');
                    } else {
                        alert('注册失败');
                    }
                })
                .catch((error) => {
                    console.error(error);
                    alert('注册失败：' + error.message);
                });
        }
    }
}
</script>

<style scoped>
/* 设置背景颜色和字体 */
body {
    background-color: #f1f1f1;
    font-family: Arial, Helvetica, sans-serif;
}

/*设置登录框的样式 */
.login-box {
    width: 500px;
    height: 500px;
    background-color: #fff;
    margin: 100px auto;
    border-radius: 10px;
    box-shadow: 0 0 20px #000;
    padding: 20px;

}

/*设置输入框样式 */
input[type=text],
input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    border-radius: 4px;

}

/* 按钮样式 */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin-top: 30px;
    box-sizing: border-box;
    width: 100%;
}

/* 按钮悬停效果 */
button:hover {
    background-color: #45a049;
}
</style>
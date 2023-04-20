<template>

    <div class="login-box">
        <h2 style="text-align:center">欢迎登录</h2>

        <form>
            <label for="id">账号</label>
            <input type="text" id="id" v-model="id" placeholder="请输入账号" />

            <label for="password">密码</label>
            <input type="password" id="password" v-model="password" placeholder="请输入密码"  />

            <button type="submit" value="Login" v-on:click="login">登录</button>
            <button type="submit" v-on:click="gosignup">注册</button>
        </form>
        <div id="error-message" style="display: none; color: red;">Invalid username or password.</div>

    </div>
</template>

<script>
import axios from "axios";
export default {
    name: 'LoginPage',
    data() {
        return {
            id: '',
            password: ''
        };
    },
    methods: {
        login() {
            const data = {
                id: this.id,
                password: this.password
            };
            axios.post('http://10.136.132.34:9000/login', data)
                .then((response) => {
                    const { code, msg, data } = response.data;
                    if (code === 1) {
                        // 登录成功，将 JWT 令牌存储到本地
                        localStorage.setItem('token', data);
                        alert('登录成功');
                        this.$router.push('/mainuser');
                    } else {
                        alert('登录失败：' + msg);
                    }
                })
                .catch((error) => {
                    console.error(error);
                    alert('登录失败：' + error.message);
                });
        },
        gosignup(){
            this.$router.push('/signup');
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
    height: 350px;
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
    box-sizing: border-box;
    width: 100%;
}

/* 按钮悬停效果 */
button:hover {
    background-color: #45a049;
}
</style>

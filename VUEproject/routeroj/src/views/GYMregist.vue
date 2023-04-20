<template>
    <body>
    <div class="header">
        <div>
            <router-link to="/useriden" class="menu-item">用户信息</router-link>
            <router-link to="/GYM" class="menu-item">比赛</router-link>
            <a href="#" class="ACMOJ">Welcome to YSUACMOJ!</a>

            <input class="search" type="text" id="searchBox">
            <button class="btn" onclick="search()">搜索</button>
            <a class="userid">
                账号:<span id="username"></span>
            </a>
            <button class="btn" v-on:click="idquit">退出登陆</button>
        </div>

    </div>

    <div class="login-box">
        <h2 style="text-align:center">创建比赛</h2>

        <form  >
            <label for="gamename">创建比赛</label>
            <input class="ipt" type="text" id="gamename" v-model="compName" placeholder="请输入比赛名称" required>

            <button class="bn" type="submit" v-on:click="ct">创建</button>
        </form>
        <div id="error-message" style="display: none; color: red;">Invalid username or password.</div>

    </div>
    </body>
</template>

<script>
import axios from "axios";
export default {

    mounted() {
        const token = localStorage.getItem('token');
        const payload = token.split('.')[1];
        const decodedPayload = atob(payload);
        const data = JSON.parse(decodedPayload);
        const usernameElement = document.getElementById('username');
        usernameElement.textContent = data.id;
    },
    name: "GYMrigist",
    data() {
        return {
            userid: '',
            compName: ''
        };
    },
    methods: {
        ct() {
            const data = {
                compName: this.compName
            };
            const token = localStorage.getItem('token');
            axios.post('http://10.136.132.34:9000/competitionRegister', data, {
                headers: {
                    'token': token
                }
            })
                .then((response) => {
                    const {code} = response.data;
                    if (code === 1) {
                        alert('创建成功');
                    } else {
                        alert('创建失败');
                    }
                })
                .catch((error) => {
                    console.error(error);
                    alert('登录失败' + error.message);
                });
        },
        idquit(){
            localStorage.removeItem('token');
            alert('退出成功');
            this.$router.push('/login');
        }
    }
}
</script>

<style scoped>
/* 样式设置 */
/*设置登录框的样式 */
.login-box {
    width: 500px;
    height: 230px;
    background-color: #fff;
    margin: 100px auto;
    border-radius: 10px;
    box-shadow: 0 0 20px #000;
    padding: 20px;

}

/*设置输入框样式 */
.ipt {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    border-radius: 4px;

}

/* 按钮样式 */
.bn {
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
body{
    background-color: #cccccc;
}
.header {
    background-color: #333;
    color: #fff;
    display: flex;
    justify-content: space-between;
    padding: 10px;
}
.menu-item {
    margin-left: 40px;
    text-decoration: none;
    color: #fff;
}
.ACMOJ {
    margin-left: 50px;
    text-decoration: none;
    color: #fff;
}
.menu-item:hover {
    text-decoration: underline;
}
table {
    border-collapse: collapse;
    width: 100%;
    border-radius: 40px;
}
th, td {
    text-align: center;
    padding: 10px;
    border: 1px solid #ddd;
}
th {
    background-color: #f2f2f2;
}
.btn {
    background-color: #4CAF50;
    color: #fff;
    border: none;
    padding: 5px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    border-radius: 5px;
}
.btn:hover {
    background-color: #3e8e41;
}
.search{
    padding: 5px 10px;
    margin-left: 40px;
}
table{
    box-shadow: 0 0 10px #cccccc;
    border-collapse: collapse;
}
td, th {
    border-right: none;
    border-left: none;
}
.userid{
    margin-left: 500px;
}
</style>
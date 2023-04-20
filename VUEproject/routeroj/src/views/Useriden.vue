<template>
    <body>
    <div class="header">
        <div>
            <router-link to="/useriden" class="menu-item">用户信息</router-link>
            <router-link to="/mainuser" class="menu-item">题库</router-link>
            <router-link to="/file" class="menu-item">文件</router-link>
            <a href="#" class="ACMOJ">Welcome to YSUACMOJ!</a>

            <input class="search" type="text" id="searchBox">
            <button class="btn" onClick="search()">搜索</button>
            <a class="userid">
                账号:<span id="username"></span>
            </a>
            <button class="btn" v-on:click="idquit">退出登陆</button>
        </div>

    </div>

    <div class="container">
        <table>
            <thead>
            <tr>
                <th>账号</th>
                <th>姓名</th>
                <th>用户名</th>
                <th>密码</th>
                <th>Rating</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>{{id}}</td>
                <td>{{name}}</td>
                <td>{{nickName}}</td>
                <td>{{password}}</td>
                <td>{{rating}}</td>

            </tr>
            </tbody>
        </table>
    </div>
    </body>
</template>

<script>
import axios from "axios";

export default {

    name: "user-iden",
    data() {
        return {
            userid: '',
            id:'',
            name:'',
            nickName: '',
            rating:'',
            password:''
        };
    },
    mounted() {
        const token = localStorage.getItem('token');
        const payload = token.split('.')[1];
        const decodedPayload = atob(payload);
        const data = JSON.parse(decodedPayload);
        const usernameElement = document.getElementById('username');
        usernameElement.textContent = data.id;
        axios.get('http://10.136.132.34:9000/information', {
            headers: {
                'token': token
            }
        })
            .then((response) => {
                const {data,msg} = response.data;
                if(msg==='NOT_LOGIN'){
                    alert('未登录');
                    this.$router.push('/login');
                }
                this.id=data.id;
                this.name=data.name;
                this.nickName=data.nickName;
                this.rating=data.rating;
                this.password=data.password;
            })
            .catch((error) => {
                console.error(error);
                alert('登录失败' + error.message);
            });
    },
    methods :{
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
body {
    background-color: #cccccc;
}

.dif1 {
    background-color: aquamarine;
    color: #fff;
    border: none;
    padding: 5px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    border-radius: 3px;
}

.dif2 {
    background-color: aqua;
    color: #fff;
    border: none;
    padding: 5px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    border-radius: 3px;
}

.dif3 {
    background-color: cornflowerblue;
    color: #fff;
    border: none;
    padding: 5px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    border-radius: 3px;
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

.search {
    padding: 5px 10px;
    margin-left: 40px;
}

.container {
    padding: 50px 100px;
    line-height: 0.5;
    background-color: white;
}

table {
    box-shadow: 0 0 10px #cccccc;
    border-collapse: collapse;
}

td, th {
    border-right: none;
    border-left: none;
}

.userid {
    margin-left: 500px;
}
</style>
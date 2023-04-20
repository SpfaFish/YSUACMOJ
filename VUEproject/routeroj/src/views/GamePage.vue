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
                用户名:<span id="username"></span>
            </a>
            <button class="btn" v-on:click="idquit">退出登陆</button>
        </div>

    </div>

    <div class="container">
        <table>
            <thead>
            <tr>
                <th>题名</th>
                <th>通关人数</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <template v-for="(item, index) in items">
                <tr :key="index">
                    <td>{{ item.name }}</td>
                    <td>{{ 0 }}</td>
                    <td><a href="#" class="btn"><router-link to="/gamepage">进入</router-link></a></td>
                </tr>
            </template>
            <!-- 其他题目条目 -->
            </tbody>
        </table>

        <div class="pages">
            <a href="#" class="page-link">1</a>
            <a href="#" class="page-link">2</a>
            <a href="#" class="page-link">3</a>
            <a href="#" class="page-link">4</a>
            <!-- 其他分页链接 -->
        </div>
    </div>
    </body>
</template>

<script>
export default {
    mounted() {
        const token = localStorage.getItem('token');
        const payload = token.split('.')[1];
        const decodedPayload = atob(payload);
        const data = JSON.parse(decodedPayload);
        const usernameElement = document.getElementById('username');
        usernameElement.textContent = data.id;
    },
    name: "Game-page",
    data() {
        return {
            userid: ''
        };
    },
    methods :{
        idquit(){
            localStorage.removeItem('token');
            alert('退出成功');
            location.reload();
        }
    }
}
</script>

<style scoped>
/* 样式设置 */
body{
    background-color: #cccccc;
}
.dif1{
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
.dif2{
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
.dif3{
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
.pages {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}
.page-link {
    margin-right: 10px;
    text-decoration: none;
}
.page-link:hover {
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
.container{
    padding: 50px 100px;
    line-height: 0.5;
    background-color: white;
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
    margin-left: 700px;
}
</style>
<template>
    <body>
    <div class="header">
        <div>
            <router-link to="/useriden" class="menu-item">用户信息</router-link>
            <router-link to="/mainuser" class="menu-item">题库</router-link>
            <a href="#" class="ACMOJ">Welcome to YSUACMOJ!</a>

            <input class="search" type="text" v-model="searchname">
            <button class="btn" v-on:click="search">搜索</button>

            <button class="btn">
                <router-link to="/GYMrg" >创建比赛</router-link>
            </button>
            <a class="userid">
                账号:<span id="username"></span>
            </a>
            <button class="btn" v-on:click="idquit">退出登陆</button>
        </div>

    </div>
    <div>
        <form>
            <label class="file" for="file">文件：</label>
            <input   ref="fileInput" type="file" id="file" name="file" required>
            <input class="btn" type="submit" v-on:click="" value="上传">
        </form>
    </div>
    <div class="container">
        <table>
            <thead>
            <tr>
                <th>比赛名称</th>
                <th>报名人数</th>
                <th>难度</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <template v-for="(item, index) in items">
                <tr :key="index">
                    <td>{{ item.name }}</td>
                    <td><a href="#" class="btn">下载</a></td>
                    <td><a href="#" class="btn">删除</a></td>
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
import axios from "axios";

export default {
    name: "GYM",
    data() {
        return {
            searchname:'',
            userid: '',
            items:[]
        };
    },
    mounted() {
        const token = localStorage.getItem('token');
        const payload = token.split('.')[1];
        const decodedPayload = atob(payload);
        const data = JSON.parse(decodedPayload);
        const usernameElement = document.getElementById('username');
        usernameElement.textContent = data.id;
        axios.get('http://10.136.132.34:9000/loadFile', {
            headers: {
                'token': token
            }
        })
            .then((response) => {
                const{ data }=response.data;
                this.items=data;
            })
            .catch((error) => {
                console.error(error);
                alert('你是一个' + error.message);
            });
    },
    methods: {
        upload() {
            const token = localStorage.getItem('token');
            const fileInput = this.$refs.fileInput;
            const file = fileInput.files[0];
            const formData = new FormData();
            formData.append('file', file);
            axios.post('http://10.136.132.34:9000/upload', formData, {
                headers: {
                    'token': token,
                    'Content-Type': 'multipart/form-data'
                }

            })
                .then((response) => {
                    const { code } = response.data;
                    if (code===1) {
                        alert('上传成功');
                    } else {
                        alert('上传失败');
                    }
                })
                .catch((error) => {
                    console.error(error);
                    alert('上传失败：' + error.message);
                });
        },
        idquit() {
            localStorage.removeItem('token');
            alert('退出成功');
            this.$router.push('/login');
        }
    }
}
</script>
<style scoped>
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
.dif4{
    background-color: blueviolet;
    color: #fff;
    border: none;
    padding: 5px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    border-radius: 3px;
}
.dif5{
    background-color: firebrick;
    color: #fff;
    border: none;
    padding: 5px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    border-radius: 3px;
}
.dif6{
    background-color: black;
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
    padding: 15px;
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
    margin-left: 10px;
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
    margin-left: 500px;
}
</style>
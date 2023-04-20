<template>
    <body>
    <div class="header">
        <div>
            <router-link to="/useriden" class="menu-item">用户信息</router-link>
            <router-link to="/mainuser" class="menu-item">题库</router-link>
            <a href="#" class="ACMOJ">Welcome to YSU网盘!</a>

            <input class="search" type="text" v-model="searchname">
            <button class="btn" v-on:click="search">搜索</button>


            <a class="userid">
                账号:<span id="username"></span>
            </a>
            <button class="btn" v-on:click="idquit">退出登陆</button>
        </div>

    </div>
    <div>
        <form>
            <label class="file" for="file">文件：</label>
            <input ref="fileInput" type="file" id="file" required>
            <button class="btn" v-on:click="pushfile">上传</button>
        </form>
    </div>
    <div class="container">
        <table>
            <thead>
            <tr>
                <th>名称</th>
                <th>下载</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <template v-for="(item, index) in items">
                <tr :key="index">
                    <td>{{ item.name }}</td>
                    <td><a href="#" class="btn" v-on:click="downloadfile(item.name)">下载</a></td>
                    <td><a href="#" class="btn" v-on:click="deletefile(item.name)">删除</a></td>
                </tr>
            </template>
            <!-- 其他题目条目 -->
            </tbody>
        </table>


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
        remouned(){
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
                    const{ msg,data }=response.data;
                    if(msg==='NOT_LOGIN'){
                        alert('未登录');
                        this.$router.push('/login');
                    }
                    this.items=data;
                })
                .catch((error) => {
                    console.error(error);
                    alert('你是一个' + error.message);
                });
        },
        deletefile(name){
            const token = localStorage.getItem('token');
            const data = {
                fileName: name
            };
            axios.post('http://10.136.132.34:9000/fileDeleter', data, {
                headers: {
                    'token': token
                }

            })
                .then((response) => {
                    const { code } = response.data;
                    if (code === 1) {
                        alert('删除成功');
                        this.remouned();
                    } else {
                        alert('删除失败');
                    }
                })
                .catch((error) => {
                    console.error(error);
                    alert('你是一个' + error.message);
                });
        },
        downloadfile(name){
            const token = localStorage.getItem('token');
            const data = {
                fileName: name
            };
            axios.post('http://10.136.132.34:9000/download', data, {
                headers: {
                    'token': token
                },
                responseType:'blob'

            })
                .then((response) => {
                    const content = response.data;
                    const fileName = name;
                    const blob = new Blob([content]);
                    const href = URL.createObjectURL(blob); // 创建blob url
                    const link = document.createElement('a');
                    link.href = href;
                    link.download = fileName; // 设置下载时文件名
                    document.body.appendChild(link);
                    link.click(); // 模拟点击下载
                    document.body.removeChild(link); // 下载完成后移除链接
                    URL.revokeObjectURL(href); // 释放blob url资源
                })
                .catch((error) => {
                    console.error(error);
                    alert('你是一个' + error.message);
                });
        },
        pushfile() {
            const token = localStorage.getItem('token');
            const fileInput = this.$refs.fileInput;
            const file = fileInput.files[0];
            const formData = new FormData();
            formData.append('file', file);
            axios.post('http://10.136.132.34:9000/upload', formData, {
                headers: {
                    'token': token,
                    'Content-Type': 'multipart/form-data'
                },
                timeout:10000
            })
                .then((response) => {
                    const { code } = response.data;
                    if (code===1) {
                        alert('上传成功');
                        this.remouned();
                    } else {
                        alert('上传失败');
                    }
                })
                .catch((error) => {
                    console.error(error);
                    alert('上传失败：' + error.message);
                });
        },
        search() {
            const token = localStorage.getItem('token');
            const data = {
                name: this.searchname
            };
            axios.post('http://10.136.132.34:9000/conpetitionFinder', data, {
                headers: {
                    'token': token
                }

            })
                .then((response) => {
                    const {data} = response.data;
                    this.items = data;
                })
                .catch((error) => {
                    console.error(error);
                    alert('你是一个' + error.message);
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
    margin-left: 400px;
}
</style>
#include<iostream>
#include<cstdio>
#include<cstring>
#include<algorithm>
#include<queue>
#include<cmath>
#include<vector>
#define int long long
using namespace std;
const int maxn=300005;
const int mod=998244353;
int T,n; 
int read(){
	char z=getchar();int x=0,y=1;
	while(z<'0'||z>'9'){if(z=='-')y=-1;z=getchar();}
	while(z<='9'&&z>='0'){x=x*10+z-'0';z=getchar();}
	return x*y;
}
void init(){
}
void solve(){
}
signed main(){
	T=read();
	while(T--){
		init();
		solve();
	}
	return 0;
}

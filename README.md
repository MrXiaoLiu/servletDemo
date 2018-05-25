## ServletDemo
本项目主要是以serlet来实现写接口功能，初次接触后台可能有些不足，这里我仅用于笔记，想学习这可以看下。
使用之前需要配置
[JDK、](https://download.csdn.net/download/mrliu253/10436744)
[IntelliJ IDEA、](https://www.jetbrains.com/idea/download/#section=mac)
[Tomcat、](https://download.csdn.net/download/mrliu253/10427661)
[MySQL、](https://download.csdn.net/download/mrliu253/10436634)
[Navicat Premium](https://download.csdn.net/download/mrliu253/10431813)
内附下载链接统一为MAC版的，需要注意Navicat Premium为破解中文版，这里还是建议使用正版的；csdn限制下载需要积分，如果没有积分可发送邮件联系我MrLiu253@163.com
### 工作模式
* 客户端发送请求至服务端；
* 服务器启动并调用Servlet,Servlet根据客户端请求生成响应内容并将其传给服务器；
* 服务器将响应返回客户端。

### 项目结构
![图片](https://github.com/MrXiaoLiu/servletDemo/blob/master/image/image.png)
### 说明
* DBHelper 为连接数据库类
* XiaoTaoBusiness 数据库增删改查帮助类
* ServletText 根据请求URl返回数据
* Medel实体类文件夹
* Utils工具文件夹

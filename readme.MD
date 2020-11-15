#争取较为全面的阐释Spring Security
## db模块
重点为后端的持久化定制。
1. 使用mybatis做为持久化方案
2. 完整的定制使用UserDetailService
3. 使用了三个用户john,tom,alice共有三个角色,密码统一为123
4. 使用了两个受保护资源/books,/admin
5. 注意坑点：
    (1) UserDetailService的loadUserByUsername方法，必须返回username,password,authorities
    (2) 数据库中的Role的namen必须加上前缀ROLE_ 
## memery模块

尝试使用SPA前后端分离的方式使用Secuity,重点在前端，后端直接使用内存较验，地址：http://localhost:3000/
1. 重新定制了.loginPage("/goLogin") ，可以接收get,delete，post,put等(删除资源delete方法->跳转到登录页)
2. 重新定制了/goLogin的登录返回信息，使用了json,返回code=401，这样前端可以通过此信息，确认没有没有登录，以显示登录表单
3. 重新定制了.loginProcessingUrl("/doLogin")，以避免添加的操作向/goLogin发出post请求
4. 前端使用纯js的方式，采用了污染全局变量的方式，完成"登录后直接访问上次资源"的功能

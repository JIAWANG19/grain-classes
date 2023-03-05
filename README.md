# 谷粒课堂微服务项目
## 项目环境

Java：17

Maven：3.6

MySQL：8.0

Redis：6.2

Spring Boot：3.0.1

Spring Cloud：2022.0.1

## 项目架构

### 整体架构

![image-20230305105242437](images/image-20230305105242437.png)

### 项目目录

```
/grain-class
	/client
		/client-token  	token服务的远程调用接口
		/client-user	user服务的远程调用接口
	/common
		/service-utils	一些工具类
	/service
		/service-active	优惠服务
		/service-order	订单服务
		/service-token	token服务
		/service-user	用户服务
		/service-vod	课程服务
	/service-gateway
```

## 项目展示

### 登录页

![image-20230305121823624](C:\Users\曹加望\AppData\Roaming\Typora\typora-user-images\image-20230305121823624.png)

### 首页

![image-20230305121943558](C:\Users\曹加望\AppData\Roaming\Typora\typora-user-images\image-20230305121943558.png)

### 讲师管理功能

#### 讲师列表页

![image-20230305122017962](C:\Users\曹加望\AppData\Roaming\Typora\typora-user-images\image-20230305122017962.png)

#### 讲师编辑(修改)页

![image-20230305122052863](C:\Users\曹加望\AppData\Roaming\Typora\typora-user-images\image-20230305122052863.png)

### 课程分类管理功能

#### 课程分类列表

![image-20230305122151450](C:\Users\曹加望\AppData\Roaming\Typora\typora-user-images\image-20230305122151450.png)

### 课程管理功能

#### 课程列表页

![image-20230305122723105](C:\Users\曹加望\AppData\Roaming\Typora\typora-user-images\image-20230305122723105.png)

#### 课程基本信息管理页

![image-20230305122757454](C:\Users\曹加望\AppData\Roaming\Typora\typora-user-images\image-20230305122757454.png)

#### 课程大纲管理页

![image-20230305122833619](C:\Users\曹加望\AppData\Roaming\Typora\typora-user-images\image-20230305122833619.png)

#### 课程最终发布页

![image-20230305122849349](C:\Users\曹加望\AppData\Roaming\Typora\typora-user-images\image-20230305122849349.png)

### 订单列表页

![image-20230305122924966](C:\Users\曹加望\AppData\Roaming\Typora\typora-user-images\image-20230305122924966.png)

### 活动管理页

#### 优惠卷列表页

![image-20230305122954147](C:\Users\曹加望\AppData\Roaming\Typora\typora-user-images\image-20230305122954147.png)

#### 优惠卷修改页

![image-20230305123022237](C:\Users\曹加望\AppData\Roaming\Typora\typora-user-images\image-20230305123022237.png)

#### 优惠卷详情页

![image-20230305123045323](C:\Users\曹加望\AppData\Roaming\Typora\typora-user-images\image-20230305123045323.png)



### 项目功能

+ `RustFul`风格的增删改查功能
+ 使用`MybatisPlus`的**分页条件查询**
+ 使用`Nacos`的服务注册与服务配置

## SpringBoot3与SpringCloud2022


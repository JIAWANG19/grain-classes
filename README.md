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

![image-20230305105242437](https://grain-classes.oss-cn-beijing.aliyuncs.com/service/index/build.png)

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

![image-20230305121823624](https://grain-classes.oss-cn-beijing.aliyuncs.com/service/index/login.png)

### 首页

![image-20230305121943558](https://grain-classes.oss-cn-beijing.aliyuncs.com/service/index/index.png)

### 讲师管理功能

#### 讲师列表页

![image-20230305122017962](https://grain-classes.oss-cn-beijing.aliyuncs.com/service/teacher/teacher-list.png)

#### 讲师编辑(修改)页

![image-20230305122052863](https://grain-classes.oss-cn-beijing.aliyuncs.com/service/teacher/teacher-info.png)

### 课程分类管理功能

#### 课程分类列表

![image-20230305122151450](https://grain-classes.oss-cn-beijing.aliyuncs.com/service/course/course-sort.png)

### 课程管理功能

#### 课程列表页

![image-20230305122723105](https://grain-classes.oss-cn-beijing.aliyuncs.com/service/course/course-list.png)

#### 课程基本信息管理页

![image-20230305122757454](https://grain-classes.oss-cn-beijing.aliyuncs.com/service/course/course-info.png)

#### 课程大纲管理页

![image-20230305122833619](https://grain-classes.oss-cn-beijing.aliyuncs.com/service/course/course-detail.png)

#### 课程最终发布页

![image-20230305122849349](https://grain-classes.oss-cn-beijing.aliyuncs.com/service/course/course-publish.png)

### 订单列表页

![image-20230305122924966](https://grain-classes.oss-cn-beijing.aliyuncs.com/service/order/order-list.png)

### 活动管理页

#### 优惠卷列表页

![image-20230305122954147](https://grain-classes.oss-cn-beijing.aliyuncs.com/service/activity/activity-list.png)

#### 优惠卷修改页

![image-20230305123022237](https://grain-classes.oss-cn-beijing.aliyuncs.com/service/activity/activity-info.png)

#### 优惠卷详情页

![image-20230305123045323](https://grain-classes.oss-cn-beijing.aliyuncs.com/service/activity/activity-detail.png)



### 项目功能

+ 使用**Restful**风格编写的基本增删改查接口
+ 使用**MybatisPlus**实现复杂的**条件分页查询**
+ 使用**阿里云OOS对象存储服务**实现头像的上传与展示
+ 使用**Nacos**实现服务的注册、服务配置
+ 使用**加密Token** + **Redis + 自定义拦截器**实现的复杂用户鉴权功能
+ 使用**Gateway**作为网关，实现服务的统一调用、负载均衡
+ 使用**OpenFeign**使用服务的远程调用功能

## SpringBoot3与SpringCloud2022

> 在项目开发的过程中，由于该项目使用的是最新的**SpringBoot3.0**与**SpringCloud2022**，出现了许多项目配置上的问题，有些问题在网上也没有可行的解决方案，所以记录一下

### yml文件的Nacos的配置

1. 注册中心(服务发现)配置

```yml
spring:
  application:
    name: service-vod
  profiles:
    active: dev
  cloud:
    nacos:
      config:		# 配置中心配置
        server-addr: 192.168.59.1:8848
        namespace: 5b1a127f-9baa-4a5f-a709-e0b67cb7ef3d
        group: dev
      discovery:	# 注册中配置
        server-addr: 192.168.59.1:8848
        namespace: 5b1a127f-9baa-4a5f-a709-e0b67cb7ef3d
        group: dev
```

2. 从配置中心中导入配置

```yml
config:
  import:
  	# group: 组名
  	# refreshEnabled: 是否支持自动刷新
    - optional:nacos:vod-database.yml?group=service-vod&refreshEnabled=true
    # 这是阿里云OOS对象存储服务的配置
    - optional:nacos:vod-aliyunOOS.properties?group=service-vod&refreshEnabled=true
```

> 使用Nacos，可以将MySQL与Redis的配置转移到配置中心中，如果再加上配置`refreshEnabled=true`，可以实现数据库密码的动态刷新，从而可以保护数据库的安全

### Gateway网关配置

1. `pom.xml`

由于`Gateway`网关使用`Netty`框架而不是SpringBoot，所以在`Gateway`中不能导入`spring-boot-starter-web`，否则会报错

2. 路由规则配置

```yml
spring:
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true
          lower-case-service-id: true
      routes:
        # service-vod 模块
        - id: service-vod
          uri: lb://service-vod
          predicates:
          - Path=/admin/vod/**

        # service-order 模块
        - id: service-order
          uri: lb://service-order
          predicates:
          - Path=/admin/order/**

        # service-activity 模块
        - id: service-activity
          uri: lb://service-activity
          predicates:
          - Path=/admin/activity/**

        # service-user 模块
        - id: service-user
          uri: lb://service-user
          predicates:
          - Path=/admin/user/**
```

> 在`uri`中使用`lb`做负载均衡时，需要在目标服务中导入`spring-cloud-starter-loadbalancer`的依赖，否则会报错

### 注册一个公用的拦截器





项目来自于：

[【尚硅谷&腾讯云】Java项目硅谷课堂丨微服务丨在线学习平台_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV13T411372x/?spm_id_from=333.337.search-card.all.click)


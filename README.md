本项目是MyBatis的学习项目，其中每个项目对应的学习内容如下：

## mybatis-01

1. **第一个MyBatis的Maven项目**。包含MyBatis的结构、核心配置文件、一个功能mapper
2. 配置了**增删改查**方法



## mybatis-02

基于**mybatis-01**之上**优化了核心配置类mybatis-config.xml**，内容如下

1. 配置了`<properies>`将db.properties从mybatis-config.xml中分离出来
2. 配置了`<typeAliases>`缩写
3. 配置了第二个`<environment>`



## mybatis-03

1. 基于**mybatis-02**之上在UserMapper.xml中使用了结果集映射（resultMap）
2. 加入了**log4j.properties**:
	- 在核心配置类mybatis-config.xml中配置了log4j
	- 编写了log4j的配置文件log4j.properties
	- 在test中加入了log4j的代码



## mybatis-05

基于**mybatis02**之上使用注解开发代替UserMapper.xml



## mybatis-06

实现了SQL中常见的**多对一**功能，在StudentMapper.xml中使用了`<association>`



## mybatis-07

实现了SQL中常见的**一对多**功能，在TeacherMapper.xml中使用了`<collection>`



## mybatis-08

实现了**动态SQL**功能



## mybatis-09

配置并实现了MyBatis的**缓存**(一级缓存)功能



## 参考

[狂神说Java MyBatis](https://www.bilibili.com/video/BV1NE411Q7Nx?from=search&seid=12974044181112636960)



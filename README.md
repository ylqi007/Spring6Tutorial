1. Module: [Spring-01-Demo](Spring-01-Demo)
2. Module: [Spring-02-IoC-xml](Spring-02-IoC-xml)
   * 这个module是通过xml实现IoC配置的演示项目工程，暂时忽略，所以只是创建这个module作为一个placeholder，并没有代码实现。
3. Module: [Spring-03-IoC-Annotation](Spring-03-IoC-Annotation)
   * 基于注解的IoC配置。
4. Placeholder: Spring-04-reflect
   * 回顾反射
   * 手写IoC
5. Module: [Spring-05-aop](Spring-05-aop)
   * 代理模式
   * AOP概念及相关术语
6. Module: [Spring-06-JUnit](Spring-06-JUnit)
   * 整合Junit5 and Junit4


## 1. Spring入门案例


## 2. IoC based on XML

## 3. IoC based on Annotation
### 3.1 对象的创建
```java
// Step 1: 启动注解扫描

// Step 2: 创建对象
@Component
@Repository
@Service
@Controller

// Step 3: 依赖注入:
// 3.1 @Autowired
// 3.2 @Resource

// Step 4: 使用
applicationContext.getBean(xxx);
```

### 3.2 对象的注入
#### 1. 通过`@Autowired`实现依赖注入
1. 场景一: 属性注入
2. 场景二: setter方法注入
3. 场景三: 构造器注入
4. 场景四: 形参上注入
5. 场景五: 只有一个构造器，无注解
6. 场景六: `@Autowired + @Qualifier`组合使用

#### 2. 通过`@Resource`实现依赖注入
⚠️注意: `@Resource`注解属于JDK扩展包，所以不在JDK当中，需要额外引⼊以下依赖：【如果是JDK8的话不需要额外引⼊依
赖。⾼于JDK11或低于JDK8需要引⼊以下依赖。
```xml
<!-- https://mvnrepository.com/artifact/jakarta.annotation/jakarta.annotation-api -->
<dependency>
    <groupId>jakarta.annotation</groupId>
    <artifactId>jakarta.annotation-api</artifactId>
    <version>3.0.0</version>
</dependency>
```

`@Resource`注解：默认byName注⼊，没有指定name时把属性名当做name，根据name找不到时，才会byType注
⼊。 byType注⼊时，某种类型的Bean只能有⼀个

#### ⚠️注意
* 将通过@Autowired实现注入的事例代码放入`com.atguigu.autowired`包下，
* 将通过@Resource实现注入的事例代码放入`com.atguigu.resource`包下.
* 使用`@Resource`注解需要引入JDK扩展包，Jakarta

### 3.3 基于全注解的Spring开发
使用一个配置类(`SpringConfig.java`)替代配置文件(比如`resources/beans.xml`)
```java
@Configuration // 这是一个配置类
@ComponentScan("com.atguigu")   // 开启注解扫描
public class SpringConfig {

}

public class UserControllerConfigTest {
   @Test
   public void test01() {
      // 加载配置类，
      // 此处使用AnnotationConfigApplicationContext，而不是ClassPathXmlApplicationContext
      ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);  

      UserController userController = applicationContext.getBean("resourceUserController", UserController.class);
      userController.add();
   }
}
```

### Spring Bean生命周期
![](docs/images/Spring.Bean.Lifecycle.png)


## 4. 原理: 手写IoC 
TODO


## 5. 面向切面: AOP
### 5.1 场景模拟
计算器接口`Calculator`

### 5.2 代理模式
1. 概念
   > 二十三种设计模式中的一种，属于结构型模式。它的作用就是通过提供一个代理类，让我们在调用目标方法的时候，不再是直接对目标方法进行调用，而是通过代理类间接调用。让不属于目标方法核心逻辑的代码从目标方法中剥离出来——解耦。调用目标方法时先调用代理对象的方法，减少对目标方法的调用和打扰，同时让附加功能能够集中在一起也有利于统一维护。
2. 静态代理 (Static Proxy)
3. 动态代理 (Dynamic Proxy)
   1. JDK的动态代理: 有接口
   2. cglib的动态代理: 无接口

### 5.3 AOP概念及相关术语
1. AOP: Aspect Oriented Programming
   > AOP（Aspect Oriented Programming）是一种设计思想，是软件设计领域中的面向切面编程，它是面向对象编程的一种补充和完善，它以通过预编译方式和运行期动态代理方式实现，在不修改源代码的情况下，给程序动态统一添加额外功能的一种技术。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。
2. 相关术语
   * 横切关注点
   * 通知（增强），增强，通俗说，就是你想要增强的功能，比如 安全，事务，日志等。
   * 切面：封装通知方法的类。
   * 目标：被代理的目标对象。
   * 代理：向目标对象应用通知之后创建的代理对象。
   * 连接点：这也是一个纯逻辑概念，不是语法定义的。
   * 切入点：定位连接点的方式。
3. 作用
   * 简化代码：把方法中固定位置的重复的代码抽取出来，让被抽取的方法更专注于自己的核心功能，提高内聚性。
   * 代码增强：把特定的功能封装到切面类中，看哪里有需要，就往上套，被套用了切面逻辑的方法就被切面给增强了。

## 6. JUnit
* JUnit4: `@RunWith(SpringJUnit4ClassRunner.class)` + `@ContextConfiguration(value = "classpath:bean.xml")`
* JUnit5: `@SpringJUnitConfig(locations = "classpath:bean.xml")`


## 7. 事务
### 7.1 JdbcTemplate
#### 1. 简介
Spring框架对JDBC进行封装，使用JdbcTemplate(`org.springframework.jdbc.core.JdbcTemplate`)方便实现对数据库操作。
* [Spring: Data Access with JDBC](https://docs.spring.io/spring-framework/reference/data-access/jdbc.html)
* 🟩🌟[Spring: Using the JDBC Core Classes to Control Basic JDBC Processing and Error Handling](https://docs.spring.io/spring-framework/reference/data-access/jdbc/core.html)

#### 2. 准备工作
1. 准备子模块
2. 添加依赖
3. 创建`jdbc.properties`
4. 配置Spring的配置文件
5. 准备数据库与测试表

#### 3. 实现CRUD
1. 装配 JdbcTemplate
2. 测试增删改功能: `Spring-07-jdbc-tx/src/test/java/com/atguigu/JdbcTemplateTest.java`

### 7.2 声明式事务概念
### 7.3 基于注解的声明式事务
### 7.4 基于XML的声明式事务

## Resource
* 课件: [Spring6.pdf](docs/Spring6.pdf)
* 📗友人的编程指南(CoderMast): [Spring](https://www.codermast.com/spring-series/spring/)
* CoderMast GitHub: https://github.com/codermast/Spring6 (有一些尚硅谷的code可以参考，但是不完全)
* 📗🌟笔记: https://github.com/mouday/atguigu-spring6
* [一张图搞定SpringBean的生命周期，再也不怕繁多的回调接口啦！](https://www.modb.pro/db/422673)
* 📗🌟不错的技术博客 https://juejin.cn/user/3562073406314311/posts
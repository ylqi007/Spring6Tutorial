
### ConflictingBeanDefinitionException
```shell
Caused by: org.springframework.context.annotation.ConflictingBeanDefinitionException: Annotation-specified bean name 'user' for bean class [com.atguigu.junit5.User] conflicts with existing, non-compatible bean definition of same name and class [com.atguigu.junit4.User]
	at org.springframework.context.annotation.ClassPathBeanDefinitionScanner.checkCandidate(ClassPathBeanDefinitionScanner.java:361)
	at org.springframework.context.annotation.ClassPathBeanDefinitionScanner.doScan(ClassPathBeanDefinitionScanner.java:288)
	at org.springframework.context.annotation.ComponentScanBeanDefinitionParser.parse(ComponentScanBeanDefinitionParser.java:90)
	at org.springframework.beans.factory.xml.NamespaceHandlerSupport.parse(NamespaceHandlerSupport.java:74)
	at org.springframework.beans.factory.xml.BeanDefinitionParserDelegate.parseCustomElement(BeanDefinitionParserDelegate.java:1390)
	at org.springframework.beans.factory.xml.BeanDefinitionParserDelegate.parseCustomElement(BeanDefinitionParserDelegate.java:1370)
	at org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader.parseBeanDefinitions(DefaultBeanDefinitionDocumentReader.java:179)
	at org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader.doRegisterBeanDefinitions(DefaultBeanDefinitionDocumentReader.java:150)
	at org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader.registerBeanDefinitions(DefaultBeanDefinitionDocumentReader.java:96)
	at org.springframework.beans.factory.xml.XmlBeanDefinitionReader.registerBeanDefinitions(XmlBeanDefinitionReader.java:520)
	at org.springframework.beans.factory.xml.XmlBeanDefinitionReader.doLoadBeanDefinitions(XmlBeanDefinitionReader.java:400)
	... 39 more
```
* Cause: Spring启动时会扫描到两个User类,`com.atguigu.junit4.User` and `com.atguigu.junit5.User`, and both of them have the default name `user`
* Solution: `@Component(value = "userJunit4")` + `@Qualifier("userJunit4")`
* [Spring Boot ConflictingBeanDefinitionException: Annotation-specified bean name for @Controller class](https://stackoverflow.com/questions/28498295/spring-boot-conflictingbeandefinitionexception-annotation-specified-bean-name-f)
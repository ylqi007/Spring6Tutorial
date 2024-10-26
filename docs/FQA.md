
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

### java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate
```shell
java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]

	at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:104)
	at org.springframework.test.context.BootstrapUtils.createBootstrapContext(BootstrapUtils.java:77)
	at org.springframework.test.context.BootstrapUtils.resolveTestContextBootstrapper(BootstrapUtils.java:126)
	at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:126)
	at org.junit.jupiter.engine.execution.ExtensionValuesStore.lambda$getOrComputeIfAbsent$4(ExtensionValuesStore.java:86)
	at org.junit.jupiter.engine.execution.ExtensionValuesStore$MemoizingSupplier.computeValue(ExtensionValuesStore.java:223)
	at org.junit.jupiter.engine.execution.ExtensionValuesStore$MemoizingSupplier.get(ExtensionValuesStore.java:211)
	at org.junit.jupiter.engine.execution.ExtensionValuesStore$StoredValue.evaluate(ExtensionValuesStore.java:191)
	at org.junit.jupiter.engine.execution.ExtensionValuesStore$StoredValue.access$100(ExtensionValuesStore.java:171)
	at org.junit.jupiter.engine.execution.ExtensionValuesStore.getOrComputeIfAbsent(ExtensionValuesStore.java:89)
	at org.junit.jupiter.engine.execution.ExtensionValuesStore.getOrComputeIfAbsent(ExtensionValuesStore.java:93)
	at org.junit.jupiter.engine.execution.NamespaceAwareStore.getOrComputeIfAbsent(NamespaceAwareStore.java:61)
	at org.springframework.test.context.junit.jupiter.SpringExtension.getTestContextManager(SpringExtension.java:366)
	at org.springframework.test.context.junit.jupiter.SpringExtension.beforeAll(SpringExtension.java:131)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeBeforeAllCallbacks$12(ClassBasedTestDescriptor.java:395)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.invokeBeforeAllCallbacks(ClassBasedTestDescriptor.java:395)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.before(ClassBasedTestDescriptor.java:211)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.before(ClassBasedTestDescriptor.java:84)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:148)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:155)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:35)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:54)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:147)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:127)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:90)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.lambda$execute$0(EngineExecutionOrchestrator.java:55)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.withInterceptedStreams(EngineExecutionOrchestrator.java:102)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:54)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:114)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:86)
	at org.junit.platform.launcher.core.DefaultLauncherSession$DelegatingLauncher.execute(DefaultLauncherSession.java:86)
	at org.junit.platform.launcher.core.SessionPerRequestLauncher.execute(SessionPerRequestLauncher.java:53)
	at com.intellij.junit5.JUnit5IdeaTestRunner.startRunnerWithArgs(JUnit5IdeaTestRunner.java:57)
	at com.intellij.rt.junit.IdeaTestRunner$Repeater$1.execute(IdeaTestRunner.java:38)
	at com.intellij.rt.execution.junit.TestsRepeater.repeat(TestsRepeater.java:11)
	at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:35)
	at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:232)
	at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:55)
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Unresolvable class definition
	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:148)
	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:169)
	at org.springframework.test.context.BootstrapUtils.createCacheAwareContextLoaderDelegate(BootstrapUtils.java:101)
	... 55 more
Caused by: java.lang.NoClassDefFoundError: org/springframework/context/ApplicationContext
	at java.base/java.lang.Class.getDeclaredConstructors0(Native Method)
	at java.base/java.lang.Class.privateGetDeclaredConstructors(Class.java:3373)
	at java.base/java.lang.Class.getConstructor0(Class.java:3578)
	at java.base/java.lang.Class.getDeclaredConstructor(Class.java:2754)
	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:139)
	... 57 more
Caused by: java.lang.ClassNotFoundException: org.springframework.context.ApplicationContext
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:525)
	... 62 more
```
* Cause: 缺少spring-context依赖
# Ways to create and manage thread-pools in Java

## Purpose
This project is created to express the differences among approaches when creating and managing thread-pool in Java Core and reproduce Tomcat memory leak warnings.

## Modifications
This project was download from website: https://memorynotfound.com/servletcontextlistener-startup-listener/ and did some modifications as below:
1. Fix compile error by allowing non required web.xml when packaging source code to WAR file.
2. Add Dockerfile in order to deploy and run in Tomcat 8.5 based docker container.
3. Define some thread-pools which managed by either ServletContextListener or itself.

## Steps to build, deploy and run project

### Build war
```
   mvn clean install
```

### Build docker image
```
   docker build -t servlet-context-listener .
```

### Run image in Tomcat based container
```
   docker run -it --rm -p 8888:8080 servlet-context-listener
```

### Test kinds of thread pool by this URL
```
   http://localhost:8888/servlet-context-listener-1.0.0-SNAPSHOT/folkJoinTestServlet/submitNewTask?testcase=2
```

## Reproduce Tomcat memory leak warnings
1. Comment lines relating to shutdown thread-pool in contextDestroyed method of class [ApplicationStartUpListener.java](src/main/java/com/memorynotfound/ApplicationStartUpListener.java) to express Tomcat memory leak warnings!

## Compare among approaches defining thread pool in Java
<table class="wrapped confluenceTable"><colgroup><col /><col /><col /></colgroup><tbody><tr><td class="confluenceTd">Singleton</td><td class="confluenceTd"><ul class="alternate"><li>reuse thread-pool</li></ul></td><td class="confluenceTd"><ul class="alternate"><li>for each of particular biz, we need to define its thread-pool</li><li>memory warning logs are still there when application is shutting down</li></ul></td></tr><tr><td class="confluenceTd">Managed by Application Context</td><td class="confluenceTd"><ul class="alternate"><li>can initialize/shutdown when the context is initialized or destroyed</li><li>can reuse thread-pool if we put them in context and retrieve it from context whenever we want to use</li></ul></td><td class="confluenceTd"><ul class="alternate"><li>validity in application context only, using in request, session context might cause errors due to thread-pool is out of context and thread-pool is shutdown while tasks are executing or waiting</li><li>for each of particular biz, we need to define its thread-pool</li><li>manage it seem more complex than other approaches</li></ul></td></tr><tr><td class="confluenceTd"><a href="https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinPool.html">ForkJoinPool</a> (recommended)</td><td class="confluenceTd"><ul class="alternate"><li>easy to use, don't need to care about shutdown</li><li>no memory leak warning logs appear</li><li>same approach with Ivy</li></ul></td><td class="confluenceTd"><ul class="alternate"><li>by default, submitted tasks are executed in synchronization, it run slower than self defined pool. This can be solved by customizing processor or define thread pool by ForkJoinPool constructor instead of using common pool.</li><li>depends directly on number of CPU (processor) as mentioned in last point.</li></ul></td></tr></tbody></table>

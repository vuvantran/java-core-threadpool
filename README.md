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

## Reproduce Tomcat memory leak warnings
1. Comment lines relating to shutdown thread-pool in contextDestroyed method of class [ApplicationStartUpListener.java](src/main/java/com/memorynotfound/ApplicationStartUpListener.java) to express Tomcat memory leak warnings!
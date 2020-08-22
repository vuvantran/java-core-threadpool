# Creating thread-pool in life cycle of ServletContextListener

## Purpose
This project is created to express the differences a mong approach when creating and managing thread-pool in Java Core.

## Reference
This project was download from website: https://memorynotfound.com/servletcontextlistener-startup-listener/ and did some modification as below:
1. Fix compile error by allowing non required web.xml when constracting source code to WAR file.
2. Add Dockerfile in order to deploy and running in Tomcat 8.5 based docker container.
3. Define some thread-pools which managed by either ServletContextListener or itself.

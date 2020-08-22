FROM tomcat:8.5.57-jdk8-adoptopenjdk-hotspot

COPY target/servlet-context-listener-1.0.0-SNAPSHOT.war /usr/local/tomcat/webapps/
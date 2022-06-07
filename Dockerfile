FROM tomcat:8.5.47-jdk8-openjdk
COPY target/JavaServerFaces.war /usr/local/tomcat/webapps
EXPOSE 8085

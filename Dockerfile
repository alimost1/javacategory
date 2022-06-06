FROM openjdk:8
COPY target/JavaServerFaces.war JavaServerFaces.war
EXPOSE 8085
ENTRYPOINT ["java", "-war" ,"JavaServerFaces.war"]
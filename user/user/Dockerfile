FROM openjdk:17-oracle

EXPOSE 8081

ADD target/user-docker.jar user-docker.jar

ENTRYPOINT [ "java","-jar","user-docker.jar"]
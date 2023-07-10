FROM openjdk:17-oracle

EXPOSE 8080

ADD target/booking-docker.jar booking-docker.jar

ENTRYPOINT [ "java","-jar","booking-docker.jar"]
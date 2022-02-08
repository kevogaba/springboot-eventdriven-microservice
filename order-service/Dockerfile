FROM openjdk:11.0-jdk

LABEL maintainer="kevogaba@gmail.com"

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} order-service.jar
ENTRYPOINT ["java", "-jar", "/order-service.jar"]

EXPOSE 9091

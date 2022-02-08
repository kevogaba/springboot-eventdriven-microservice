FROM openjdk:11.0-jdk

LABEL maintainer="kevogaba@gmail.com"

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} user-service.jar
ENTRYPOINT ["java", "-jar", "/user-service.jar"]

EXPOSE 9092

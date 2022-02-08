FROM openjdk:11.0-jdk

LABEL maintainer="kevogaba@gmail.com"

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} common-service.jar
ENTRYPOINT ["java", "-jar", "/common-service.jar"]

EXPOSE 9090

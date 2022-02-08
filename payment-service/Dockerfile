FROM openjdk:11.0-jdk

LABEL maintainer="kevogaba@gmail.com"

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} payment-service.jar
ENTRYPOINT ["java", "-jar", "/payment-service.jar"]

EXPOSE 9093

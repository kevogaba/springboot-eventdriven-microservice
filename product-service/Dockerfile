FROM openjdk:11.0-jdk

LABEL maintainer="kevogaba@gmail.com"

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} product-service.jar
ENTRYPOINT ["java", "-jar", "/product-service.jar"]

EXPOSE 8081

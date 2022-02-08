FROM openjdk:11.0-jdk

LABEL maintainer="kevogaba@gmail.com"

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} shipment-service.jar
ENTRYPOINT ["java", "-jar", "/shipment-service.jar"]

EXPOSE 9094

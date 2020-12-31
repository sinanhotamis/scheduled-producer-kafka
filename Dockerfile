FROM openjdk:11-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/scheduled-producer-kafka-0.0.2-SNAPSHOT.jar
ADD ${JAR_FILE} Root.jar
ENTRYPOINT ["java","-jar","/Root.jar"]
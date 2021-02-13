# SNN Lab Projects - scheduled-producer-message

*  This tutorial app provides sechudeled producing generic object into Kafka Broker and RabbitMQ which is ready on Local Docker.
*  The app send message each 1 minute into the Kafka Broker. 

# Project Requisites

* JDK 11
* Maven Project Management Tool
* spring-scheduler spring-kafka, spring-boot-starter-amqp,and spring-boot-configuration-processor

# Getting Started

*   To be installed Zookeeper, Kafka Broker, and RabbitMQ on  local Docker, execute command 'docker-compose up' on docker-compose.yaml file path.
*   For the local running app, just run ScheduledProducerMessageApplication Spring Boot main class.
*   Finally, to be observed console log for each 1 minute.

### Reference Documentation
For further reference, please consider the following sections:

* [Spring Kafka - Baeldung ](https://www.baeldung.com/spring-kafka)
* [Spring RabbitMQ - spring.io](https://spring.io/guides/gs/messaging-rabbitmq/)


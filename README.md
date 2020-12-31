# SNN Lab Projects - scheduled-producer-kafka

*  This tutorial app provides sechudeled producing generic object into Kafka Broker which is ready on Local Docker.
*  The app send message each 1 minute into the Kafka Broker. 

# Project Requisites

* JDK 11
* Maven Project Management Tool
* spring-boot-starter-quartz, spring-kafka, spring-boot-configuration-processor

# Getting Started

*   To be installed Zookeeper and Kafka Broker on  local Docker, execute command 'docker-compose up' on docker-compose.yaml file path.
*   For the local running app, just run ScheduledProducerKafkaApplication Spring Boot main class.
*   Finally, to be observed console log for each 1 minute.

### Reference Documentation
For further reference, please consider the following sections:

* [Spring Quartz - Baeldung ](https://www.baeldung.com/spring-quartz-schedule)
* [Spring Kafka - Baeldung ](https://www.baeldung.com/spring-kafka)


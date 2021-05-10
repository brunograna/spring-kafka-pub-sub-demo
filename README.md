<h1 align="center">
    <img alt="Apache Kafka" src="https://github.com/brunograna/kafka-pub-sub-demo/blob/master/kafka-logo.png" width="300px" />
</h1>

<h3 align="center">
  Project: Spring Boot Kafka Pub Sub Demo
</h3>

<p align="center">

  <img alt="License: MIT" src="https://img.shields.io/badge/license-MIT-%2304D361">
  <img alt="Language: Java" src="https://img.shields.io/badge/language-java-green">
  <img alt="Version: 1.0" src="https://img.shields.io/badge/version-1.0-yellowgreen">

</p>

## :rocket: Project Features

* Publish and Subscribe Kafka Messages
* Docker Compose with Kafka and ZooKeeper configuration

:mag: Download the project and test by yourself.

## :dart: Development objective

- Java 11 with Spring Boot 2.4.5 and Apache Kafka
- Available endpoint to publish messages to Kafka Topics

## :file_folder: Resources

**Base Url**

*Annotations Route*

```
${HOST_URL}/kafka/v1
```

## /producer

**Endpoint**

```
HTTP POST - ${HOST_URL}/kafka/v1/producer
```

* Available endpoint that sends a message to Apache Kafka Topic
  * You can send a String in the body of the request

---

Developed by Bruno Garcia :wave: [More about me](https://www.linkedin.com/in/dev-brunogarcia/)
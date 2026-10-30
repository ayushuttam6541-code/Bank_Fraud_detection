# Bank Fraud Detection

A Java-based microservices project for a banking and fraud-monitoring platform. The repository is organized as a set of Spring Boot services that work together to manage accounts, transactions, payments, alerts, and fraud detection.

## Overview

This project simulates a banking ecosystem where transactions are processed through independent services and analyzed for suspicious activity. The architecture includes:

- API Gateway: central access point for incoming requests
- Account Service: creates and manages customer accounts and balances
- Transaction Service: handles transaction processing
- Payment Service: supports payment-related workflows
- Fraud Detection Service: evaluates suspicious transaction patterns
- Notification Service: sends alerts and notifications
- Shared infrastructure: Redis, MySQL, Kafka, and Zookeeper via Docker Compose

## Architecture

```text
Client / API Consumer
        |
        v
   API Gateway
   /  |  |  \
  /   |  |   \
 v    v  v    v
Account Transaction Payment Notification
   \     |      /
    \    |     /
      Fraud Detection Service
           |
           v
        Kafka / Redis / MySQL
```

## Repository Structure

```text
Bank_Fraud_detection/
├── API-gateway/
│   └── API-gateway/
├── account-service/
│   └── account-service/
├── fraud-detection-service/
│   └── fraud-detection-service/
├── notification-service/
│   └── notification-service/
├── payment-service/
│   └── payment-service/
├── transaction-service/
│   └── transaction-service/
├── docker-compose.yml
├── .idea/
└── README.md
```

## Tech Stack

- Java 17
- Spring Boot 4.x
- Maven
- MySQL
- Redis
- Kafka
- Zookeeper
- Docker / Docker Compose

## Prerequisites

Before running the project, make sure you have:

- JDK 17+
- Maven
- Docker and Docker Compose
- Git

## Running the Infrastructure

Start the shared services required by the platform:

```bash
docker compose up -d
```

This brings up:

- Redis
- MySQL
- Zookeeper
- Kafka

## Running the Services

Each service is a separate Spring Boot application. Run them from their project folders:

```bash
cd API-gateway/API-gateway
./mvnw spring-boot:run
```

```bash
cd account-service/account-service
./mvnw spring-boot:run
```

```bash
cd transaction-service/transaction-service
./mvnw spring-boot:run
```

```bash
cd payment-service/payment-service
./mvnw spring-boot:run
```

```bash
cd fraud-detection-service/fraud-detection-service
./mvnw spring-boot:run
```

```bash
cd notification-service/notification-service
./mvnw spring-boot:run
```

## Suggested Flow

1. Start infrastructure using Docker Compose.
2. Start the API Gateway.
3. Start the account and transaction-related services.
4. Launch payment and fraud detection services.
5. Start the notification service for alerts.

## Notes

- This repository is still structured as a modular microservices prototype.
- The service applications are configured for Spring Boot and Kafka-based event-driven patterns.
- The actual endpoints and business logic may be extended as the project evolves.

## License

This project does not currently declare a specific license in the repository metadata.

## Contributing

Contributions are welcome. To contribute:

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Open a pull request with a clear description.

## Contact

Ayush Raj

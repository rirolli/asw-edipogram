#!/bin/bash

# compila il progetto e crea i vari JDK
echo Building project
gradle clean
gradle build

# avvia il docker compose
echo Starting docker compose
docker compose build
docker compose push
docker compose up -d

#crea i topics per kafka
echo Creating Kafka topics for the Edipogram...
KAFKA_DOCKER=$(docker ps | grep kafka | grep -v zookeeper | awk '{print $1}')
docker exec $KAFKA_DOCKER kafka-topics.sh --bootstrap-server localhost:9092 --create --topic enigmi-event-channel --replication-factor 1 --partitions 4
docker exec $KAFKA_DOCKER kafka-topics.sh --bootstrap-server localhost:9092 --create --topic connessioni-event-channel --replication-factor 1 --partitions 4

#!/bin/bash

sudo docker-compose exec kafka /bin/sh -c "kafka-topics --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic topic_lead_events"
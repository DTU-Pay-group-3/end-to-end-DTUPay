#!/bin/bash
set -e
docker image prune -f
docker-compose up -d rabbitMq
sleep 10
docker-compose up -d token-service account-service payment-service reporting-service facade-service


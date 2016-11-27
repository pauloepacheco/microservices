#!/usr/bin/env bash

cd microservices/core/product-service-tms;                ./gradlew clean publishToMavenLocal; cd -
cd microservices/core/recomendation-service-tms;         ./gradlew clean publishToMavenLocal; cd -
cd microservices/composite/product-composite-service-tms; ./gradlew clean build; cd -

cd microservices/support/discovery-server-tms;            ./gradlew clean build; cd -
cd microservices/support/edge-server-tms;                 ./gradlew clean build; cd -


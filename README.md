# to-event-sourcing-lab

## Pre-requisites
To run the application are needed the follow applications installed on you machine (Simplest way si to start them in a docker container):
1. MongoDB (in application conf mongo si set on 29017 port)
    docker run -d -p 27017-27019:27017-27019 --name mongodb mongo

2. Zipkin server
    docker run -d -p 9411:9411 openzipkin/zipkin

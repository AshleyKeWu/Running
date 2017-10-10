# Running Information Analysis Service

Homework1

This is a Java web application recording and analyzing the health situation of a running user. It concerns mainly the hear rate.

## Prerequisites

+ git

+ Maven

+ MySQL

+ Docker(Optional)

## Getting Started

    $git clone https://github.com/AshleyKeWu/Running/edit/master/README.md

Go into directory running-information-service-analysis/target. If there's no target directory, run ``$mvn clean install `` under running-information-service-analysis directory. After going into target directory, 

    $java -jar running-information-analysis-service-1.0.0.BUILD-SNAPSHOT.jar
    
And Tomcat will started on port 8080.

## Test

Start MySQL server or connect to a MySQL server instance using Docker:

    $ docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:tag
    $ docker run -it --link some-mysql:mysql --rm mysql sh -c 'exec mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL_ENV_MYSQL_ROOT_PASSWORD"'
    
Then create a database running_information_analysis_db_prod:

    mysql>create database running_information_analysis_db_prod;

Operation supported includes:

+ **POST**: on path localhost:8080/runningInfo

+ **GET**: on path localhost:8080/runningInfo

Parameters page and size required. The response are sorted by the health warning level of each record. For example, GET request

*localhost:8080/runningInfo/?page=0&size=10*

would return 

![GitHub](https://user-images.githubusercontent.com/32628944/31413809-27807102-ade9-11e7-98ec-4af0adcda33c.png)

+ **DELETE** (by runningId): on path localhost:8080/runningInfo/{runningId}

For example, DELETE request 

*localhost:8080/runningInfo/abc*

will delete the record whose runningId is abc. If no such record exists, then no record would be deleted.

## Built With
+ IntelliJ IDEA
+ Maven

## Author
Ke Wu - *Initial work*




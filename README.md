# p1 Furrukh Khan

This project builds upon the maven based Corona Data Tracker. It now receives data from all countries starting from 1st January 2021 till date. The project adds a layer of data caching through an additional server which handles the main source api and stores all the data against a particular date in a postgres db. This allows the application to handle each data retrieval against a date in a quicker fashion. 

## Technologies Used


```bash
Java Spring
PostgreSQl
Spring JPA
Spring Web Starter
HTML
```

## How to run


- Connect a postgresql server to GlobalCoronaApi. (only url, user, and  pass need to be changed in application.properties.)
- Run GlobalCoronaAPI application.
- Run Client application.
- Access the application at localhost:8081
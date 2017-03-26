# example-kue-docker-microservices
Demonstrates a simple setup with microservices using Docker

### Running the project
From the root directory, execute docker-compose up. Then you can browse to http://localhost:5678/numbers?count=5. You should see a list of five numbers from the fibonacci sequence and 5 prime numbers.

### Architecture
The project runs 3 microservices that are built on the Kue framework. One microservice computes prime numbers, another computes fibonacci numbers, while the third serves data from the other two via a REST API.

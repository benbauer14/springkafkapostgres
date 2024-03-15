# Spring Kafka Postgres Project

<img src="https://miro.medium.com/v2/resize:fit:640/format:webp/1*aRUnth2T7XPMwCpMHrjfyQ.png" width="25%">
<img src="https://www.inrhythm.com/wp-content/uploads/2022/12/1_X-eza7p0qwKoZhCZEHYIhQ.png" width="25%">
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Postgresql_elephant.svg/120px-Postgresql_elephant.svg.png" width="50">

---
Background:
This project is a simple example of how to use Spring Kafka and Postgres to create a simple message queue and update a database. The project contains both a Kafka producer and consumer. Using Postman, the producer sends a message to the Kafka topic, the consumer (Kafka listener) will consume the message and update the Postgres database for both the order status and the member balance. 
---



# Setup:
1. Download Kafka from https://kafka.apache.org/quickstart
2. Start Zookeeper and Kafka (running on port 9090)
3. Create a database in Postgres named "kafkapostgres" (port 5432)
4. Create a table in the database named "member" with the following columns:
    - id (serial)
    - first_name (text)
    - last_name (text)
    - member_id (int)
    - phone_number (int, optional)
    - balance (int)
5. Create another table in the database named "order" with the following columns:
    - id (serial) 
    - member_id (int)
    - status (text)
    - order_amount (int)
6. Start the Spring Boot application (port 8080)
7. Using postman, send a POST request to localhost:8080/user/create with the following JSON body:
    - {
        "id": null,
        "firstName": "John",
        "lastName": "Doe",
        "memberId": 123,
        "phoneNumber": 1234567890,
        "balance": 100
    } 
8. Using Postman, send a GET request to localhost:8080/user/getAll to see the user that was created.
9. Using postman, send a POST request to localhost:8080/order/create with the following JSON body:
   - {
       "id": null,
       "memberId": 1,
       "status": "CREATED",
       "orderAmount": 30
   }
10. Using Postman, send a GET request to localhost:8080/order/getAll to see the order that was created. In addition, the order status should change to "COMPLETED" and the user's balance should be updated to 70.



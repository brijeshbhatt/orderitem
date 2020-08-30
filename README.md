# Order Item Service

This is a spring boot based application.

## Build

Prerequisites:
 - Java must be install in system.
 - Maven must be present in system.

Run `mvn clean install` to build the project.

## Running the application

Process to start application:

   - Run OrderItemApplication.java from any IDE
    Or
   - java -jar  order-item-1.0-SNAPSHOT.jar

## Running API

- Create order item api call
```
curl --location --request POST 'http://localhost:8081/online/items' \
--header 'Content-Type: application/json' \
--data-raw '{
	"code": "Item-code-1",
	"name": "Item Name one",
	"quantity": 10

}'

```

- Get all existing order items api call
```
curl --location --request GET 'http://localhost:8081/online/items'
```

- Get particular order items api call
```
curl --location --request GET 'http://localhost:8081/online/items/2'
```


- Update order item api call
```
curl --location --request PUT 'http://localhost:8081/online/items' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 2,
    "code": "Item-code-1",
    "name": "Item Name one",
    "quantity": 12
}'

```


- Delete particular order items api call
```
curl --location --request DELETE 'http://localhost:8081/online/items/3'
```


# The Ultimate Testing Workshop Project

## Entities

The application has three main entities: `Product`, `Order`, and `User`.

### Product

The `Product` entity represents a product in the e-commerce system. It has the following attributes:

- `id`: unique identifier for the product (integer)
- `name`: name of the product (string)
- `description`: description of the product (string)
- `price`: price of the product (decimal)
- `inStock`: number of items in stock for the product (integer)

### Order

The `Order` entity represents an order in the e-commerce system. It has the following attributes:

- `id`: unique identifier for the order (integer)
- `date`: date when the order was placed (date)
- `total`: total price of the order (decimal)

### User

The `User` entity represents a user in the e-commerce system. It has the following attributes:

- `id`: unique identifier for the user (integer)
- `firstName`: first name of the user (string)
- `lastName`: last name of the user (string)
- `email`: email address of the user (string)
- `password`: password of the user (string)

## Functionality

### Product Management

The application allows the user to perform CRUD (Create, Read, Update, Delete) operations on the `Product` entity. The following endpoints should be available:

- `GET /api/products`: Get a list of all products
- `GET /api/products/{productId}`: Get a single product by ID
- `POST /api/products`: Create a new product
- `PUT /api/products/{productId}`: Update an existing product by ID
- `DELETE /api/products/{productId}`: Delete a product by ID

### Order Management

The application allows the user to perform CRUD operations on the `Order` entity. The following endpoints should be available:

- `GET /api/orders`: Get a list of all orders
- `GET /api/orders/{orderId}`: Get a single order by ID
- `POST /api/orders`: Create a new order
- `PUT /api/orders/{orderId}`: Update an existing order by ID
- `DELETE /api/orders/{orderId}`: Delete an order by ID

### User Management

The application allows the user to perform CRUD operations on the `User` entity. The following endpoints should be available:

- `GET /api/users`: Get a list of all users
- `GET /api/users/{userId}`: Get a single user by ID
- `POST /api/users`: Create a new user
- `PUT /api/users/{userId}`: Update an existing user by ID
- `DELETE /api/users/{userId}`: Delete a user by ID

## Database

The application uses a PostgreSQL database to persist the data. The database should have the following tables:

- `product`: table for the `Product` entity
- `order`: table for the `Order` entity
- `user`: table for the `User` entity

The application should use the JPA (Java Persistence API) for database access.

## Other Requirements

The application should be built using Maven and should be runnable using the `mvn spring-boot:run` command. The application should also be Dockerized, and a Docker container for the PostgreSQL database should be provided using the `


```shell
docker run --name ecommerce-workshop-db --rm -e POSTGRES_USER=ecommerce -e POSTGRES_PASSWORD=mysecretpassword -e POSTGRES_DB=ecommerce-workshop -p 5435:5432 -d postgres:15.2-alpine
```
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
- `product`: ordered product
- `quantity`: number of ordered products
- `orderDate`: date when the order was placed (date)
- `total`: total price of the order (decimal)
- `user`: User who submitted the order

### User

The `User` entity represents a user in the e-commerce system. It has the following attributes:

- `id`: unique identifier for the user (integer)
- `firstName`: first name of the user (string)
- `lastName`: last name of the user (string)
- `email`: email address of the user (string)
- `password`: password of the user (string)

## Functionality

### Product Management

The application allows the user to perform CRUD (Create, Read, Update, Delete) operations on the `Product` entity. The
following endpoints should be available:

- `GET /api/products`: Get a list of all products. The response should include an array of `Product` objects.
- `GET /api/product/{productId}`: Get a single product by ID. The response should include a single `Product` object.
- `POST /api/product`: Create a new product. The request body should include a `Product` object. The response should
  include the newly created `Product` object.
- `PUT /api/product/{productId}`: Update an existing product by ID. The request body should include a `Product` object.
  The response should include the updated `Product` object.
- `DELETE /api/product/{productId}`: Delete a product by ID. The response should include a message indicating that the
  product has been deleted.

### Order Management

The application allows the user to perform CRUD operations on the `Order` entity. The following endpoints should be
available:

- `GET /api/orders`: Get a list of all orders. The response should include an array of `Order` objects.
- `GET /api/order/{orderId}`: Get a single order by ID. The response should include a single `Order` object.
- `POST /api/order`: Create a new order. The request body should include an `Order`. The response should include the newly created `Order` object.
- `PUT /api/order/{orderId}`: Update an existing order by ID. The request body should include a `Order` object. The
  response should include the updated `Order` object.
- `DELETE /api/order/{orderId}`: Delete an order by ID. The response should include a message indicating that the order
  has been deleted.

Any changes to the order quantity is represented by the currently available product's quantity.

### User Management

The application allows the user to perform CRUD operations on the `User` entity. The following endpoints should be
available:+

- `GET /api/users`: Get a list of all users. The response should include an array of `User` objects.
- `GET /api/user/{id}`: Get a single user by ID. The response should include a single `User` object.
- `POST /api/user`: Create a new user. The request body should include a `User` object.

```shell
docker run --name ecommerce-workshop-db --rm -e POSTGRES_USER=ecommerce -e POSTGRES_PASSWORD=mysecretpassword -e POSTGRES_DB=ecommerce-workshop -p 5435:5432 -d postgres:15.2-alpine
```

You can try the application from Postman by importing the `ECommece Backend Testing Workshop.postman_collection.json` file,
and running requests manually.


## Tasks

### Write Unit tests for Product service

Some suggestions for test method names:
- `findAllShouldReturnWithOrderDaoResponse`
- `saveNewOrderShouldDecreaseProductInStock`
- `saveExistingOrderShouldDecreaseProductInStockOnlyWithTheDifference`
- `saveNewOrderShouldFailWhenLessProductsAreInStockThenOrdered`

[Background material](https://1kevinson.com/testing-service-spring-boot/)

### Write integration tests


### Write integration test with testcontainers
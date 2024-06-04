# Tinybeans Evaluation
NOTE: If you are on windows, make sure to clone the repo using `git clone git@github.com:tinybeanskids/tinybeans-backend-project.git --config core.autocrlf=input` to avoid issues starting up


## How to run it
This repo is setup using docker containers with docker-compose. To run it properly you will need 

- Docker VM installed on your machine
- Docker-Compose installed ( available via homebrew)

To start the app simply run the command 
```
docker-compose up --build
```

NOTE: ports 3306 & 8080 must be available for it to run

After startup you can test that Spring Boot is running by going to `http://localhost:8080/test`
and if opting to use react you can verify its up and running by going to `http://localhost:3000/`

Both projects have `hot reload` capability, saving and/or recompiling a class will cause the docker project to reload


## Solution

This repository is setup using the following technologies:

- Spring boot
- MySQL 5.7
- Java 11

## Project Structure

### Backend

- Spring Boot Application: Handles backend logic, including product listing, checkout, and order processing. 
- MySQL Database: Stores product and order data.
- Application Runners: For Initializing database.

### Frontend

- React: Provides the user interface for listing products, checking out, and displaying order confirmation.

### Backend Endpoints

- 'GET /items': Returns a list of products.
- 'POST /orders': Processes a checkout request For order and payment

### Frontend Routes

- '/': Product listing screen.
- '/cart': Product listing screen For Items in Cart.
- '/payment/success': Order success screen.
- '/payment/cancel': Order cancel screen.

## Screens

### Product Screen

Displays a list of products available for purchase. Users can click on a product to add it to their cart and proceed to checkout.

### Cart Screen

Shows the selected product and allows users to the purchase.

### Success Screen

Displays a confirmation message with the Order ID and payment reference after a successful transaction.


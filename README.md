Pizza Ordering JavaFX Application

This is a JavaFX-based application developed by Simranjeet Kaur for managing pizza orders. It supports CRUD operations, calculates the total bill with tax, and connects to a MySQL database. The project also includes JUnit tests for validation.

Technologies Used

Java 17

JavaFX

MySQL

JDBC

JUnit 5

FXML (optional)

Maven

Project Structure

PizzaOrderingApp/
├── src/main/java/com/example/pizza/
│   ├── Main.java
│   ├── PizzaOrder.java
│   ├── PizzaController.java
│   ├── PizzaOrderDAO.java
│   ├── DBConnection.java
│   ├── BillCalculator.java
│   ├── BillCalculatorTest.java
│
├── src/main/resources/com/example/pizza/
│   └── pizza_order.fxml
│
├── pom.xml
└── README.md

Features

JavaFX GUI with input fields for customer and order details

Checkboxes for pizza sizes (XL, L, M, S)

Number of toppings input

CRUD Operations (Create, Read, Update, Delete)

TableView to display all orders

Total Bill Calculation:

XL: $15.00

L: $12.00

M: $10.00

S: $8.00

Topping: $1.50 each

HST: 15%

JUnit Testing for bill calculation

MySQL database integration

Database Setup

Run the following SQL to set up the table:

CREATE DATABASE pizza_db;
USE pizza_db;

CREATE TABLE pizza_orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    mobile_number VARCHAR(20),
    pizza_size VARCHAR(5),
    number_of_toppings INT,
    total_bill DOUBLE
);

How to Run

Clone the project from GitHub

Import into your Java IDE (Eclipse, IntelliJ, etc.)

Set up your MySQL connection in DBConnection.java

Use Main.java to launch the application

JUnit Testing

BillCalculatorTest.java includes tests to validate the total bill calculation logic.

Documentation Includes

GUI layout screenshot

Database structure screenshot

Sample data screenshot

JUnit test result screenshot


Developed By

Simranjeet KaurStudent ID: 23099687 Date: 10 July 2025

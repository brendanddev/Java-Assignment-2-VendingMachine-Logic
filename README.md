# Vending Machine Simulation in Java

This repository contains a Java-based simulation of a break room containing two vending machines. The goal is to simulate user interaction with these vending machines, which each hold a specific type of product. The simulation focuses on object-oriented principles, such as encapsulation, instance variables, and methods, while adhering to the separation of the model and view.

## Overview

The project is divided into two main parts:

1. **Vending Machine Model**: The vending machine is responsible for tracking the product's name, price, quantity, current user credit, and the total money accumulated since activation. It interacts only through method calls and does not directly handle user input or output.
  
2. **Break Room Simulation (View)**: This is a text-based interface that allows a user to interact with two vending machines through a menu system. It processes user input, calls the vending machine methods, and displays the outcomes.

## Features

### Vending Machine (Model)
- **Product Tracking**: Each machine holds one type of product, with its name, price, and quantity tracked.
- **Coin Input**: The machine accepts loonies, toonies, quarters, dimes, and nickels. Coins are inserted one at a time, and no bills or pennies are accepted.
- **Vending**: Users can attempt to vend products from the machine, which succeeds if there is enough credit and sufficient stock. 
- **Credit Management**: Users can add credit to the machine, which keeps track of current unused credit and total earnings.
- **Coin Return**: There is a coin return option that gives back any unused credit to the user.
- **Encapsulation**: All instance variables are encapsulated with appropriate getter and setter methods.
- **ToString Method**: Provides a summary of the vending machine status, including the product name, quantity, price, current credit, and total earnings.

### Break Room Simulation (View)
- **Menu Interface**: A simple text-based menu allows the user to:
  - Enter coins into either vending machine
  - Vend a product from either machine
  - Get change back from the machine
  - Exit the break room
- **Interaction**: The view communicates with the vending machines solely through method calls and displays the results based on the machine's responses.

## Usage

1. Clone the repository and navigate to the project directory.
2. Compile the Java files.
3. Run the main class to simulate the break room interaction with two vending machines.

## Classes

- **VendingMachine**: Represents the vending machine model.
  - `setProductName(String name)`: Sets the product name.
  - `setPrice(double price)`: Sets the price of the product.
  - `setQuantity(int quantity)`: Sets the available quantity of the product.
  - `insertCoin(double amount)`: Inserts a coin into the machine and increases the user's credit.
  - `vend()`: Attempts to vend a product if enough credit is available.
  - `returnCredit()`: Returns any unused credit to the user.
  - `toString()`: Returns a summary of the machine's status.
  
- **BreakRoom**: The view that provides a text-based interface for interacting with the vending machines.
  - `main()`: Simulates the break room where users can interact with the vending machines.

## Requirements

- Java 8 or higher

## Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
2. Compile the Java files:
  javac *.java
3. Run the application:
  java BreakRoom

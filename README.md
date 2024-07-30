Daily Expenses Sharing Application Backend

Overview

The Daily Expenses Sharing Application backend is a Spring Boot-based RESTful service that allows users to manage their daily expenses and split them among participants using three different methods: equal amounts, exact amounts, and percentages. The application also provides features to manage user details, validate inputs, and generate downloadable balance sheets.

Features

User Management

Create user
Retrieve user details
Expense Management

Add expense

Retrieve individual user expenses
Retrieve overall expenses
Download balance sheet

Technologies Used

Java
Spring Boot
MongoDB
Maven

Requirements

JDK 11 or higher
Maven 3.6.3 or higher
MongoDB 4.0 or higher


Setup and Installation

Clone the Repository

bash

Copy code

git clone https://github.com/Tarun6468/DailyExpensesSharingApplication.git

cd DailyExpensesSharingApplication

Configure MongoDB

Ensure MongoDB is running and accessible at the default port (27017). If MongoDB is running on a different host or port, update the application properties accordingly.

Build the Project

bash
Copy code

mvn clean install

Run the Application

bash
Copy code
mvn spring-boot:run

The application will start on http://localhost:8080.

API Endpoints
User Endpoints
Create User

bash
Copy code
POST /api/users
Request Body:

json

Copy code
{
  "email": "user@example.com",
  "name": "John Doe",
  "mobileNumber": "1234567890"
}

Retrieve User Details

bash

Copy code
GET /api/users/{userId}


Expense Endpoints
Add Expense

bash

Copy code
POST /api/expenses
Request Body:

json

Copy code
{
  "description": "Dinner at restaurant",
  "totalAmount": 3000,
  "splitMethod": "equal", // or "exact", "percentage"
  "participants": ["user1", "user2", "user3"],
  "exactAmounts": {
    "user1": 1000,
    "user2": 1000,
    "user3": 1000
  }, // Optional, required for "exact" split method
  "percentages": {
    "user1": 33.33,
    "user2": 33.33,
    "user3": 33.34
  } // Optional, required for "percentage" split method
}

Retrieve Individual User Expenses

sql

Copy code
GET /api/expenses/user/{userId}
Retrieve Overall Expenses

bash

Copy code
GET /api/expenses

Download Balance Sheet

bash
Copy code

GET /api/expenses/balance-sheet

Data Validation

Equal Split: No additional validation is required.
Exact Amounts: The sum of exact amounts must be equal to the total amount.
Percentage Amounts: The sum of percentages must add up to 100%.
Error Handling
The application includes comprehensive error handling to provide meaningful error messages for invalid inputs and other exceptional cases.

Documentation

Code Comments: The codebase includes clear and concise comments to explain the functionality and logic.
API Documentation: The above API endpoints are documented with example requests and responses.
Evaluation Criteria
Correctness: Functionality meets the requirements.
Code Quality: Code is clean, readable, and maintainable.
Documentation: Clear and comprehensive documentation.
Innovation: Creative and efficient solutions.

Bonus Points

Implemented user authentication and authorization.
Included error handling and input validation.
Optimized performance for large datasets.
Added unit and integration tests.

Contributing

Feel free to submit issues or pull requests. For major changes, please open an issue first to discuss what you would like to change.

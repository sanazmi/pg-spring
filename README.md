# Password Generator API

Overview
This project is a Password Generator API that provides a backend service for generating random passwords with customizable settings. 
The API allows users to specify the desired length of the password and whether to include special characters in the generated password.

The project is built using Spring Boot and utilizes CORS configuration to allow cross-origin requests from both local and production environments.

# Features
- Generate random passwords with user-defined length and inclusion of special characters.
- CORS support for secure and flexible integration with local and production frontend applications.
- Responsive and easy-to-use API for frontend applications to integrate seamlessly.
  
# API Endpoint
URL: https://pg-spring-production.up.railway.app/
Method: GET

# Query Parameters:
length: The desired length of the generated password (integer).
includeSpecialCharacters: A boolean to decide whether to include special characters (true/false).

# Setup and Installation
Requirements : 
JDK 17+
Maven

# Frontend Integration
The API can be integrated with a frontend application by calling the Link (mentioned Above)  and providing the required query parameters. 
The frontend should handle the response and display the generated password to the user.

CORS Configuration
The API includes CORS support for cross-origin requests.
The CORS settings enable support for cookies, authentication headers, and allow all HTTP methods and headers.

# Result
![image](https://github.com/user-attachments/assets/101c9c3b-7514-4d30-83d2-6d6ea3a0912c)


Here’s a basic structure for your `README.md` file. It covers the purpose of the project, setup instructions, and details for running the Flask API as well as the Spring Boot component.

---

# Mobile Price Classification System

This project involves building a **Devices Price Classification System** using **Python** and **Spring Boot**. It provides a machine learning model to predict device price ranges based on device specifications and a RESTful API to interface with the model.

## Table of Contents
- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Architecture](#architecture)
- [Setup Instructions](#setup-instructions)
  - [Python (Flask API)](#python-flask-api-setup)
  - [Spring Boot (Java API)](#spring-boot-setup)
- [Running the Project](#running-the-project)
- [API Endpoints](#api-endpoints)
  - [Flask API](#flask-api-endpoints)
  - [Spring Boot API](#spring-boot-api-endpoints)
- [Testing](#testing)
- [Future Improvements](#future-improvements)

## Project Overview
This project is designed to predict the price range of devices based on various specifications like battery power, RAM, and pixel density using a **Support Vector Classifier (SVC)**. The backend is composed of:
- **Python Flask API**: Serving machine learning predictions.
- **Spring Boot API**: Managing device data and calling the Python API for predictions.

## Technologies Used
- **Python**: Core language for machine learning and data processing.
- **Flask**: Python framework for serving the ML model as an API.
- **Scikit-learn**: Machine learning model used for classification (SVC).
- **Pandas & NumPy**: For data manipulation and preprocessing.
- **Spring Boot**: Java framework for building a RESTful API.
- **Maven**: For managing Spring Boot project dependencies.
- **Git**: Version control system.

## Architecture
1. **Python Flask API**: Handles the machine learning model, processes input device specifications, and returns predicted price ranges.
2. **Spring Boot API**: Provides endpoints for managing devices, fetching device details, and retrieving predictions by calling the Flask API.

## Setup Instructions

### Python (Flask API) Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repo/devices-price-classification.git
   cd devices-price-classification
   ```

2. **Set Up Python Environment**:
   - Create a virtual environment:
     ```bash
     python -m venv venv
     source venv/bin/activate  # On Windows: venv\Scripts\activate
     ```
   - Install dependencies:
     ```bash
     pip install -r requirements.txt
     ```

3. **Train or Load the Model**:
   - If you have the trained model, load it from the provided file (`svc_model.pkl`).
   - To train the model, run the Python script to train and save the model.

4. **Run the Flask API**:
   ```bash
   flask run
   ```

### Spring Boot Setup

1. **Navigate to the Spring Boot Directory**:
   ```bash
   cd demo
   ```

2. **Build and Run**:
   - Use Maven to build and run the Spring Boot application:
     ```bash
     mvn clean install
     mvn spring-boot:run
     ```

## Running the Project

- **Flask API**: Once the Python Flask app is running, it will be accessible at `http://127.0.0.1:5000/`.
- **Spring Boot API**: The Spring Boot API will be accessible at `http://localhost:8080/`.

## API Endpoints

### Flask API Endpoints

1. **Predict Device Price**: 
   - **Endpoint**: `/predict`
   - **Method**: `POST`
   - **Description**: Sends device specifications to the Flask API and returns the predicted price range.
   - **Request Body** (JSON example):
     ```json
     {
       "battery_power": 5000,
       "px_height": 1080,
       "px_width": 1920,
       "ram": 2048
     }
     ```
   - **Response** (JSON example):
     ```json
     {
       "predicted_price": 2
     }
     ```

### Spring Boot API Endpoints

1. **Get All Devices**:
   - **Endpoint**: `/api/devices`
   - **Method**: `GET`
   - **Description**: Retrieves all devices in the system.

2. **Get Device by ID**:
   - **Endpoint**: `/api/devices/{id}`
   - **Method**: `GET`
   - **Description**: Retrieves the device details by ID.

3. **Add New Device**:
   - **Endpoint**: `/api/devices`
   - **Method**: `POST`
   - **Description**: Adds a new device to the system.

4. **Predict Price for a Device**:
   - **Endpoint**: `/api/predict/{deviceId}`
   - **Method**: `POST`
   - **Description**: Calls the Flask API to predict the price range for a given device and stores the result.

## Testing

### Python Unit Testing
To test the Python Flask API, you can use `unittest` or `pytest`. Run the tests by executing:
```bash
python -m unittest discover
```

### Spring Boot Testing
To run tests in Spring Boot, use Maven:
```bash
mvn test
```

## Future Improvements
- Implement caching for model predictions to improve response times.
- Integrate a database (e.g., MySQL) to persist device data and prediction results.
- Extend the model to handle more complex device specifications.

---

This `README.md` gives an overview of the project, how to set it up, and the API endpoints available. Make sure to customize it with your actual GitHub link and any additional project-specific details.

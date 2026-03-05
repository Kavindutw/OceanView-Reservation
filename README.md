# Ocean View Resort Reservation System

A **Java EE web-based room reservation management system** developed for **Ocean View Resort**, a beachside hotel in Galle.
This system digitizes the manual reservation process to prevent booking conflicts, improve efficiency, and provide quick access to guest booking information.

The application allows staff members to securely log in, manage reservations, calculate guest bills, and retrieve reservation details through a user-friendly web interface.

---

# Project Overview

Ocean View Resort previously managed room reservations manually, which caused:

* Booking conflicts
* Data entry errors
* Slow reservation retrieval
* Inefficient billing processes

This system introduces a **computerized reservation management solution** built using **Java EE technologies with MySQL database integration**.

---

# System Features

### 1. User Authentication

Secure login system for staff members using username and password.

### 2. Add New Reservation

Staff can create reservations by entering:

* Reservation Number
* Guest Name
* Address
* Contact Number
* Room Type
* Check-in Date
* Check-out Date

### 3. Display Reservation Details

Search and retrieve full reservation details using the reservation number.

### 4. Calculate and Print Bill

Automatically calculates the total cost based on:

* Room type price
* Number of nights stayed

### 5. Delete Reservation

Allows staff to remove reservation records when necessary.

### 6. Help Section

Provides instructions for new staff members on how to use the system.

### 7. Logout / Exit System

Securely logs out users from the system.

---

# System Architecture

The application follows the **MVC (Model-View-Controller) architecture**.

### Model

Represents system data.

Examples:

* User
* Reservation
* RoomType

### View

User interface developed using **JSP and Bootstrap**.

Examples:

* login.jsp
* dashboard.jsp
* reservation-add.jsp
* reservation-view.jsp
* bill.jsp

### Controller

Handles user requests using **Java Servlets**.

Examples:

* LoginServlet
* AddReservationServlet
* ViewReservationServlet
* DeleteReservationServlet
* BillServlet

### Service Layer

Contains business logic.

Examples:

* ReservationService
* BillingService
* AuthService

### DAO Layer

Handles database operations.

Examples:

* ReservationDao
* UserDao
* RoomTypeDao

---

# Technologies Used

| Technology             | Purpose                 |
| ---------------------- | ----------------------- |
| Java EE 8              | Backend development     |
| Servlets               | Controller layer        |
| JSP                    | Frontend pages          |
| Bootstrap              | User interface styling  |
| MySQL                  | Database management     |
| JDBC                   | Database connectivity   |
| Maven                  | Dependency management   |
| IntelliJ IDEA Ultimate | Development environment |
| GitHub                 | Version control         |

---

# Project Structure

```
OceanView-Reservation-JavaEE
│
├── src/main/java/com/example/oceanviewreservation
│   ├── api
│   ├── config
│   ├── dao
│   ├── model
│   ├── service
│   ├── util
│   └── web
│        ├── servlet
│        └── filter
│
├── src/main/resources
│   └── db
│        └── schema.sql
│
├── src/main/webapp
│   ├── css
│   ├── login.jsp
│   ├── dashboard.jsp
│   ├── reservation-add.jsp
│   ├── reservation-view.jsp
│   ├── bill.jsp
│   └── help.jsp
│
└── pom.xml
```

---

# Database Structure

### users

Stores login credentials.

| Column        | Description        |
| ------------- | ------------------ |
| id            | User ID            |
| username      | Login username     |
| password_hash | Encrypted password |
| role          | User role          |

---

### reservations

Stores guest booking details.

| Column         | Description               |
| -------------- | ------------------------- |
| reservation_no | Unique reservation number |
| guest_name     | Guest full name           |
| address        | Guest address             |
| contact_number | Phone number              |
| room_type_code | Room category             |
| check_in       | Check-in date             |
| check_out      | Check-out date            |

---

### room_types

Stores room types and rates.

| Column         | Description     |
| -------------- | --------------- |
| code           | Room type code  |
| name           | Room name       |
| rate_per_night | Price per night |

---

# Installation Guide

### 1. Clone Repository

```bash
git clone https://github.com/Kavindutw/OceanView-Reservation.git
```

---

### 2. Configure Database

Create MySQL database:

```
oceanview_db
```

Run the SQL script:

```
src/main/resources/db/schema.sql
```

---

### 3. Update Database Configuration

Modify database credentials in:

```
src/main/java/com/example/oceanviewreservation/config/Db.java
```

Example:

```java
private static final String USER = "root";
private static final String PASS = "yourpassword";
```

---

### 4. Run Application

Deploy the project using:

* **Apache Tomcat**
* **Payara Server**
* **GlassFish Server**

Then open:

```
http://localhost:8080/oceanview/login
```

---

# Default Login

```
Username: admin
Password: admin123
```

---

# REST API Example

Retrieve reservation details:

```
GET
http://localhost:8080/oceanview/api/reservations/{reservationNo}
```

Example:

```
http://localhost:8080/oceanview/api/reservations/R-1001
```

---

# Future Improvements

Possible future system enhancements:

* Online reservation portal for customers
* Payment gateway integration
* Room availability tracking
* Email confirmation system
* Reservation editing functionality
* Advanced reporting dashboard

---

# Author

**Kavindu Wijesinghe**

Final Year Academic Project
Java EE Web Application Development

---

# License

This project is developed for **academic purposes** as part of a university coursework assignment.

---


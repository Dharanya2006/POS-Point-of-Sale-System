# POS Transaction Management System

## 🔹 Description
- A Java-based web application to manage Point of Sale (POS) transactions
- Developed using Servlets, JSP, JDBC, and Oracle Database
- Runs on Apache Tomcat 11 (Jakarta EE)
- Follows MVC and layered architecture

---

## 🔹 Key Functionalities
- Add new transaction details
- Automatically generate transaction ID
- View a single transaction by customer name and date
- View all transactions stored in the database
- Validate user inputs
- Display proper success and error messages

---

## 🔹 Technologies & Tools
- Java (JDK 17+)
- JSP & Servlets (Jakarta EE)
- Apache Tomcat 11
- Oracle Database (XE)
- JDBC
- JSTL 3.x
- HTML

---

## 🔹 Project Modules
- **Bean Layer**
  - Stores transaction details using `PosBean`
- **DAO Layer**
  - Handles database operations (insert, fetch, fetch all)
- **Service Layer**
  - Contains business logic and validations
- **Servlet Layer**
  - Acts as controller between JSP and backend
- **JSP Pages**
  - User interface for add, view, and display transactions

---

## 🔹 Database Structure
- Table Name: `POS_TB`
- Stores transaction ID, customer name, item name, date, quantity, price, total amount, and remarks
- Sequence `POS_SEQ` used for transaction ID generation

---

## 🔹 Application Pages
- Menu Page
- Add Transaction Page
- View Transaction Page
- View All Transactions Page
- Success Page
- Error Page

---

## 🔹 How the Application Works
- User selects an option from the main menu
- Inputs are validated in servlet and service layers
- Data is stored and retrieved from Oracle database
- Results are displayed using JSP and JSTL

---

## 🔹 How to Run
- Install JDK and Tomcat 11
- Create Oracle database and required table
- Configure database credentials in `DBUtil.java`
- Add JSTL 3.x dependency or jar file
- Deploy project on Tomcat server
- Access application through browser

---

## 🔹 Advantages
- Simple and user-friendly interface
- Proper separation of layers
- Secure database handling
- Easy to maintain and extend

---

## 🔹 Learning Outcome
- Practical understanding of Java web applications
- Hands-on experience with Servlets and JSP
- Working with Oracle database using JDBC
- Using JSTL with Tomcat 11
- Implementing MVC architecture


## 🔹 Purpose
- Academic project
- Learning-based implementation

- Outputs:
-<img width="1597" height="265" alt="image" src="https://github.com/user-attachments/assets/91f1c39a-413b-4510-b03d-0bdd25a874ce" />
<img width="874" height="521" alt="image" src="https://github.com/user-attachments/assets/441ccbef-d160-4958-9abe-f0de708f0ab2" />
<img width="659" height="216" alt="image" src="https://github.com/user-attachments/assets/c2141298-7b4e-4c30-ad0e-883e0627cd9f" />
<img width="710" height="315" alt="image" src="https://github.com/user-attachments/assets/c0ff5324-9907-44c2-bfb8-457b4750e029" />
<img width="691" height="523" alt="image" src="https://github.com/user-attachments/assets/24343b04-a5e5-40e0-a20c-71bf86239849" />
<img width="707" height="213" alt="image" src="https://github.com/user-attachments/assets/365501e6-474e-4e97-baae-bc763de45de5" />
<img width="1100" height="442" alt="image" src="https://github.com/user-attachments/assets/3c2ee9bd-8f27-4b3d-a4d3-a052a9db43da" />



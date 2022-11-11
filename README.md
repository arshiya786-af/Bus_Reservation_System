# iBus  REST API for Bus Reservation System Portal 
<img  src="https://media1.giphy.com/media/j375yFxei6JtEcDA65/giphy.gif?cid=6c09b952j6fzqoryrmfw9um982tnnvbg9v3wmxffm828lkol&rid=giphy.gif&ct=s" width="85%" height="377px" /><img align="right"  src="https://user-images.githubusercontent.com/100846744/200823463-827828d9-f686-4bc4-a9d5-eb1df69472e7.png"/>

* We have developed this REST API for a Bus Reservation System Portal Application. This API performs all the fundamental CRUD operations of any Bus Reservation Application platform with user validation at every step.
* This project is developed by team of 5 Back-end Developers during project week in Masai School. 
## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL

## Modules

* Login, Logout Module
* Admin Module
* User Module
* Route Module
* Bus Module
* Reservation Module
* Feedback Module

## Features

* User and Admin authentication & validation with session uuid.
* Admin Features:
    * Administrator Role of the entire application
    * Only registered admins with valid session token can add/update/delete route and bus from main database
    * Admin can access the details of different users and reservations.
* User Features:
    * Registering themselves with application, and logging in to get the valid session token
    * Viewing list of available buses and booking a reservation
    * Only logged in user can access his reservations, profile updation and other features.

## Contributors

* [@Arshiya](https://github.com/arshiya786-af)
* [@Mohammad](https://github.com/ahtishamkhan5678)
* [@Lalit Singh](https://github.com/lalitsingh28)
* [@Lakhan](https://github.com/lakhan1122)
* [@Para Aghi](https://github.com/PARAS-AGHI)

## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](https://github.com/arshiya786-af/afraid-stew-8500/tree/main/BusReservationSystemPortal/src/main/resources) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/ibusdb
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

## API Root Endpoint

`https://localhost:8888/`

`http://localhost:8888/swagger-ui/`


## API Module Endpoints

### Login Module

* `POST //login/admin` : Admin can login with mobile number and password provided at the time of registation
<!--
### User Module


* `POST /customer/login` : Logging in customer with valid mobile number & password
* `GET /customer/availablecabs` : Getting the list of all the available cabs
* `GET /customers/cabs` : Getting All the cabs
* `GET /customers/checkhistory` : Getting the history of completed tr
* `PUT /customer/update/{mobile}` : Updates customer details based on mobile number
* `PATCH /customer/updatepassword/{mobile}` : Updates customer's password based on the given mobile number
* `POST /customer/booktrip` : Customer can book a cab
* `POST /customer/updatetrip` : Customer can modify or update the trip
* `POST /customer/logout` : Logging out customer based on session token
* `DELETE /customer/delete` : Deletes logged in user 
* `DELETE /customer/complete/{tripid}` : Completed the trip with the given tripid 
* `DELETE /customer/canceltrip` : Cancel the trip with the given tripid   


### Admin Module

* `POST /admin/register` : Register a new admin with proper data validation and admin session
* `POST /admin/login` : Admin can login with mobile number and password provided at the time of registation
* `GET /admin/logout` : Logging out admin based on session token
* `GET /admin/listoftripsbycustomer` : Get list of trips of by a customer id
* `GET /admin/listoftrips` : Get list of trips of all the trips
* `GET /admin/listocustomers` : Get list of all the customers
* `GET /admin/listodrivers` : Get list of all the drivers
* `PUT /admin/update/{username}` : Updates admin detaisl by passed user name
* `DELETE /admin/delete` : Deletes the admin with passed id   -->


### Sample API Response for Admin Login

`POST   localhost:8888/login/admin`

* Sample Request Body

```
    {
        "mobileNo": "8891067909",
        "password": "Moarpllme@007"
    }
```

* Sample Response Body

```
   CurrentAdminSession( adminId=1, uuid=uUcWXg,localDatetime=2022-11-11 12:29:52.376508)
   
```

### Swagger UI

---
### User and User Login Controller

---
![Screenshot (291)](https://user-images.githubusercontent.com/100846744/201393329-4ca0173c-b6fe-46f9-afe0-a977f096687f.png)


![Screenshot (292)](https://user-images.githubusercontent.com/100846744/201393274-7d2f08c6-2fbe-47d2-af20-e85f0cc6482b.png)

---

### Admin and Admin Login Controller

---
![Screenshot (290)](https://user-images.githubusercontent.com/100846744/201393426-bdee2b71-4b89-47c2-b60a-969464088294.png)
![Screenshot (285)](https://user-images.githubusercontent.com/100846744/201393509-babcc11c-8501-4ad9-b8a7-30a5a67615a9.png)

---

### Bus Controller

---


![Screenshot (286)](https://user-images.githubusercontent.com/100846744/201393212-9f8d839e-a6cd-4d9e-aac3-7cd975d04675.png)

---

### Reservation Controller

---


![Screenshot (288)](https://user-images.githubusercontent.com/100846744/201393110-68855185-f04d-4bb8-9af1-9f69bb2ecf5d.png)

---

### Route Controller

---

![Screenshot (289)](https://user-images.githubusercontent.com/100846744/201393162-8a30069f-039a-4010-9fe9-3864452545a6.png)


---

### Feedback Controller

---


![Screenshot (287)](https://user-images.githubusercontent.com/100846744/201393007-95a20ad5-1816-4dc6-8d9c-2ff41c22c450.png)

---


<img  align="center" src="https://readme-typing-svg.herokuapp.com?font=Architects+Daughter&amp;color=FF5733&amp;size=20&amp;lines=Thanks!+For+Visiting+On+My+Project!;See+You+Next-Time+Hope+u+like+its...👨🏻‍💻;" style="width: 70%;">

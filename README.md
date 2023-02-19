# E-commerce_Api
Create E-commerce api
# E_commerce Api

In this project we build e-commerce api.Int his projet there is 4 models(user,order,product,adress) and we performe some operations like create user,adrees,product,(placed) order. In this project we use join colomn Annotation which connect two tables based on foregn key which we dicide.

# framework and languges 
* Springboot framework is used
* Java is Used for code
# Dependencies
* Springboot dev tools
* lombok
* sping web 
* h2 databse
* spring data jpa

# Data flows

* UI(postman or localhost 8080 made requests)

# 1 Cotroller
* Cotroller -> requestcome from ui and  execute mathod in cotroller based on end points. In controller various mathods are available Ex

->create user : http://localhost:8080/saveuser

->create product: http://localhost:8080/saveproduct

->create address : http://localhost:8080/saveadress

->create order: http://localhost:8080/saveorder

* used requestparams

->getuser by user id: http://localhost:8080/getuser

->getproduct by category:  http://localhost:8080/getallproduct?category=.electronics

->get order by orderid :  http://localhost:8080/getorder



* form controller service methods are call where our main buisness logic is wriiten

# 2 service

* the methods are called and its get data from databse with help of repository layer

# 3 Repository
repository layes is help to connect with database

# used databse
->H2

# data Structure
->  ArrayList


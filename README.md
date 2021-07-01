# SalernoFoodShop_WebApp

---

#### > about

Web Application designed and developed using Java/Spring technologies. 

The project follows the **MVC** {Model-View-Controller} model/pattern. 

The Application is related to Food Shop World, but they are based on a limited number of entities. 

At the startup, Spring calls **population** services to populate the Database using the **Spring Context**.

The project is a **SpringBoot** project, so most of the Configurations are provided by default.

---

#### > run app

In my case, using Spring Tool Suit, to run my app I open it and
```
  right click on project + run as Spring Boot App
```
Another way is to launch from command line
```
  mvn spring-boot:run
```
where the *project* is located (into the project folder)

---

#### > technologies, libraries & representations

- [ ] Java 11     
- [ ] JPA
- [ ] Thymeleaf
- [ ] HTML & CSS
- [ ] H2 database
- [ ] Spring Web Modules
- [ ] Tomcat (provided by SpringBoot)

---
#### > entities/models 

- [ ] Foodstuff
- [ ] Item

#### > persistence & repository 

Persistence is represented by the in-memory database called H2 Database.

Classes which implements JPA interfaces have the **DAO** at the end of the name and they allow access to data.

**DAO** stands for Data-Access-Object.

In addition, there are also functionalities related to **Foreign Key** and **external relations** (e.g. **OneToOne|OneToMany|ManyToOne**).

![image](https://user-images.githubusercontent.com/45211249/124113164-696c6780-da6b-11eb-8061-a26a96831d85.png)


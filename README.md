<div id="top"></div>


[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]


<br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="https://github.com/Ranajaafar/Bank-Management-System/assets/110610925/440c9a4f-7894-4d84-bfd2-4ccec41d48a8" alt="Logo" width="80" height="80">
  </a>
  <h3 align="center">README for <b> Bank-Management-System </b> </h3>
 </div> 


# Technologies

<img src="https://img.shields.io/badge/-SPRING-00f000?logo=Spring&logoColor=fff" />   <img src="https://img.shields.io/badge/-PostgreSQL-007fff?logo=POSTGRESQL&logoColor=0ff" />   <img src="https://img.shields.io/badge/-Gradle-000000?logo=GRADLE&logoColor=fff" />      <img src="https://img.shields.io/badge/-Lombok-5F259F?logo=LOMBOK&logoColor=fff" />    <img src="https://img.shields.io/badge/-Spring%20Data%20JPA-19A974?logo=&logoColor=fff" />     <img src="https://img.shields.io/badge/-JDBC-FC4C02?logo=&logoColor=fff" />  

# About The Project
this project implemented after 3 days of learning Spring boot framework.
I have built 6 API (rest endpoint) for user that sends an HTTP request and will be returned with an HTTP response 
this small project built to manage the flow of a bank 
  - The user should be able to issue a card
  - The User can get a card by sending a post request with the PAN(16 digits number), CVV(3 digits secret) and expiry date(MM/yy), Only retrieve the card details when these are met
  - the user can Transfer money to somebody else's card on the same system
  - This API adds an amount to a card, the value can be negative so the amount will decrease. So withdrawal or deposit How do i install the project </h2>

# Instalation

<h3> <b> Requirements: </b> </h3>

 you are in need for those software:<br/>
    1 **PostgreSql** <br/>
    2 **JDK 17**  
    3 **Intellij IDEA (IDE)**  
    4 **Gradle**
    
 Note: make sure that no process is running behind on port 8080 if there is, you have to kill it or change the port     
<h3> steps: </h3>
this is an example of how you can instruct your audience on installing and setting up your app

  1. download the above requirements please don't forget to setup the system environment variables
  2. download the project from github to your desktop by cloning it
     
   ```sh
     git clone https://github.com/Ranajaafar/Bank-Management-System.git
   ```
  3. open the project in intellij idea
  4. this Step you must do it to make the application work properly :
     access `src/main/resources/application.properties` and change spring.datasource.username and spring.datasource.password <a href="https://github.com/Ranajaafar/Bank-Management-System/blob/master/src/main/resources/application.properties" target=blank >DataBase connection</a>

~~~~~~~~~~~
 ##connection string
spring.datasource.url=jdbc:postgresql://localhost:5432/Bank
spring.datasource.username=postgres
spring.datasource.password=123
spring.jpa.show-sql=true

## Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database(platform)
spring.jpa.properties.hibernate.t = org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto=update

 ~~~~~~~~~~~
   5. finally you can run the project. now we have a Tomcat web server up and running on port 8080 listenning for request
   6. in the browser access localhost:8080


 
Please feel free to fork this repository and clone it



# 📬 Contact

If you want to contact me or you have any question you can reach me through below handles.

<div align="center">

<a  href="https://www.linkedin.com/in/rana-jaafar/" target="_blank"><img alt="LinkedIn" src="https://img.shields.io/badge/linkedin%20-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white" /></a>
<a href="mailto:jaafarrana220@gmail.com"><img  alt="Gmail" src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" />

</div>
<p align="right">(<a href="#top">back to top</a>)</p>






<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
 [contributors-shield]: https://img.shields.io/github/contributors/Ranajaafar/Bank-Management-System.svg?style=for-the-badge
[contributors-url]: https://github.com/Ranajaafar/Bank-Management-System/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Ranajaafar/Bank-Management-System.svg?style=for-the-badge
[forks-url]: https://github.com/Ranajaafar/Bank-Management-System/network/members
[stars-shield]: https://img.shields.io/github/stars/Ranajaafar/Bank-Management-System.svg?style=for-the-badge
[stars-url]: https://github.com/Ranajaafar/Bank-Management-System/stargazers
[issues-shield]: https://img.shields.io/github/issues/Ranajaafar/Bank-Management-System?style=for-the-badge
[issues-url]: https://github.com/Ranajaafar/Bank-Management-System/issues

 



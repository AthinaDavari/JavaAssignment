# JavaAssignment
Assignment for 3rd semester course "Programming 2" <br />
Department of Management Science and Technology <br />
Athens University of Economics and Business

## Description
This application is a potential module of an ERP system of an industrial company. Employees can monitor and manage raw materials and ready products' stock, record and update their customers and suppliers' data as well as orders from and to them. They can also get notified about lack of products or ingredients. Application supports 2 roles-simple user and administrator. More information about the program's functions can be found at user's manual. 

## Tools
* [Maven](https://maven.apache.org/) - Dependency Management and Project Building
* [MySQL 8](https://www.mysql.com/) - Database Server
* [JDBC](https://www.oracle.com/technetwork/java/javase/tech/index-jsp-136101.html) - API for Java Connectivity
* [Java Swing](https://docs.oracle.com/javase/tutorial/uiswing/index.html) - GUI Toolkit
* [JUnit 4](https://junit.org/junit4/) - Testing Framework
* [Javadoc](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html) - Documentation Generator

## Prerequisites
* Java 8 or newer
* MySQL server
* Maven

## Instructions
#### Database
Run both [erp_progII.sql](https://github.com/AthinaDavari/JavaAssignment/blob/master/erp_progII.sql) and [erp_progIITest.sql](https://github.com/AthinaDavari/JavaAssignment/blob/master/erp_progIITest.sql) at a MySQL server
#### Application
Enter your own credentials in order to connect to database. Open both <b>proderp\src\main\java\gr\aueb\dmst\pijavaparty\proderp\dao\Dao.java</b> and <b>proderp\src\test\java\gr\aueb\dmst\pijavaparty\proderp\dao\DaoTest.java</b> type them at username and password.
#### Installation
To install the project from command line use 
```bash
mvn clean compile assembly:single
```
and then enter the project folder and run 
```bash
java -jar target\proderp-1.0-SNAPSHOT-jar-with-dependencies.jar
```
After the .jar file is created you can just enter target folder and double click it.
#### Testing
To run tests use
```bash
mvn test
```
## Authors
| Full Name | Github Account |
| --- | --- |
| Davari Athina (Team Coordinator) | [AthinaDavari](https://github.com/AthinaDavari) |
| Katsiapi Natalia | [nataliaKat](https://github.com/AthinaDavari) |
| Kokkorou Maria | [mariakokkorou](https://github.com/mariakokkorou) |
| Koutsoumpa Styliani Aikaterini | [Stella-Koutsoumpa](https://github.com/Stella-Koutsoumpa) |
| Pantazopoulou Athina | [AthinaPantazopoulou](https://github.com/AthinaPantazopoulou) |
| Papakonstantinou Aggeliki | [AggelikiPapa](https://github.com/AggelikiPapa) |
| Shambel Anna | [AnnaShambel3](https://github.com/AnnaShambel3) ||

![Proderp logo](https://github.com/AthinaDavari/JavaAssignment/blob/master/proderp/src/main/resources/ProdErp_Logo.png)

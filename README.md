# G7_ComputerNetworkProject

- This is a project in the course Data Communication and Network Programming at NTNU Ålesund.
- Our goal is to get sensor data from MQTT, and visualize it on a website.

## Table of content overview:

The following is the table content overview:
- [Preparation](#preparation)
- [Installation and running the project](#installation-and-running-the-project)
- [Credits](#credits)
- [License](#license)

## Preparation
1. Install MySQL (optional)


2. Edit the `application.properties` file if you are planning on using another database than MySQL (would recommend to go through either ways) :


3. change the `server port` to whatever you want. (recommended: 8443 for https)
```
server.port=
```
4. Change the `url` to the desired database.
```
spring.datasource.url=jdbc:mysql://localhost:3306/computer_networks
```
5. Change the `username` and `password` for the selcted database(may not be required for some databases).
```
spring.datasource.username=
spring.datasource.password=
```
6. Change the dialect to the selected database type.
```
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
```
---

## Credits

We would like to give credits to NTNU Ålesund for this assignment.

Collaborators:
- https://github.com/TobiasGrav
- https://github.com/EdvinAstad
- https://github.com/Jonas-Nedreberg-Kalstad
- https://github.com/Fereshtaha

Some sources we used for this project:
- https://github.com/strazdinsg/datakomm-tools

---
## License

This project is licenced by the © group 7 in the course [Computer Networks and Data Communcation](https://www.ntnu.no/studier/emner/IDATA2304) at Norwegian University of Science and Technology (NTNU).

---

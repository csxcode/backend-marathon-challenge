# Backend Marathon Challenge 🔥

This code was developed in order to do the challenge for marathon company using spring boot (java) and sql as database.


## Installation

Please, like first step, check or change your sql connections from application.properties, currently these values are in this file:
```properties
spring.datasource.url=jdbc:sqlserver://DESKTOP-0I1IMTM\\SQLEXPRESS;databaseName=maraton_challenge;integratedSecurity=false;encrypt=true;trustServerCertificate=true
spring.datasource.username=developer
spring.datasource.password=developer
spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.SQLServer2012Dialect
spring.jpa.hibernate.ddl-auto= update
spring.data.web.pageable.one-indexed-parameters=false
server.servlet.context-path=/v1
sunat.url=http://wsruc.com/Ruc2WS_JSON.php
sunat.token=cXdlcnR5bGFtYXJja19zYUBob3RtYWlsLmNvbXF3ZXJ0eQ==
```

properties to change:
```properties
spring.datasource.url
spring.datasource.username
spring.datasource.password
```

Run app and then in any browser go to:

`http://localhost:8080/v1/persons`

All endpoints and request are in this postman: 
https://documenter.getpostman.com/view/1268014/UVknuGkE




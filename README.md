mvn clean deploy

java -jar target/ab-testing-router-1.0.jar server configuration.yml
 
localhost:8080/route?id={clientId}


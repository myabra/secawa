mvn clean package
jetty:run-war -Dspring.profiles.active=standalone

http://localhost:8080/main
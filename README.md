download load docker desktop
*Create Docker File on src path in java project.
From openjdk:17:alpine
WORKDIR /opt
ENV port 8080
EXPOSE 8080
Copy target/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar  app.jar

*build image
docker build -t codedecode25/demoimageaug:0.0.1.

creating image sha created

image is created we need conatiner to run this image

*run container 
docker run -p 8080:8080 codedecode25/demoimageaug:0.0.1.
docker run -p 8080:8080 --name dockerdemo codedecode25/demoimageaug:0.0.1.

to compose multiple containers as springboot and mysl we need docker-compose yml file.

we will run docker compose file consist of 

version: '3.8'

services:
  app:
    image: your-java-service-image:latest
    container_name: java_service
    build:
      context: .
      dockerfile: Dockerfile
    ports:
      - "8080:8080"
    environment:
      - SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/your_database
      - SPRING_DATASOURCE_USERNAME=root
      - SPRING_DATASOURCE_PASSWORD=rootpassword
    depends_on:
      - db

  db:
    image: mysql:8.0
    container_name: mysql_db
    ports:
      - "3306:3306"
    environment:
      MYSQL_ROOT_PASSWORD: rootpassword
      MYSQL_DATABASE: your_database
    volumes:
      - db_data:/var/lib/mysql

volumes:
  db_data:





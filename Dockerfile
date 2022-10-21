FROM maven:3.8-openjdk-11 as build
WORKDIR /app
COPY . .
RUN mvn install

FROM openjdk:11docker
EXPOSE 8081
ADD app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
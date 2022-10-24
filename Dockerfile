FROM openjdk:11
EXPOSE 8082
ADD target/springprojet1.jar springprojet1.jar
ENTRYPOINT ["java","-jar","/springprojet1.jar"]
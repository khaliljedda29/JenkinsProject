FROM openjdk:11
EXPOSE 8082
ADD https://github.com/rchouda/JenkinsProject/tree/backend_AK/target .
ENTRYPOINT ["java","-jar","/devops-integration.jar"]

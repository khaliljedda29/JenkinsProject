FROM imagenarium/jdk-maven:17
EXPOSE 8082
ADD https://github.com/rchouda/JenkinsProject/tree/backend_YS/target .
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]

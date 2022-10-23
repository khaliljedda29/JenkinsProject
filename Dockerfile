FROM imagenarium/jdk-maven:17
EXPOSE 8082
COPY target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
ADD https://github.com/rchouda/JenkinsProject/tree/backend_YS/target .
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]

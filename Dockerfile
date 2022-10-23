FROM imagenarium/jdk-maven:17
EXPOSE 8082
COPY target/tpAchatProject.jar tpAchatProject.jar
ADD https://github.com/rchouda/JenkinsProject/tree/backend_HB/target .
ENTRYPOINT ["java","-jar","tpAchatProject.jar"]

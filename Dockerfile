FROM openjdk:11
EXPOSE 8080
ADD target/tpAchatProject-1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
ENV FONTCONFIG_PATH=/etc/fonts

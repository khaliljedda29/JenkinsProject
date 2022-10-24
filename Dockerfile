FROM openjdk:11
ADD /target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar tpAchatProject-1.0.jar"]  
ENV FONTCONFIG_PATH=/etc/fonts

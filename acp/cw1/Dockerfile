FROM --platform=linux/amd64 openjdk:21
VOLUME /tmp
EXPOSE 8080
COPY target/cw1*.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]
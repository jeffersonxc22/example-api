FROM openjdk:15-alpine
COPY target/example-api-1.0.0.jar example-api.jar
ENTRYPOINT ["java", "-jar", "example-api.jar"]
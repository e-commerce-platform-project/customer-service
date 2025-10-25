FROM openjdk:17-apline
WORKDIR /app
RUN apk add --no-cache curl
COPY target/user-service-0.0.1-SNAPSHOT.jar /app/user-service.jar
ENTRYPOINT ["java", "-jar", "user-service.jar"]
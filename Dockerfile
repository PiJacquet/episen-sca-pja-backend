FROM openjdk:8-jdk-alpine
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/episen-sca-pja-backend*.jar /app/episen-sca-pja-backend.jar
ENTRYPOINT ["java", "-jar", "/app/episen-sca-pja-backend.jar"]
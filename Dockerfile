FROM openjdk:8-jdk-alpine as build
EXPOSE 8080
RUN mkdir -p /app/

FROM openjdk:8-jdk-alpine
ADD build/libs/episen-sca-pja-backend*.jar /app/episen-sca-pja-backend.jar
ENTRYPOINT ["java", "-jar", "/app/episen-sca-pja-backend.jar"]
LABEL "episen.sca.pja"="backendtp4"
LABEL version="1.0"
LABEL description="Backend used on the SCA TP4"
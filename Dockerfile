FROM openjdk:8-jdk-alpine as builder1
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/episen-sca-pja-backend*.jar /app/episen-sca-pja-backend.jar

FROM builder1 as builder2
#Create user spring and adding curl for test purpose
RUN adduser appspring -u 1200 -g user -D -s /bin/bash && \
	chmod 777 /usr/local && \
	apk --no-cache add curl
USER 1200
ENTRYPOINT ["java", "-jar", "/app/episen-sca-pja-backend.jar"]
LABEL "episen.sca.pja"="backendtp4"
LABEL version="1.0"
LABEL description="Backend used on the SCA TP4"
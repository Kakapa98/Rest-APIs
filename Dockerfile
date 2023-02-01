#Dockerrising the current REST API project

FROM openjdk:1.8
LABEL maintainer="Mofokeng Mpho Alphios"
ADD target/APIs_project-0.0.1-SNAPSHOT.jar REST-API-for-mini-bank.jar
ENTRYPOINT ["java", "-jar", "REST-API-for-mini-bank.jar"]
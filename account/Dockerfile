FROM openjdk:16-alpine3.13
COPY ["target/account-0.0.1-SNAPSHOT.jar", "target/"]
CMD ["nohup","java","-jar","-Dspring.profiles.active=prod","target/account-0.0.1-SNAPSHOT.jar"]
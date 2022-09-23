FROM openjdk:8-jdk-alpine

COPY target/craftproject-0.0.1-SNAPSHOT.jar craftproject.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/craftproject.jar"]
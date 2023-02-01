FROM maven:3.8-amazoncorretto-19 AS maven
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package

FROM openjdk:19-jdk-alpine
ARG JAR_FILE=anthony-photography-be.jar
WORKDIR /opt/app
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/
ENTRYPOINT ["java","-jar","anthony-photography-be.jar"]
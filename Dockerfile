FROM maven:3.6.1-jdk-8 as builder
### Provide Default Argument
WORKDIR /usr/src/app 
COPY src/ src/
COPY pom.xml pom.xml
RUN mvn clean package -Dmaven.test.skip=true

FROM ubuntu:20.10 as extractor

WORKDIR /pinpoint-agent

ADD https://github.com/pinpoint-apm/pinpoint/releases/download/v2.2.2/pinpoint-agent-2.2.2.tar.gz pinpoint-agent-2.2.2.tar.gz

RUN tar -xzf pinpoint-agent-2.2.2.tar.gz

## Use only a JRE to run application
FROM gcr.io/distroless/java:8
# FROM openjdk:7
## Copy Artifact from maven image
WORKDIR /app 

COPY --from=extractor /pinpoint-agent/pinpoint-agent-2.2.2/ /pinpoint-agent
COPY pinpoint.config /pinpoint-agent/pinpoint.config
COPY --from=builder /usr/src/app/*.jar /app/app.jar 
# MUST CONFIRM ARTIFACT NAME! TRY HITHERTO EXISTING PROJECT ARTIFACT NAME
EXPOSE 8080
ENTRYPOINT ["java", "-javaagent:/pinpoint-agent/pinpoint-bootstrap-2.2.2.jar", "-Dpinpoint.agentId=rss-inventory", "-Dpinpoint.config=pinpoint-agent/pinpoint.config","-Dpinpoint.applicationName=rss-inventory","-Dpinpoint.container=rss-inventory", "-jar", "app.jar"]

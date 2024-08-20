FROM openjdk:17-jdk-slim as builder

MAINTAINER ianlombu

ARG version=1.32.0

#COPY --from=builder /usr/src/app/ ./
ADD --chmod=644 https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v$version/opentelemetry-javaagent.jar /usr/src/app/opentelemetry-javaagent.jar
ENV JAVA_TOOL_OPTIONS=-javaagent:/usr/src/app/opentelemetry-javaagent.jar

COPY target/attendance-service-0.0.1-SNAPSHOT.jar attendance-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "attendance-service-0.0.1-SNAPSHOT.jar"]
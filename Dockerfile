FROM eclipse-temurin:17-jre
LABEL authors="salaheddine"

WORKDIR app

COPY target/hospital-operations-0.0.1-SNAPSHOT.jar hospital-operations-0.0.1-SNAPSHOT.jar

EXPOSE 7866

ENTRYPOINT ["java", "-jar", "hospital-operations-0.0.1-SNAPSHOT.jar","--spring.profiles.active=${ENV_PROFILE}"]
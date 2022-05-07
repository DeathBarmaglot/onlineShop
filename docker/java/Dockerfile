FROM openjdk:11-oracle
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar", "--spring.profiles.active=docker"]

FROM debian:latest
RUN apt-get update && apt-get install -qq -y \
    shellcheck \
  && rm -rf /var/lib/apt/lists/*
WORKDIR /usr/src/app/
COPY . /usr/src/app/
CMD ["docker-compose","up","--force-recreate"]

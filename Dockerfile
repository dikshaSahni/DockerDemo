FROM java:8
EXPOSE 8761
VOLUME /tmp
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD /target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar","demo-0.0.1-SNAPSHOT.jar"]
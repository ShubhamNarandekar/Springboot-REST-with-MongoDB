FROM openjdk:8-jre-alpine
COPY target/examoffice-1.0-SNAPSHOT.jar /examoffice.jar
EXPOSE 8080
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
RUN chmod +x /wait
CMD /wait && ["/usr/bin/java", "-jar", "/examoffice.jar", "http://dsclassroom:8081/applications,http://ccclassroom:8082/applications,http://mlclassroom:8083/applications"]
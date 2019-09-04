FROM openjdk:latest
COPY ./target/taskmanagement-0.0.2.jar /usr/src/taskmanagement-0.0.2.jar
EXPOSE 5000
CMD java -jar /usr/src/taskmanagement-0.0.2.jar


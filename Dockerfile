FROM maven:3.6.1-jdk-8-alpine AS BUILD
RUN mkdir -p /opt/app
WORKDIR /opt/app
# copy the pom and src code to the container
COPY ./ /opt/app
# package our application code
RUN mvn clean package -DskipTests -B

# the second stage of our build will use open jdk 8 on alpine 3.9
FROM openjdk:8-jre-alpine3.9
# copy only the artifacts we need from the first stage and discard the rest
COPY --from=BUILD /opt/app/target/*.jar app.jar
# set the startup command to execute the jar
ENTRYPOINT java -Xmx1024m -jar app.jar -Djava.security.egd=file:/dev/./urandom
EXPOSE 8080
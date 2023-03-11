/FROM openjdk:8-jdk-alpine
//RUN apk --no-cache add curl
//RUN curl -u admin:nexus -o achat.jar "http://192.168.1.30:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar" -L
//ENTRYPOINT ["java","-jar","/achat.jar"]
//EXPOSE 8089

FROM openjdk:11
EXPOSE 8089
ADD target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java", "-jar", "/achat-1.0.jar"]

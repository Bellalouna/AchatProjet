# Build a JAR File
FROM maven:3.8.6 AS stage1
WORKDIR /home/app
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean package

# Create an Image
FROM openjdk:8-alpine
EXPOSE 8089
COPY --from=stage1 /home/app/target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["sh", "-c", "java -jar /achat-1.0.jar"]
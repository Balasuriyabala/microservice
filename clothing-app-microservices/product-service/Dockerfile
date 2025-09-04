FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 6000
ENTRYPOINT ["java","-jar","/app/app.jar"]

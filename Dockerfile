FROM java:8-jdk-alpine
COPY ./dist ./docker
WORKDIR ./docker
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ColetorIntraday.jar"]

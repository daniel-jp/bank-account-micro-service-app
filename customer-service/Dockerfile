FROM openjdk:17-oracle
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


#NB : O DOCKER-FILE SE CARREGARA DE EXECUTAR O MS-SERVICE
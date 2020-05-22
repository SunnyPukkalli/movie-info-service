FROM openjdk:8
ADD target/movie-info.jar movie-info.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]

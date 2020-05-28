FROM openjdk:8
ADD target/movie-info.jar movie-info.jar
EXPOSE 8080
ENTRYPOINT exec java -jar movie-info.jar --spring.profiles.active=$PROFILE

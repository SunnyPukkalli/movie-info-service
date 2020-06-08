# Details for Current Branch

###### default profile
|Property                   |Values                         |
|---------------------------|-------------------------------|
|`server.port`              |`8083`                         |
|`zipkin.base-url`          |`http://localhost:9411/`       |
|`eureka url`               |`http://localhost:8095/eureka/`|

###### cloud profile
|Property                   |Values                         |
|---------------------------|-------------------------------|
|`server.port`              |`8080`                         |
|`zipkin.base-url`          |`http://zipkin-server/`        |
|`eureka url`               |`http://eureka-server/eureka/` |


## API Exposed for image version : e1
|API                        |Description                        |
|---------------------------|-----------------------------------|
|**`/movies/{movieId}`**    |will return Movie with random data |


## API Exposed for image version : https
|API                        |Description                        |
|---------------------------|-----------------------------------|
|**`/movies/v1/{movieId}`**    |will return Movie with random data |
|**`/movies/v2/{movieId}`**    |will fetch data from external API and use configmap |

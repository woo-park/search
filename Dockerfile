FROM frolvlad/alpine-java:jdk8-slim
VOLUME /tmp
ADD target/search-1.0.jar search.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/search.jar"]

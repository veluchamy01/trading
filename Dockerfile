FROM openjdk:17
VOLUME /tmp
EXPOSE 9001
ADD target/trading-0.0.1-SNAPSHOT.jar trading-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","/trading-0.0.1-SNAPSHOT.jar"]
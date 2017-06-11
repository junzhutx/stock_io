FROM java:8-alpine
MAINTAINER Jun Zhu
ADD target/stock-io-daily-processor-0.0.1-SNAPSHOT.jar /
EXPOSE 8082
ENTRYPOINT ["java", "-classpath", "/data/inbox", "-jar", "stock-io-daily-processor-0.0.1-SNAPSHOT.jar"]

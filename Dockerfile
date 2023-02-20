FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./target/vlog.jar vlog.jar
# 设置容器默认命令为 java -jar vlog.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/vlog.jar"]



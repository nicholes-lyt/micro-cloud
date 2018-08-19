FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD micro-cloud-config-server-1.0.0.BUILD-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

FROM openjdk:alpine
VOLUME /tmp
COPY target/*.jar /app.jar
RUN sh -c 'touch /app.jar'
CMD ["sh", "-c", "java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar ${RUN_ARGS}"]
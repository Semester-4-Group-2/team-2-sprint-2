FROM openjdk:19.0.1-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# Edit configurations-
#   Maven-> clean package
#       creates jar files.
# In terminal:
#   docker build -t (name of your compose image) .
#       creates the image
#   docker-compose up
#       Starts the image.
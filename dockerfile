# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory in the container
EXPOSE 7878

# Copy the application JAR file into the container at /usr/src/app
COPY target/camundabpm.jar camundabpm.jar

# Specify the command to run on container start
CMD ["java", "-jar", "camundabpm.jar"]
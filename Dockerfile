# Use the official Tomcat image from the Docker Hub
FROM tomcat:9.0

# Copy the web application to the Tomcat webapps directory
COPY target/CoupangSpring.war /usr/local/tomcat/webapps/

# Expose the default Tomcat port
EXPOSE 8080
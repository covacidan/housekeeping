FROM tomcat:latest

ADD target/housekeeping.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
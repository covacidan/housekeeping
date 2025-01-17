# housekeeping

how to run: \n
update src/main/resources/application.properties with the new DB IP address \n
cd ../../../

# need to give permissions to maven to run
chown +x ./mvnw 

docker build --tag housekeeping .

docker run -d --name housekeeping -p 3000:8080 housekeeping

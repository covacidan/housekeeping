# housekeeping

how to run:
update src/main/resources/application.properties with the new DB IP address
cd ../../../

docker build --tag housekeeping .

docker run -d --name housekeeping -p 3000:8080 housekeeping

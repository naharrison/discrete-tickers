#!/bin/csh -f

rm -rf ticker-app ticker-app.zip

mvn install
mvn clean compile assembly:single
mkdir ticker-app
cp target/introphys-1.0-SNAPSHOT-jar-with-dependencies.jar ticker-app
chmod +x ticker-app/introphys-1.0-SNAPSHOT-jar-with-dependencies.jar
mv ticker-app/introphys-1.0-SNAPSHOT-jar-with-dependencies.jar ticker-app/ticker.jar
zip -r ticker-app.zip ticker-app
rm -rf ticker-app

echo "unzip ticker-app.zip ; cd ticker-app ; java -jar ticker.jar"

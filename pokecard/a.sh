mvn compile
mvn org.codehaus.mojo:exec-maven-plugin:1.5.0:java -Dexec.mainClass="com.pokecard.heroku.Main" | grep -Ev '(^\[|Download\w+:)'

mvn compile;

mvn exec:java -Dexec.mainClass="com.sharad.app.jsonobject" -Dexec.classpathScope=runtime

java -cp target/my-app-1.0-SNAPSHOT.jar:$HOME/.m2/repository/org/json/json/20160810/json-20160810.jar com.sharad.app.jsonobject


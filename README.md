# Create initial project structure using maven

1. f you don't have maven installed (_type mvn on terminal to check whether it exists_), install [maven](https://maven.apache.org/install.html). On Mac use  
```brew install maven```

1. First time you run any maven command it will download lots of dependencies and print lots of download statements on console. Second time onwards, it will be faster and won't fill up your screen.

1. Create a new Java project with maven  
```mvn archetype:generate```

1. Select default options for for first two questions. Just hit enter twice.

1. Enter artifact-id (com.shital) and group id (tutorial).

1. Select default value for version and package.

1. Confirm all properties.

### maven will create a basic directory structure suitable for Java projects as follows:
```
|-pom.xml  
 |-src  
 | |-test  
 | | |-java  
 | | | |-com  
 | | | | |-shital  
 | | | | | |-AppTest.java  
 | |-main  
 | | |-java  
 | | | |-com  
 | | | | |-shital  
 | | | | | |-App.java  
 ```


 # Now compile and run your Main class 

 1. Using compile and exec plugins of maven. You need to specify the main class in the argument as follows:
 ```mvn compile exec:java -Dexec.mainClass="com.shital.App"```

 1. Put main Class in pom.xml so that you don't have to specify it at command line. Insert following inside <build> tag in pom.xml
 	```xml
 	<plugins>
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <version>3.0.0</version>
        <executions>
          <execution>
            <goals>
              <goal>java</goal>
            </goals>
          </execution>
        </executions>
        <configuration>
          <mainClass>com.shital.App</mainClass>
        </configuration>
      </plugin>
    </plugins> 	
 	```

1. Now you can simply type following to run your program. No need to specify main class

	```
	mvn compile exec:java
	```

1. Maven creates all classes inside target/classes dir. To simply run using java commmand, do following in the base dir
	```
	cd target/classes
	java com.shital.App
	```

1. Now run all uni tests. Check dummy test written in src/test/java/com/shital/AppTest.java
	```
	mvn test
	```

1. You should see following on your console. This means all tests passed and there are no test failures.
	```
	Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
	
	```















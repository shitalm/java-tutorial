# Create directory structure. 

1. As we are not using any tools, such as maven, we need to do this manually.

1. First create base project directory
	```
	mkdir java-tutorial
	cd java-tutorial	
	```

1. Now create a directory structure to match the package structure of our source code
	```
	mkdir -p src/main/java/com/shital
	```

1. Create a file App.java inside src/main/java/com/shital and put following code:
	```java
	package com.shital;

	public class App
	{
	    public static void main( String[] args )
	    {
	        System.out.println( "Hello World!" );
	    }
	}
	```

1. Now compile the java code
	```
	cd src/main/java
	javac com/shital/App.java
	
	```

1. It will create a class App.class in src/main/java/com/shital
	```
	ls com/shital/

	```

1. It should show
	```
	App.class	App.java
	
	```
Note: This is not a proper directory structure as source code and generated classes are in same directory. Ideally we should separate them out. When we use a tool like maven, it will automatically take care of it.

1. Now run the code from dir src/main/java
	```
	java com.shital.App
	```

1. You should see:
	```
	Hello World!
	```

1. In the maven branch, you will see an automated way of creating the folder structure and also keeping source and class files separate.

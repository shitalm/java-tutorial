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

1. If you want to look at the complete code at this point in time, do:
	```
	git checkout basic
	
	```

# Create a simple HTTP server without using any framework

1. Following code assumes that you know Inheritance ([w3c](https://www.w3schools.com/java/java_inheritance.asp), [baeldung](https://www.baeldung.com/java-inheritance)), Polymorphism ([w3c](https://www.w3schools.com/java/java_polymorphism.asp), [baeldung](https://www.baeldung.com/java-polymorphism)), Inner classes ([w3c](https://www.w3schools.com/java/java_inner_classes.asp), [baeldung](https://www.baeldung.com/java-nested-classes)), Abstract classes ([w3c](https://www.w3schools.com/java/java_abstract.asp), [baeldung](https://www.baeldung.com/java-abstract-class)), Iterfaces ([w3c](https://www.w3schools.com/java/java_interface.asp), [baeldung](https://www.baeldung.com/java-interfaces)) and [OutputStream](https://www.baeldung.com/java-outputstream). If not, please follow the link and read the tutorials.

1. Type following code in the main method
	```java
	HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
    server.createContext("/hello", new HelloWorldHandler());
    server.start();
	
	```
	1. This creates a server socket to listen to HTTP requests at port 8080. Don't worry about the second parameter (0) for now.
	1. We also need to explictly state which requests will be handled. We are just going to handle one type of request in this example - requests having hello in the context i.e. http://localhost/hello
	1. We need to provide an HTTPHandler object which will handle this request i.e. HelloWorldHandler
	1. Now that we have provided minimum arguments to create an HTTP listener, we will start the server

1. Before we can go ahead, we need to implement HelloWorldHandler. Insert following code in App.java
	```java
	static class HelloWorldHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String response = "Hello World!";
            // we need to set response lengthin HTTP response header
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

    }
	```
	1. HelloWorldHandler implements HttpHandler and needs to provide an implementation for handle() method.
	1. We can HttpExchange which is passed in argument to handle() method to look at the request attributes and also create a response.
	1. In this example, we are not looking at any request attributes and just providing a static response "Hello World!"
	1. We need to get an OutputStream from HttpExchange so that we can write our response.

1. Now compile the java code
	```
	cd src/main/java
	javac com/shital/App.java
	
	```

1. Run the java code using main class
	```java
	java com.shital.App
	```

1. Open a browser and browse http://localhost:8080/hello You should see "Hello World!"

1. If you browse to http://localhost:8080/login, then it will give an error as we haven't implemented any handler other than for "/hello" context.

1. If you want to look at the complete code at this point in time, do:
	```
	git checkout basic-http
	
	```

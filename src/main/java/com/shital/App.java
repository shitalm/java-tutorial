package com.shital;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class App
{
    public static void main( String[] args ) throws Exception
    {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/hello", new HelloWorldHandler());
        // we are making our server multi-threaded by providing a thread pool to our HTTP server
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();    
    }

    static class HelloWorldHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            try {
                Thread.sleep(30000);
            } catch(InterruptedException ex) {}
            String response = "Hello World!" + new Date();
            // we need to set response lengthin HTTP response header
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

    }

}


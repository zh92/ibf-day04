package sdf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    public static void main(String[] args) throws IOException {
        
        System.out.println("Starting server on port 3000");
        //Create a server socket and listen to a specific port
        ServerSocket server = new ServerSocket(3000);

        while (true) {
        //Wait for a connection
        System.out.println("Waiting for incoming connection");
        Socket conn = server.accept();

        System.out.println("Got a connection");

        //Do something
        //Get the input stream, read the data from the client
        InputStream is = conn.getInputStream();
        Reader r = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(r);

        String input = br.readLine();
        System.out.printf(">>> from client: %s\n", input);

        input = input.toUpperCase();
        OutputStream os = conn.getOutputStream();
        Writer w = new OutputStreamWriter(os);
        
        //Close the connection, all stream will be close
        conn.close();
        }

    }
}
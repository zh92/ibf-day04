package sdf;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class Client {
    
    public static void main(String[] args) throws IOException {
        
        //Connect to the server listening on port 3000
        // 127.0.0.1 or localhost means the local computer
        Socket conn = new Socket("127.0.0.1", 3000);

        System.out.println("Connected to server on localhost:3000");

        Console cons = System.console();
        String line = cons.readLine("What would you like to uppercase today? ");
        
        //Do something
        OutputStream os = conn.getOutputStream();
        Writer w = new OutputStreamWriter(os);
        w.write(line);
        w.flush();
        
        //Get input from server
        InputStream is = conn.getInputStream();
        Reader r = new InputStreamReader(is);
        BufferedReader  br = new BufferedReader(r);

        //Close connection
        conn.close();
    }
}

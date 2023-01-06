package sdf;

import java.io.IOException;
import java.net.ServerSocket;

public class CalculatorClient {
    
    public static void main(String[] args) throws IOException {
        
        ServerSocket server = ServerSocket(4000);
        server.accept();
        
    }
}

package com.ravi.learnings.features.tcpstream;

import java.io.*;
import java.net.*;

public class TcpStreamClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9009);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println("📥 Received: " + line);
        }
    }
}

package com.ravi.learnings.features.tcpstream;

import java.io.*;
import java.net.*;
import java.util.Random;

public class TcpStreamServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9009);
        System.out.println("✅ Server started on port 9009...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("👤 Client connected: " + clientSocket.getInetAddress());

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        Random random = new Random();

        while (true) {
            int price = 1000 + random.nextInt(100); // Random price
            String tick = "TICK: STOCK=XYZ, PRICE=" + price + ", TIME=" + System.currentTimeMillis();
            out.println(tick);
            System.out.println("📤 Sent: " + tick);

            try {
                Thread.sleep(1000); // 1 tick per second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

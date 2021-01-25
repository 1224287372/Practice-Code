package com.yym.nio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSocket {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8090);
        System.out.println("setp1: new ServerSocket(8090) ");
        while (true) {
            Socket clinet = server.accept();
            System.out.println("setp2: client\t" + clinet.getPort());

            new Thread(new Runnable() {
                Socket ss;

                public Runnable setSS(Socket s) {
                    ss = s;
                    return this;
                }

                @Override
                public void run() {
                    try {
                        InputStream in = ss.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        while (true) {
                            System.out.println(reader.readLine());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.setSS(clinet)
            ).start();
        }
    }
}

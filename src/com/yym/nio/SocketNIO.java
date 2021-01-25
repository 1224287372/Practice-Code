package com.yym.nio;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

public class SocketNIO {
    public static void main(String[] args) throws Exception {
        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9090));
        ss.configureBlocking(false);

        while (true) {
            Thread.sleep(1000);
            SocketChannel client = ss.accept();

            if (client == null) {
                System.out.println("null....");
            } else {
                client.configureBlocking(false);
                int port = client.socket().getPort();
            }
        }
    }
}
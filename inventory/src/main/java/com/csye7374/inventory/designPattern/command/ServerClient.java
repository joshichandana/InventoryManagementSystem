package com.csye7374.inventory.designPattern.command;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ServerClient {

    int port = 1234;

    public ServerClient() {

    }

    public void Server() throws IOException {
        DatagramSocket ds = new DatagramSocket(port);
        byte[] recieve = new byte[10000];

        DatagramPacket dpPacket = null;
        System.out.println("***** Server Listening on Port ***********");
        while (dpPacket == null || !data(recieve).toString().equalsIgnoreCase("bye")) {
            dpPacket = new DatagramPacket(recieve, recieve.length);

            ds.receive(dpPacket);

            System.out.print("\n***** Data sent by Client *****\n" + data(recieve));
            System.out.println();

            if (data(recieve).toString().equalsIgnoreCase("bye")) {
                System.out.println("Exiting");
                break;
            }
            recieve = new byte[10000];

        }
        ds.disconnect();
        ds.close();
        ds.setSoTimeout(10);
    }

    private static StringBuilder data(byte[] a) {
        if (a == null) {
            return null;
        }
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0) {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }

    public void Client(String msg) throws IOException {
        Scanner sc = new Scanner(System.in);
        String inp = "NO message";
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        inp = msg;
        byte[] buf = inp.getBytes();

        DatagramPacket dpSend = new DatagramPacket(buf, buf.length, ip, port);

        ds.send(dpSend);

        ds.disconnect();
        sc.close();
        ds.close();
    }
}

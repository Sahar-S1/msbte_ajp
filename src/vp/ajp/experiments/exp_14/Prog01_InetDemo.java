package vp.ajp.experiments.exp_14;

import java.io.*;
import java.net.*;

@SuppressWarnings("unused")
public class Prog01_InetDemo {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("localhost");
            System.out.println("Host Name: " + ip.getHostName());
            System.out.println("IP Address: " + ip.getHostAddress());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

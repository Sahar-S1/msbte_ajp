package vp.ajp.experiments.exp_15;

import java.net.*;

public class Prog01_URLDemo {
    public static void main(String args[]) throws MalformedURLException {
        URL hp = new URL("https://www.javatpoint.com/javafx-tutorial");
        System.out.println("Protocol: " + hp.getProtocol());
        System.out.println("Port: " + hp.getPort());
        System.out.println("Host: " + hp.getHost());
        System.out.println("File: " + hp.getFile());
        System.out.println("Ext:" + hp.toExternalForm());
    }
}

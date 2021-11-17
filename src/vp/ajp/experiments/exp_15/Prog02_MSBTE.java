package vp.ajp.experiments.exp_15;

import java.net.MalformedURLException;
import java.net.URL;

public class Prog02_MSBTE {
    public static String URL = "http://www.msbte.org.in";

    public static void main(String[] args) {
        try {
            URL url = new URL(URL);
            System.out.println("\"" + url + "\"" + " " + "Metadata");
            System.out.println("Host: " + url.getHost());
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Port: " + url.getPort());
            System.out.println("File: " + url.getFile());
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }
    }
}

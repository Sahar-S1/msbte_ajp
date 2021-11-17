package vp.ajp.experiments.exp_14;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Prog02_HostIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter hostname: ");
        String host = sc.nextLine();

        try {
            InetAddress[] ips = InetAddress.getAllByName(host);
            for (InetAddress ip : ips) {
                System.out.println("IP Address of " + host + " is " + ip.getHostAddress());
            }
        } catch (UnknownHostException unknownHostException) {
            System.out.println("Unknown host " + host);
        }

        sc.close();
    }
}

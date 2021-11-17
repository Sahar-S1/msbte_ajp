package vp.ajp.experiments.exp_15;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Scanner;

public class Prog03_ConnectURL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a URL: ");
        String urlString = sc.nextLine();

        try {
            URL url = new URL(urlString);

            URLConnection urlConnection = url.openConnection();

            System.out.println("\"" + url + "\"" + " Connection Stats");
            System.out.println("Date: " + new Date(urlConnection.getDate()));
            System.out.println("Content Type: " + urlConnection.getContentType());
            System.out.println("Content Length: " + urlConnection.getContentLength());
        } catch (MalformedURLException malformedURLException) {
            System.out.println("Unknown URL " + urlString);
        } catch (IOException ioException) {
            System.out.println("Unable to connect to " + urlString);
        }

        sc.close();
    }
}

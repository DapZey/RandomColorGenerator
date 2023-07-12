package org.example;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://picsum.photos/200/300");
            new Window(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
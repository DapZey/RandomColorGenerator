package org.example;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
public class Window extends JFrame {
    JLabel img;
    public Window(URL url){
        try {
            BufferedImage bufferedImage = ImageIO.read(url);
            mostPopularColor(bufferedImage);
            ImageIcon imageIcon = new ImageIcon(bufferedImage);
            this.img = new JLabel();
            img.setIcon(imageIcon);
            this.add(img);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            this.setSize(200,300);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void mostPopularColor(BufferedImage bufferedImage){
        HashMap<Color,Integer> pixelCounter = new HashMap<>();
        BufferedImage output = new BufferedImage(200,300,BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < output.getWidth(); x++){
            for (int y = 0; y < output.getHeight(); y++){
                Color color = new Color(bufferedImage.getRGB(x,y));
                    if (pixelCounter.containsKey(color)){
                        pixelCounter.put(color, pixelCounter.get(color) + 1);
                    }
                    else {
                        pixelCounter.put(color, 1);
                    }
            }
        }
        int counter = 0;
        Color colour = new Color(0,0,0);
        for (Color color : pixelCounter.keySet()){
            if (pixelCounter.get(color) > counter){
                counter = pixelCounter.get(color);
                colour = color;
            }
        }
        System.out.println("The most common rgs is: " + colour.toString());
    }
}

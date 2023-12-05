package ldts.dino.gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteBuilder {

    private String resourcePath = "./src/main/resources/images/";
    private final Map<String , BufferedImage> cache;
    public static final Font FONT;

    static {
        Font font;

        try {
            URL resource = SpriteBuilder.class.getClassLoader().getResource("fonts/square.ttf");
            File file = new File(resource.toURI());
            font = Font.createFont(Font.TRUETYPE_FONT, file);
        } catch (NullPointerException | IOException | URISyntaxException | FontFormatException e) {
            System.out.println("Font not found, using default font.");
            font = Font.decode(Font.SANS_SERIF);
        }

        FONT = font;
    }
    public SpriteBuilder() throws IOException, URISyntaxException {
        this.cache = new HashMap<>();
    }

    public boolean isInCache(String name) {
        return cache.containsKey(name);
    }

    public BufferedImage getFromCache(String name) {
        return cache.get(name);
    }

    public void setToCache(String name, BufferedImage image) {
        cache.put(name, image);
    }


    public BufferedImage loadImage(String filename) {
        if(isInCache(filename)) return getFromCache(filename);

        BufferedImage image = null;
        try {
            File file = new File(resourcePath + filename + ".png");
            image = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("Error reading image!" + filename);
        }
        setToCache(filename, image);
        return image;
    }

    public static BufferedImage loadText(String text, int size, String color) {
        Font font = FONT.deriveFont((float) size);

        FontRenderContext frc = new FontRenderContext(null, false, false);
        LineMetrics metrics = font.getLineMetrics(text, frc);

        int width = (int) Math.ceil(font.getStringBounds(text, frc).getWidth());
        int height = (int) Math.ceil(metrics.getHeight());
        int ascent = (int) Math.ceil(metrics.getAscent());

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics graphics = image.getGraphics();
        graphics.setColor(new Color(Integer.parseInt(color.substring(1), 16)));
        graphics.setFont(font);
        graphics.drawString(text, 0, ascent);

        return image;
    }

}
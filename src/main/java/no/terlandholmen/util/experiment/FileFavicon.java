package no.terlandholmen.util.experiment;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class FileFavicon extends Canvas {

    private static DateTimeFormatter DT_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        super.paint(g2d);
        //g2d.scale();
        Polygon logoPolygon = createLogoPolygon();
        g2d.setTransform(transformationUpperRight());
        g2d.setColor(getLogoColor());
        g2d.fill(logoPolygon);
        g2d.drawPolygon(logoPolygon);
        g2d.setTransform(transformationLowerLeft());
        g2d.setColor(getLogoColor());
        g2d.fill(logoPolygon);
        g2d.drawPolygon(logoPolygon);
    }

    private AffineTransform transformationLowerLeft() {
        AffineTransform result = new AffineTransform();
        result.translate(0, 50);
        result.rotate(degrees45().doubleValue());
        return result;
    }

    private AffineTransform transformationUpperRight() {
        AffineTransform result = new AffineTransform();
        result.translate(100, 50);
        result.rotate(degrees225().doubleValue());
        return result;
    }

    private Polygon createLogoPolygon() {
        Polygon polygon = new Polygon();
        polygon.addPoint(0,0);
        polygon.addPoint(30,0);
        polygon.addPoint(30,10);
        polygon.addPoint(10,10);
        polygon.addPoint(10,60);
        polygon.addPoint(20,60);
        polygon.addPoint(20,40);
        polygon.addPoint(50,40);
        polygon.addPoint(50,50);
        polygon.addPoint(30,50);
        polygon.addPoint(30,70);
        polygon.addPoint(0,70);
        polygon.addPoint(0,0);
        return polygon;
    }

    private Color getLogoColor() {
        return new Color(55,71,133);
    }

    private Double degrees45() {
        return Math.PI * 7 / 4;
    }

    private Double degrees225() {
        return Math.PI * 3 / 4;
    }

    public static void main(String[] args) {
        BufferedImage bufferedImage = new BufferedImage(146, 146, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        FileFavicon fileFavicon = new FileFavicon();
        fileFavicon.paintComponent(graphics2D);

        String now = DT_FORMATTER.format(java.time.LocalDateTime.now());
        try {
            ImageIO.write(bufferedImage, "PNG", new File("src/main/resources/terlandholmen.favicon." + now + ".PNG"));
            ImageIO.write(bufferedImage, "gif", new File("src/main/resources/terlandholmen.favicon." + now + ".GIF"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package no.terlandholmen.experiment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;

public class DisplayLogoV2 extends JPanel {

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        super.paintComponent(g2d);
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
        result.translate(100, 200);
        result.rotate(degrees45().doubleValue());
        return result;
    }

    private AffineTransform transformationUpperRight() {
        AffineTransform result = new AffineTransform();
        result.translate(285, 200);
        result.rotate(degrees225().doubleValue());
        return result;
    }

    private Polygon createLogoPolygon() {
        Polygon polygon = new Polygon();
        polygon.addPoint(0,0);
        polygon.addPoint(50,0);
        polygon.addPoint(50,10);
        polygon.addPoint(10,10);
        polygon.addPoint(10,120);
        polygon.addPoint(40,120);
        polygon.addPoint(40,80);
        polygon.addPoint(90,80);
        polygon.addPoint(90,90);
        polygon.addPoint(50,90);
        polygon.addPoint(50,130);
        polygon.addPoint(0,130);
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
        JFrame frame = new JFrame();
        frame.setTitle("Terlandholmen Logo");
        frame.setSize(400, 400);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Container contentPane = frame.getContentPane();
        contentPane.add(new DisplayLogoV2());
        frame.show();
    }
}
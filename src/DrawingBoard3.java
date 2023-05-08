//Author: Ngoc Bui
//Date: 04/07/2023
//Purpose: Create snowflakes

import javax.swing.*;
import java.awt.*;
public class DrawingBoard3 extends JPanel{
    int strokeWeight = 1;

    public void paintComponent(Graphics g){
        this.setBackground(Color.WHITE);

        snowFlake(g, 400, 300, 60, 1, 0, 0, 50);
        snowFlake(g, 400, 300, 0, 1, 0, 0, 50);

        snowFlake(g, 600, 100, 0, 1, 50, 0, 0);
        snowFlake(g, 700, 210, 0, 1, 150, 0, 10);
        snowFlake(g, 200, 600, 0, 1, 150, 0, 10);

        snowFlake(g, 50, 500, 4, 1, 0, 50, 0);
        snowFlake(g, 150, 340, 6, 1, 0, 50, 0);
        snowFlake(g, 700, 530, 2, 1, 0, 100, 50);
        snowFlake(g, 850, 50, 2, 1, 0, 150, 0);
        snowFlake(g, 400, 590, 4, 1, 0, 150, 10);

        snowFlake(g, 550, 600, 0, 1, 0, 0, 50);
        snowFlake(g, 150, 20, 0, 1, 0, 0, 50);
        snowFlake(g, 250, 100, 0, 1, 0, 0, 50);
        snowFlake(g, 550, 40, 0, 1, 0, 0, 150);
        snowFlake(g, 50, 140, 0, 1, 0, 0, 50);
        snowFlake(g, 70, 240, 0, 1, 0, 0, 50);
        snowFlake(g, 20, 640, 0, 1, 0, 0, 50);
        snowFlake(g, 790, 400, 0, 1, 0, 0, 50);
        snowFlake(g, 360, 20, 0, 1, 0, 0, 50);
        snowFlake(g, 650, 300, 0, 1, 0, 0, 50);
        snowFlake(g, 850, 620, 0, 1, 0, 0, 50);
    }

    public void snowFlake(Graphics g, int xCenter, int yCenter, int radius, int radiusIncrement,
                           int redIncrement, int greenIncrement, int blueIncrement){
        int redVal = 0;
        int greenVal = 0;
        int blueVal = 155;

        int iterations = 20;
        for(int num = 0; num < iterations; num++){
            Color color = new Color(redVal, greenVal, blueVal);

            rotateDesign(g, xCenter, yCenter, radius, color);
            radius += radiusIncrement;

            blueVal += blueIncrement;
            if(blueVal > 255){
                blueVal = 100;
            }
            redVal += redIncrement;
            if(redVal > 255){
                redVal = 0;
            }
            greenVal += greenIncrement;
            if(greenVal > 255){
                greenVal = 0;
            }
        }
    }

    public void rotateDesign(Graphics g, int xCenter, int yCenter, int radius, Color color){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(strokeWeight));

        int angle = 0;
        int angleIncrement = 30;
        int maxAngle = 360;

        double radius2 = 2 * radius * (Math.cos(Math.toRadians(angle + 30)));
        while(angle < maxAngle){
            int x1 = xCenter;
            int x2 = xCenter + (int)(radius * Math.cos(Math.toRadians(angle)));
            int x3 = xCenter + (int)(radius2 * Math.cos(Math.toRadians(angle + 30)));
            int x4 = xCenter + (int)(radius * Math.cos(Math.toRadians(angle + 60)));

            int y1 = yCenter;
            int y2 = yCenter + (int)(radius * Math.sin(Math.toRadians(angle)));
            int y3 = yCenter + (int)(radius2 * Math.sin(Math.toRadians(angle + 30)));
            int y4 = yCenter + (int)(radius * Math.sin(Math.toRadians(angle + 60)));

            int[] xes = {x1, x2, x3, x4};
            int[] yes = {y1, y2, y3, y4};

            g.setColor(color);
            g.drawPolygon(xes, yes, xes.length);

            angle += angleIncrement;
        }
    }

    public static void main(String[] args){
        int winWid = 900;
        int winHie = 700;
        JFrame myFrame = new JFrame("My Snow Flake - Ngoc Bui");
        myFrame.setSize(winWid, winHie);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.add(new DrawingBoard3());
        myFrame.setVisible(true);
    }
}

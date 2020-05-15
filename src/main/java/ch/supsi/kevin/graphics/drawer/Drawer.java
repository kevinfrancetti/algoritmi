package ch.supsi.kevin.graphics.drawer;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;


@Deprecated
public class Drawer extends Frame {

    WindowAdapter nn = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            //super.windowClosing(e);
            dispose();
        }
    };

    public Drawer(){



        addWindowListener(nn);

        /*
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
        */

    }

    @Override
    public void paint(Graphics g) {
        Line2D shape = new Line2D.Double();
        shape.setLine(250D,250D,150D,150D);
        Graphics2D g2 = (Graphics2D) g;
        double scaleValue = 2;
        AffineTransform at = AffineTransform.getScaleInstance(scaleValue, scaleValue);
        g2.setTransform(at);
        g2.draw (shape);
        g2.draw(new Line2D.Double(1, 1, 300, 250));
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2.setFont(font);
        g.drawString("Welcome to TutorialsPoint", 50, 70);
        g2.drawString("Line2D.Line", 100, 120);
    }

    public void test(){
        setSize(800,800);
        setTitle("TSP");

        setVisible(true);
    }




    /*
    public void repaint(Graphics g){

    }

    public void addWindowListener(WindowListener e){
        super.addWindowListener(e);
        //dispose();
    }
    */

    public static void main(String[] args){
        Drawer d = new Drawer();
        d.test();
    }


}

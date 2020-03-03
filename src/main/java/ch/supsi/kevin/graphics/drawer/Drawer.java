package ch.supsi.kevin.graphics.drawer;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Line2D;

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
        g2.draw (shape);
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2.setFont(font);
        g.drawString("Welcome to TutorialsPoint", 50, 70);
        g2.drawString("Line2D.Line", 100, 120);
    }

    public void repaint(Graphics g){

    }

    public void test(){
        setSize(500,500);
        setTitle("Culo");

        setVisible(true);
    }


    /*
    public void addWindowListener(WindowListener e){
        super.addWindowListener(e);
        //dispose();
    }
    */

}

package ch.supsi.kevin.drawer;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Drawer extends Frame {

    public Drawer(){
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
    }

    public void test(){
        setSize(500,500);
        setTitle("Culo");

        setVisible(true);
    }

    /*
    public void addWindowListener(WindowListener e){
        dispose();
    }
     */

}

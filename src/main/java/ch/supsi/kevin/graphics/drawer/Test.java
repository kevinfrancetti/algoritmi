package ch.supsi.kevin.graphics.drawer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@Deprecated
public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                TestPane tp = new TestPane();

                JSlider slider = new JSlider(10, 200);
                slider.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        tp.setScale(slider.getValue());
                    }
                });
                slider.setValue(100);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(tp);
                frame.add(slider, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private int scale = 100;

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(250, 350);
        }

        public void setScale(int value) {
            if (value != scale) {
                int old = scale;
                this.scale = value;
                firePropertyChange("scale", old, scale);
                repaint();
            }
        }

        public int getScale() {
            return scale;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            double scaleValue = getScale() / 100d;
            System.out.println(scaleValue);
            AffineTransform at = AffineTransform.getScaleInstance(scaleValue, scaleValue);
            g2d.setTransform(at);

            int x = 10;
            int y = 10;

            g2d.drawLine(110 + x, 135 - y, 10 + x, 205 - y);
            g2d.drawLine(10 + x, 205 - y, 48 + x, 320 - y);
            g2d.drawLine(48 + x, 320 - y, 170 + x, 320 - y);
            g2d.drawLine(170 + x, 320 - y, 205 + x, 205 - y);
            g2d.drawLine(205 + x, 205 - y, 110 + x, 135 - y);
            g2d.dispose();
        }

    }

}
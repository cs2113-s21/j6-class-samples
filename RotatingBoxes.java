import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class RotatingBoxes extends JFrame {

    AnimateArea aa; 
    AnimateThread at; 

    public RotatingBoxes(){
        super();
        aa = new AnimateArea();
        at = new AnimateThread(aa);
        this.add(aa);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void animate(){
        at.start(); //star the thread
    }

    private class AnimateArea extends JComponent{

        Color colors[] = {Color.BLACK, Color.BLUE, Color.RED,
            Color.YELLOW, Color.ORANGE};
        
        int numRotations = 0;
        int colorIdx = 0;
        
        public AnimateArea(){
            super();
            setPreferredSize(new Dimension(500, 500));
        }

        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;

            g2.setStroke(new BasicStroke(1));

            AffineTransform tf = g2.getTransform();
            g2.translate(250, 250);


            if((numRotations + 1) % 48 == 0)
                colorIdx = (colorIdx +1)%colors.length;
                
            numRotations = (numRotations + 1)%48;
            
            double rotate = Math.PI/24;
            g2.setColor(colors[colorIdx]);
            for(int i=0;i<numRotations+1;i++){
                g2.rotate(rotate);
                g2.draw(new Rectangle2D.Double(0, 0, 60, 60));
            }

            g2.setTransform(tf);
        }

    }


        //animation thread
    private class AnimateThread extends Thread{
        AnimateArea d;
        public AnimateThread(AnimateArea d) {
            this.d = d;
        }
        
        public void run() {
            while( true ) {
                
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
                d.repaint(); //repaint
            }
        }
    }

    public static void main(String[] args) {
        RotatingBoxes f = new RotatingBoxes();
        f.setVisible(true);
        f.animate();
    }

}

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Ex4Frame extends JFrame {

    AnimateArea aa; 
    AnimateThread at; 

    public Ex4Frame(){
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

    //animation area
    private class AnimateArea extends JComponent{

        
        double x=200,y=200; //initial location of the dot
        final double dw=20,dh=20; //width/height dot
        double dir=1; //moving down (-1 moving up)

        final int width=400,height=400; //width/height of animate area
        public AnimateArea(){
            super();
            setPreferredSize(new Dimension(width, height));

            //add a mouse listener
            this.addMouseListener(new MouseInputAdapter(){
                    public void mouseClicked(MouseEvent e){
                        x = e.getX(); //set the ball to x and y
                        y = e.getY();
                        //changeDir(); //also change the dirction
                        dir=1;
                    }
                });
        }

        public void changeDir(){
           dir *= -1;
        }
        public void moveDot(){
            //move in a direction, turn around if off the area
            double new_y = y+dir*10;
            if(new_y > height || new_y < 0){
                changeDir();//turn around!
                new_y = y+dir*10;
            }
            
            y=new_y;
        }
        
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;

            g2.setColor(Color.RED);
            g2.fill(new Ellipse2D.Double(x,y,dw, dh));
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
                    Thread.sleep(20); //wait 20 millis
                } catch (Exception e) {}
                d.moveDot();//move dot
                d.repaint(); //repaint
            }
        }
    }
    
    public static void main(String[] args) {
        Ex4Frame f = new Ex4Frame();
        f.setVisible(true);
        f.animate(); //star the animation thread
    }
}

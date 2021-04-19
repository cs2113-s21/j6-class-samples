import java.awt.*;
import javax.swing.*;

public class Ex0Frame extends JFrame{

    GraffitiButton gb;
    public Ex0Frame(){
        super();
        
        gb = new GraffitiButton("Attention Please: This is a button");
        gb.setPreferredSize(new Dimension(320, 40));

        this.setLocation(2000,-50);
        this.add(gb);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    private class GraffitiButton extends JButton {
        public GraffitiButton(String s) {
            super(s);
        }

        protected void paintComponent(Graphics g) {
            // Draw the button as normal.           
            super.paintComponent(g);
            
            // Make a white rectangle on top.
            g.setColor(Color.BLUE);
            g.fillRect(75, 5, 140, 15);

            // Write a String in red.
            g.setColor(Color.RED);
            g.drawString("this button stinks!", 80, 18);
        }
    }

    
    public static void main(String[] args) {
        Ex0Frame f = new Ex0Frame();
        f.setVisible(true);
    }
}

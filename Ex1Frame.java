import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ex1Frame extends JFrame{

    GraffitiButton gb;
    public Ex1Frame(){
        super();
        
        gb = new GraffitiButton("Attention Please: This is a button");
        gb.setPreferredSize(new Dimension(320, 40));

        this.setLocation(2000,-50);
        this.add(gb);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    private class GraffitiButton extends JButton {

        boolean addGraffiti = false;
        
        public GraffitiButton(String s) {
            super(s);

            this.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        
                        addGraffiti= true ^ addGraffiti;
                        
                        repaint(); //<-- calling repaint calls paintComponent()
                    }
                });
        }

        protected void paintComponent(Graphics g) {
            // Draw the button as normal.           
            super.paintComponent(g);

            //this cast is totally legal
            Graphics2D g2 = (Graphics2D) g; 

            if(addGraffiti){
                // Make a white rectangle on top.
                g2.setColor(Color.RED);
                g2.fillRect(75, 5, 140, 15);
                
                // Write a String in red.
                g2.setColor(Color.WHITE);
                g2.drawString("this button stinks!", 80, 18);
            }
        }       
    }

    
    public static void main(String[] args) {
        Ex1Frame f = new Ex1Frame();
        f.setVisible(true);
    }
}

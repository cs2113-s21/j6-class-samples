import java.awt.*;
import javax.swing.*;

public class Ex3Frame extends Frame {

    public Ex3Frame(){
        JComponent c = new DrawArea();

        this.setLocation(2000,-50);
        this.add(c);
        this.pack();
        
    }
    
    public static void main(String[] args) {
        Ex3Frame f = new Ex3Frame();
        f.setVisible(true);
    }
}

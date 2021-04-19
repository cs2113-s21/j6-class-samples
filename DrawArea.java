import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class DrawArea extends JComponent {
  public DrawArea() {
    super();
    setPreferredSize(new Dimension(400, 400));
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;

    // This voodoo makes the output prettier
    g2.setRenderingHint(
      RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint(
      RenderingHints.KEY_RENDERING,
      RenderingHints.VALUE_RENDER_QUALITY);

    // Drawing lines
    g2.setColor(Color.BLUE);
    g2.draw(new Line2D.Double(5, 100, 30, 220));
    g2.setColor(Color.ORANGE);
    g2.draw(new Line2D.Double(15, 100, 40, 220));

    // Drawing rectangles, defining colors, overlap
    g2.setColor(Color.RED);
    g2.draw(new Rectangle2D.Double(300, 100, 40, 40));
    g2.setColor(new Color(61, 153, 122));
    g2.fill(new Rectangle2D.Double(250, 100, 40, 40));
    g2.setColor(new Color(255, 51, 0, 255));
    g2.fill(new Rectangle2D.Double(275, 125, 40, 40));
    g2.setColor(new Color(255, 51, 0, 127));
    g2.fill(new Rectangle2D.Double(275, 75, 40, 40));

    // Drawing Ellipses, changing the "stroke"
    g2.setColor(new Color(255, 51, 255, 255));
    g2.fill(new Ellipse2D.Double(20, 320, 60, 60));
    g2.setColor(new Color(155, 51, 255, 255));
    g2.draw(new Ellipse2D.Double(60, 270, 100, 60));
    g2.setColor(new Color(105, 51, 255, 255));
    g2.setStroke(new BasicStroke(5));
    g2.draw(new Ellipse2D.Double(80, 250, 60, 100));

    // Drawing strings, changing fonts
    g2.drawString("This is some text", 20, 20);
    g2.setFont(new Font("Serif", Font.BOLD, 18));
    g2.drawString("Try a serif font", 20, 40);
    g2.setFont(new Font("Monospaced", Font.BOLD, 18));
    g2.drawString("Try a monospace font", 20, 60);

    // Drawing an image
    BufferedImage img = null;
    try {
      img = ImageIO.read(new File("catr.png"));
    } catch (IOException e) {}
    g2.drawImage(img, 80, 120, null);

    // Playing with transforms
    g2.setStroke(new BasicStroke(1));
    AffineTransform savedTf = g2.getTransform();
    g2.translate(300, 300);

    for (int i = 0; i < 24; i++) {
      g2.rotate(Math.PI / 24);
      g2.draw(new Rectangle2D.Double(0, 0, 60, 60));
    }
    g2.setTransform(savedTf);
  }
}

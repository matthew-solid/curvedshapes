import org.junit.Test;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;

public class ShapeColorTest {
    @Test
    public void testGradientPresence() {
        int w = 200, h = 200;
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        TitlesPanel panel = new TitlesPanel(37);
        panel.setSize(w, h);
        panel.paint(g2d);
        g2d.dispose();
        // Scan the image for at least two different colors
        java.util.Set<Integer> colors = new java.util.HashSet<>();
        for (int y = 0; y < h; y += 5) {
            for (int x = 0; x < w; x += 5) {
                colors.add(img.getRGB(x, y));
                if (colors.size() > 1) break;
            }
            if (colors.size() > 1) break;
        }
        assertTrue("Gradient should be present (at least two different colors)", colors.size() > 1);
    }
}

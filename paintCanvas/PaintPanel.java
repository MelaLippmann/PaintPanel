package paintCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {

    private PaintModel model;

    public PaintPanel(PaintModel model) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.model = model;
    }

    public Dimension getPreferredSize() {
        return new Dimension(450, 400);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < model.getNumberOfLines(); i++) {
            Line line = model.getLine(i);
            g.setColor(line.color);
            g.drawLine(line.startX, line.startY, line.endX, line.endY);
        }   
    }
}

package paintCanvas;

import java.awt.Color;

public class Line {

    final Color color;
    final int startX;
    final int startY;
    final int endX;
    final int endY;
    
    public Line(Color color, int startX, int startY, int endX, int endY) {
        this.color = color;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
}

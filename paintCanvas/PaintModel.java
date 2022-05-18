package paintCanvas;

import java.awt.Color;
import java.util.ArrayList;

public class PaintModel {

    private ArrayList<Line> lines = new ArrayList<Line>();
    
    int getNumberOfLines() {
        return lines.size();
    }
    
    public void addLine(Line line) {
        lines.add(line);
    }
    
    public Line getLine(int i) {
        return lines.get(i);
    }
    
    public void deleteAllLines() {
       lines.clear(); 
    }
}

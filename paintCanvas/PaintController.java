package paintCanvas;

import java.awt.Color;
import java.awt.event.*;
import java.lang.reflect.Field;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JComboBox;

public class PaintController extends MouseMotionAdapter implements MouseListener, ActionListener {
    private PaintPanel view;
    private PaintModel model;
    private OptionsPanel panel;

    private int startX;
    private int startY;
    private Color color;
    private PaintingMode mode;

    public PaintController(PaintModel model, PaintPanel view, OptionsPanel panel) {
        this.model = model;
        this.view = view;
        this.panel = panel;
        this.mode = PaintingMode.FREE;

        view.addMouseListener(this);
        view.addMouseMotionListener(this);

        panel.colorOptions.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String colorName = (String) cb.getSelectedItem();
                Color newColor = getColorFromString(colorName);
                setColor(newColor);
            }
        });
        
        //add ActionListener to all RadioButtons
        for (Enumeration<AbstractButton> buttonList = panel.modeOptions.getElements(); buttonList.hasMoreElements();)
            buttonList.nextElement().addActionListener(this);
        
        panel.clear.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                model.deleteAllLines();
                view.repaint();
            }
        });
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        if (mode.equals(PaintingMode.FREE)) {
            System.out.println("!");
            model.addLine(new Line(this.color, startX, startY, e.getX(), e.getY()));
            startX = e.getX();
            startY = e.getY();
            view.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.mode = PaintingMode.valueOf(e.getActionCommand());
    }
    
    public void setColor(Color newColor) {
        this.color = newColor;
    }

    public Color getColorFromString(String colorName) {
        Color color;
        try {
            // getting a Color-Object with Reflection
            Field field = Class.forName("java.awt.Color").getField(colorName.toUpperCase());
            color = (Color) field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }
        return color;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (mode) {
        case LINE:
            System.out.println("!");
            model.addLine(new Line(this.color, startX, startY, e.getX(), e.getY()));
            view.repaint();
            break;
        case RECT:
            int endX = e.getX();
            int endY = e.getY();
            addRectangleToModel(endX, endY);
            view.repaint();
            break;
        default:
            break;
        }        
    }
    
    private void addRectangleToModel(int endX, int endY) {
        int minX = Math.min(startX, endX);
        int maxX = Math.max(startX, endX);
        int minY = Math.min(startY, endY);
        int maxY = Math.max(startY, endY);
        model.addLine(new Line(this.color, minX, minY, minX, maxY));
        model.addLine(new Line(this.color, minX, maxY, maxX, maxY));
        model.addLine(new Line(this.color, maxX, maxY, maxX, minY));
        model.addLine(new Line(this.color, maxX, minY, minX, minY));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

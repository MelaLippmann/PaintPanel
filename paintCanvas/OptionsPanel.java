package paintCanvas;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class OptionsPanel extends JPanel {

    final JComboBox<String> colorOptions;
    final ButtonGroup modeOptions;
    final Button clear;

    public OptionsPanel() {
        String[] choices = { "Black", "Red", "Blue", "Green", "Yellow" };
        colorOptions = new JComboBox<String>(choices);
        modeOptions = new ButtonGroup();
        clear = new Button("Clear Canvas");
    }

    public void styleOptionsPanel() {
        this.setLayout(new GridLayout(10, 1, 20, 0));
        JLabel lbl = new JLabel("Choose the Color");
        lbl.setVisible(true);
        this.add(lbl);

        colorOptions.setMaximumSize(colorOptions.getPreferredSize());
        this.add(colorOptions);

        JLabel lbl2 = new JLabel("Choose Painting Mode");
        lbl2.setVisible(true);
        this.add(lbl2);

        JRadioButton freeButton = new JRadioButton("free Hand");
        freeButton.setMnemonic(KeyEvent.VK_F);
        freeButton.setActionCommand("FREE");
        freeButton.setSelected(true);

        JRadioButton lineButton = new JRadioButton("lines");
        lineButton.setMnemonic(KeyEvent.VK_L);
        lineButton.setActionCommand("LINE");

        JRadioButton rectButton = new JRadioButton("rectangles");
        rectButton.setMnemonic(KeyEvent.VK_R);
        rectButton.setActionCommand("RECT");

        modeOptions.add(freeButton);
        modeOptions.add(lineButton);
        modeOptions.add(rectButton);
        
        this.add(freeButton);
        this.add(lineButton);
        this.add(rectButton);
        
        this.add(clear);
    }

}

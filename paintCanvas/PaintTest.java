package paintCanvas;

import java.awt.BorderLayout;

import javax.swing.*;

public class PaintTest {

    public static void main(String[] args) {

        JFrame f = new JFrame("Paint Panel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setSize(700, 600);
        f.setLocationRelativeTo(null);

        System.out.println("Test");

        OptionsPanel optionsPanel = new OptionsPanel();
        optionsPanel.styleOptionsPanel();
        PaintModel model = new PaintModel();
        PaintPanel panel =new PaintPanel(model);
        PaintController controller = new PaintController(model, panel, optionsPanel);

        f.add(optionsPanel, BorderLayout.EAST);

        f.add(panel, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }

}

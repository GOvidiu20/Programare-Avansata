import javax.swing.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new ConfigPanel(this),"North");
        add(new ControlPanel(this),"South");
        canvas = new DrawingPanel(this);
        add(canvas, "Center");
        pack();
    }
}

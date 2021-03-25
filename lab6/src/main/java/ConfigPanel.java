import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    public static int sides;
    String[] colors = {"Black", "White"};
    JLabel label;
    JSpinner sidesField;
    JComboBox colorCombo = new JComboBox(colors);
    public int valueSpinner;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        JLabel sidesLabel = new JLabel("Number of sides:");
        JButton changeBtn = new JButton("Change");
        changeBtn.addActionListener(this::change);
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);
        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
        add(changeBtn);
        try {
            sidesField.commitEdit();
        } catch (java.text.ParseException e) {
            System.err.println(e);
        }
    }

    private void change(ActionEvent actionEvent) {
        valueSpinner=(Integer) sidesField.getValue();
        System.out.println(valueSpinner);
    }

    public int getCellEditorValue() {
        return valueSpinner;
    }
}

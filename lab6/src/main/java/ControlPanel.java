import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.JFileChooser;
import java.io.File;
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton exitBtn = new JButton("Exit");
    JButton resetBtn = new JButton("Reset");
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        setLayout(new GridLayout(1, 4));
        add(saveBtn,BorderLayout.SOUTH);
        add(loadBtn,BorderLayout.SOUTH);
        add(resetBtn,BorderLayout.SOUTH);
        add(exitBtn,BorderLayout.SOUTH);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }
    private void save(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                ImageIO.write(frame.canvas.image, "PNG",
                        new FileOutputStream(selectedFile.getAbsolutePath()));
            } catch (IOException ex) { System.err.println(ex); }
        }
    }
    private void load(ActionEvent e){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try{
                frame.canvas.image=ImageIO.read(new FileInputStream((selectedFile.getAbsolutePath())));
            }catch (IOException ex){
                System.err.println(ex);
            }
        }
    }
    private void reset(ActionEvent e){

    }
    private void exit(ActionEvent e){
        System.exit(0);
    }
}

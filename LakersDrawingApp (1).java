import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class LakersDrawingApp extends JFrame{

    private ArrayList <Shape> shapes = new ArrayList<>();
    private String shapeType = "Lakers Basketball";
    private Color currentColor = new Color(85, 37, 130);
    private JLabel statusLabel;

    public LakersDrawingApp(){
        setTitle("Lakers-Themed Drawing App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel controlPanel = new JPanel();

    // Display labels
    statusLabel = new JLabel("Shape: Basketball | Colour: Purple");
    controlPanel.add(statusLabel);

    //JBotton to clear the canvas
    JButton clearButton = new JButton("Clear Court");
    clearButton.addActionListener(e -> clearCanvas());
    controlPanel.add(clearButton);

    //JButton to reset to default settings 
    JButton resetButton = new JButton("Reset");
    resetButton.addActionListener(e -> resetSettings());
    controlPanel.add(resetButton);

    //JComboBox to select shape type (Basketball or Hoop)
    String[] shapeOptions = {"Basketball", "Hoop"};
    JComboBox<String> shapeSelector = new JComboBox <> (shapeOptions);
    shapeSelector.addActionListener(e -> {
        shapeType = (String) shapeSelector.getSelectedItem();
        updateStatus();
    });
    controlPanel.add(shapeSelector);

    //JRadioButtones for color selection (Purple or Gold)
    JRadioButton purpleButton = new JRadioButton("Purple", true);
    JRadioButton goldButton = new JRadioButton("Gold");
    ButtonGroup colorGroup = new ButtonGroup();
    colorGroup.add(purpleButton);
    colorGroup.add(goldButton);

    purpleButton.addActionListener(e -> {
        currentColor = new Color(85, 37, 130); //Purple
        updateStatus();
    });
    goldButton.addActionListener(e -> {
        currentColor = new Color(255, 223, 0);
        updateStatus();
    });
    controlPanel.add(purpleButton);
    controlPanel.add(goldButton);

    //Court panel for drawing
    CourtPanel courtPanel = new CourtPanel();
    courtPanel.setBackground(new Color(210, 180, 140));
    courtPanel.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
            drawShape(e.getX(), e.getY());
        }
    });
    courtPanel.addKeyListener(new KeyAdapter(){
        @Override
        public void keyPressed(KeyEvent e){
            handleKeyboardInput(e.getKeyChar());

        }
    });
    courtPanel.setFocusable(true);

    add(controlPanel, BorderLayout.NORTH);
    add(courtPanel, BorderLayout.CENTER);
    setVisible(true);

    }
    private void clearCanvas(){
        shapes.clear();
        repaint();
        updateStatus("Canvas cleared!");
    }

    private void resetSettings(){
        shapeType = "Basketball";
        currentColor = new Color(85, 37, 130);
        shapes.clear();
        repaint();
        updateStatus("Settings reset to default.");
    
    }
    private void drawShape(int x, int y){
        if (shapeType.equals("Basketball")){
            shapes.add(new Ellipse2D.Double(x - 15, y - 15, 30, 30));
        }else{
            shapes.add(new Rectangle(x - 20, y - 10, 40, 20));
        }
        repaint();
        updateStatus("Drawn: " + shapeType);
    }
    private void updateStatus(){
        statusLabel.setText("Shape: " + shapeType + " | Color:  " + (currentColor.equals(new Color(85, 37, 130)) ? "Purple" : "Gold"));
    }
    private void updateStatus(String message){
        statusLabel.setText(message);
    }

    private void handleKeyboardInput(char key){
        if(key == 'b'){
            shapeType = "Basketball";
            updateStatus();
        } else if (key == 'h') {
            shapeType = "Hoop";
            updateStatus();
        } else if (key == 'p'){
            currentColor = new Color(85, 37, 130);
            updateStatus();
        }else if (key == 'g'){
            currentColor = new Color(255, 223, 0);
            updateStatus();

        } else if (key == 'c'){
           
            clearCanvas();

        }else if (key == 'r'){
            resetSettings();
        }

    }
    class CourtPanel extends JPanel {
        @Override 
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(currentColor);
            for (Shape shape : shapes){
                g2.fill(shape);
            }
        }
    }
}
 

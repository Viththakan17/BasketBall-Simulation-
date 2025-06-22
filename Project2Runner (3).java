public class Project2Runner {
    
    /*
     * Name: <Viththakan Sitsabesan>
     * Student ID: <501171814>
     * 
     ******** Project Description ********
     * 
     * 
     * 
     * This is a Lakers-Themed Drawing App that is interactive graphical application 
     * development using Java Swing and 2D Graphics.The basket-ball related app enables 
     * users to choose from shapes (Basketball or Hoop) on a designed court. The colors 
     * that can be chosen for this project are either yellow or purple (Lakers colours).
     * The user is allowed to choose what shape and what colour they would like to use. 
     * The canvas can also be cleared or reset to default settings using the keyboard 
     * shortcuts or by mouse clicking the buttons.

     * Keyboard shortcuts
    ‘b’ : Selects Basketball shape
    ‘h’ : Selects Hoop shape
    ‘p’ : Purple colour change
    'g’ : Gold colour change
    ‘c’ : Canvas Clears
    ‘r’ : Reset to default settings
     *
     * 
     ******** Swing Requirement ********
    The Swing requirement was met with the inclusion of the three unique Swing
    components. JButton was used to cler the canvas in line 26 of the 
    LakersDrawingApp.java file. JComboBox was implemented in line 37 of the 
    LakersDrawingApp.java file when selecting the shape type(Basketball or hoop). 
    JRadioButton allows the user to choose the colour (Purple or Gold) and can 
    be found in line 45 of the LakersDrawingApp.java file. 

    
    These are all in the control panel at the top of the application for easy access.

     * 
     ******** 2D Graphics Requirement ********
     
     * For the drawing of the application, 2D graphics required with the use of 
     * JPanel is done. In the drawing panel of the application (CourtPanel), a 
     * basketball court is presented as that is where users can click to place 
     * shapes.The circles represent basketballs and rectangles represent the hoops 
     * are drawn using the Graphics2D object within the paintComponent method that 
     * can be found on line 128. The JPanel is updated with new shapes based on 
     * what the user mouse clicks.


     ******** Event Listener Requirement ********
     * 
     * The event listener requirement is fulfilled with the use of the “ActionListener”
     * and the “MouseListner”. The ActionListener uses the actions such as 
     * “Clear Court” and “Reset” buttons. This also handles the shape choices (JComboBox)
     * and colour choices (JRadioButton). These can be found in line 26 and line 31 of
     * the LakersDrawingApp.java file. MouseListener - The CourtPanel on the 
     * MouseListener allows the program to detect mouse clicks in order to place shapes.
     * This can be found in line 51 of the LakersDrawingApp.java file. The KeyListner 
     * is what detects any of the keyboard shortcuts that the user might prompt.
     * This can be found in line 54 in the LakersDrawingApp.java file. 

     * 
     * 
     */

    public static void main(String[] args) {
        new LakersDrawingApp();
    }
}

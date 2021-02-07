/*	Name: Jake Coombes
 * 	Date: 11/27/18
 * 	Description:
 * 		add the Greeting Panel to the GUI
 */

import java.awt.Color;

import javax.swing.*;

/**
 *  The GreetingPanel class is a specialized JPanel class.
 *  It displays a greeting for the application window.
 */

public class GreetingPanel extends JPanel
{
   /**
    *  Constructor
    */

   public GreetingPanel()
   {
      // Create the label.
      JLabel greeting =
          new JLabel("Welcome to Brandi's Bagel House");

      // Add the label to this panel.
      add(greeting);
   }
}

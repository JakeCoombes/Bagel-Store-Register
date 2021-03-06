/*	Name: Jake Coombes
 * 	Date: 11/27/18
 * 	Description:
 * 		Create a GUI menu that calculates an orders total
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
   The OrderCalculatorGUI class creates the GUI for the
   Brandi's Bagel House application.
*/

public class OrderCalculatorGUI extends JFrame
{
   private BagelPanel bagels;     // Bagel panel
   private ToppingPanel toppings; // Topping panel
   private CoffeePanel coffee;    // Coffee panel
   private GreetingPanel banner;  // To display a greeting
   private JPanel buttonPanel;    // To hold the buttons
   private JButton calcButton;    // To calculate the cost
   private JButton exitButton;    // To exit the application
   private final double TAX_RATE = 0.06; // Sales tax rate

   /**
      Constructor
   */

   public OrderCalculatorGUI()
   {
      // Display a title.
      setTitle("Order Calculator");

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a BorderLayout manager.
      setLayout(new BorderLayout());

      // Create the custom panels.
      banner = new GreetingPanel();
      bagels = new BagelPanel();
      toppings = new ToppingPanel();
      coffee = new CoffeePanel();

      // Create the button panel.
      buildButtonPanel();

      // Add the components to the content pane.
      add(banner, BorderLayout.NORTH);
      add(bagels, BorderLayout.CENTER);
      add(toppings, BorderLayout.EAST);
      add(coffee, BorderLayout.WEST);
      add(buttonPanel, BorderLayout.SOUTH);

      //make look and feel motif
      try
      {
    	  UIManager.setLookAndFeel
    	  	("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
    	  
    	  SwingUtilities.updateComponentTreeUI(this);
      }
      catch (Exception e)
      {
    	  JOptionPane.showMessageDialog
    	  (null, "Error setting the look and feel.");
      }
      
      //change background colors
      banner.setBackground(Color.YELLOW);
      bagels.setBackground(Color.CYAN); 
      coffee.setBackground(Color.GREEN); 
      toppings.setBackground(Color.PINK); 
      
      
      // Pack the contents of the window and display it.
      pack();
      setVisible(true);
   }

   /**
      The buildButtonPanel method builds the button panel.
   */

   private void buildButtonPanel()
   {
      // Create a panel for the buttons.
      buttonPanel = new JPanel();

      // Create the buttons.
      calcButton = new JButton("Calculate");
      exitButton = new JButton("Exit");

      // Register the action listeners.
      calcButton.addActionListener(new CalcButtonListener());
      exitButton.addActionListener(new ExitButtonListener());

      // Add the buttons to the button panel.
      buttonPanel.add(calcButton);
      buttonPanel.add(exitButton);
   }

   /**
      Private inner class that handles the event when
      the user clicks the Calculate button.
   */

   private class CalcButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
    	  // make sure the user is sure about the order
    	  int value;
    	  value = JOptionPane.showConfirmDialog(null,
    	  "Are you sure about your order?");
    	 
    	  if(value == JOptionPane.YES_OPTION)
    	  {
	         // Variables to hold the subtotal, tax, and total
	         double subtotal, tax, total;
	
	         // Calculate the subtotal.
	         subtotal = bagels.getBagelCost() + 
	                    toppings.getToppingCost() +
	                    coffee.getCoffeeCost();
	
	         // Calculate the sales tax.
	         tax = subtotal * TAX_RATE;
	
	         // Calculate the total.
	         total = subtotal + tax;
	
	         // Create a DecimalFormat object to format output.
	         DecimalFormat dollar = new DecimalFormat("0.00");
	
	         // Display the charges.
	         JOptionPane.showMessageDialog(null, "Subtotal: $" +
	                       dollar.format(subtotal) + "\n" +
	                       "Tax: $" + dollar.format(tax) + "\n" +
	                       "Total: $" + dollar.format(total));
    	  }
      }
   }

   /**
      Private inner class that handles the event when
      the user clicks the Exit button.
   */

   private class ExitButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
          System.exit(0);
      }
   }
   
   /**
      main method
   */
   
   public static void main(String[] args)
   {
      new OrderCalculatorGUI();
   }
}
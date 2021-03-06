/*	Name: Jake Coombes
 * 	Date: 11/27/18
 * 	Description:
 * 		add the toping options to the GUI and toping prices
 */

import java.awt.*;
import javax.swing.*;

/**
 *  The ToppingPanel class allows the user to select
 *  the toppings for the bagel.
 */

public class ToppingPanel extends JPanel
{
   // The following constants are used to indicate
   // the cost of toppings.
   public final double CREAM_CHEESE = 0.50;
   public final double BUTTER = 0.25;
   public final double PEACH_JELLY = 0.75;
   public final double BLUEBERRY_JAM = 0.75;
   public final double STRAWBERRY_JAM = BLUEBERRY_JAM;
   public final double NONE = 0.00;

   // Check boxes for the available toppings.
   private JCheckBox creamCheese;  	// Cream cheese
   private JCheckBox butter;       	// Butter
   private JCheckBox peachJelly;   	// Peach jelly
   private JCheckBox blueberryJam; 	// Blueberry jam
   private JCheckBox strawberryJam; // Strawberry jam
   private JCheckBox none;			//no toping
   
   /**
    *  Constructor
    */

   public ToppingPanel()
   {
      // Create a GridLayout manager with 
      // four rows and one column.
      setLayout(new GridLayout(4, 1));

      // Create the check boxes.
      none = new JCheckBox("No Toping");
      creamCheese = new JCheckBox("Cream cheese");
      butter = new JCheckBox("Butter");
      peachJelly = new JCheckBox("Peach jelly");
      blueberryJam = new JCheckBox("Blueberry jam");
      strawberryJam = new JCheckBox("Strawberry jam");

      // Add a border around the panel.
      setBorder(BorderFactory.createTitledBorder("Toppings"));

      // Add the check boxes to this panel.
      add(none);
      add(creamCheese);
      add(butter);
      add(peachJelly);
      add(blueberryJam);
      add(strawberryJam);
   }

   /**
    *  The getToppingCost method returns the cost of
    *  the selected topings.
    */

   public double getToppingCost()
   {
      // The following variable will hold the cost
      // of the selected toping.
      double toppingCost = 0.0;

      // Determine which of the topings are selected.
      // More than one may be selected.
      if (creamCheese.isSelected())
         toppingCost += CREAM_CHEESE;
      if (butter.isSelected())
         toppingCost += BUTTER;
      if (peachJelly.isSelected())
         toppingCost += PEACH_JELLY;
      if (blueberryJam.isSelected())
         toppingCost += BLUEBERRY_JAM;
      if (strawberryJam.isSelected())
    	  toppingCost += STRAWBERRY_JAM;

      // Return the toping cost.
      return toppingCost;
   }
}
// Class Accumulator keeps track of the state of an adding
// machine.  It accumulates digits to form entire numbers and
// either adds or subtracts those numbers to a cumulative sum.
// It also has a reset option.

// Adapted from:
// Stuart Reges (8/27/99)
//
// AddingMain provides method main for a graphical adding machine.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddingMain extends JFrame
{
   public AddingMain()
   {
   	// create frame and accumulator
      setSize(400, 450);
      setTitle("Adding Machine");
      Container contentPane = getContentPane();
      myAccumulator = new Accumulator();
   
   	// create and add text field for current display
      myText = new JTextField("0", 20);
      contentPane.add(myText, "North");
      myText.setHorizontalAlignment(JTextField.RIGHT);
   	
   	// create and add button panel for adding machine
      JPanel buttons = createButtonPanel();
      contentPane.add(buttons, "Center");
   	
   	// create and add clear button at the bottom
      JButton clear = new JButton("Clear");
      clear.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               myAccumulator.clear();
               updateDisplay();
            }
         });
      contentPane.add(clear, "South");
   
      addWindowListener(
          new WindowAdapter() {
             public void windowClosing(WindowEvent e)
             {
                System.exit(0);
             }
          });
   }

   private JPanel createButtonPanel()
   // post: creates a panel of buttons with digits placed as
   //       in an adding machine, with minus and plus buttons
   //       surrounding 0 in the bottom row.  Adds listeners
   //       to each button to modify accumulator and update
   //       the display.
   {
      JPanel buttons = new JPanel();
      buttons.setLayout(new GridLayout(4, 3));
      digitButton(buttons, 7);
      digitButton(buttons, 8);
      digitButton(buttons, 9);
      digitButton(buttons, 4);
      digitButton(buttons, 5);
      digitButton(buttons, 6);
      digitButton(buttons, 1);
      digitButton(buttons, 2);
      digitButton(buttons, 3);
      JButton minus = new JButton("-");
      minus.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               myAccumulator.minus();
               updateDisplay();
            }
         });
      buttons.add(minus);
      digitButton(buttons, 0);
      JButton plus = new JButton("+");
      plus.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               myAccumulator.plus();
               updateDisplay();
            }
         });
      buttons.add(plus);
      return buttons;
   }
	
   private void digitButton(JPanel buttons, final int value)
   // post: adds a single digit button to the buttons panel
   //       and adds a listener that calls the accumulator
   //       with that digit value.
   {
      JButton b = new JButton("" + value);
      b.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               myAccumulator.addDigit(value);
               updateDisplay();
            }
         });
      buttons.add(b);
   }
	
   private void updateDisplay()
   // post: updates the text display to the current display
   //       value returned by the accumulator
   {
      myText.setText("" + myAccumulator.getDisplay());
   }
	
   private Accumulator myAccumulator; // accumulator for math
   private JTextField myText;         // text display

   public static void main(String[] args)
   {
      AddingMain f = new AddingMain();
      f.show();
   }
}
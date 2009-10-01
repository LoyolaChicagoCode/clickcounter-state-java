package clickcounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * An interface whose presentation is built entirely using JBuilder.
 * All commented code was added manually.
 */

public class JBuilderPresentation extends JPanel implements Presentation {
  BorderLayout borderLayout1 = new BorderLayout();
  JLabel valueDisplay = new JLabel();
  JPanel jPanel1 = new JPanel();
  JButton incrementButton = new JButton();
  GridLayout gridLayout1 = new GridLayout();
  JButton resetButton = new JButton();
  JButton decrementButton = new JButton();

  /**
   * List of listeners for making this presentation object an event source.
   * In this way, the presentation knows nothing about the translation.  The
   * translation is simply added as one of the listeners.
   */
  private ActionListener listeners = null;

  /**
   * Default constructor.
   */
  public JBuilderPresentation() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    valueDisplay.setHorizontalAlignment(SwingConstants.CENTER);
    valueDisplay.setText("0");
    this.setLayout(borderLayout1);
    incrementButton.setBackground(Color.green);
    incrementButton.setActionCommand("increment");
    incrementButton.setText("+");
    incrementButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        incrementButton_actionPerformed(e);
      }
    });
    jPanel1.setLayout(gridLayout1);
    resetButton.setBackground(Color.green);
    resetButton.setForeground(Color.red);
    resetButton.setActionCommand("reset");
    resetButton.setText("0");
    resetButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        resetButton_actionPerformed(e);
      }
    });
    decrementButton.setBackground(UIManager.getColor("InternalFrame.borderDarkShadow"));
    decrementButton.setActionCommand("decrement");
    decrementButton.setText("-");
    decrementButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        decrementButton_actionPerformed(e);
      }
    });
    this.setBackground(Color.orange);
    jPanel1.setBackground(Color.red);
    this.add(valueDisplay,  BorderLayout.CENTER);
    this.add(jPanel1,  BorderLayout.SOUTH);
    jPanel1.add(incrementButton, null);
    jPanel1.add(resetButton, null);
    jPanel1.add(decrementButton, null);
  }

  /**
   * Forwards this event to the translation object.
   */
  void incrementButton_actionPerformed(ActionEvent e) {
    if (listeners != null)
      listeners.actionPerformed(e);
  }

  /**
   * Forwards this event to the translation object.
   */
  void resetButton_actionPerformed(ActionEvent e) {
    if (listeners != null)
      listeners.actionPerformed(e);
  }

  /**
   * Forwards this event to the translation object.
   */
  void decrementButton_actionPerformed(ActionEvent e) {
    if (listeners != null)
      listeners.actionPerformed(e);
  }

  /**
   * Sets the string being displayed.
   */
  public void setValueDisplay(int newValue) {
    valueDisplay.setText(Integer.toString(newValue));
  } // End setValueDisplay.

  /**
   * Makes the presentation correspond to the logical minimum state
   * in the translation.
   */
  public void setMinimumState() {
    incrementButton.setEnabled(true);
    resetButton.setEnabled(false);
    decrementButton.setEnabled(false);
  } // End setMinimumState.

  /**
   * Makes the presentation correspond to the logical counting state
   * in the translation.
   */
  public void setCountingState() {
    incrementButton.setEnabled(true);
    resetButton.setEnabled(true);
    decrementButton.setEnabled(true);
  } // End setCountingState.

  /**
   * Makes the presentation correspond to the logical maximum state
   * in the translation.
   */
  public void setMaximumState() {
    incrementButton.setEnabled(false);
    resetButton.setEnabled(true);
    decrementButton.setEnabled(true);
  } // End setMaximumState.

  /**
   * Adds an ActionListener to this presentation object.
   */
  public synchronized void addActionListener(ActionListener l) {
    listeners = AWTEventMulticaster.add(l, listeners);
  }

  /**
   * Removes an ActionListener from this presentation object.
   */
  public synchronized void removeActionListener(ActionListener l) {
    listeners = AWTEventMulticaster.remove(l, listeners);
  }
}
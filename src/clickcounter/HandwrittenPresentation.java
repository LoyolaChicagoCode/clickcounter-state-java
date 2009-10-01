package clickcounter;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.event.EventListenerList;

/**
 * An interactive interface for the ClickCounter class.
 */

public class HandwrittenPresentation
    extends JPanel
    implements Presentation, EventLabels {

  // the presentation components
    
  private JButton incrementButton = new JButton("+");
  private JButton resetButton     = new JButton("0");
  private JButton decrementButton = new JButton("-");
//  private JLabel  valueDisplay    = new JLabel();
  private JProgressBar valueDisplay = new JProgressBar();
  private JPanel  buttonPanel    = new JPanel();

  /** 
   * An auxiliary object for formatting a number with three digits.
   */  
  private DecimalFormat format = new DecimalFormat("000");

  /**
   * List of listeners for making this presentation object an event source.
   * In this way, the presentation knows nothing about the translation.  The
   * translation is simply added as one of the listeners.
   */
  private EventListenerList listeners = new EventListenerList();

  public HandwrittenPresentation() {
    // build the visible interface
    this.setLayout(new BorderLayout());
    this.add(valueDisplay, BorderLayout.CENTER);
//    valueDisplay.setHorizontalAlignment(JLabel.CENTER);
    // TODO parameterize properly
    valueDisplay.setMinimum(0);
    valueDisplay.setMaximum(5);
    valueDisplay.setStringPainted(true);
    buttonPanel.setLayout(new GridLayout(1, 0));
    buttonPanel.add(incrementButton);
    buttonPanel.add(resetButton);
    buttonPanel.add(decrementButton);
    this.add(buttonPanel,  BorderLayout.SOUTH);

    // a listener that forwards events from 
    // internal event sources to external event listeners
    ActionListener forwardListener = new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Object[] currentListeners = listeners.getListenerList();
        for (int i = currentListeners.length - 2; i >= 0; i -= 2) {
          if (currentListeners[i] == ActionListener.class) {
            ((ActionListener) currentListeners[i + 1]).actionPerformed(event);
          }
        }
      }
    };
    // listen to events of interest 
    incrementButton.setActionCommand(INCREMENT);
    resetButton.setActionCommand(RESET);
    decrementButton.setActionCommand(DECREMENT);
    incrementButton.addActionListener(forwardListener);
    resetButton.addActionListener(forwardListener);
    decrementButton.addActionListener(forwardListener);
  } // end HandwrittenPresentation constructor.

  public void addActionListener(ActionListener l) {
    listeners.add(ActionListener.class, l);
  }

  public void removeActionListener(ActionListener l) {
    listeners.remove(ActionListener.class, l);
  }

  public void setValueDisplay(int newValue) {
    valueDisplay.setValue(newValue);
//    valueDisplay.setText(format.format(newValue));
  } // End setValueDisplay.

  public void setMinimumState() {
    incrementButton.setEnabled(true);
    resetButton.setEnabled(false);
    decrementButton.setEnabled(false);
  } // End setMinimumState.

  public void setCountingState() {
    incrementButton.setEnabled(true);
    resetButton.setEnabled(true);
    decrementButton.setEnabled(true);
  } // End setCountingState.

  public void setMaximumState() {
    incrementButton.setEnabled(false);
    resetButton.setEnabled(true);
    decrementButton.setEnabled(true);
  } // End setMaximumState.

} // end class HandwrittenPresentation.

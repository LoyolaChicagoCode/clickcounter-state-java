package clickcounter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Provides the interface behaviour for the interactive
 * ClickCounter.
 */

public class ClickCounterTranslation implements ActionListener, EventLabels {

  private ClickCounter theCounter;
  private Presentation visibleInterface;
  private ClickCounterState theState;

  /**
   * This method provides this translation with a reference to the
   * application.
   */
  public void setApplication(ClickCounter app) {
    theCounter = app;
  }

  /**
   * This method provides this translation with a visible interface
   * (presentation).
   */
  public void setVisibleInterface(Presentation visibleInterface) {
    this.visibleInterface = visibleInterface;
    visibleInterface.setValueDisplay(theCounter.countIs());
    visibleInterface.setMinimumState();
    theState = MINIMUM;
  } // end init.

  public void actionPerformed(ActionEvent event) {
    // handle global events first
    String buttonPressed = event.getActionCommand();
    if (RESET.equals(buttonPressed)) {
        theCounter.reset();
        visibleInterface.setMinimumState();
        changeState(MINIMUM);
        visibleInterface.setValueDisplay(theCounter.countIs());
    } else {
      // use the State pattern for handling state-specific events
      theState.actionPerformed(event);
    }
  }

  protected void changeState(ClickCounterState state) {
    theState = state;
  }

  /**
   * Interface to support the State pattern.
   */
  private interface ClickCounterState extends ActionListener {
  }

  private final ClickCounterState MINIMUM = new ClickCounterState() {
    public void actionPerformed(ActionEvent event) {
      String buttonPressed = event.getActionCommand();
      if (INCREMENT.equals(buttonPressed)) {
        theCounter.count();
        if (theCounter.isAtMaximum()) {
          visibleInterface.setMaximumState();
          changeState(MAXIMUM);
        } else {
          visibleInterface.setCountingState();
          changeState(COUNTING);
        }
      }
      visibleInterface.setValueDisplay(theCounter.countIs());
    }
  };

  private final ClickCounterState COUNTING = new ClickCounterState() {
    public void actionPerformed(ActionEvent event) {
      String buttonPressed = event.getActionCommand();
      if (INCREMENT.equals(buttonPressed)) {
        theCounter.count();
        if (theCounter.isAtMaximum()) {
          visibleInterface.setMaximumState();
          changeState(MAXIMUM);
        }
      } else if (DECREMENT.equals(buttonPressed)) {
        theCounter.unCount();
        if (theCounter.isAtMinimum()) {
          visibleInterface.setMinimumState();
          changeState(MINIMUM);
        } // End if.
      } // End if.
      visibleInterface.setValueDisplay(theCounter.countIs());
    }
  };

  private final ClickCounterState MAXIMUM = new ClickCounterState() {
    public void actionPerformed(ActionEvent event) {
      String buttonPressed = event.getActionCommand();
      if (DECREMENT.equals(buttonPressed)) {
        theCounter.unCount();
        if (theCounter.isAtMinimum()) {
          visibleInterface.setMinimumState();
          changeState(MINIMUM);
        } else {
          visibleInterface.setCountingState();
          changeState(COUNTING);
        } // End if.
      } // End if.
      visibleInterface.setValueDisplay(theCounter.countIs());
    }
  };

} // end class ClickCounterTranslation.

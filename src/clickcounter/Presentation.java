package clickcounter;

import java.awt.event.ActionListener;

/**
 * An interface for ClickCounter presentation classes.
 */

public interface Presentation {

  void setValueDisplay(int newValue);
  void setMinimumState();
  void setCountingState();
  void setMaximumState();

  void addActionListener(ActionListener l);
  void removeActionListener(ActionListener l);

} // end class Presentation.

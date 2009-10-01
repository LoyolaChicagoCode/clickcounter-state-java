package clickcounter;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.event.ActionListener;

/**
 * Provides the interface behaviour for the interactive ClickCounter.
 */

public class ClickCounterMain extends JApplet {

  public void init() {
    // create a translation independently from the presentation
    ClickCounterTranslation translation = new ClickCounterTranslation();
    // decide here which presentation to use
    // (this decision used to be hidden in the translation class)
//    Presentation visibleInterface = new EclipseVEPresentation();
    Presentation visibleInterface = new HandwrittenPresentation();
//    Presentation visibleInterface = new JBuilderPresentation();
    // hook the components up to each other
    translation.setApplication(new ClickCounter(0, 5));
    translation.setVisibleInterface(visibleInterface);
    // the presentation acts as an event source using the
    // Java Swing event multicast mechanism
    visibleInterface.addActionListener(translation);
    // add another listener to the presentation for illustration purposes
    visibleInterface.addActionListener(new ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        System.out.println("Event: " + e.getActionCommand());
      }
    });
    // add the presentation to this applet
    this.getContentPane().add((JComponent) visibleInterface);
  } // end init.

  public static void main(String args[]) {
    // create a frame around the applet
    JFrame frame = new JFrame("Click Counter Demo");
    ClickCounterMain theInterface = new ClickCounterMain();
    // invoke the applet's lifecycle methods manually
    theInterface.init();
    // put the applet into the frame
    frame.setContentPane(theInterface);
    // bring the close button to life
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // lay out components in the frame
    frame.pack();
    // make the GUI visible
    frame.setVisible(true);
  } // end main.
} // end class ClickCounterTranslation.


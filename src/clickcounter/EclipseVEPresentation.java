package clickcounter;

import java.awt.AWTEventMulticaster;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * An interface whose presentation is built entirely using Eclipse Visual Editor.
 * Certain marked code was added manually.
 * Note that the action commands for the buttons had to be entered
 * as string literals instead of constants, otherwise VE would get confused. 
 */
public class EclipseVEPresentation extends JPanel implements Presentation, EventLabels {

	private JLabel valueDisplay = null;
	private JPanel jPanel = null;
	private JButton incrementButton = null;
	private JButton resetButton = null;
	private JButton decrementButton = null;

  /**
   * List of listeners for making this presentation object an event source.
   * In this way, the presentation knows nothing about the translation.  The
   * translation is simply added as one of the listeners.
   * We are using an empty action listener as the initial value.
   */
  private ActionListener listener = new ActionListener() {
    public void actionPerformed(ActionEvent event) { } 
  };
    
  private DecimalFormat format = new DecimalFormat("000");

    /* (non-Javadoc)
     * @see clickcounter.Presentation#setValueDisplay(int)
     */
    public void setValueDisplay(int newValue) {
      // body of this auto-generated method added manually                  
      valueDisplay.setText(format.format(newValue));
    }

    /* (non-Javadoc)
     * @see clickcounter.Presentation#setMinimumState()
     */
    public void setMinimumState() {
      // body of this auto-generated method added manually                  
      incrementButton.setEnabled(true);
      resetButton.setEnabled(false);
      decrementButton.setEnabled(false);
    }

    /* (non-Javadoc)
     * @see clickcounter.Presentation#setCountingState()
     */
    public void setCountingState() {
      // body of this auto-generated method added manually                  
      incrementButton.setEnabled(true);
      resetButton.setEnabled(true);
      decrementButton.setEnabled(true);
    }

    /* (non-Javadoc)
     * @see clickcounter.Presentation#setMaximumState()
     */
    public void setMaximumState() {
      // body of this auto-generated method added manually                  
      incrementButton.setEnabled(false);
      resetButton.setEnabled(true);
      decrementButton.setEnabled(true);
    }

    /* (non-Javadoc)
     * @see clickcounter.Presentation#addActionListener(java.awt.event.ActionListener)
     */
    public void addActionListener(ActionListener l) {
      listener = AWTEventMulticaster.add(listener, l);
    }

    /* (non-Javadoc)
     * @see clickcounter.Presentation#removeActionListener(java.awt.event.ActionListener)
     */
    public void removeActionListener(ActionListener l) {
      listener = AWTEventMulticaster.remove(listener, l);
    }

	/**
	 * This is the default constructor
	 */
	public EclipseVEPresentation() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() {
		valueDisplay = new JLabel();
		this.setLayout(new BorderLayout());
		this.setSize(300,200);
		valueDisplay.setText("abc");
		valueDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		valueDisplay.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 36));
		valueDisplay.setPreferredSize(new java.awt.Dimension(100,60));
		this.add(valueDisplay, java.awt.BorderLayout.CENTER);
		this.add(getJPanel(), java.awt.BorderLayout.SOUTH);
	}
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel() {
		if (jPanel == null) {
			java.awt.GridLayout gridLayout1 = new GridLayout();
			jPanel = new JPanel();
			jPanel.setLayout(gridLayout1);
			gridLayout1.setRows(1);
			jPanel.add(getIncrementButton(), null);
			jPanel.add(getResetButton(), null);
			jPanel.add(getDecrementButton(), null);
		}
		return jPanel;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getIncrementButton() {
		if (incrementButton == null) {
			incrementButton = new JButton();
			incrementButton.setActionCommand("increment");
			incrementButton.setText("+");
			incrementButton.setBackground(java.awt.Color.green);
			incrementButton.setMnemonic(java.awt.event.KeyEvent.VK_ADD);
			incrementButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
          // body of this auto-generated method added manually                  
          listener.actionPerformed(e);
				}
			});
		}
		return incrementButton;
	}
	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getResetButton() {
		if (resetButton == null) {
			resetButton = new JButton();
			resetButton.setActionCommand("reset");
			resetButton.setText("0");
			resetButton.setBackground(java.awt.Color.orange);
			resetButton.setMnemonic(java.awt.event.KeyEvent.VK_NUMPAD0);
			resetButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
          // body of this auto-generated method added manually                  
          listener.actionPerformed(e);
				}
			});
		}
		return resetButton;
	}
	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getDecrementButton() {
		if (decrementButton == null) {
			decrementButton = new JButton();
			decrementButton.setText("-");
			decrementButton.setActionCommand("decrement");
			decrementButton.setBackground(java.awt.Color.red);
			decrementButton.setMnemonic(java.awt.event.KeyEvent.VK_SUBTRACT);
			decrementButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
          // body of this auto-generated method added manually                  
          listener.actionPerformed(e);
				}
			});
		}
		return decrementButton;
	}
    }

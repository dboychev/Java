import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FractalMaker1 extends JApplet implements ActionListener {
	
	private final int APPLET_WIDTH = 500;
	private final int APPLET_HEIGHT = 500;
	
	private final int MIN = 1, MAX = 5;		// min and max orders for fractal
	
	private JButton increase, decrease;
	private JLabel titleLabel, orderLabel;
	private FractalPanel1 drawing;
	private JPanel appletPanel, infoPanel;
	
	public void init() {

		infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		infoPanel.setBackground(Color.yellow);
		infoPanel.setOpaque(true);
		
		titleLabel = new JLabel("Sierpinski's Carpet");
		titleLabel.setForeground(Color.black);
		
		increase = new JButton("Increase");
		increase.addActionListener(this);
		decrease = new JButton("Decrease");
		decrease.addActionListener(this);
		
		orderLabel = new JLabel("Order: 1");
		orderLabel.setForeground(Color.black);
		
		infoPanel.add(titleLabel);
		infoPanel.add(decrease);
		infoPanel.add(increase);
		infoPanel.add(orderLabel);
		
		drawing = new FractalPanel1(1);
		appletPanel = new JPanel();
		appletPanel.add(infoPanel);
		appletPanel.add(drawing);
		
		getContentPane().add(appletPanel);
		
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		
	}
	
	public void actionPerformed(ActionEvent event) {

		// When a button is clicked, this object detects the event and
		// calls this method. This method determines which button was
		// the source of the event and updates order of fractal
		// appropriately.
		
		int order = drawing.getOrder();
		if (event.getSource() == increase) {
			if (order < MAX)
				order++;
		}
		else {
			if (order > MIN)
				order--;
		}
		orderLabel.setText("Order: " + order);
		drawing.setOrder(order);
		repaint();
	}

}

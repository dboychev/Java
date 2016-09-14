import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumericValuePanel extends JPanel
{
	private int number;
	private JButton increment;
	private JButton decrement;
	private JLabel label;
	
	public NumericValuePanel()
	{
		number = 50;
		
		increment = new JButton("Increment!");
		increment.addActionListener(new ButtonListenerIncrement());
		
		decrement = new JButton("Decrement!");
		decrement.addActionListener(new ButtonListenerDecrement());
		
		label = new JLabel("Number: " + number);
		
		add(increment);
		add(decrement);
		add(label);
		
		setPreferredSize(new Dimension(300, 100));
		setBackground(Color.gray);
	}
	
	private class ButtonListenerIncrement implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			number++;
			label.setText("Number: " + number);
		}
	}

	private class ButtonListenerDecrement implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			number--;
			label.setText("Number: " + number);
		}
	}
	
	
}

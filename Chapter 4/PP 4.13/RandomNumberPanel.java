import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class RandomNumberPanel extends JPanel
{
	private int number;
	private JButton push;
	private JLabel label;

	Random generator = new Random();
	
	public RandomNumberPanel()
	{

		number = generator.nextInt(100) + 1;
		
		push = new JButton("Pick a random number!");
		push.addActionListener(new ButtonListener());
		
		label = new JLabel("Number: " + number);
		
		add(push);
		add(label);
		
		setPreferredSize(new Dimension(300,50));
		setBackground(Color.gray);
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			number = generator.nextInt(100) + 1;
			label.setText("Number: " + number);
		}
	}
}

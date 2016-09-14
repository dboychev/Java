import javax.swing.JFrame;

public class RandomNumber 
{

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Random Number Picker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new RandomNumberPanel());
		
		frame.pack();
		frame.setVisible(true);
	}

}

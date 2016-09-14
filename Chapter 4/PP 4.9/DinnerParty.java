import javax.swing.JFrame;

public class DinnerParty 
{

	public static void main (String[] args)
	{
		JFrame frame = new JFrame("Diner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DinerPanel panel = new DinerPanel();
		
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
}

import javax.swing.JPanel;
import java.awt.*;

public class DinerPanel extends JPanel
{
	private Diner diner1, diner2, diner3, diner4, diner5, diner6;
	
	private final int BASEX = 120, BASEY = 60;
	
	public DinerPanel()
	{
		diner1 = new Diner("Georgi", "male", 105, 60);
		diner2 = new Diner("Maria", "female", 195, 60);
		diner3 = new Diner("Dimitar", "male", 245, 130);
		diner4 = new Diner("Todor", "male", 195, 200);
		diner5 = new Diner("Petar", "male", 105, 200);
		diner6 = new Diner("Vanya", "female", 55, 130);
		
		setPreferredSize(new Dimension(400, 400));
		setBackground(Color.gray);
		setFont(new Font("Arial", Font.BOLD, 12));
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		
		diner1.draw(page);
		diner2.draw(page);
		diner3.draw(page);
		diner4.draw(page);
		diner5.draw(page);
		diner6.draw(page);
		
		page.drawRoundRect(140, 145, 100, 50, 2, 2);
		page.setColor(Color.white);
		page.fillRect(140, 145, 101, 51);
		page.setColor(Color.red);
		page.setFont(new Font("Arial", Font.BOLD, 16));
		page.drawString("Dinner Table", 140, 175);
	}
}

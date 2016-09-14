import java.awt.*;
import javax.swing.JFrame;

public class Diner 
{
	private String name;
	private Color color;
	private int x;
	private int y;
	private final int diameter = 80;
	
	public Diner(String newName, String newGender, int newX, int newY)
	{
		setName(newName);
		setGender(newGender);
		setX(newX);
		setY(newY);
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
	
	public void setGender(String newGender)
	{
		if (newGender == "male")
		{
			color = Color.blue;
		}
		
		if (newGender == "female")
		{
			color = Color.pink;
		}
	}
	
	public void setX(int newX)
	{
		x = newX;
	}
	
	public void setY(int newY)
	{
		y = newY;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public String getGender()
	{
		String gender;
		if (color == Color.blue)
		{
			gender = new String("male");
		}

		else
		{
			gender = new String("female");
		}
		return gender;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}

	public void draw(Graphics page) 
	{
		page.setColor(color);
		page.fillOval(x, y, diameter, diameter);
		
		page.setColor(Color.black);
		page.drawString(name, x+22, y+44);
	}
}

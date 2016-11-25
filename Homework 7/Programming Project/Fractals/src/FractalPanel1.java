import java.awt.*;
import javax.swing.*;

public class FractalPanel1 extends JPanel {
	
	private final int PANEL_WIDTH = 400;
	private final int PANEL_HEIGHT = 400;
	private final int TOPLEFTX = 50, TOPLEFTY = 50;
	private final int WIDTH = 300, HEIGHT = 300;
	private int currentOrder;
	private Graphics page;		// object where drawing is done
	
	public FractalPanel1(int order) {
		currentOrder = order;
		setBackground(Color.black);
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
	}
	
	public void drawFractal(int order, int x1, int y1, int width, int height) 
	{
		
		// Draw the Sierpinski's Carpet RECURSIVELY in an area whose top left coordinate 
		// is (x1,y1) with the given width and height. Divide the area into 9 equal sized
		// squares and draw a filled rectangle in the middle square. If the order is not 1,
		// recursively draw Sierpinski Carpets of order-1 in the remaining eight squares.
		
		// COMPLETE YOUR CODE HERE:
		
		//Create a variable at each loop that every time gets 3 times smaller
		//this variable always shows the distance between two points of one kind (one size and in one sq area)
		int len = width / 3; 
		
		//Crate a filled rectangle
		page.fillRect(x1 + len, y1 + len, len, len);
				
		//When order is bigger than 1, there is more than 1 figure
		if (order > 1)
		{
			//Change the coordinates of the rectangles, so all the 8 zones could be filled
			drawFractal(order - 1, x1, y1, len, len);
			drawFractal(order - 1, x1 + len, y1, len, len);
			drawFractal(order - 1, x1 + 2 * len, y1, len, len);
			drawFractal(order - 1, x1, y1 + len, len, len);
			drawFractal(order - 1, x1 + 2 * len, y1 + len, len, len);
			drawFractal(order - 1, x1, y1 + 2 * len, len, len);
			drawFractal(order - 1, x1 + len, y1 + 2 * len, len, len);
			drawFractal(order - 1, x1 + 2 * len, y1 + 2 * len, len, len);			
		}
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		page = g;
		page.setColor(Color.green);
		
		// Draw initial square region for fractal	
		page.drawRect(TOPLEFTX, TOPLEFTY, WIDTH, HEIGHT);
		
		// Recursively draw fractal of given order in square region		
		drawFractal(currentOrder, TOPLEFTX, TOPLEFTY, WIDTH, HEIGHT);
	}
	
	public void setOrder(int order) {
		currentOrder = order;
	}

	public int getOrder() {
		return currentOrder;
	}
}

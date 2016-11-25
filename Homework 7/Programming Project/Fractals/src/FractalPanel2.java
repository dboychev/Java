import java.awt.*;
import javax.swing.*;

public class FractalPanel2 extends JPanel {

	private final int PANEL_WIDTH = 400;
	private final int PANEL_HEIGHT = 400;
	private final int TOPX = 200, TOPY = 50;
	private final int LEFTX = 50, LEFTY = 350;
	private final int RIGHTX = 350, RIGHTY = 350;
	private int currentOrder;
	private Graphics page;		// object where drawing is done
	
	public FractalPanel2(int order) {
		currentOrder = order;
		setBackground(Color.black);
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
	}
	
	public void drawFractal(int order, int topx, int topy, int leftx, int lefty, int rightx, int righty) {
		
		// Draw the Sierpinski's Triangle RECURSIVELY in a triangular area whose top coordinate 
		// is (topx, topy), bottom left coordinate is (leftx, lefty) and bottom right 
		// coordinate is (rightx, righty): Draw a triangle by connecting the midpoints
		// of the triangle given by the coordinates of the parameters. If the order of 
		// this fractal is not 1, recursively draw Sierpinski Triangles of order-1 in 
		// each of the triangles created except the middle (upside-down) triangle.
		
		// COMPLETE YOUR CODE HERE:
		
		//Create 6 new variables for the new points
		int x1 = topx;
		int y1 = lefty;
		int x2 = topx - (topx - leftx) / 2;
		int y2 = lefty - (lefty - topy) / 2;
		int x3 = rightx - (rightx - topx) / 2;;
		int y3 = righty - (righty - topy) / 2;
		
		//Draw the triangle by connecting the points
		page.drawLine(x1, y1, x2, y2);
		page.drawLine(x2, y2, x3, y3);
		page.drawLine(x3, y3, x1, y1);

		//If order is bigger than 1, there is more than one triangle that should be drawn
		if (order > 1)
		{
			drawFractal(order - 1, topx, topy, x2, y2, x3, y3);
			drawFractal(order - 1, x2, y2, leftx, lefty, x1, y1);
			drawFractal(order - 1, x3, y3, x1, y1, rightx, righty);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		page = g;
		page.setColor(Color.green);
		
		// Draw initial triangular region for fractal
		page.drawLine(TOPX, TOPY, LEFTX, LEFTY);
		page.drawLine(TOPX, TOPY, RIGHTX, RIGHTY);
		page.drawLine(LEFTX, LEFTY, RIGHTX, RIGHTY);

		// Recursively draw fractal of given order in triangular region
		drawFractal(currentOrder, TOPX, TOPY, LEFTX, LEFTY, RIGHTX, RIGHTY);
	}
	
	public void setOrder(int order) {
		currentOrder = order;
	}

	public int getOrder() {
		return currentOrder;
	}
	
}

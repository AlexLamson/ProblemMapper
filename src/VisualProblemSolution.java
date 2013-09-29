//VisualProblemSolution.java
//renders the ProblemSolution

import java.awt.Color;
import java.awt.Graphics;

public class VisualProblemSolution extends ProblemSolution
{
	public int x, y;				//x,y is the center of the problem and solution
	public int width, height;		//height is the height of problem + height of solution
	
	public VisualProblemSolution(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		Color red = new Color(255, 0, 0);
		Color green = new Color(0, 255, 0);
		
		g.setColor(green);
		g.fillRect(x-width/2, y-height/2, width, height/2);
		
		g.setColor(red);
		g.fillRect(x-width/2, y, width, height/2);
		
		g.setColor(Color.black);
		g.drawRect(x-width/2, y-height/2, width, height);
		g.drawLine(x-width/2, y, x+width/2, y);
	}
}
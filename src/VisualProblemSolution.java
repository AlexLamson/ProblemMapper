//VisualProblemSolution.java
//renders the ProblemSolution

import java.awt.Color;
import java.awt.Graphics;

public class VisualProblemSolution extends ProblemSolution
{
	public int x, y;					//x,y is the center of the problem and solution
	public static final int width = 300, height = 200;	//height is the height of problem + height of solution
	
	public VisualProblemSolution(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		Color red = new Color(255, 0, 0);
		Color green = new Color(0, 255, 0);
		
		g.setColor(green);
		g.fillRect(x-width/2-Main.camX, y-height/2, width, height/2);
		
		g.setColor(red);
		g.fillRect(x-width/2-Main.camX, y, width, height/2);
		
		g.setColor(Color.black);
		g.drawRect(x-width/2-Main.camX, y-height/2, width, height);
		g.drawLine(x-width/2-Main.camX, y, x+width/2-Main.camX, y);
	}
}
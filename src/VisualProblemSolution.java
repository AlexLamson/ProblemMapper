//VisualProblemSolution.java
//renders the ProblemSolution

import java.awt.Color;
import java.awt.Graphics;

public class VisualProblemSolution extends ProblemSolution
{
	public int x, y;					//x,y is the center of the problem and solution
	public static final int width = 300, height = 200;	//height is the height of problem + height of solution
	public static final int padding = 50;	//the minimum distance that 2 problems must be apart
	
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
		Color red = new Color(255, 108, 90);
		Color green = new Color(183, 241, 140);
		
		//fill problem
		g.setColor(red);
		g.fillRect(x-width/2-Main.line.camX, y, width, height/2);
		
		//fill solution
		g.setColor(green);
		g.fillRect(x-width/2-Main.line.camX, y-height/2, width, height/2);
		
		//draw black lines
		g.setColor(Color.black);
		g.drawRect(x-width/2-Main.line.camX, y-height/2, width, height);
		g.drawLine(x-width/2-Main.line.camX, y, x+width/2-Main.line.camX, y);
		
		//draw IDs
		int IDwidth = 40, IDheight = 15;
		g.drawString("ID "+problem.id, x+width/2-Main.line.camX - IDwidth, y-height/2 + IDheight);
		g.drawString("ID "+solutions.get(selectedSolution).id, x+width/2-Main.line.camX - IDwidth, y + IDheight);
	}
}
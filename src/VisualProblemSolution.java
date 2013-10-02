//VisualProblemSolution.java
//renders the ProblemSolution

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class VisualProblemSolution extends ProblemSolution
{
	public int x, y;					//x,y is the center of the problem and solution
	public static final int width = 300, height = 200, stripeHeight = 10;	//height is the height of problem + height of solution
	public static final int padding = 50;	//the minimum distance that 2 problems must be apart
	
	public Color color;
	public static int colorPos = 0;
	
	public VisualProblemSolution(int x, int y)
	{
		this.x = x;
		this.y = y;
		color = niceColor();
	}
	
	// generate random int between floor and ceiling, inclusive
	public int random(int floor, int ceiling)
	{
		if(ceiling < 0)
			return 0;
		return (int)((Math.random()*(1.0 + ceiling - floor)) + floor);
	}
	
	//use golden ratio to create pleasant colors
	//http://martin.ankerl.com/2009/12/09/how-to-create-random-colors-programmatically/
	public static Color niceColor()
	{
		double goldenRatioConj = (1.0 + Math.sqrt(5.0)) / 2.0;
		float hue = new Random().nextFloat();
		
		hue += goldenRatioConj * (colorPos / (5 * Math.random()));
		hue = hue % 1;
		
		return Color.getHSBColor(hue, 0.5f, 0.95f);
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
		
		//add colored stripe
		g.setColor(color);
		g.fillRect(x-width/2-Main.line.camX+1, y+height/2-stripeHeight, width-1, stripeHeight);
		g.setColor(Color.black);
		g.drawLine(x-width/2-Main.line.camX, y+height/2-stripeHeight, x-width/2-Main.line.camX+width, y+height/2-stripeHeight);
	}
}
//ProblemLine.java
//renders the ProblemList

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

public class ProblemLine
{
	public int width, height;
	public ArrayList<VisualProblemSolution> probList = new ArrayList<VisualProblemSolution>();
	
	public ProblemLine(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	public void addProblem(int x)
	{
		probList.add(new VisualProblemSolution(x, height/2, 100, 200));
	}
	
	public void tick()
	{
		for(int i = 0; i < probList.size(); i++)
			probList.get(i).tick();
	}
	
	public void render(Graphics g)
	{
		double notLine = 0.10;		//percent of width that is not the line
		double circleRadius = 10;	//radi of the circles on the ends of the line
		
		int lineY = height/2;				//y value of both ends
		int lineX1 = (int)(notLine*width);	//x value of left side
		int lineX2 = width-lineX1;			//x value of right side
		
		BasicStroke normalStroke = new BasicStroke();
		BasicStroke thickStroke = new BasicStroke(3.0f);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//draw the line
		g2.setColor(Color.black);
		g2.setStroke(thickStroke);
		g2.drawLine(lineX1, lineY, lineX2, lineY);
		
		//draw the circles on the ends
		g2.setColor(Color.black);
		g2.setStroke(normalStroke);
		g2.fillOval((int)(lineX1-circleRadius), (int)(lineY-circleRadius), (int)circleRadius*2, (int)circleRadius*2);
		g2.fillOval((int)(lineX2-circleRadius), (int)(lineY-circleRadius), (int)circleRadius*2, (int)circleRadius*2);
		
		for(int i = 0; i < probList.size(); i++)
			probList.get(i).render(g);
	}
}
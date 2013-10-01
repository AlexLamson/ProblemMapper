//Listening.java
//deals with all keyboard and mouse input

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Listening implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
{

	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		switch(key)
		{
		case KeyEvent.VK_RIGHT:
			Main.moveCamRight();
			break;
		case KeyEvent.VK_LEFT:
			Main.moveCamLeft();
			break;
		case KeyEvent.VK_SPACE:
			
			break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		switch(key)
		{
		}
	}
	
	public void keyTyped(KeyEvent e)
	{

	}
	
	public void mouseClicked(MouseEvent e)
	{
		Main.mse.setLocation(e.getX()/Main.pixelSize, e.getY()/Main.pixelSize);
		if(Main.isMouseLeft)			//left click
		{
			
		}
		else if(Main.isMouseMiddle)	//middle click
		{
			
		}
		else if(Main.isMouseRight)	//right click
		{
			
		}
	}
	
	public void mouseDragged(MouseEvent e)
	{
		Main.mse.setLocation(e.getX()/Main.pixelSize, e.getY()/Main.pixelSize);
		if(Main.isMouseLeft)			//left click
		{
			
		}
		else if(Main.isMouseMiddle)	//middle click
		{
			
		}
		else if(Main.isMouseRight)	//right click
		{
			
		}
	}
	
	public void mousePressed(MouseEvent e)
	{
		mouseToggle(e, true);
	}

	public void mouseReleased(MouseEvent e)
	{
		//if the mouse was close to the line, create a ProblemSolution at that point
		if(Main.isMouseLeft)
		{
			if(Main.line.isProblemBox(Main.mse.x+Main.line.camX) && mouseYIsInProblem())	//if mouse was in box
			{
				if(Main.mse.y < Main.pixel.height/2)	//if mouse was on green box
				{
					//expand the solutions
					
				}
				else	//if mouse was on red box
				{
					//zoom in
					int pos = Main.line.getProblemFromX(Main.mse.x+Main.line.camX);
					Main.line.zoomTo(pos);
				}
			}
			else		//if mouse wasn't in box
			{
				if(mouseIsCloseToLine())
					Main.line.addProblem(Main.mse.x+Main.line.camX);
			}
		}
		else if(Main.isMouseRight)
		{
//			Main.line.zoomOut();
			Main.line.zoomOutALevel();
		}
		mouseToggle(e, false);
	}
	
	public static void mouseToggle(MouseEvent e, boolean toggle)
	{
		if(e.getButton() == MouseEvent.BUTTON1)			//left click
			Main.isMouseLeft = toggle;
		else if(e.getButton() == MouseEvent.BUTTON2)	//middle click
			Main.isMouseMiddle = toggle;
		else if(e.getButton() == MouseEvent.BUTTON3)	//right click
			Main.isMouseRight = toggle;
	}
	
	public void mouseMoved(MouseEvent e)
	{
		Main.mse.setLocation(e.getX(), e.getY());
		if(Listening.mouseIsCloseToLine() && Main.line.isValidPos(Main.mse.x+Main.line.camX) && !Main.line.isProblemBox(Main.mse.x+Main.line.camX))
			Main.drawDot = true;
		else
			Main.drawDot = false;
	}

	public void mouseWheelMoved(MouseWheelEvent e)
	{
		int times = 6;
		if(e.getWheelRotation() < 0)			//scrolled up
		{
			for(int i = 0; i < times; i++)
				Main.moveCamLeft();
		}
		else if(e.getWheelRotation() > 0)		//scrolled down
		{
			for(int i = 0; i < times; i++)
				Main.moveCamRight();
		}
	}
	
	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}
	
	public static boolean mouseIsCloseToLine()
	{
		int y = Main.mse.y;
		int lineY = Main.pixel.height/2;
		return (y >= lineY - 30 && y <= lineY + 30);
	}
	
	public static boolean mouseYIsInProblem()
	{
		int y = Main.mse.y;
		int lineY = Main.pixel.height/2;
		return (y >= lineY && y <= lineY+VisualProblemSolution.height/2);
	}
}

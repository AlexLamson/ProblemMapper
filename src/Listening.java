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
			Main.line.addProblem(Main.mse.x+Main.camX);
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
	}

	public void mouseWheelMoved(MouseWheelEvent e)
	{
		if(e.getWheelRotation() < 0)			//scrolled up
		{
			Main.moveCamLeft();
			Main.moveCamLeft();
		}
		else if(e.getWheelRotation() > 0)		//scrolled down
		{
			Main.moveCamRight();
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
}

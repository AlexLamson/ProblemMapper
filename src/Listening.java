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
		case KeyEvent.VK_SPACE:
			System.out.println("Space was pressed!");
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
			
		}
		else if(e.getWheelRotation() > 0)		//scrolled down
		{
			
		}
	}
	
	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}
}

import java.awt.*;

/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author	Michael Kolling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */

public class Triangle
{
    private int height;
    private int width;
	private int xPosition;
	private int yPosition;
	private String color;
	private boolean isVisible;

    /**
     * Create a new triangle at default position with default color.
     */
    public Triangle()
    {
		height = 30;
		width = 40;
		xPosition = 20;
		yPosition = 0;
		color = "green";
		isVisible = false;
    }

    public void setXPosition(int x) {
        xPosition = x;
    }
    
    public void setYPosition(int y) {
        yPosition = y;
    }
    
	/**
	 * Make this triangle visible. If it was already visible, do nothing.
	 */
	public void makeVisible()
	{
		isVisible = true;
		draw();
	}
	
	/**
	 * Make this triangle invisible. If it was already invisible, do nothing.
	 */
	public void makeInvisible()
	{
		erase();
		isVisible = false;
	}
	
    /**
     * Move the triangle a few pixels to the right.
     */
    public void moveRight()
    {
		moveHorizontal(20);
    }

    /**
     * Move the triangle a few pixels to the left.
     */
    public void moveLeft()
    {
		moveHorizontal(-20);
    }

    /**
     * Move the triangle a few pixels up.
     */
    public void moveUp()
    {
		moveVertical(-20);
    }

    /**
     * Move the triangle a few pixels down.
     */
    public void moveDown()
    {
		moveVertical(20);
    }

    /**
     * Move the triangle horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
		erase();
		xPosition += distance;
		draw();
    }

    /**
     * Move the triangle vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
		erase();
		yPosition += distance;
		draw();
    }

    /**
     * Slowly move the triangle horizontally by 'distance' pixels.
     */
    public void slowMoveHorizontal(int speed, int distance)
    {
		int delta;

		if(distance < 0) 
		{
			delta = -speed;
			distance = -distance;
		}
		else 
		{
			delta = speed;
		}

		for(int i = 0; i < distance; i+=speed)
		{
			xPosition += delta;
			draw();
		}
    }

    /**
     * Slowly move the triangle vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int speed, int distance)
    {
		int delta;

		if(distance < 0) 
		{
			delta = -speed;
			distance = -distance;
		}
		else 
		{
			delta = speed;
		}

		for(int i = 0; i < distance; i+=speed)
		{
			yPosition += delta;
			draw();
		}
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newHeight, int newWidth)
    {
		erase();
		height = newHeight;
		width = newWidth;
		draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
	 * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
		color = newColor;
		draw();
    }

	/*
	 * Draw the triangle with current specifications on screen.
	 */
	private void draw()
	{
		if(isVisible) {
			Canvas canvas = Canvas.getCanvas();
			int[] xpoints = { xPosition, xPosition + (width/2), xPosition - (width/2) };
			int[] ypoints = { yPosition, yPosition + height, yPosition + height };
			canvas.draw(this, color, new Polygon(xpoints, ypoints, 3));
			canvas.wait(10);
		}
	}

	/*
	 * Erase the triangle on screen.
	 */
	private void erase()
	{
		if(isVisible) {
			Canvas canvas = Canvas.getCanvas();
			canvas.erase(this);
		}
	}
}

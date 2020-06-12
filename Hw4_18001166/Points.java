package Hw4_18001166;

public class Points<E>
	{
	private int xCoord;
	private int yCoord;
	private char val;
	private boolean N;
	private boolean S;
	private boolean E;
	private boolean W;
	
	public Points()
	{
	    xCoord =0;
	    yCoord =0;
	    val =' ';
	    N = true;
	    S = true;
	    E = true;
	    W = true;
	
	}
	
	public Points (int X, int Y)
	{
	        xCoord = X;
	        yCoord = Y;
	
	}
	
	public void setX(int x)
	{
	    xCoord = x;
	}
	public void setY(int y)
	{
	    yCoord = y;
	}
	
	public void setNorth(boolean n)
	{
	    N = n;
	}
	public void setSouth(boolean s)
	{
	    S= s;
	}
	public void setEast(boolean e)
	{
	    E = e;
	}
	
	public void setWest(boolean w)
	{
	    W = w;
	}
	
	public int getX()
	{
	    return xCoord;
	
	}
	
	public int getY()
	{
	    return yCoord;
	}
	public char getVal()
	{
	    return val;
	}
	
	public boolean getNorth()
	{
	    return N;
	}
	public boolean getSouth()
	{
	    return S;
	}
	
	public boolean getEast()
	{
	    return E;
	}
	public boolean getWest()
	{
	    return W;
	}
	
	public String toString1()
	{
	    String result = "(" + xCoord + ", " +yCoord + ")";
	    return result;
	}
}
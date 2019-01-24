package tplab;

import java.awt.Color;
import java.awt.Graphics;


public abstract class Plane implements ITransport{
	protected float _startPosX;
    protected float _startPosY;
    protected int _pictureWidth;
    protected int _pictureHeight;
    
    public int MaxSpeed;
    public int getMaxSpeed() {
    	return MaxSpeed;
    	}
    private void setMaxSpeed(int newSpeed){
    	MaxSpeed = newSpeed;
    	}
    
    public float Weight;
    public float getWeight() {
    	return Weight;
    	}
    private void setWeight(float newWeight){
    	Weight = newWeight;
    	}
    
    public Color MainColor;
    public Color getMainColor() {
    	return MainColor;
    	}
    private void setMainColor(Color newMainColor){
    	MainColor = newMainColor;
    	}
    @Override
 	public void setMainColor(String colorName){
 		switch (colorName) {
 		case "magenta":
        	MainColor = Color.MAGENTA;
            break;
        case "blue":
        	MainColor = Color.BLUE;
            break;
        case "gray":
        	MainColor = Color.GRAY;
            break;
        case "cyan":
        	MainColor = Color.CYAN;
            break;
         case "yellow":
             MainColor = Color.YELLOW;
             break;
         case "orange":
             MainColor = Color.ORANGE;
             break;
         case "green":
             MainColor = Color.GREEN;
             break;
         case "black":
             MainColor = Color.BLACK;
             break;
 		}
 
  	}
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }
    public abstract void DrawAircraft(Graphics g);
    public abstract void MoveTransport(Direction direction);
}

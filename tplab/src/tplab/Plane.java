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

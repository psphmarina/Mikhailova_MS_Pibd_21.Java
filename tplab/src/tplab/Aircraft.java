package tplab;

import java.awt.Color;
import java.awt.Graphics;

public class Aircraft {
	/// <summary>
    /// Левая координата отрисовки автомобиля
    /// </summary>

	public static int _ScreenWidth;
	public static int _ScreenHeight;
	
    private float _startPosX;
    private float _startPosY;
    private int _pictureWidth;
    private int _pictureHeight;
    
    private int carWidth = 100;
    private int carHeight = 60;

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
    private Color DopColor;
    public Color getDopColor() {
        return DopColor;
    }
     public void setAddColor(Color value) {
        DopColor = value;
    }
    public Aircraft(int maxSpeed, float weight, Color mainColor, Color dopColor)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        DopColor = dopColor;
    }
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;

        _pictureHeight = height;
		_pictureWidth  = width;
    }
    public void MoveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            // вправо
            case Right:
            	if (_startPosX + step < _pictureWidth - carWidth)
                {
                    _startPosX += step;
                }
                break;
            //влево
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            
            //вверх
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
            //вниз
            case Down:
                if (_startPosY + step < _pictureHeight - carHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }
    public void DrawAircraft(Graphics g)
    {
    	//отрисовка
    	
    	//super.paint(g);
        
    	g.setColor(MainColor); 
        g.fillOval((int)_startPosX, (int)_startPosY, 90, 10);
        g.fillRect( (int)_startPosX + 60, (int)_startPosY - 22, 12, 50);
        g.fillRect( (int)_startPosX + 10, (int)_startPosY - 10, 8, 30);
        g.fillOval( (int)_startPosX + 45, (int)_startPosY - 20, 40, 5);
        g.fillOval( (int)_startPosX + 45, (int)_startPosY + 20, 40, 5);
        
        //контуры
        g.setColor(Color.BLACK);
        g.drawOval( (int)_startPosX, (int)_startPosY, 90, 10);
        g.drawRect( (int)_startPosX + 60, (int)_startPosY - 22, 12, 50);
        g.drawRect((int)_startPosX + 10, (int)_startPosY - 10, 8, 30);
        g.drawOval((int)_startPosX + 45, (int)_startPosY - 20, 40, 5);
        g.drawOval((int)_startPosX + 45, (int)_startPosY + 20, 40, 5);
        
     }
}


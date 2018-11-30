package tplab;

import java.awt.Color;
import java.awt.Graphics;


public class Aircraft extends Plane{
	private int carWidth = 100;
    private int carHeight = 60;
   
    public Aircraft(int maxSpeed, float weight, Color mainColor)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
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
    @Override
    public void DrawAircraft(Graphics g)
    {
    	//отрисовка
    	
    	//super.paint(g);
        
    	g.setColor(MainColor); 
        g.fillOval( (int)_startPosX, (int)_startPosY, 90, 10);
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


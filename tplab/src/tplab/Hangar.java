package tplab;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

class Hangar <T extends ITransport > {
	private HashMap<Integer,T> _places;
    private int _maxCount;
	
 	private int PictureWidth;
 	public int getPictureWidth() {
		return PictureWidth;
	}
 	public void setPictureWidth(int value) {
		PictureWidth = value;
	}
 	
 	private int PictureHeight;
 	public int getPictureHeight() {
		return PictureHeight;
	}
 	public void setPPictureHeighth(int value) {
		PictureHeight = value;
	}
 	
 	private int _placeSizeWidth = 210;
	private int _placeSizeHeight = 80;
	
	public Hangar( int sizes, int pictureWidth, int pictureHeight)
	{
		    _maxCount = sizes;
		    _places = new  HashMap<Integer,T>();
	        PictureWidth = pictureWidth;
	        PictureHeight = pictureHeight; 
	}
	
	public  int Plus (T car)
    {
		if (_places.size() == _maxCount)
        {
            return -1;
        }
        for (int i = 0; i < _maxCount;  i++)
        {	        
            if (CheckFreePlace(i))
            {
                _places.put(i, car);
                _places.get(i).SetPosition(10 + i / 5 * _placeSizeWidth + 5, i % 5 * _placeSizeHeight + 20, PictureWidth, PictureHeight);
                return i;
            }
        }
        return -1;
    }
	public T Minus (int index)
    {
		if (index < 0 || index > _maxCount)
        {
            return null;
        }
        if (!CheckFreePlace(index))
        {
            T car = _places.get(index);
            _places.remove(index);
            return car;
        } 
        	return null;
        
    }
	private boolean CheckFreePlace(int index)
    {
		 return !_places.containsKey(index); 
    }
	public void Draw(Graphics g)
    {
		DrawHangar(g);
        for (int i = 0; i < _places.size(); i++)
        {
        	 _places.get(_places.keySet().toArray()[i]).DrawAircraft(g);
        }
    }
	private void DrawHangar(Graphics g)
	{
	
		g.setColor(Color.BLACK);         
		g.drawRect(0, 0, (_places.size() / 5) * _placeSizeWidth, 480);
        for (int i = 0; i < _maxCount / 5; i++)
        {
            for (int j = 0; j < 6; ++j)
            {
                g.drawRect(i * _placeSizeWidth, j * _placeSizeHeight, 110, 5 );
                g.setColor(Color.BLACK);
                g.fillRect(i * _placeSizeWidth, j * _placeSizeHeight, 110, 5);
            }
            g.drawLine( i * _placeSizeWidth, 0, i * _placeSizeWidth, 400);
        }
	}
}

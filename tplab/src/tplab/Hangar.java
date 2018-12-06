package tplab;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

class Hangar <T extends ITransport > {
	ArrayList<T> _places; 
	
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
	        _places = new ArrayList<T>();
	        PictureWidth = pictureWidth;
	        PictureHeight = pictureHeight;
	        for (int i = 0; i < sizes; i++)
	        {
	            _places.add (null);
	        }
	}
	
	public  int Plus (T car)
    {
        for (int i = 0; i < _places.size(); i++)
        {
            if (CheckFreePlace(i))
            {
                _places.add(i, car);
                _places.get(i).SetPosition(10 + i / 5 * _placeSizeWidth + 5, i % 5 * _placeSizeHeight + 20, PictureWidth, PictureHeight);
                return i;
            }
        }
        return -1;
    }
	public T Minus (int index)
    {
       if (index < 0 || index > _places.size())
        {
            return null;
        }
        if (!CheckFreePlace(index))
        {
            T car = _places.get(index);
            _places.set(index, null);
            return car;
        } 
        	return null;
        
    }
	private boolean CheckFreePlace(int index)
    {
        if (_places.get(index) == null) 
        	{
        	return true;
        	} else {
        		return false;
        	}
    }
	public void Draw(Graphics g)
    {
        DrawHangar(g);
        for (int i = 0; i < _places.size(); i++)
        {
            if (!CheckFreePlace(i))
            {
            	_places.get(i).DrawAircraft(g);
            }
        }
    }
	private void DrawHangar(Graphics g)
	{
	
		g.setColor(Color.BLACK);         
        g.drawRect(0, 0, (_places.size() / 5) * _placeSizeWidth, 480);
        for (int i = 0; i < _places.size() / 5; i++)
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

package tplab;

import java.awt.Color;
import java.awt.Graphics;

public class FighterAircraft extends Aircraft{
	private Color DopColor;
    public Color getDopColor() {
        return DopColor;
    } 
    public void setDopColor(Color dop) {
        DopColor = dop;
    }
    
    private boolean DopMotor;
    public boolean getDopMotor() {
        return DopMotor;
    }
    public void setDopMotor(boolean d) {
    	 DopMotor = d;
    }
     
    private boolean Bomb;
    public boolean getBomb() {
        return Bomb;
    }
    public void setBomb(boolean b) {
    	Bomb = b;
    }
    
    private boolean Exhaust;
    public boolean getExhaust() {
        return Exhaust;
    }
    public void setExhaust(boolean e) {
    	 Exhaust = e;
    }
    
    public FighterAircraft(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean dopMotor, boolean bomb, boolean exhaust) {
    	super(maxSpeed, weight, mainColor);
    	MaxSpeed = maxSpeed;	
        Weight = weight;	
        MainColor = mainColor;
        DopColor = dopColor;
        DopMotor = dopMotor;
        Bomb = bomb;
        Exhaust = exhaust;
    }   
    
    @Override
    public void DrawAircraft(Graphics g)
    {
    	super.DrawAircraft(g);
    	
    	if (DopMotor) {
    		g.setColor(DopColor);
    		g.fillOval((int)_startPosX + 45, (int)_startPosY - 10, 35, 5);
    		g.fillOval( (int)_startPosX + 45, (int)_startPosY + 12, 35, 5);
    		g.setColor(Color.BLACK);
            g.drawOval( (int)_startPosX + 45, (int)_startPosY - 10, 35, 5);
            g.drawOval((int)_startPosX + 45, (int)_startPosY + 12, 35, 5);
       }
    	
    	if (Bomb)
        {
    		g.setColor(Color.BLACK);
    		g.fillOval((int)_startPosX + 80, (int)_startPosY - 10, 7, 5);
    		g.fillOval((int)_startPosX + 80, (int)_startPosY + 15, 7, 5);
    		g.fillOval( (int)_startPosX + 95, (int)_startPosY - 10, 7, 5);
    		g.fillOval( (int)_startPosX + 95, (int)_startPosY + 15, 7, 5);
        }
    	if (Exhaust)
        {
    		g.setColor(Color.GRAY);
    		g.fillOval( (int)_startPosX + 20, (int)_startPosY - 18, 17, 15);
    		g.fillOval( (int)_startPosX + 7, (int)_startPosY - 25, 20, 15);
    		g.fillOval( (int)_startPosX + 20, (int)_startPosY + 20, 17, 15);
    		g.fillOval( (int)_startPosX + 7, (int)_startPosY + 25, 20, 15);
        }
    }
}

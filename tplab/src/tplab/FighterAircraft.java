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
    public void setDopColor(String colorName) {
        switch (colorName) {
            case "magenta":
            	DopColor = Color.MAGENTA;
                break;
            case "blue":
            	DopColor = Color.BLUE;
                break;
            case "gray":
            	DopColor = Color.GRAY;
                break;
            case "cyan":
            	DopColor = Color.CYAN;
                break;
            case "yellow":
            	DopColor = Color.YELLOW;
                break;
            case "orange":
            	DopColor = Color.ORANGE;
                break;
            case "green":
            	DopColor = Color.GREEN;
                break;
            case "black":
            	DopColor = Color.BLACK;
                break;
        }

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
    
    public FighterAircraft(String info){
        super(info);
        String[] strs = info.split(";");
        if(strs.length == 11) {
        MaxSpeed = Integer.parseInt(strs[0]);
        Weight = Float.parseFloat(strs[1]);
        MainColor = new Color(Integer.parseInt(strs[2]), Integer.parseInt(strs[3]), Integer.parseInt(strs[4]));
        DopColor = new Color(Integer.parseInt(strs[5]), Integer.parseInt(strs[6]), Integer.parseInt(strs[7]));
        DopMotor = Boolean.parseBoolean(strs[8]);
        Bomb = Boolean.parseBoolean(strs[9]);
        Exhaust = Boolean.parseBoolean(strs[10]);
        }
    }
    
    @Override
    public void DrawAircraft(Graphics g)
    {
    	super.DrawAircraft(g);
    	
    	if (DopMotor) {
    		g.setColor(DopColor);
    		g.fillOval((int)_startPosX + 45, (int)_startPosY+ 10, 35, 5);
    		g.fillOval( (int)_startPosX + 45, (int)_startPosY + 32, 35, 5);
    		g.setColor(Color.BLACK);
            g.drawOval( (int)_startPosX + 45, (int)_startPosY + 32, 35, 5);
            g.drawOval((int)_startPosX + 45, (int)_startPosY+ 10, 35, 5);
       }
    	
    	if (Bomb)
        {
    		g.setColor(Color.BLACK);
    		g.fillOval((int)_startPosX + 80, (int)_startPosY+ 10, 7, 5);
    		g.fillOval((int)_startPosX + 80, (int)_startPosY + 30, 7, 5);
    		g.fillOval( (int)_startPosX + 95, (int)_startPosY + 30, 7, 5);
    		g.fillOval( (int)_startPosX + 95, (int)_startPosY+ 10, 7, 5);
        }
    	if (Exhaust)
        {
    		g.setColor(Color.GRAY);
    		g.fillOval( (int)_startPosX + 20, (int)_startPosY + 2, 17, 15);
    		g.fillOval( (int)_startPosX + 7, (int)_startPosY - 5, 20, 15);
    		g.fillOval( (int)_startPosX + 20, (int)_startPosY + 40, 17, 15);
    		g.fillOval( (int)_startPosX + 7, (int)_startPosY + 45, 20, 15);
        }
    }
    @Override
    public String toString() {
        return super.toString()+ ";"+ DopColor.getRed() + ";" + DopColor.getGreen() + ";" 
				+ DopColor.getBlue()+";"+DopMotor+";"+Bomb+";"+Exhaust;
    }
}

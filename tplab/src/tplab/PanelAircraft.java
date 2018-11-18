package tplab;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelAircraft extends JPanel {
	
 	private static Aircraft car;
	static void setAircraft(Aircraft v) {  
               car = v;
 	}
 	@Override
 	public void paint(Graphics g) {
 		super.paint(g);
 		if (car != null) {
 			car.DrawAircraft( g);
 		}
 	}
}



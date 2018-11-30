package tplab;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PanelAircraft extends JPanel {
	
	private static ITransport car;
	static void setAircraft(ITransport car2) {
               car = car2;
 	}
 	@Override
 	public void paint(Graphics g) {
 		super.paint(g);
 		if (car != null) {
 			car.DrawAircraft( g);
 		}
 	}
}



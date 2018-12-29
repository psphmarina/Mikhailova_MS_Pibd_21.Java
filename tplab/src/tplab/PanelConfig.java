package tplab;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelConfig extends JPanel {
	private ITransport car;
	 
    void setAircraft(ITransport t) {
   	car = t;
   }

    @Override
   public void paint(Graphics g) {
       super.paint(g);
       if (car != null) {
       	car.DrawAircraft(g);
       }
   }
}

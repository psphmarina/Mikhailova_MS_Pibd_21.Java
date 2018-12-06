package tplab;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelHangar extends JPanel {
	private  Hangar<ITransport> hangar;
	
	 public Hangar<ITransport> getHangar() {
	        return hangar;
	    }
	    public PanelHangar() {
	    	hangar = new Hangar<>(14, 1015, 683);
	    }
	@Override 
	public void paint(Graphics g) { 
		super.paint(g); 
			if(hangar != null) {
				hangar.Draw(g);
			}
	}
}

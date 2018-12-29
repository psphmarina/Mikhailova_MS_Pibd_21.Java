package tplab;

import java.awt.Graphics;

import javax.swing.JList;
import javax.swing.JPanel;


public class PanelHangar extends JPanel {
	private  MultiLevelHangar hangar;
	private JList listLevels;
	private int countLevel = 5;
	public MultiLevelHangar getHangar() {
        return hangar;
	}
    public PanelHangar() {
    	hangar = new MultiLevelHangar(countLevel, 615, 603);
    }
    public void setListLevels(JList listLevels) {
    	this.listLevels = listLevels;
    }	    
	@Override 
	public void paint(Graphics g) { 
		super.paint(g); 
		int selectedLevel = listLevels.getSelectedIndex();
		hangar.getHangar(selectedLevel).Draw(g);
		if(selectedLevel != -1){
			if (hangar!=null) {
				hangar.getHangar(selectedLevel).Draw(g);
			}
		}
	}
}

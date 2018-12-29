package tplab;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class FormHangar {

	private JFrame frame;
	private JTextField textFieldTake;
	MultiLevelHangar hangar;
	private PanelHangar panelHangar;
	private PanelAircraft panelAircraft;
	private JList listLevels;
    private DefaultListModel model;
    private ITransport car;
	private int countLevel = 5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormHangar window = new FormHangar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormHangar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelHangar = new PanelHangar();
		panelHangar.setBounds(0, 11, 607, 409);
		frame.getContentPane().add(panelHangar);
		
		hangar = panelHangar.getHangar();
		
		JList listLevels = new JList();
		listLevels.setBounds(613, 107, 161, 139);
		frame.getContentPane().add(listLevels);
		model = new DefaultListModel();
        for(int i = 0; i < countLevel; i++)
        {
        	model.addElement("Уровень " + (i + 1));
        }
        listLevels.setModel(model);
        listLevels.setSelectedIndex(0);
        panelHangar.setListLevels(listLevels);   
        listLevels.addListSelectionListener(new ListSelectionListener() { 
			@Override 
			public void valueChanged(ListSelectionEvent e) { 
				panelHangar.repaint(); 
			} 
		});
		
		JButton buttonAircraft = new JButton("\u041F\u043E\u0441\u0442\u0430\u0432\u0438\u0442\u044C \u0441\u0430\u043C\u043E\u043B\u0451\u0442");
		buttonAircraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Color mainColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
	             car = new Aircraft(100, 1000, mainColor);
	             int place = hangar.getHangar(listLevels.getSelectedIndex()).Plus(car);
	             panelHangar.repaint();
			}
		});
		buttonAircraft.setBounds(617, 12, 162, 39);
		frame.getContentPane().add(buttonAircraft);
		
		JButton buttonFAircraft = new JButton("\u041F\u043E\u0441\u0442\u0430\u0432\u0438\u0442\u044C \u0438\u0441\u0442\u0440\u0435\u0431\u0438\u0442\u0435\u043B\u044C");
		buttonFAircraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color mainColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
				Color dopColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
				FighterAircraft car = new FighterAircraft(100, 1000, mainColor, dopColor, true, true,true);
               	int place = hangar.getHangar(listLevels.getSelectedIndex()).Plus(car);	
               	panelHangar.repaint();
			}
		});
		buttonFAircraft.setBounds(617, 62, 162, 39);
		frame.getContentPane().add(buttonFAircraft);
		
		JLabel label = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		label.setBounds(637, 252, 46, 14);
		frame.getContentPane().add(label);
		
		textFieldTake = new JTextField();
		textFieldTake.setBounds(693, 249, 86, 20);
		frame.getContentPane().add(textFieldTake);
		textFieldTake.setColumns(10);
		
		panelAircraft = new PanelAircraft();
		panelAircraft.setBounds(617, 300, 162, 120);
		frame.getContentPane().add(panelAircraft);
		
		JButton buttonTake = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
		buttonTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldTake.getText().equals("")) {
					Integer.parseInt(textFieldTake.getText());
					ITransport car = hangar.getHangar(listLevels.getSelectedIndex()).Minus(Integer.parseInt(textFieldTake.getText()));
					if (car != null) {
						car.SetPosition(5, 25, panelAircraft.getWidth(), panelAircraft.getHeight());
						panelAircraft.setAircraft(car);
						panelAircraft.repaint();
						panelHangar.repaint();
					} else {
						panelAircraft.setAircraft(null);
						panelAircraft.repaint();
					}
				}
			}
		});
		buttonTake.setBounds(647, 277, 89, 23);
		frame.getContentPane().add(buttonTake);
		
	}
}

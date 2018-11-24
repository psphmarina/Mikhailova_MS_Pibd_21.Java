package tplab;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;

public class FormAircraft {

	private JFrame frame;
	private JPanel panel;
	private Aircraft car;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAircraft window = new FormAircraft();
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
	public FormAircraft() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 687, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new PanelAircraft();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 463, 336);
		frame.getContentPane().add(panel);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Random rnd = new Random();
	            car = new Aircraft(100+rnd.nextInt(300), 1000+rnd.nextInt(2000), Color.darkGray, Color.BLUE);
	            car.SetPosition(rnd.nextInt(150) + 50, rnd.nextInt(150) + 50, 473, 376);
	            PanelAircraft.setAircraft(car);
				panel.repaint();
			}
		});
		btnCreate.setBounds(528, 11, 89, 23);
		frame.getContentPane().add(btnCreate);
		
		JButton btnUp = new JButton("^");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				car.MoveTransport(Direction.Up);
				panel.repaint();
			}
		});
		btnUp.setBounds(540, 278, 57, 23);
		frame.getContentPane().add(btnUp);
		
		JButton btnDown = new JButton("v");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				car.MoveTransport(Direction.Down);
				panel.repaint();
			}
		});
		btnDown.setBounds(540, 324, 57, 23);
		frame.getContentPane().add(btnDown);
		
		JButton btnLeft = new JButton("<");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				car.MoveTransport(Direction.Left);
				panel.repaint();
			}
		});
		btnLeft.setBounds(482, 298, 48, 23);
		frame.getContentPane().add(btnLeft);
		
		JButton btnRight = new JButton(">");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				car.MoveTransport(Direction.Right);
				panel.repaint();
			}
		});
		btnRight.setBounds(607, 298, 54, 29);
		frame.getContentPane().add(btnRight);
		
	}
}

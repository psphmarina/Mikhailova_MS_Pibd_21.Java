package tplab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CarConfig extends JDialog {

	ITransport car = null;
 	PanelConfig carPanel;
 	boolean succes;
 
  	public CarConfig(JFrame parent) {
 		super(parent, true);
 		initialize();
 	}
 
  	public boolean isSuccessful() {
         setVisible(true);
         return succes;
     }
 
  	private void initialize() {
 		this.getContentPane().setBackground(SystemColor.controlHighlight);
         this.setBounds(100, 100, 565, 418);
         this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         this.getContentPane().setLayout(null);
 
          Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
 
          JLabel labelAircraft = new JLabel("Самолёт");
         labelAircraft.setHorizontalAlignment(SwingConstants.CENTER);
         labelAircraft.setBounds(10, 29, 153, 84);
         labelAircraft.setBorder(new LineBorder(new Color(0, 0, 0)));
         getContentPane().add(labelAircraft);
 
          JLabel labelFAircraft = new JLabel("Самолёт-штурмовик");
         labelFAircraft.setHorizontalAlignment(SwingConstants.CENTER);
         labelFAircraft.setBounds(10, 135, 153, 84);
         labelFAircraft.setBorder(new LineBorder(new Color(0, 0, 0)));
         getContentPane().add(labelFAircraft);
 
          JLabel labelMainColor = new JLabel("Основной цвет");
         labelMainColor.setHorizontalAlignment(SwingConstants.CENTER);
         labelMainColor.setBounds(211, 223, 133, 50);
         labelMainColor.setBorder(new LineBorder(new Color(0, 0, 0)));
         getContentPane().add(labelMainColor);
 
          JLabel labelSecondColor = new JLabel("Дополнительный цвет");
         labelSecondColor.setHorizontalAlignment(SwingConstants.CENTER);
         labelSecondColor.setBounds(211, 286, 133, 50);
         labelSecondColor.setBorder(new LineBorder(new Color(0, 0, 0)));
         getContentPane().add(labelSecondColor);
 
         carPanel = new PanelConfig();
         carPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
         FlowLayout flowLayout = (FlowLayout) carPanel.getLayout();
         carPanel.setBounds(201, 29, 153, 178);
         this.getContentPane().add(carPanel);
 
          MouseListener ml = new MouseAdapter() {
             @Override
             public void mousePressed(MouseEvent e) {
                 JComponent jc = (JComponent) e.getSource();
                 TransferHandler th = jc.getTransferHandler();
                 th.exportAsDrag(jc, e, TransferHandler.COPY);
             }
         };
 
         labelAircraft.addMouseListener(ml);
         labelFAircraft.addMouseListener(ml);
         labelFAircraft.setTransferHandler(new TransferHandler("text"));
         labelAircraft.setTransferHandler(new TransferHandler("text"));
 
         carPanel.setDropTarget(new DropTarget() {
 
              public void drop(DropTargetDropEvent e) {
 
                  try {
                     for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                         if (e.getTransferable().getTransferData(df) == "Самолёт") {
                             car = new Aircraft(10, 10, Color.WHITE);
                             carPanel.setAircraft(car);
                             car.SetPosition(25, 50, carPanel.getWidth(), carPanel.getHeight());
                         } else if (e.getTransferable().getTransferData(df) == "Самолёт-штурмовик") {
                         	car = new FighterAircraft(30, 2, Color.WHITE, Color.BLACK, true, true, true);
                             carPanel.setAircraft(car);
                             car.SetPosition(25, 50, carPanel.getWidth(), carPanel.getHeight());
                         }
                         carPanel.repaint();
                     }
                 } catch (Exception ex) {
                 }
 
              }
 
              public void dragEnter(DropTargetDragEvent e) {
                 for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                     try {
                         if (e.getTransferable().getTransferData(df) instanceof String)
                             e.acceptDrag(DnDConstants.ACTION_COPY);
                         else
                             e.acceptDrag(DnDConstants.ACTION_NONE);
                     } catch (Exception e1) {
                         e1.printStackTrace();
                     }
                 }
             }
         });
 
          JPanel panelCyan = new JPanel();
         panelCyan.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
         panelCyan.setName("cyan");
         panelCyan.setBackground(Color.CYAN);
         panelCyan.setBounds(458, 92, 50, 50);
         this.getContentPane().add(panelCyan);
 
          JPanel panelMagenta = new JPanel();
         panelMagenta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
         panelMagenta.setName("magenta");
         panelMagenta.setBackground(Color.MAGENTA);
         panelMagenta.setBounds(396, 29, 50, 50);
         this.getContentPane().add(panelMagenta);
 
          JPanel panelBlue = new JPanel();
         panelBlue.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
         panelBlue.setName("blue");
         panelBlue.setBackground(Color.BLUE);
         panelBlue.setBounds(458, 29, 50, 50);
         this.getContentPane().add(panelBlue);
 
          JPanel panelGray = new JPanel();
         panelGray.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
         panelGray.setName("gray");
         panelGray.setBackground(Color.GRAY);
         panelGray.setBounds(396, 92, 50, 50);
         this.getContentPane().add(panelGray);
 
          JPanel panelGreen = new JPanel();
         panelGreen.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
         panelGreen.setName("green");
         panelGreen.setBackground(Color.GREEN);
         panelGreen.setBounds(396, 223, 50, 50);
         this.getContentPane().add(panelGreen);
 
          JPanel panelYellow = new JPanel();
         panelYellow.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
         panelYellow.setName("yellow");
         panelYellow.setBackground(Color.YELLOW);
         panelYellow.setBounds(396, 160, 50, 50);
         this.getContentPane().add(panelYellow);
 
          JPanel panelBlack = new JPanel();
         panelBlack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
         panelBlack.setName("black");
         panelBlack.setBackground(Color.BLACK);
         panelBlack.setBounds(458, 223, 50, 50);
         this.getContentPane().add(panelBlack);
 
          JPanel panelOrange = new JPanel();
         panelOrange.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
         panelOrange.setName("orange");
         panelOrange.setBackground(Color.ORANGE);
         panelOrange.setBounds(458, 160, 50, 50);
         this.getContentPane().add(panelOrange);
 
          panelMagenta.addMouseListener(ml);
         panelMagenta.setTransferHandler(new TransferHandler("name"));
 
          panelBlue.addMouseListener(ml);
         panelBlue.setTransferHandler(new TransferHandler("name"));
 
          panelGray.addMouseListener(ml);
         panelGray.setTransferHandler(new TransferHandler("name"));
 
          panelYellow.addMouseListener(ml);
         panelYellow.setTransferHandler(new TransferHandler("name"));
 
          panelBlack.addMouseListener(ml);
         panelBlack.setTransferHandler(new TransferHandler("name"));
 
          panelOrange.addMouseListener(ml);
         panelOrange.setTransferHandler(new TransferHandler("name"));
 
          panelCyan.addMouseListener(ml);
         panelCyan.setTransferHandler(new TransferHandler("name"));
 
          panelGreen.addMouseListener(ml);
         panelGreen.setTransferHandler(new TransferHandler("name"));
 
          JButton btnAdd = new JButton("Добавить");
         btnAdd.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent arg0) {
                 succes = true;
                 dispose();
             }
         });
         btnAdd.setBounds(29, 250, 106, 23);
         this.getContentPane().add(btnAdd);
 
          JButton btnCancell = new JButton("Отмена");
         btnCancell.setBounds(71, 300, 106, 23);
         this.getContentPane().add(btnCancell);
         btnCancell.addActionListener((ActionEvent e) -> {
             succes = false;
             dispose();
         });
 
          labelMainColor.setDropTarget(new DropTarget() {
             public void drop(DropTargetDropEvent e) {
                 if (car != null) {
                     try {
                         for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                         	car.setMainColor(e.getTransferable().getTransferData(df).toString());
                         	carPanel.setAircraft(car);
                         	carPanel.repaint();
                         }
                     } catch (Exception ex) {
                     }
                 }
             }
 
              public void dragEnter(DropTargetDragEvent e) {
                 for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                     try {
                         if (e.getTransferable().getTransferData(df) instanceof String)
                             e.acceptDrag(DnDConstants.ACTION_COPY);
                         else
                             e.acceptDrag(DnDConstants.ACTION_NONE);
                     } catch (UnsupportedFlavorException | IOException e1) {
                         e1.printStackTrace();
                     }
                 }
             }
         });
         labelSecondColor.setDropTarget(new DropTarget() {
             public void drop(DropTargetDropEvent e) {
                 if (car != null) {
                     try {
                         for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                             ((FighterAircraft) car).setDopColor(e.getTransferable().getTransferData(df).toString());
                             carPanel.setAircraft(car);
                            carPanel.repaint();
                         }
                     } catch (Exception ex) {
                     }
                 }
             }
 
              public void dragEnter(DropTargetDragEvent e) {
                 for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                     try {
                         if (e.getTransferable().getTransferData(df) instanceof String)
                             e.acceptDrag(DnDConstants.ACTION_COPY);
                         else
                             e.acceptDrag(DnDConstants.ACTION_NONE);
                     } catch (UnsupportedFlavorException | IOException e1) {
                         e1.printStackTrace();
                     }
                 }
             }
         });
 	}
 
  	public ITransport getAircraft() {
         return car;
     }
}

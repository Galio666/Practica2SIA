package practica2sia;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaMensaje extends JDialog {

	public VentanaMensaje(JFrame padre, String palabra, JTextField[][] arregloLetras) {
		super(padre, "Mensaje", true);
		
		JLabel lbMensaje = new JLabel("Palabra '" + palabra + "' encontrada.");
		lbMensaje.setBounds(30, 10, 300, 20);
		
		JButton btAceptar = new JButton("Continuar");
		btAceptar.setBounds(100, 70, 100, 20);
		
		this.setBounds(50, 100, 300, 150);
		this.add(lbMensaje);
		this.add(btAceptar);
		btAceptar.addActionListener(new ActionListener() {
	        
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	        	setVisible(false);
	        }
	    });
		
		this.repaint();
		lbMensaje.setLayout(null);		
		btAceptar.setLayout(null);
		this.setLayout(null);
		
		this.setLocation(800, 400); 
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
	}
}

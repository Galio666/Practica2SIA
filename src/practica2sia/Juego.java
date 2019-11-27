package practica2sia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SingleSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;

public class Juego extends JFrame {
	
	private char[][] sopa = {{'i', 'j', 's', 'i', 'j', 'a', 't', 'a', 'a', 'd', 'e', 'u', 'q', 's', 'u', 'b'},
							 {'e', 'k', 'y', 'c', 'f', 's', 'q', 'c', 'g', 'b', 'u', 'w', 's', '�', 'o', 'p'},
							 {'j', 'i', 'o', 'g', 'r', 'n', 'o', 'i', 'c', 'a', 'l', 'u', 'm', 'i', 's', 'r'},
							 {'a', 'a', 'n', 'w', 'a', 'e', 'f', 'g', 'l', 'e', 'x', 'i', 'p', 'h', 'l', 'o'},
							 {'z', 'b', 'a', 't', 'm', 'k', 'e', 'o', 'e', 'e', 'h', 'i', 'k', 'd', 'n', 'l'},
							 {'i', 'n', 'i', 'o', 'e', 'p', 'f', 'l', 'n', 'u', 'a', 'p', 'r', 'a', 'r', 'o'},
							 {'d', 'a', 'p', '�', 'c', 'l', 'd', 'l', 's', 'k', 'j', 'a', 'k', 't', 'z', 'g'},
							 {'n', 'r', 'o', 'b', 'o', 't', 'i', 'c', 'a', 'a', 'k', 'e', 'l', 'a', 'a', 'w'},
							 {'e', 'v', 't', 'i', 'u', 'p', 'p', 'g', 'v', 'c', 'h', 'r', 't', 'r', 't', 'm'},
							 {'r', 'k', 'u', 'r', 'o', 'a', 'b', 'a', 'e', 'v', 'i', 'a', 'l', 'i', 'p', 'o'},
							 {'p', 'm', 'i', 'n', 'c', 'r', 'q', 'd', 'f', 'n', 'z', 't', 'j', 'i', 'p', 'e'},
							 {'a', 'n', 'g', 'm', 't', 'e', 'n', 'y', 'k', 's', 'c', 'j', 'e', 'f', 's', 'x'},
							 {'g', 'd', 'a', 'd', 'i', 'n', 'a', 'm', 'u', 'h', 'e', 'i', 'm', 'n', 'n', 'p'},
							 {'u', 'n', 's', 'b', 'u', 'z', 'a', 's', 'c', 'i', 'h', 'p', 'a', 'r', 'e', 'y'},
							 {'i', 'p', 'y', 'o', 't', 'n', 'e', 'i', 'm', 'a', 'n', 'o', 'z', 'a', 'r', 'g'},
							 {'a', 'c', 'i', 't', 'a', 'm', 'r', 'o', 'f', 'n', 'i', 'o', 'i', 'b', 'r', 't'},
					        };
	
	private JTextField[][] arregloLetras = new JTextField[16][16];
	private JTextArea tiempoTotalCuadro = new JTextArea(); 
	private ArrayList<String> palabras;
	
//	public Juego(char[][] sopa, ArrayList<String> palabras) {
	public Juego(ArrayList<String> palabras) {
		super("Sopa de letras");
		this.palabras = palabras;
		Font font = new Font("Times New Roman", Font.PLAIN, 17);
		
		JFrame c = this;
		
		this.setBackground(Color.DARK_GRAY);
		this.setBounds(50, 100, 1700, 800);
		this.setVisible(true);
		
		int x = 1;
		int y = 1;
		for (int j = 0; j < sopa.length; j++) {
			for (int i = 0; i < sopa[j].length; i++) {
				JTextField letra = new JTextField();
				letra.setText(Character.toString(sopa[j][i]));
				letra.setFont(font);
				letra.setEnabled(false);
				letra.setBackground(Color.GRAY);
				letra.setCaretColor(Color.WHITE);
				letra.setHorizontalAlignment((int) CENTER_ALIGNMENT);
				letra.setBounds(10+x, 50+y, 32, 32);
				arregloLetras[j][i] = letra;
				try {
					c.add(letra);
					letra.repaint();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				x += 32;
			}
			x = 1;
			y += 32;
		}
		
		JLabel texto1 = new JLabel();
		texto1.setText("SOPA DE LETRAS");
		texto1.setBounds(200, 20, 100, 20);
		texto1.setFocusable(true);
		c.add(texto1);
		texto1.repaint();
		
		JPanel panelLetrasTiempos = new JPanel();
		panelLetrasTiempos.setBounds(600, 0, 900, 650);
		
		//NUMEROS CLAVE
		JLabel numerosClave = new JLabel();
		numerosClave.setText("N�MEROS CLAVE");
		numerosClave.setBounds(5, 25, 100, 20);
		panelLetrasTiempos.add(numerosClave);
		panelLetrasTiempos.repaint();
		
		//TIEMPO TOTAL
		JLabel tiempoTotal = new JLabel();
		tiempoTotal.setText("TIEMPO TOTAL:");
		tiempoTotal.setBounds(355, 25, 110, 20);
		panelLetrasTiempos.add(tiempoTotal);
		panelLetrasTiempos.repaint();
		
		JTextArea tiempoTotalJTA = new JTextArea();
		tiempoTotalJTA.setText("HH:M:S:MS");
		tiempoTotalJTA.setEditable(false);
		tiempoTotalJTA.setBounds(500, 25, 200, 20);
		tiempoTotalCuadro = tiempoTotalJTA;
		panelLetrasTiempos.add(tiempoTotalJTA);
		panelLetrasTiempos.repaint();
		
		//Letra y tiempo de busqueda
		JLabel letraCol1 = new JLabel();
		letraCol1.setText("Letra");
		letraCol1.setBounds(5, 75, 110, 20);
		panelLetrasTiempos.add(letraCol1);
		panelLetrasTiempos.repaint();
		
		JLabel tiempoBusquedaCol1 = new JLabel();
		tiempoBusquedaCol1.setText("Tiempo de Busqueda");
		tiempoBusquedaCol1.setBounds(110, 75, 180, 20);
		panelLetrasTiempos.add(tiempoBusquedaCol1);
		panelLetrasTiempos.repaint();
		
		JLabel letraCol2 = new JLabel();
		letraCol2.setText("Letra");
		letraCol2.setBounds(350, 75, 110, 20);
		panelLetrasTiempos.add(letraCol2);
		panelLetrasTiempos.repaint();
		
		JLabel tiempoBusquedaCol2 = new JLabel();
		tiempoBusquedaCol2.setText("Tiempo de Busqueda");
		tiempoBusquedaCol2.setBounds(500, 75, 180, 20);
		panelLetrasTiempos.add(tiempoBusquedaCol2);
		panelLetrasTiempos.repaint();
		
		//Letras y registro de tiempos.
		y = 70;
		x = 5;
		int xTiempo = 110;
		
		ArrayList<JTextArea> camposDeTiempo = new ArrayList<>();
		for (int i = 0; i < palabras.size(); i++) {
			if (i == 12) {
				x = 350;
				y = 70;
				xTiempo = 500;
			}
			JLabel palabra = new JLabel();
			palabra.setText(palabras.get(i));
			palabra.setBounds(x, 40+y, 100, 20);
			palabra.setLayout(null);
			
			JTextArea tiempo = new JTextArea();
			tiempo.setText("HH:M:S:MS");
			tiempo.setEditable(false);
			tiempo.setBounds(xTiempo, 40+y, 200, 20);
			tiempo.setLayout(null);
			
			camposDeTiempo.add(tiempo);
			try {
				panelLetrasTiempos.add(palabra);
				panelLetrasTiempos.add(tiempo);
				panelLetrasTiempos.repaint();
			} catch (Exception e) {
				// TODO: handle exception
			}
			y += 40;
		}
		 
		try {
			c.add(panelLetrasTiempos);
			c.repaint();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		JButton botonEjecucion = new JButton();
		botonEjecucion.setText("INICIAR EJECUCI�N DEL PROGRAMA");
		botonEjecucion.setBounds(118, 590, 300, 25);
		
		this.setLayout(null);
		panelLetrasTiempos.setLayout(null);
		
		//acciones al ejecutar el boton ejecucion.
		botonEjecucion.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	ArrayList<String> palabras = Juego.this.palabras;
	    		
	    		Tiempo tiempoGlobal = new Tiempo();
	    		tiempoGlobal.iniciar();
	    		
	    		int msGlobal = 0;
	    		int csGlobal = 0;
	    		int sGlobal = 0;
	    		int mGlobal = 0;
	    		int hGlobal = 0;
	    		
	    		for (int i = 0; i < palabras.size(); i++) {
	    			Tiempo t = new Tiempo();
	    			t.iniciar();
	    			ArrayList<String> resultado = resolver(palabras.get(i));
	    			
	    			JTextArea tiempo = camposDeTiempo.get(i);
	    			int ms = t.getMiliSegundos();
	    			int cs = t.getCentesimasDeSegundos();
	    			int s = t.getSegundos();
	    			int m = t.getMinutos();
	    			int h = t.getHoras();
//	    			String tiempoCadena = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s+":"+(cs<=9?"0":"")+cs +":"+(ms<=9?"0":"")+ms;
	    			String tiempoCadena = (h<=9?"0":"")+h + "h" +":"+(m<=9?"0":"")+m+"m"+":"+(s<=9?"0":"")+s+"s"+":"+(ms<=9?"0":"")+ms+"ms";
	    			
	    			msGlobal += ms;
	    			csGlobal += cs;
	    			sGlobal += s;
	    			mGlobal += m;
	    			hGlobal += h;
	    			
	    			tiempo.setText(tiempoCadena);
	    			
	    			System.out.println("\n\n" + resultado.get(0) + "\n");
	    			System.out.println("-----------------------------------------------------------------------------------");
	    			System.out.println(t.getTiempo());
	    			System.out.println("tiempo global: " + tiempoGlobal.getTiempo());
	    			
	    			t.detener();
	    			
	    			VentanaMensaje vm = new VentanaMensaje(c, palabras.get(i), arregloLetras);
	    			
	    			SwingUtilities.updateComponentTreeUI(c);
	    			
//	    			for (int j = 0; j < arregloLetras.length; j++) {
//						for (int k = 0; k < arregloLetras[j].length; k++) {
//							arregloLetras[j][k].setBackground(Color.GRAY);		
//						}
//					}
	    			
	    		}
//	    		String tiempoGlobalCadena = (hGlobal<=9?"0":"")+hGlobal+":"+(mGlobal<=9?"0":"")+mGlobal+":"+(sGlobal<=9?"0":"")+sGlobal+":"+(csGlobal<=9?"0":"")+csGlobal  +":"+(msGlobal<=9?"0":"")+msGlobal;
	    		String tiempoGlobalCadena = (hGlobal<=9?"0":"")+hGlobal+"h"+":"+(mGlobal<=9?"0":"")+mGlobal+"m"+":"+(sGlobal<=9?"0":"")+sGlobal+"s"+":"+(msGlobal<=9?"0":"")+msGlobal+"ms";
	    		tiempoTotalCuadro.setText(tiempoGlobalCadena);
	    		tiempoGlobal.detener();
	        }
	    });

		try {
			c.add(botonEjecucion);
			c.repaint();
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * @return the sopa
	 */
	public char[][] getSopa() {
		return sopa;
	}

	/**
	 * @param sopa the sopa to set
	 */
	public void setSopa(char[][] sopa) {
		this.sopa = sopa;
	}
	
	public ArrayList<String> resolver(String palabraABuscar) {
		boolean encontradoDerecha = true;
		boolean encontradoIzquierda = true;
		boolean encontradoTop = true;
		boolean encontradoBottom = true;
		boolean encontradoDerechaTop = true;
		boolean encontradoIzquierdaTop = true;
		boolean encontradoDerechaBottom = true;
		boolean encontradoIzquierdaBottom = true;
		String palabraFormadaDerecha = "";
		String palabraFormadaIzquierda = "";
		String palabraFormadaTop = "";
		String palabraFormadaBottom = "";
		String palabraFormadaDerechaTop = "";
		String palabraFormadaIzquierdaTop = "";
		String palabraFormadaDerechaBottom = "";
		String palabraFormadaIzquierdaBottom = "";
		
		for (int i = 0; i < sopa.length; i++) {
			for (int j = 0; j < sopa[i].length; j++) {
				String palabra = palabraABuscar;
				if (sopa[i][j] == palabra.charAt(0)) {
					encontradoDerecha = true;
					encontradoIzquierda = true;
					encontradoTop = true;
					encontradoBottom = true;
					encontradoDerechaTop = true;
					encontradoIzquierdaTop = true;
					encontradoDerechaBottom = true;
					encontradoIzquierdaBottom = true;
					palabraFormadaDerecha = "" + palabra.charAt(0);
					palabraFormadaIzquierda = "" + palabra.charAt(0);
					palabraFormadaTop = "" + palabra.charAt(0);
					palabraFormadaBottom = "" + palabra.charAt(0);
					palabraFormadaDerechaTop = "" + palabra.charAt(0);
					palabraFormadaIzquierdaTop = "" + palabra.charAt(0);
					palabraFormadaDerechaBottom = "" + palabra.charAt(0);
					palabraFormadaIzquierdaBottom = "" + palabra.charAt(0);
					
					ArrayList<Integer> arregloFilasDerecha = new ArrayList<>();
					ArrayList<Integer> arregloColumnasDerecha = new ArrayList<>();
					arregloFilasDerecha.add(i);
					arregloColumnasDerecha.add(j);
					ArrayList<Integer> arregloFilasIzquierda = new ArrayList<>();
					ArrayList<Integer> arregloColumnasIzquierda = new ArrayList<>();
					arregloFilasIzquierda.add(i);
					arregloColumnasIzquierda.add(j);
					ArrayList<Integer> arregloFilasTop= new ArrayList<>();
					ArrayList<Integer> arregloColumnasTop = new ArrayList<>();
					arregloFilasTop.add(i);
					arregloColumnasTop.add(j);
					ArrayList<Integer> arregloFilasBottom = new ArrayList<>();
					ArrayList<Integer> arregloColumnasBottom = new ArrayList<>();
					arregloFilasBottom.add(i);
					arregloColumnasBottom.add(j);
					ArrayList<Integer> arregloFilasDerechaTop = new ArrayList<>();
					ArrayList<Integer> arregloColumnasDerechaTop = new ArrayList<>();
					arregloFilasDerechaTop.add(i);
					arregloColumnasDerechaTop.add(j);
					ArrayList<Integer> arregloFilasIzquierdaTop = new ArrayList<>();
					ArrayList<Integer> arregloColumnasIzquierdaTop = new ArrayList<>();
					arregloFilasIzquierdaTop.add(i);
					arregloColumnasIzquierdaTop.add(j);
					ArrayList<Integer> arregloFilasDerechaBottom = new ArrayList<>();
					ArrayList<Integer> arregloColumnasDerechaBottom = new ArrayList<>();
					arregloFilasDerechaBottom.add(i);
					arregloColumnasDerechaBottom.add(j);
					ArrayList<Integer> arregloFilasIzquierdaBottom = new ArrayList<>();
					ArrayList<Integer> arregloColumnasIzquierdaBottom = new ArrayList<>();
					arregloFilasIzquierdaBottom.add(i);
					arregloColumnasIzquierdaBottom.add(j);
					
					int c = j;
					for (int k = 1; k < palabra.length(); k++) {
						//Busqueda derecha
						try {
							if (sopa[i][j + k] == palabra.charAt(k) && encontradoDerecha == true) {
								encontradoDerecha = true;
								palabraFormadaDerecha += palabra.charAt(k);
								
								arregloFilasDerecha.add(i);
								arregloColumnasDerecha.add(j + k);
								
								if (palabraFormadaDerecha.equals(palabra)) {
									System.out.println("\nfila: " + i + " | columna: " + c + " | palabraFormadaDerecha: " + palabraFormadaDerecha + " | palabra: " + palabra);
									ArrayList<String> resultado = new ArrayList<>();
									resultado.add("encontradoDerecha");
									resultado.add(palabraFormadaDerecha);
									
									for (int h = 0; h < arregloFilasDerecha.size(); h++) {
										int fila = arregloFilasDerecha.get(h);
										int columna = arregloColumnasDerecha.get(h);
										arregloLetras[fila][columna].setBackground(Color.YELLOW);
									}
									
									return resultado;
								}
							} else {
								encontradoDerecha = false;
							}
						} catch (Exception e) {
							encontradoDerecha = false;
						}
						//busqueda izquierda
						try {
							if (sopa[i][j - k] == palabra.charAt(k) && encontradoIzquierda == true) {
								encontradoIzquierda = true;
								palabraFormadaIzquierda += palabra.charAt(k);
								
								arregloFilasIzquierda.add(i);
								arregloColumnasIzquierda.add(j - k);
								
								if (palabraFormadaIzquierda.equals(palabra)) {
									System.out.println("\nfila: " + i + " | columna: " + c + " | palabraFormadaIzquierda: " + palabraFormadaIzquierda + " | palabra: " + palabra);
									ArrayList<String> resultado = new ArrayList<>();
									resultado.add("encontradoIzquierda");
									resultado.add(palabraFormadaIzquierda);
									
									for (int h = 0; h < arregloFilasIzquierda.size(); h++) {
										int fila = arregloFilasIzquierda.get(h);
										int columna = arregloColumnasIzquierda.get(h);
										arregloLetras[fila][columna].setBackground(Color.YELLOW);
									}
									
									return resultado;
								}
							} else {
								encontradoIzquierda = false;
							}
						} catch (Exception e) {
							encontradoIzquierda = false;
						}
						//Busqueda top
						try {
							if (sopa[i - k][j] == palabra.charAt(k) && encontradoTop == true) {
								encontradoTop = true;
								palabraFormadaTop += palabra.charAt(k);
								
								arregloFilasTop.add(i - k);
								arregloColumnasTop.add(j);
								
								if (palabraFormadaTop.equals(palabra)) {
									System.out.println("\nfila: " + i + " | columna: " + c + " | palabraFormadaTop: " + palabraFormadaTop + " | palabra: " + palabra);
									ArrayList<String> resultado = new ArrayList<>();
									resultado.add("encontradoTop");
									resultado.add(palabraFormadaTop);
									
									for (int h = 0; h < arregloFilasTop.size(); h++) {
										int fila = arregloFilasTop.get(h);
										int columna = arregloColumnasTop.get(h);
										arregloLetras[fila][columna].setBackground(Color.YELLOW);
									}
									
									return resultado;
								}
							} else {
								encontradoTop = false;
							}
						} catch (Exception e) {
							encontradoTop = false;
						}
						//Busqueda bottom
						try {
							if (sopa[i + k][j] == palabra.charAt(k) && encontradoBottom == true) {
								encontradoBottom = true;
								palabraFormadaBottom += palabra.charAt(k);
								
								arregloFilasBottom.add(i + k);
								arregloColumnasBottom.add(j);
								
								if (palabraFormadaBottom.equals(palabra)) {
									System.out.println("\nfila: " + i + " | columna: " + c + " | palabraFormadaBottom: " + palabraFormadaBottom + " | palabra: " + palabra);
									ArrayList<String> resultado = new ArrayList<>();
									resultado.add("encontradoBottom");
									resultado.add(palabraFormadaBottom);
									
									for (int h = 0; h < arregloFilasBottom.size(); h++) {
										int fila = arregloFilasBottom.get(h);
										int columna = arregloColumnasBottom.get(h);
										arregloLetras[fila][columna].setBackground(Color.YELLOW);
									}
									
									return resultado;
								}
							} else {
								encontradoBottom = false;
							}
						} catch (Exception e) {
							encontradoBottom = false;
						}
						//Busqueda derecha-top
						try {
							if (sopa[i - k][j + k] == palabra.charAt(k) && encontradoDerechaTop == true) {
								encontradoDerechaTop = true;
								palabraFormadaDerechaTop += palabra.charAt(k);
								
								arregloFilasDerechaTop.add(i - k);
								arregloColumnasDerechaTop.add(j + k);
								
								if (palabraFormadaDerechaTop.equals(palabra)) {
									System.out.println("\nfila: " + i + " | columna: " + c + " | palabraFormadaDerechaTop: " + palabraFormadaDerechaTop + " | palabra: " + palabra);
									ArrayList<String> resultado = new ArrayList<>();
									resultado.add("encontradoDerechaTop");
									resultado.add(palabraFormadaDerechaTop);
									
									for (int h = 0; h < arregloFilasDerechaTop.size(); h++) {
										int fila = arregloFilasDerechaTop.get(h);
										int columna = arregloColumnasDerechaTop.get(h);
										arregloLetras[fila][columna].setBackground(Color.YELLOW);
									}
									
									return resultado;
								}
							} else {
								encontradoDerechaTop = false;
							}
						} catch (Exception e) {
							encontradoDerechaTop = false;
						}
						//Busqueda izquierda-top
						try {
							if (sopa[i - k][j - k] == palabra.charAt(k) && encontradoIzquierdaTop == true) {
								encontradoIzquierdaTop = true;
								palabraFormadaIzquierdaTop += palabra.charAt(k);
								
								arregloFilasIzquierdaTop.add(i - k);
								arregloColumnasIzquierdaTop.add(j - k);
								
								if (palabraFormadaIzquierdaTop.equals(palabra)) {
									System.out.println("\nfila: " + i + " | columna: " + c + " | palabraFormadaIzquierdaTop: " + palabraFormadaIzquierdaTop + " | palabra: " + palabra);
									ArrayList<String> resultado = new ArrayList<>();
									resultado.add("encontradoIzquierdaTop");
									resultado.add(palabraFormadaIzquierdaTop);
									
									for (int h = 0; h < arregloFilasIzquierdaTop.size(); h++) {
										int fila = arregloFilasIzquierdaTop.get(h);
										int columna = arregloColumnasIzquierdaTop.get(h);
										arregloLetras[fila][columna].setBackground(Color.YELLOW);
									}
									
									return resultado;
								}
							} else {
								encontradoIzquierdaTop = false;
							}
						} catch (Exception e) {
							encontradoIzquierdaTop = false;
						}
						//Busqueda derecha-bottom
						try {
							if (sopa[i + k][j + k] == palabra.charAt(k) && encontradoDerechaBottom == true) {
								encontradoDerechaBottom = true;
								palabraFormadaDerechaBottom += palabra.charAt(k);
								
								arregloFilasDerechaBottom.add(i + k);
								arregloColumnasDerechaBottom.add(j + k);
								
								if (palabraFormadaDerechaBottom.equals(palabra)) {
									System.out.println("\nfila: " + i + " | columna: " + c + " | palabraFormadaDerechaBottom: " + palabraFormadaDerechaBottom + " | palabra: " + palabra);
									ArrayList<String> resultado = new ArrayList<>();
									resultado.add("encontradoDerechaBottom");
									resultado.add(palabraFormadaDerechaBottom);
									
									for (int h = 0; h < arregloFilasDerechaBottom.size(); h++) {
										int fila = arregloFilasDerechaBottom.get(h);
										int columna = arregloColumnasDerechaBottom.get(h);
										arregloLetras[fila][columna].setBackground(Color.YELLOW);
									}
									
									return resultado;
								}
							} else {
								encontradoDerechaBottom = false;
							}
						} catch (Exception e) {
							encontradoDerechaBottom = false;
						}
						//Busqueda izquierda-bottom
						try {
							if (sopa[i + k][j - k] == palabra.charAt(k) && encontradoIzquierdaBottom == true) {
								encontradoIzquierdaBottom = true;
								palabraFormadaIzquierdaBottom += palabra.charAt(k);
								
								arregloFilasIzquierdaBottom.add(i + k);
								arregloColumnasIzquierdaBottom.add(j - k);
								
								if (palabraFormadaIzquierdaBottom.equals(palabra)) {
									System.out.println("\nfila: " + i + " | columna: " + c + " | palabraFormadaIzquierdaBottom: " + palabraFormadaIzquierdaBottom + " | palabra: " + palabra);
									ArrayList<String> resultado = new ArrayList<>();
									resultado.add("encontradoIzquierdaBottom");
									resultado.add(palabraFormadaIzquierdaBottom);
									
									for (int h = 0; h < arregloFilasIzquierdaBottom.size(); h++) {
										int fila = arregloFilasIzquierdaBottom.get(h);
										int columna = arregloColumnasIzquierdaBottom.get(h);
										arregloLetras[fila][columna].setBackground(Color.YELLOW);
									}
									
									return resultado;
								}
							} else {
								encontradoIzquierdaBottom = false;
							}
						} catch (Exception e) {
							encontradoIzquierdaBottom = false;
						}	
					}
				}
			}
		} //primer for
		ArrayList<String> resultado = new ArrayList<>();
		resultado.add("No se encontro nada");
		return resultado;
	}
}





























package practica2sia;



import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tiempo  {

    private Timer timer;
    private int h, m, s, cs, ms;
    
    public Tiempo() {
    	timer = new Timer(1, acciones);
    }
    
    private ActionListener acciones = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            ++ms; 
            if (ms == 1000) {
				ms = 0;
				++s;
			}
//            if (cs == 100) {
//                cs = 0;
//                ++s;
//            }
            if (s == 60) {
                s = 0;
                ++m;
            }
            if (m == 60) {
                m = 0;
                ++h;
            }
            
        }
        
    };

    //Crea un timer, inicia segundos a 0 y comienza a contar
    public void iniciar() {
    	this.ms = 0;
    	this.cs = 0;
    	this.s = 0;
    	this.m = 0;
        
        timer.start();
        
    }
    //Detiene el contador
    public void detener() {
        if (timer.isRunning()) {
			timer.stop();
		}
        this.ms = 0;
        this.cs = 0;
    	this.s = 0;
    	this.m = 0;
    }
    
    public void pausar() {
    	timer.stop();
    }
    
    public String getTiempo() {
//    	String tiempo = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s +":"+(cs<=9?"0":"")+cs +":"+(ms<=9?"0":"")+ms;
    	String tiempo = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s +":"+(ms<=9?"0":"")+ms;
    	return tiempo;
    }
    
    public int getMiliSegundos() {
    	return this.ms;
    }
    
    public int getCentesimasDeSegundos() {
    	return this.cs;
    }
    
    public int getSegundos() {
    	return this.s;
    }
    
    public int getMinutos() {
    	return this.m;
    }
    
    public int getHoras() {
    	return this.h;
    }
}

package ec.edu.puce;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Tabla extends JPanel {

    private JToggleButton[][] botones; 
    private ArrayList<Integer> sacados; 

    public Tabla() {
        setLayout(new GridLayout(9, 10)); 
        botones = new JToggleButton[9][10]; 

        for (int i = 0; i < 9; i++) { 
            for (int j = 0; j < 10; j++) { 
                int numero = i * 10 + j + 1; 
                botones[i][j] = new JToggleButton(Integer.toString(numero)); 
                botones[i][j].setEnabled(false); 
                add(botones[i][j]); 
            }
        }
    }

    public void setSacados(ArrayList<Integer> sacados) {
        this.sacados = sacados; 
    }

    public void marcarNumero(int numero) {
        int i = (numero - 1) / 10; 
        int j = (numero - 1) % 10; 
        botones[i][j].setBackground(Color.YELLOW); 
        botones[i][j].setEnabled(true); 
        sacados.add(numero); 
    }
    public void reiniciar() {
    	for (int i = 0; i < 9; i++) { 
            for (int j = 0; j < 10; j++) { 
                botones[i][j].setBackground(null); 
                botones[i][j].setEnabled(false); 
            }
        }
        sacados.clear(); 
    }

    public boolean tablaLlena() {
        for (int i = 0; i < botones.length; i++) { 
            for (int j = 0; j < botones[i].length; j++) { 
                if (!botones[i][j].getBackground().equals(Color.YELLOW)) { 
                    return false; 
                }
            }
        }
        return true; 
    }

    }
    
    
package ec.edu.puce;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Bingo extends JFrame {

    private ArrayList<Integer> bolas; 
     
    private Tabla tabla;
   
    private JLabel lblNumeroSacado;
   
    private JButton btnSacarBola;
   

    public Bingo() {
    	getContentPane().setBackground(new Color(255, 255, 128));
        setTitle("Bingo");
        
        setSize(833, 676);   
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        getContentPane().setLayout(null);

        bolas = new ArrayList<Integer>();
        for (int i = 1; i <= 90; i++) {
        	bolas.add(i);
        }
        Collections.shuffle(bolas);
        
        tabla = new Tabla();
        tabla.setBackground(new Color(255, 128, 64));
        tabla.setBounds(75, 161, 556, 465);
        tabla.setSacados(bolas);
        
        getContentPane().add(tabla);

        lblNumeroSacado = new JLabel();
        lblNumeroSacado.setBackground(new Color(255, 255, 255));
        lblNumeroSacado.setForeground(new Color(0, 0, 0));
        lblNumeroSacado.setFont(new Font("Unispace", Font.PLAIN, 64));
        lblNumeroSacado.setBounds(688, 198, 129, 95);
        getContentPane().add(lblNumeroSacado);
        

        btnSacarBola = new JButton("Sacar bola");
        btnSacarBola.setBackground(new Color(0, 255, 0));
        btnSacarBola.setFont(new Font("Stencil", Font.PLAIN, 16));
        btnSacarBola.setBounds(642, 11, 149, 95);
        btnSacarBola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bolas.size() > 0 && !tabla.tablaLlena()) {
                    int numero = bolas.remove(0);
                    
                    lblNumeroSacado.setText(Integer.toString(numero));
                    tabla.marcarNumero(numero);
                 
                } else {
                lblNumeroSacado.setText("Juego terminado");
                btnSacarBola.setEnabled(false);
                
                }
                }
                });
                getContentPane().add(btnSacarBola);
                
                JButton btnReiniciar = new JButton("Reiniciar");
                btnReiniciar.setFont(new Font("Stencil", Font.PLAIN, 11));
                btnReiniciar.setBackground(new Color(255, 0, 0));
                btnReiniciar.setBounds(642, 117, 149, 30);
                btnReiniciar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        reiniciar();
                        
                    }
                });
                getContentPane().add(btnReiniciar);
                

                JLabel lblNewLabel = new JLabel("Bingo90");
                lblNewLabel.setForeground(new Color(128, 0, 64));
                lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 90));
                lblNewLabel.setBounds(142, 25, 412, 116);
                getContentPane().add(lblNewLabel);
                
                
            
                
            }

            public void reiniciar() {
                tabla.reiniciar();
                
                Collections.shuffle(bolas);
                tabla.setSacados(bolas);
                
                lblNumeroSacado.setText("");
                btnSacarBola.setEnabled(true);
                
            }

            public static void main(String[] args) {
            	Bingo bingo = new Bingo();
            	bingo.setVisible(true);
            	
            	}
            	}
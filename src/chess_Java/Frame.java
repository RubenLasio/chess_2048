package chess_Java;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;



public class Frame extends JFrame{
	
	public Icon pallino;
	
	public Icon pedoneBianco;
	public Icon reginaBianca;
	public Icon reBianco;
	public Icon alfiereBianco;
	public Icon torreBianca;
	public Icon cavalloBianco;
	
	public Icon pedoneNero;
	public Icon reginaNera;
	public Icon reNero;
	public Icon alfiereNero;
	public Icon torreNera;
	public Icon cavalloNero;
	
	Color green = new Color(119,149,86);
	Color white = new Color(235,236,208);
	
	//Border x = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);

	int n = 8;// caselle per lato
	public JPanel[][] caselle;// matrice di caselle
	public JButton[][] pezzi;//matrice di pezzi
	
	public Frame() {
		super("2048");
		Container c = this.getContentPane();
		
		caselle = new JPanel[n][n];
		pezzi = new JButton[n][n];
		
		pallino = new ImageIcon("C:/Users/Ruben/Downloads/pezzi/pallino.png");
		
		pedoneBianco = new ImageIcon("C:/Users/Ruben/Downloads/pezzi/pedoneBianco.png");
		reginaBianca = new ImageIcon("C:/Users/Ruben/Downloads/pezzi/reginaBianca.png");
		reBianco = new ImageIcon("C:/Users/Ruben/Downloads/pezzi/reBianco.png");
		alfiereBianco = new ImageIcon("C:/Users/Ruben/Downloads/pezzi/alfiereBianco.png");
		torreBianca = new ImageIcon("C:/Users/Ruben/Downloads/pezzi/torreBianca.png");
		cavalloBianco = new ImageIcon("C:/Users/Ruben/Downloads/pezzi/cavalloBianco.png");
		
		pedoneNero = new ImageIcon("C:/Users/Ruben/Downloads/pezzi/pedoneNero.png");
		reginaNera = new ImageIcon("C:/Users/Ruben/Downloads/pezzi/reginaNera.png");
		reNero = new ImageIcon("C:/Users/Ruben/Downloads/pezzi/reNero.png");
		alfiereNero = new ImageIcon("C:/Users/Ruben/Downloads/pezzi/alfiereNero.png");
		torreNera = new ImageIcon("C:/Users/Ruben/Downloads/pezzi/torreNera.png");
		cavalloNero = new ImageIcon("C:/Users/Ruben/Downloads/pezzi/cavalloNero.png");
		
		int d=0;
		for(int y=0; y<n; y++) {
			for(int x=0; x<n; x++) {
				caselle[x][y] = new JPanel();
				
				if(y>1 && y<6) {
					pezzi[x][y] = new JButton();
					pezzi[x][y].setBackground(null);
					pezzi[x][y].setVisible(false);
				}
				else if(y==1) {
					pezzi[x][y] = new JButton(pedoneNero);
					pezzi[x][y].setBackground(null);
				}
				else if(y==6) {
					pezzi[x][y] = new JButton(pedoneBianco);
					pezzi[x][y].setBackground(null);
				}
				else if(y==7) {
					switch(x) {
					case 0: {
						pezzi[x][y] = new JButton(torreBianca);
						pezzi[x][y].setBackground(null);
					}
						break;
					case 1:{
						pezzi[x][y] = new JButton(cavalloBianco);
						pezzi[x][y].setBackground(null);
					}
						break;
					case 2:{
						pezzi[x][y] = new JButton(alfiereBianco);
						pezzi[x][y].setBackground(null);
					}
						break;
					case 3:{
						pezzi[x][y] = new JButton(reginaBianca);
						pezzi[x][y].setBackground(null);
					}
						break;
					case 4:{
						pezzi[x][y] = new JButton(reBianco);
						pezzi[x][y].setBackground(null);
					}
						break;
					case 5:{
						pezzi[x][y] = new JButton(alfiereBianco);
						pezzi[x][y].setBackground(null);
					}
						break;
					case 6:{
						pezzi[x][y] = new JButton(cavalloBianco);
						pezzi[x][y].setBackground(null);
					}
						break;
					case 7:{
						pezzi[x][y] = new JButton(torreBianca);
						pezzi[x][y].setBackground(null);
					}
					}
					
				}
				else if(y==0) {
					switch(x) {
					case 0: {
						pezzi[x][y] = new JButton(torreNera);
						pezzi[x][y].setBackground(null);
					}
						break;
					case 1:{
						pezzi[x][y] = new JButton(cavalloNero);
						pezzi[x][y].setBackground(null);
					}
						break;
					case 2:{
						pezzi[x][y] = new JButton(alfiereNero);
						pezzi[x][y].setBackground(null);
					}
						break;
					case 3:{
						pezzi[x][y] = new JButton(reginaNera);
						pezzi[x][y].setBackground(null);
					}
						break;
					case 4:{
						pezzi[x][y] = new JButton(reNero);
						pezzi[x][y].setBackground(null);
					}
						break;
					case 5:{
						pezzi[x][y] = new JButton(alfiereNero);
						pezzi[x][y].setBackground(null);
					}
						break;
					case 6:{
						pezzi[x][y] = new JButton(cavalloNero);
						pezzi[x][y].setBackground(null);
					}
						break;
					case 7:{
						pezzi[x][y] = new JButton(torreNera);
						pezzi[x][y].setBackground(null);
					}
					}
					
				}
				else {
					pezzi[x][y] = new JButton();
					pezzi[x][y].setBackground(null);
					pezzi[x][y].setVisible(false);
				}
				
				c.add(caselle[x][y]);
				caselle[x][y].setLayout(new BorderLayout());
				caselle[x][y].add(pezzi[x][y],BorderLayout.CENTER);
				
				if((x%2 > 0 && y%2 > 0) || (x%2 == 0 && y%2 == 0))
					caselle[x][y].setBackground(white);
				else
					caselle[x][y].setBackground(green);
				d++;
				pezzi[x][y].addActionListener(new MyActionListener(x, y, this));
			}
		}
		c.setLayout(new GridLayout(n,n));
	}
}

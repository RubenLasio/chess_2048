package chess_Java;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class MyActionListener implements ActionListener {
    private int x;
    private int y;
    private static int c=0;
    private static int xPiece;
    private static int yPiece;
    private Icon iconPiece;
    private static Icon exIconPiece;
    private static boolean pallinoEsiste = false;
    private static boolean pallino2Esiste = false;
    
    Frame f;
    
    //creare una matrice da x=24 y=2 per mettere i posti dove sono i vecchi pallini
    //creare una variabile per sapere l'indice dell'ultimo dei pallini piazzati
    //creare metodo che ripulisce pallini dalla matrice e dal campo
    
    public MyActionListener(int x, int y, Frame f) {
        this.x = x;
        this.y = y;
        this.f= f;
    }


    public void actionPerformed(ActionEvent e) {
    	iconPiece = f.pezzi[x][y].getIcon();
    	
    	if(c%2 == 0) {// turno dei bianchi
    		if(iconPiece == f.pallino) {
        		move();
        	}
        	else if(iconPiece == f.pedoneBianco) {// se clicco un pedone bianco
        		checkPedoneBianco();
        	}
        	else{
        		checkEAT();
        	}
    	}
    	else {// turno dei neri
    		if(iconPiece == f.pallino) {
        		move();
        	}
        	else if(iconPiece == f.pedoneNero) {// se clicco un pedone bianco
        		checkPedoneNero();
        	}
        	else if(iconPiece == f.torreNera) {
        		checkTorreNera();
        	}
        	else{
        		checkEAT();
        	}
    	}
    }
    
    public void checkPedoneBianco() {
    	delete();
        	exIconPiece = f.pezzi[x][y].getIcon();
        	xPiece = x;
    		yPiece = y;
        	if(x != 7) {
        		if(f.pezzi[x+1][y-1].getIcon() == f.alfiereNero || f.pezzi[x+1][y-1].getIcon() == f.pedoneNero || f.pezzi[x+1][y-1].getIcon() == f.torreNera || f.pezzi[x+1][y-1].getIcon() == f.cavalloNero || f.pezzi[x+1][y-1].getIcon() == f.reginaNera || f.pezzi[x+1][y+1].getIcon() == f.reNero) {
            		f.pezzi[x+1][y-1].setBorder(BorderFactory.createLineBorder(Color.red, 3));
            	}
        	}
        	if(x != 0) {
        		if(f.pezzi[x-1][y-1].getIcon() == f.alfiereNero || f.pezzi[x-1][y-1].getIcon() == f.pedoneNero || f.pezzi[x-1][y-1].getIcon() == f.torreNera || f.pezzi[x-1][y-1].getIcon() == f.cavalloNero || f.pezzi[x-1][y-1].getIcon() == f.reginaNera || f.pezzi[x-1][y+1].getIcon() == f.reNero) {
            		f.pezzi[x-1][y-1].setBorder(BorderFactory.createLineBorder(Color.red, 3));
            	}
        	}
        	if(f.pezzi[x][y-1].getIcon() == null) {
        		f.pezzi[x][y-1].setIcon(f.pallino);
        		f.pezzi[x][y-1].setVisible(true);
        		if(f.pezzi[x][y-2].getIcon() == null && y == 6) {
            		f.pezzi[x][y-2].setIcon(f.pallino);
            		f.pezzi[x][y-2].setVisible(true);
            	}
        	}
    }
    
    public void checkEAT() {
    	System.out.println("d1ocane");
    	if(f.pezzi[x][y].getBorder() != null){
    		System.out.println("diocane");
    		move();
    	}
    }
    
    public void checkPedoneNero() {
    	delete();
    	exIconPiece = f.pezzi[x][y].getIcon();
    	xPiece = x;
		yPiece = y;
    	if(x != 7) {
    		if(f.pezzi[x+1][y+1].getIcon() == f.alfiereBianco || f.pezzi[x+1][y+1].getIcon() == f.pedoneBianco || f.pezzi[x+1][y+1].getIcon() == f.torreBianca || f.pezzi[x+1][y+1].getIcon() == f.cavalloBianco || f.pezzi[x+1][y+1].getIcon() == f.reginaBianca || f.pezzi[x+1][y+1].getIcon() == f.reBianco) {
        		f.pezzi[x+1][y+1].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
    	}
    	if(x != 0) {
    		if(f.pezzi[x-1][y+1].getIcon() == f.alfiereBianco || f.pezzi[x-1][y+1].getIcon() == f.pedoneBianco || f.pezzi[x-1][y+1].getIcon() == f.torreBianca || f.pezzi[x-1][y+1].getIcon() == f.cavalloBianco || f.pezzi[x-1][y+1].getIcon() == f.reginaBianca || f.pezzi[x-1][y+1].getIcon() == f.reBianco) {
        		f.pezzi[x-1][y+1].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
    	}
    	if(f.pezzi[x][y+1].getIcon() == null) {
    		f.pezzi[x][y+1].setIcon(f.pallino);
    		f.pezzi[x][y+1].setVisible(true);
    		if(f.pezzi[x][y+2].getIcon() == null && y == 1) {
        		f.pezzi[x][y+2].setIcon(f.pallino);
        		f.pezzi[x][y+2].setVisible(true);
        	}
    	}
    }
    
    public void move() {
    	delete();
    	f.pezzi[x][y].setIcon(exIconPiece);
		f.pezzi[x][y].setVisible(true);
		f.pezzi[xPiece][yPiece].setIcon(null);
		f.pezzi[xPiece][yPiece].setVisible(false);
		xPiece = x;
		yPiece = y;
		c++;
    }
    
    public void delete() {
    	int x,y;
    	for(y=0; y<f.n; y++) {
    		for(x=0; x<f.n; x++) {
    			if(f.pezzi[x][y].getIcon() == f.pallino) {
    				f.pezzi[x][y].setIcon(null);
    				f.pezzi[x][y].setVisible(false);
    			}
    			if(f.pezzi[x][y].getBorder() != null) {
    				f.pezzi[x][y].setBorder(null);
    			}
    		}
    	}
    }
    
    public boolean selected() {
    	for(int y=0; y<f.n; y++) {
    		for(int x=0; x<f.n; x++) {
    			if(f.pezzi[x][y].getIcon() == f.pallino || f.pezzi[x][y].getBorder() == BorderFactory.createLineBorder(Color.red, 3)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public void checkTorreNera() {
    	delete();
    	exIconPiece = f.pezzi[x][y].getIcon();
    	xPiece = x;
		yPiece = y;
		int east=x+1;
		int west=x-1;
		int north=y-1;
		int south=y+1;
    	while(north>=0 && f.pezzi[x][north].getIcon() == null) {
    		f.pezzi[x][north].setIcon(f.pallino);
    		f.pezzi[x][north].setVisible(true);
    		north--;
    	}
    	if(north>=0 && (f.pezzi[x][north].getIcon() == f.alfiereBianco || f.pezzi[x][north].getIcon() == f.pedoneBianco || f.pezzi[x][north].getIcon() == f.torreBianca || f.pezzi[x][north].getIcon() == f.cavalloBianco || f.pezzi[x][north].getIcon() == f.reginaBianca || f.pezzi[x][north].getIcon() == f.reBianco)) {
    		f.pezzi[x][north].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    	}
    	
    	while(south<=7 && f.pezzi[x][south].getIcon() == null) {
    		f.pezzi[x][south].setIcon(f.pallino);
    		f.pezzi[x][south].setVisible(true);
    		south++;
    	}
    	if(south<=7 && (f.pezzi[x][south].getIcon() == f.alfiereBianco || f.pezzi[x][south].getIcon() == f.pedoneBianco || f.pezzi[x][south].getIcon() == f.torreBianca || f.pezzi[x][south].getIcon() == f.cavalloBianco || f.pezzi[x][south].getIcon() == f.reginaBianca || f.pezzi[x][south].getIcon() == f.reBianco)) {
    		f.pezzi[x][south].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    	}
    	
    	while(east<=7 && f.pezzi[east][y].getIcon() == null) {
    		f.pezzi[east][y].setIcon(f.pallino);
    		f.pezzi[east][y].setVisible(true);
    		east++;
    	}
    	if(east<=7 && (f.pezzi[east][y].getIcon() == f.alfiereBianco || f.pezzi[east][y].getIcon() == f.pedoneBianco || f.pezzi[east][y].getIcon() == f.torreBianca || f.pezzi[east][y].getIcon() == f.cavalloBianco || f.pezzi[east][y].getIcon() == f.reginaBianca || f.pezzi[east][y].getIcon() == f.reBianco)) {
    		f.pezzi[east][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    	}
    	
    	while(west>=0 && f.pezzi[west][y].getIcon() == null) {
    		f.pezzi[west][y].setIcon(f.pallino);
    		f.pezzi[west][y].setVisible(true);
    		west++;
    	}
    	if(west>=0 && (f.pezzi[west][y].getIcon() == f.alfiereBianco || f.pezzi[west][y].getIcon() == f.pedoneBianco || f.pezzi[west][y].getIcon() == f.torreBianca || f.pezzi[west][y].getIcon() == f.cavalloBianco || f.pezzi[west][y].getIcon() == f.reginaBianca || f.pezzi[west][y].getIcon() == f.reBianco)) {
    		f.pezzi[west][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    	}
    }
}

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
        	else if(iconPiece == f.torreBianca) {
        		checkTorreBianca();
        	}
        	else if(iconPiece == f.alfiereBianco) {
        		checkAlfiereBianco();
        	}
        	else if(iconPiece == f.alfiereBianco) {
        		checkAlfiereBianco();
        	}
        	else if(iconPiece == f.reginaBianca) {
        		checkReginaBianca();
        	}
        	else if(iconPiece == f.cavalloBianco) {
        		checkCavalloBianco();
        	}
        	else if(iconPiece == f.reBianco) {
        		checkReBianco();
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
        	else if(iconPiece == f.alfiereNero) {
        		checkAlfiereNero();
        	}
        	else if(iconPiece == f.reginaNera) {
        		checkReginaNera();
        	}
        	else if(iconPiece == f.cavalloNero) {
        		checkCavalloNero();
        	}
        	else if(iconPiece == f.reNero) {
        		checkReNero();
        	}
        	else{
        		checkEAT();
        	}
    	}
    }
    
    public void checkPedoneBianco() {
    	int[][] pos = posReBianco();
    	if(!scaccoNero(pos[0][0], pos[1][0])) {
    		delete();
        	exIconPiece = f.pezzi[x][y].getIcon();
        	xPiece = x;
    		yPiece = y;
        	if(x != 7) {
        		if(f.pezzi[x+1][y-1].getIcon() == f.alfiereNero || f.pezzi[x+1][y-1].getIcon() == f.pedoneNero || f.pezzi[x+1][y-1].getIcon() == f.torreNera || f.pezzi[x+1][y-1].getIcon() == f.cavalloNero || f.pezzi[x+1][y-1].getIcon() == f.reginaNera || f.pezzi[x+1][y-1].getIcon() == f.reNero) {
            		f.pezzi[x+1][y-1].setBorder(BorderFactory.createLineBorder(Color.red, 3));
            	}
        	}
        	if(x != 0) {
        		if(f.pezzi[x-1][y-1].getIcon() == f.alfiereNero || f.pezzi[x-1][y-1].getIcon() == f.pedoneNero || f.pezzi[x-1][y-1].getIcon() == f.torreNera || f.pezzi[x-1][y-1].getIcon() == f.cavalloNero || f.pezzi[x-1][y-1].getIcon() == f.reginaNera || f.pezzi[x-1][y-1].getIcon() == f.reNero) {
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
    }
    
    public void checkEAT() {
    	if(f.pezzi[x][y].getBorder() != null){
    		move();
    	}
    }
    
    public void checkPedoneNero() {
    	int[][] pos = posReNero();
    	
    	if(!scaccoBianco(pos[0][0], pos[1][0])) {
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
    	int[][] pos = posReNero();
    	
    	if(!scaccoBianco(pos[0][0], pos[1][0])) {
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
        		west--;
        	}
        	if(west>=0 && (f.pezzi[west][y].getIcon() == f.alfiereBianco || f.pezzi[west][y].getIcon() == f.pedoneBianco || f.pezzi[west][y].getIcon() == f.torreBianca || f.pezzi[west][y].getIcon() == f.cavalloBianco || f.pezzi[west][y].getIcon() == f.reginaBianca || f.pezzi[west][y].getIcon() == f.reBianco)) {
        		f.pezzi[west][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
    	}
    }
    
    public void checkTorreBianca() {
    	int[][] pos = posReBianco();
    	
    	if(!scaccoNero(pos[0][0], pos[1][0])) {
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
        	if(north>=0 && (f.pezzi[x][north].getIcon() == f.alfiereNero || f.pezzi[x][north].getIcon() == f.pedoneNero || f.pezzi[x][north].getIcon() == f.torreNera || f.pezzi[x][north].getIcon() == f.cavalloNero || f.pezzi[x][north].getIcon() == f.reginaNera || f.pezzi[x][north].getIcon() == f.reNero)) {
        		f.pezzi[x][north].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	
        	while(south<=7 && f.pezzi[x][south].getIcon() == null) {
        		f.pezzi[x][south].setIcon(f.pallino);
        		f.pezzi[x][south].setVisible(true);
        		south++;
        	}
        	if(south<=7 && (f.pezzi[x][south].getIcon() == f.alfiereNero || f.pezzi[x][south].getIcon() == f.pedoneNero || f.pezzi[x][south].getIcon() == f.torreNera || f.pezzi[x][south].getIcon() == f.cavalloNero || f.pezzi[x][south].getIcon() == f.reginaNera || f.pezzi[x][south].getIcon() == f.reNero)) {
        		f.pezzi[x][south].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	
        	while(east<=7 && f.pezzi[east][y].getIcon() == null) {
        		f.pezzi[east][y].setIcon(f.pallino);
        		f.pezzi[east][y].setVisible(true);
        		east++;
        	}
        	if(east<=7 && (f.pezzi[east][y].getIcon() == f.alfiereNero || f.pezzi[east][y].getIcon() == f.pedoneNero || f.pezzi[east][y].getIcon() == f.torreNera || f.pezzi[east][y].getIcon() == f.cavalloNero || f.pezzi[east][y].getIcon() == f.reginaNera || f.pezzi[east][y].getIcon() == f.reNero)) {
        		f.pezzi[east][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	
        	while(west>=0 && f.pezzi[west][y].getIcon() == null) {
        		f.pezzi[west][y].setIcon(f.pallino);
        		f.pezzi[west][y].setVisible(true);
        		west--;
        	}
        	if(west>=0 && (f.pezzi[west][y].getIcon() == f.alfiereNero || f.pezzi[west][y].getIcon() == f.pedoneNero || f.pezzi[west][y].getIcon() == f.torreNera || f.pezzi[west][y].getIcon() == f.cavalloNero || f.pezzi[west][y].getIcon() == f.reginaNera || f.pezzi[west][y].getIcon() == f.reNero)) {
        		f.pezzi[west][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
    	}
    }
    
    public void checkAlfiereBianco() {
    	int[][] pos = posReBianco();
    	
    	if(!scaccoNero(pos[0][0], pos[1][0])) {
    		delete();
        	exIconPiece = f.pezzi[x][y].getIcon();
        	xPiece = x;
    		yPiece = y;
    		int east=x+1;
    		int west=x-1;
    		int north=y-1;
    		int south=y+1;
        	while(north>=0 && east<=7 && f.pezzi[east][north].getIcon() == null) {
        		f.pezzi[east][north].setIcon(f.pallino);
        		f.pezzi[east][north].setVisible(true);
        		north--;
        		east++;
        	}
        	if(north>=0 && east<=7 && (f.pezzi[east][north].getIcon() == f.alfiereNero || f.pezzi[east][north].getIcon() == f.pedoneNero || f.pezzi[east][north].getIcon() == f.torreNera || f.pezzi[east][north].getIcon() == f.cavalloNero || f.pezzi[east][north].getIcon() == f.reginaNera || f.pezzi[east][north].getIcon() == f.reNero)) {
        		f.pezzi[east][north].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	east=x+1;
    		west=x-1;
    		north=y-1;
    		south=y+1;
        	while(north>=0 && west>=0 && f.pezzi[west][north].getIcon() == null) {
        		f.pezzi[west][north].setIcon(f.pallino);
        		f.pezzi[west][north].setVisible(true);
        		north--;
        		west--;
        	}
        	if(north>=0 && west>=0 && (f.pezzi[west][north].getIcon() == f.alfiereNero || f.pezzi[west][north].getIcon() == f.pedoneNero || f.pezzi[west][north].getIcon() == f.torreNera || f.pezzi[west][north].getIcon() == f.cavalloNero || f.pezzi[west][north].getIcon() == f.reginaNera || f.pezzi[west][north].getIcon() == f.reNero)) {
        		f.pezzi[west][north].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	
        	east=x+1;
    		west=x-1;
    		north=y-1;
    		south=y+1;
        	while(south<=7 && east<=7 && f.pezzi[east][south].getIcon() == null) {
        		f.pezzi[east][south].setIcon(f.pallino);
        		f.pezzi[east][south].setVisible(true);
        		south++;
        		east++;
        	}
        	if(south<=7 && east<=7 && (f.pezzi[east][south].getIcon() == f.alfiereNero || f.pezzi[east][south].getIcon() == f.pedoneNero || f.pezzi[east][south].getIcon() == f.torreNera || f.pezzi[east][south].getIcon() == f.cavalloNero || f.pezzi[east][south].getIcon() == f.reginaNera || f.pezzi[east][south].getIcon() == f.reNero)) {
        		f.pezzi[east][south].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	east=x+1;
    		west=x-1;
    		north=y-1;
    		south=y+1;
        	while(south<=7 && west>=0 && f.pezzi[west][south].getIcon() == null) {
        		f.pezzi[west][south].setIcon(f.pallino);
        		f.pezzi[west][south].setVisible(true);
        		south++;
        		west--;
        	}
        	if(south<=7 && west>=0 && (f.pezzi[west][south].getIcon() == f.alfiereNero || f.pezzi[west][south].getIcon() == f.pedoneNero || f.pezzi[west][south].getIcon() == f.torreNera || f.pezzi[west][south].getIcon() == f.cavalloNero || f.pezzi[west][south].getIcon() == f.reginaNera || f.pezzi[west][south].getIcon() == f.reNero)) {
        		f.pezzi[west][south].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
    	}
    }
    
    public void checkAlfiereNero() {
    	int[][] pos = posReNero();
    	
    	if(!scaccoBianco(pos[0][0], pos[1][0])) {
    		delete();
        	exIconPiece = f.pezzi[x][y].getIcon();
        	xPiece = x;
    		yPiece = y;
    		int east=x+1;
    		int west=x-1;
    		int north=y-1;
    		int south=y+1;
        	while(north>=0 && east<=7 && f.pezzi[east][north].getIcon() == null) {
        		f.pezzi[east][north].setIcon(f.pallino);
        		f.pezzi[east][north].setVisible(true);
        		north--;
        		east++;
        	}
        	if(north>=0 && east<=7 && (f.pezzi[east][north].getIcon() == f.alfiereBianco || f.pezzi[east][north].getIcon() == f.pedoneBianco || f.pezzi[east][north].getIcon() == f.torreBianca || f.pezzi[east][north].getIcon() == f.cavalloBianco || f.pezzi[east][north].getIcon() == f.reginaBianca || f.pezzi[east][north].getIcon() == f.reBianco)) {
        		f.pezzi[east][north].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	east=x+1;
    		west=x-1;
    		north=y-1;
    		south=y+1;
        	while(north>=0 && west>=0 && f.pezzi[west][north].getIcon() == null) {
        		f.pezzi[west][north].setIcon(f.pallino);
        		f.pezzi[west][north].setVisible(true);
        		north--;
        		west--;
        	}
        	if(north>=0 && west>=0 && (f.pezzi[west][north].getIcon() == f.alfiereBianco || f.pezzi[west][north].getIcon() == f.pedoneBianco || f.pezzi[west][north].getIcon() == f.torreBianca || f.pezzi[west][north].getIcon() == f.cavalloBianco || f.pezzi[west][north].getIcon() == f.reginaBianca || f.pezzi[west][north].getIcon() == f.reBianco)) {
        		f.pezzi[west][north].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	
        	east=x+1;
    		west=x-1;
    		north=y-1;
    		south=y+1;
        	while(south<=7 && east<=7 && f.pezzi[east][south].getIcon() == null) {
        		f.pezzi[east][south].setIcon(f.pallino);
        		f.pezzi[east][south].setVisible(true);
        		south++;
        		east++;
        	}
        	if(south<=7 && east<=7 && (f.pezzi[east][south].getIcon() == f.alfiereBianco || f.pezzi[east][south].getIcon() == f.pedoneBianco || f.pezzi[east][south].getIcon() == f.torreBianca || f.pezzi[east][south].getIcon() == f.cavalloBianco || f.pezzi[east][south].getIcon() == f.reginaBianca || f.pezzi[east][south].getIcon() == f.reBianco)) {
        		f.pezzi[east][south].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	east=x+1;
    		west=x-1;
    		north=y-1;
    		south=y+1;
        	while(south<=7 && west>=0 && f.pezzi[west][south].getIcon() == null) {
        		f.pezzi[west][south].setIcon(f.pallino);
        		f.pezzi[west][south].setVisible(true);
        		south++;
        		west--;
        	}
        	if(south<=7 && west>=0 && (f.pezzi[west][south].getIcon() == f.alfiereBianco || f.pezzi[west][south].getIcon() == f.pedoneBianco || f.pezzi[west][south].getIcon() == f.torreBianca || f.pezzi[west][south].getIcon() == f.cavalloBianco || f.pezzi[west][south].getIcon() == f.reginaBianca || f.pezzi[west][south].getIcon() == f.reBianco)) {
        		f.pezzi[west][south].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
    	}
    }
    
    public void checkReginaBianca() {
    	int[][] pos = posReBianco();
    	
    	if(!scaccoNero(pos[0][0], pos[1][0])) {
    		delete();
        	exIconPiece = f.pezzi[x][y].getIcon();
        	xPiece = x;
    		yPiece = y;
    		int east=x+1;
    		int west=x-1;
    		int north=y-1;
    		int south=y+1;
        	while(north>=0 && east<=7 && f.pezzi[east][north].getIcon() == null) {
        		f.pezzi[east][north].setIcon(f.pallino);
        		f.pezzi[east][north].setVisible(true);
        		north--;
        		east++;
        	}
        	if(north>=0 && east<=7 && (f.pezzi[east][north].getIcon() == f.alfiereNero || f.pezzi[east][north].getIcon() == f.pedoneNero || f.pezzi[east][north].getIcon() == f.torreNera || f.pezzi[east][north].getIcon() == f.cavalloNero || f.pezzi[east][north].getIcon() == f.reginaNera || f.pezzi[east][north].getIcon() == f.reNero)) {
        		f.pezzi[east][north].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	east=x+1;
    		west=x-1;
    		north=y-1;
    		south=y+1;
        	while(north>=0 && west>=0 && f.pezzi[west][north].getIcon() == null) {
        		f.pezzi[west][north].setIcon(f.pallino);
        		f.pezzi[west][north].setVisible(true);
        		north--;
        		west--;
        	}
        	if(north>=0 && west>=0 && (f.pezzi[west][north].getIcon() == f.alfiereNero || f.pezzi[west][north].getIcon() == f.pedoneNero || f.pezzi[west][north].getIcon() == f.torreNera || f.pezzi[west][north].getIcon() == f.cavalloNero || f.pezzi[west][north].getIcon() == f.reginaNera || f.pezzi[west][north].getIcon() == f.reNero)) {
        		f.pezzi[west][north].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	
        	east=x+1;
    		west=x-1;
    		north=y-1;
    		south=y+1;
        	while(south<=7 && east<=7 && f.pezzi[east][south].getIcon() == null) {
        		f.pezzi[east][south].setIcon(f.pallino);
        		f.pezzi[east][south].setVisible(true);
        		south++;
        		east++;
        	}
        	if(south<=7 && east<=7 && (f.pezzi[east][south].getIcon() == f.alfiereNero || f.pezzi[east][south].getIcon() == f.pedoneNero || f.pezzi[east][south].getIcon() == f.torreNera || f.pezzi[east][south].getIcon() == f.cavalloNero || f.pezzi[east][south].getIcon() == f.reginaNera || f.pezzi[east][south].getIcon() == f.reNero)) {
        		f.pezzi[east][south].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	east=x+1;
    		west=x-1;
    		north=y-1;
    		south=y+1;
        	while(south<=7 && west>=0 && f.pezzi[west][south].getIcon() == null) {
        		f.pezzi[west][south].setIcon(f.pallino);
        		f.pezzi[west][south].setVisible(true);
        		south++;
        		west--;
        	}
        	if(south<=7 && west>=0 && (f.pezzi[west][south].getIcon() == f.alfiereNero || f.pezzi[west][south].getIcon() == f.pedoneNero || f.pezzi[west][south].getIcon() == f.torreNera || f.pezzi[west][south].getIcon() == f.cavalloNero || f.pezzi[west][south].getIcon() == f.reginaNera || f.pezzi[west][south].getIcon() == f.reNero)) {
        		f.pezzi[west][south].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	east=x+1;
    		west=x-1;
    		north=y-1;
    		south=y+1;
        	while(north>=0 && f.pezzi[x][north].getIcon() == null) {
        		f.pezzi[x][north].setIcon(f.pallino);
        		f.pezzi[x][north].setVisible(true);
        		north--;
        	}
        	if(north>=0 && (f.pezzi[x][north].getIcon() == f.alfiereNero || f.pezzi[x][north].getIcon() == f.pedoneNero || f.pezzi[x][north].getIcon() == f.torreNera || f.pezzi[x][north].getIcon() == f.cavalloNero || f.pezzi[x][north].getIcon() == f.reginaNera || f.pezzi[x][north].getIcon() == f.reNero)) {
        		f.pezzi[x][north].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	
        	while(south<=7 && f.pezzi[x][south].getIcon() == null) {
        		f.pezzi[x][south].setIcon(f.pallino);
        		f.pezzi[x][south].setVisible(true);
        		south++;
        	}
        	if(south<=7 && (f.pezzi[x][south].getIcon() == f.alfiereNero || f.pezzi[x][south].getIcon() == f.pedoneNero || f.pezzi[x][south].getIcon() == f.torreNera || f.pezzi[x][south].getIcon() == f.cavalloNero || f.pezzi[x][south].getIcon() == f.reginaNera || f.pezzi[x][south].getIcon() == f.reNero)) {
        		f.pezzi[x][south].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	
        	while(east<=7 && f.pezzi[east][y].getIcon() == null) {
        		f.pezzi[east][y].setIcon(f.pallino);
        		f.pezzi[east][y].setVisible(true);
        		east++;
        	}
        	if(east<=7 && (f.pezzi[east][y].getIcon() == f.alfiereNero || f.pezzi[east][y].getIcon() == f.pedoneNero || f.pezzi[east][y].getIcon() == f.torreNera || f.pezzi[east][y].getIcon() == f.cavalloNero || f.pezzi[east][y].getIcon() == f.reginaNera || f.pezzi[east][y].getIcon() == f.reNero)) {
        		f.pezzi[east][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	
        	while(west>=0 && f.pezzi[west][y].getIcon() == null) {
        		f.pezzi[west][y].setIcon(f.pallino);
        		f.pezzi[west][y].setVisible(true);
        		west--;
        	}
        	if(west>=0 && (f.pezzi[west][y].getIcon() == f.alfiereNero || f.pezzi[west][y].getIcon() == f.pedoneNero || f.pezzi[west][y].getIcon() == f.torreNera || f.pezzi[west][y].getIcon() == f.cavalloNero || f.pezzi[west][y].getIcon() == f.reginaNera || f.pezzi[west][y].getIcon() == f.reNero)) {
        		f.pezzi[west][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
    	}
    }
    
    public void checkReginaNera() {
    	int[][] pos = posReNero();
    	
    	if(!scaccoBianco(pos[0][0], pos[1][0])) {
    		delete();
        	exIconPiece = f.pezzi[x][y].getIcon();
        	xPiece = x;
    		yPiece = y;
    		int east=x+1;
    		int west=x-1;
    		int north=y-1;
    		int south=y+1;
        	while(north>=0 && east<=7 && f.pezzi[east][north].getIcon() == null) {
        		f.pezzi[east][north].setIcon(f.pallino);
        		f.pezzi[east][north].setVisible(true);
        		north--;
        		east++;
        	}
        	if(north>=0 && east<=7 && (f.pezzi[east][north].getIcon() == f.alfiereBianco || f.pezzi[east][north].getIcon() == f.pedoneBianco || f.pezzi[east][north].getIcon() == f.torreBianca || f.pezzi[east][north].getIcon() == f.cavalloBianco || f.pezzi[east][north].getIcon() == f.reginaBianca || f.pezzi[east][north].getIcon() == f.reBianco)) {
        		f.pezzi[east][north].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	east=x+1;
    		west=x-1;
    		north=y-1;
    		south=y+1;
        	while(north>=0 && west>=0 && f.pezzi[west][north].getIcon() == null) {
        		f.pezzi[west][north].setIcon(f.pallino);
        		f.pezzi[west][north].setVisible(true);
        		north--;
        		west--;
        	}
        	if(north>=0 && west>=0 && (f.pezzi[west][north].getIcon() == f.alfiereBianco || f.pezzi[west][north].getIcon() == f.pedoneBianco || f.pezzi[west][north].getIcon() == f.torreBianca || f.pezzi[west][north].getIcon() == f.cavalloBianco || f.pezzi[west][north].getIcon() == f.reginaBianca || f.pezzi[west][north].getIcon() == f.reBianco)) {
        		f.pezzi[west][north].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	
        	east=x+1;
    		west=x-1;
    		north=y-1;
    		south=y+1;
        	while(south<=7 && east<=7 && f.pezzi[east][south].getIcon() == null) {
        		f.pezzi[east][south].setIcon(f.pallino);
        		f.pezzi[east][south].setVisible(true);
        		south++;
        		east++;
        	}
        	if(south<=7 && east<=7 && (f.pezzi[east][south].getIcon() == f.alfiereBianco || f.pezzi[east][south].getIcon() == f.pedoneBianco || f.pezzi[east][south].getIcon() == f.torreBianca || f.pezzi[east][south].getIcon() == f.cavalloBianco || f.pezzi[east][south].getIcon() == f.reginaBianca || f.pezzi[east][south].getIcon() == f.reBianco)) {
        		f.pezzi[east][south].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	east=x+1;
    		west=x-1;
    		north=y-1;
    		south=y+1;
        	while(south<=7 && west>=0 && f.pezzi[west][south].getIcon() == null) {
        		f.pezzi[west][south].setIcon(f.pallino);
        		f.pezzi[west][south].setVisible(true);
        		south++;
        		west--;
        	}
        	if(south<=7 && west>=0 && (f.pezzi[west][south].getIcon() == f.alfiereBianco || f.pezzi[west][south].getIcon() == f.pedoneBianco || f.pezzi[west][south].getIcon() == f.torreBianca || f.pezzi[west][south].getIcon() == f.cavalloBianco || f.pezzi[west][south].getIcon() == f.reginaBianca || f.pezzi[west][south].getIcon() == f.reBianco)) {
        		f.pezzi[west][south].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
        	east=x+1;
    		west=x-1;
    		north=y-1;
    		south=y+1;
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
        		west--;
        	}
        	if(west>=0 && (f.pezzi[west][y].getIcon() == f.alfiereBianco || f.pezzi[west][y].getIcon() == f.pedoneBianco || f.pezzi[west][y].getIcon() == f.torreBianca || f.pezzi[west][y].getIcon() == f.cavalloBianco || f.pezzi[west][y].getIcon() == f.reginaBianca || f.pezzi[west][y].getIcon() == f.reBianco)) {
        		f.pezzi[west][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
        	}
    	}
    }
    
    public void checkCavalloBianco() {
    	int[][] pos = posReBianco();
    	
    	if(!scaccoNero(pos[0][0], pos[1][0])) {
    		delete();
        	exIconPiece = f.pezzi[x][y].getIcon();
        	xPiece = x;
    		yPiece = y;
    		int leftBig=x-2;
    		int leftSmall=x-1;
    		int rightBig=x+2;
    		int rightSmall=x+1;
    		
    		int upBig=y-2;
    		int upSmall=y-1;
    		int downBig=y+2;
    		int downSmall=y+1;
    		if(leftBig < f.n && leftBig >=0) {
    			if(upSmall < f.n && upSmall >=0) {
    				if(f.pezzi[leftBig][upSmall].getIcon() == null) {
    					f.pezzi[leftBig][upSmall].setIcon(f.pallino);
    		    		f.pezzi[leftBig][upSmall].setVisible(true);
    				}
    				else if(f.pezzi[leftBig][upSmall].getIcon() == f.alfiereNero || f.pezzi[leftBig][upSmall].getIcon() == f.pedoneNero || f.pezzi[leftBig][upSmall].getIcon() == f.torreNera || f.pezzi[leftBig][upSmall].getIcon() == f.cavalloNero || f.pezzi[leftBig][upSmall].getIcon() == f.reginaNera || f.pezzi[leftBig][upSmall].getIcon() == f.reNero) {
    					f.pezzi[leftBig][upSmall].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    			if(downSmall < f.n && downSmall >=0) {
    				if(f.pezzi[leftBig][downSmall].getIcon() == null) {
    					f.pezzi[leftBig][downSmall].setIcon(f.pallino);
    		    		f.pezzi[leftBig][downSmall].setVisible(true);
    				}
    				else if(f.pezzi[leftBig][downSmall].getIcon() == f.alfiereNero || f.pezzi[leftBig][downSmall].getIcon() == f.pedoneNero || f.pezzi[leftBig][downSmall].getIcon() == f.torreNera || f.pezzi[leftBig][downSmall].getIcon() == f.cavalloNero || f.pezzi[leftBig][downSmall].getIcon() == f.reginaNera || f.pezzi[leftBig][downSmall].getIcon() == f.reNero) {
    					f.pezzi[leftBig][downSmall].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    		}
    		if(rightBig < f.n && rightBig >=0) {
    			if(upSmall < f.n && upSmall >=0) {
    				if(f.pezzi[rightBig][upSmall].getIcon() == null) {
    					f.pezzi[rightBig][upSmall].setIcon(f.pallino);
    		    		f.pezzi[rightBig][upSmall].setVisible(true);
    				}
    				else if(f.pezzi[rightBig][upSmall].getIcon() == f.alfiereNero || f.pezzi[rightBig][upSmall].getIcon() == f.pedoneNero || f.pezzi[rightBig][upSmall].getIcon() == f.torreNera || f.pezzi[rightBig][upSmall].getIcon() == f.cavalloNero || f.pezzi[rightBig][upSmall].getIcon() == f.reginaNera || f.pezzi[rightBig][upSmall].getIcon() == f.reNero) {
    					f.pezzi[rightBig][upSmall].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    			if(downSmall < f.n && downSmall >=0) {
    				if(f.pezzi[rightBig][downSmall].getIcon() == null) {
    					f.pezzi[rightBig][downSmall].setIcon(f.pallino);
    		    		f.pezzi[rightBig][downSmall].setVisible(true);
    				}
    				else if(f.pezzi[rightBig][downSmall].getIcon() == f.alfiereNero || f.pezzi[rightBig][downSmall].getIcon() == f.pedoneNero || f.pezzi[rightBig][downSmall].getIcon() == f.torreNera || f.pezzi[rightBig][downSmall].getIcon() == f.cavalloNero || f.pezzi[rightBig][downSmall].getIcon() == f.reginaNera || f.pezzi[rightBig][downSmall].getIcon() == f.reNero) {
    					f.pezzi[rightBig][downSmall].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    		}
    		if(upBig < f.n && upBig >=0) {
    			if(rightSmall < f.n && rightSmall >=0) {
    				if(f.pezzi[rightSmall][upBig].getIcon() == null) {
    					f.pezzi[rightSmall][upBig].setIcon(f.pallino);
    		    		f.pezzi[rightSmall][upBig].setVisible(true);
    				}
    				else if(f.pezzi[rightSmall][upBig].getIcon() == f.alfiereNero || f.pezzi[rightSmall][upBig].getIcon() == f.pedoneNero || f.pezzi[rightSmall][upBig].getIcon() == f.torreNera || f.pezzi[rightSmall][upBig].getIcon() == f.cavalloNero || f.pezzi[rightSmall][upBig].getIcon() == f.reginaNera || f.pezzi[rightSmall][upBig].getIcon() == f.reNero) {
    					f.pezzi[rightSmall][upBig].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    			if(leftSmall < f.n && leftSmall >=0) {
    				if(f.pezzi[leftSmall][upBig].getIcon() == null) {
    					f.pezzi[leftSmall][upBig].setIcon(f.pallino);
    		    		f.pezzi[leftSmall][upBig].setVisible(true);
    				}
    				else if(f.pezzi[leftSmall][upBig].getIcon() == f.alfiereNero || f.pezzi[leftSmall][upBig].getIcon() == f.pedoneNero || f.pezzi[leftSmall][upBig].getIcon() == f.torreNera || f.pezzi[leftSmall][upBig].getIcon() == f.cavalloNero || f.pezzi[leftSmall][upBig].getIcon() == f.reginaNera || f.pezzi[leftSmall][upBig].getIcon() == f.reNero) {
    					f.pezzi[leftSmall][upBig].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    		}
    		if(downBig < f.n && downBig >=0) {
    			if(rightSmall < f.n && rightSmall >=0) {
    				if(f.pezzi[rightSmall][downBig].getIcon() == null) {
    					f.pezzi[rightSmall][downBig].setIcon(f.pallino);
    		    		f.pezzi[rightSmall][downBig].setVisible(true);
    				}
    				else if(f.pezzi[rightSmall][downBig].getIcon() == f.alfiereNero || f.pezzi[rightSmall][downBig].getIcon() == f.pedoneNero || f.pezzi[rightSmall][downBig].getIcon() == f.torreNera || f.pezzi[rightSmall][downBig].getIcon() == f.cavalloNero || f.pezzi[rightSmall][downBig].getIcon() == f.reginaNera || f.pezzi[rightSmall][downBig].getIcon() == f.reNero) {
    					f.pezzi[rightSmall][downBig].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    			if(leftSmall < f.n && leftSmall >=0) {
    				if(f.pezzi[leftSmall][downBig].getIcon() == null) {
    					f.pezzi[leftSmall][downBig].setIcon(f.pallino);
    		    		f.pezzi[leftSmall][downBig].setVisible(true);
    				}
    				else if(f.pezzi[leftSmall][downBig].getIcon() == f.alfiereNero || f.pezzi[leftSmall][downBig].getIcon() == f.pedoneNero || f.pezzi[leftSmall][downBig].getIcon() == f.torreNera || f.pezzi[leftSmall][downBig].getIcon() == f.cavalloNero || f.pezzi[leftSmall][downBig].getIcon() == f.reginaNera || f.pezzi[leftSmall][downBig].getIcon() == f.reNero) {
    					f.pezzi[leftSmall][downBig].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    		}
    	}
    }
    
    public void checkCavalloNero() {
    	int[][] pos = posReNero();
    	
    	if(!scaccoBianco(pos[0][0], pos[1][0])) {
    		delete();
        	exIconPiece = f.pezzi[x][y].getIcon();
        	xPiece = x;
    		yPiece = y;
    		int leftBig=x-2;
    		int leftSmall=x-1;
    		int rightBig=x+2;
    		int rightSmall=x+1;
    		
    		int upBig=y-2;
    		int upSmall=y-1;
    		int downBig=y+2;
    		int downSmall=y+1;
    		if(leftBig < f.n && leftBig >=0) {
    			if(upSmall < f.n && upSmall >=0) {
    				if(f.pezzi[leftBig][upSmall].getIcon() == null) {
    					f.pezzi[leftBig][upSmall].setIcon(f.pallino);
    		    		f.pezzi[leftBig][upSmall].setVisible(true);
    				}
    				else if(f.pezzi[leftBig][upSmall].getIcon() == f.alfiereBianco || f.pezzi[leftBig][upSmall].getIcon() == f.pedoneBianco || f.pezzi[leftBig][upSmall].getIcon() == f.torreBianca || f.pezzi[leftBig][upSmall].getIcon() == f.cavalloBianco || f.pezzi[leftBig][upSmall].getIcon() == f.reginaBianca || f.pezzi[leftBig][upSmall].getIcon() == f.reBianco) {
    					f.pezzi[leftBig][upSmall].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    			if(downSmall < f.n && downSmall >=0) {
    				if(f.pezzi[leftBig][downSmall].getIcon() == null) {
    					f.pezzi[leftBig][downSmall].setIcon(f.pallino);
    		    		f.pezzi[leftBig][downSmall].setVisible(true);
    				}
    				else if(f.pezzi[leftBig][downSmall].getIcon() == f.alfiereBianco || f.pezzi[leftBig][downSmall].getIcon() == f.pedoneBianco || f.pezzi[leftBig][downSmall].getIcon() == f.torreBianca || f.pezzi[leftBig][downSmall].getIcon() == f.cavalloBianco || f.pezzi[leftBig][downSmall].getIcon() == f.reginaBianca || f.pezzi[leftBig][downSmall].getIcon() == f.reBianco) {
    					f.pezzi[leftBig][downSmall].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    		}
    		if(rightBig < f.n && rightBig >=0) {
    			if(upSmall < f.n && upSmall >=0) {
    				if(f.pezzi[rightBig][upSmall].getIcon() == null) {
    					f.pezzi[rightBig][upSmall].setIcon(f.pallino);
    		    		f.pezzi[rightBig][upSmall].setVisible(true);
    				}
    				else if(f.pezzi[rightBig][upSmall].getIcon() == f.alfiereBianco || f.pezzi[rightBig][upSmall].getIcon() == f.pedoneBianco || f.pezzi[rightBig][upSmall].getIcon() == f.torreBianca || f.pezzi[rightBig][upSmall].getIcon() == f.cavalloBianco || f.pezzi[rightBig][upSmall].getIcon() == f.reginaBianca || f.pezzi[rightBig][upSmall].getIcon() == f.reBianco) {
    					f.pezzi[rightBig][upSmall].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    			if(downSmall < f.n && downSmall >=0) {
    				if(f.pezzi[rightBig][downSmall].getIcon() == null) {
    					f.pezzi[rightBig][downSmall].setIcon(f.pallino);
    		    		f.pezzi[rightBig][downSmall].setVisible(true);
    				}
    				else if(f.pezzi[rightBig][downSmall].getIcon() == f.alfiereBianco || f.pezzi[rightBig][downSmall].getIcon() == f.pedoneBianco || f.pezzi[rightBig][downSmall].getIcon() == f.torreBianca || f.pezzi[rightBig][downSmall].getIcon() == f.cavalloBianco || f.pezzi[rightBig][downSmall].getIcon() == f.reginaBianca || f.pezzi[rightBig][downSmall].getIcon() == f.reBianco) {
    					f.pezzi[rightBig][downSmall].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    		}
    		if(upBig < f.n && upBig >=0) {
    			if(rightSmall < f.n && rightSmall >=0) {
    				if(f.pezzi[rightSmall][upBig].getIcon() == null) {
    					f.pezzi[rightSmall][upBig].setIcon(f.pallino);
    		    		f.pezzi[rightSmall][upBig].setVisible(true);
    				}
    				else if(f.pezzi[rightSmall][upBig].getIcon() == f.alfiereBianco || f.pezzi[rightSmall][upBig].getIcon() == f.pedoneBianco || f.pezzi[rightSmall][upBig].getIcon() == f.torreBianca || f.pezzi[rightSmall][upBig].getIcon() == f.cavalloBianco || f.pezzi[rightSmall][upBig].getIcon() == f.reginaBianca || f.pezzi[rightSmall][upBig].getIcon() == f.reBianco) {
    					f.pezzi[rightSmall][upBig].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    			if(leftSmall < f.n && leftSmall >=0) {
    				if(f.pezzi[leftSmall][upBig].getIcon() == null) {
    					f.pezzi[leftSmall][upBig].setIcon(f.pallino);
    		    		f.pezzi[leftSmall][upBig].setVisible(true);
    				}
    				else if(f.pezzi[leftSmall][upBig].getIcon() == f.alfiereBianco || f.pezzi[leftSmall][upBig].getIcon() == f.pedoneBianco || f.pezzi[leftSmall][upBig].getIcon() == f.torreBianca || f.pezzi[leftSmall][upBig].getIcon() == f.cavalloBianco || f.pezzi[leftSmall][upBig].getIcon() == f.reginaBianca || f.pezzi[leftSmall][upBig].getIcon() == f.reBianco) {
    					f.pezzi[leftSmall][upBig].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    		}
    		if(downBig < f.n && downBig >=0) {
    			if(rightSmall < f.n && rightSmall >=0) {
    				if(f.pezzi[rightSmall][downBig].getIcon() == null) {
    					f.pezzi[rightSmall][downBig].setIcon(f.pallino);
    		    		f.pezzi[rightSmall][downBig].setVisible(true);
    				}
    				else if(f.pezzi[rightSmall][downBig].getIcon() == f.alfiereBianco || f.pezzi[rightSmall][downBig].getIcon() == f.pedoneBianco || f.pezzi[rightSmall][downBig].getIcon() == f.torreBianca || f.pezzi[rightSmall][downBig].getIcon() == f.cavalloBianco || f.pezzi[rightSmall][downBig].getIcon() == f.reginaBianca || f.pezzi[rightSmall][downBig].getIcon() == f.reBianco) {
    					f.pezzi[rightSmall][downBig].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    			if(leftSmall < f.n && leftSmall >=0) {
    				if(f.pezzi[leftSmall][downBig].getIcon() == null) {
    					f.pezzi[leftSmall][downBig].setIcon(f.pallino);
    		    		f.pezzi[leftSmall][downBig].setVisible(true);
    				}
    				else if(f.pezzi[leftSmall][downBig].getIcon() == f.alfiereBianco || f.pezzi[leftSmall][downBig].getIcon() == f.pedoneBianco || f.pezzi[leftSmall][downBig].getIcon() == f.torreBianca || f.pezzi[leftSmall][downBig].getIcon() == f.cavalloBianco || f.pezzi[leftSmall][downBig].getIcon() == f.reginaBianca || f.pezzi[leftSmall][downBig].getIcon() == f.reBianco) {
    					f.pezzi[leftSmall][downBig].setBorder(BorderFactory.createLineBorder(Color.red, 3));
    				}
    			}
    		}
    	}
    }
    
    public void checkReNero() {
    	delete();
    	exIconPiece = f.pezzi[x][y].getIcon();
    	xPiece = x;
		yPiece = y;
		int left=x-1;
		int right=x+1;
		int up=y-1;
		int down=y+1;
		if(!scaccoBianco(x, y)) {
			if(left < f.n && left >=0) {
				if(f.pezzi[left][y].getIcon() == null && !scaccoBianco(left, y)) {
					f.pezzi[left][y].setIcon(f.pallino);
		    		f.pezzi[left][y].setVisible(true);
				}
				else if(f.pezzi[left][y].getIcon() == f.alfiereBianco || f.pezzi[left][y].getIcon() == f.pedoneBianco || f.pezzi[left][y].getIcon() == f.torreBianca || f.pezzi[left][y].getIcon() == f.cavalloBianco || f.pezzi[left][y].getIcon() == f.reginaBianca) {
					f.pezzi[left][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
				}
				if(up < f.n && up >=0 && !scaccoBianco(left, up)) {
					if(f.pezzi[left][up].getIcon() == null) {
						f.pezzi[left][up].setIcon(f.pallino);
			    		f.pezzi[left][up].setVisible(true);
					}
					else if(f.pezzi[left][up].getIcon() == f.alfiereBianco || f.pezzi[left][up].getIcon() == f.pedoneBianco || f.pezzi[left][up].getIcon() == f.torreBianca || f.pezzi[left][up].getIcon() == f.cavalloBianco || f.pezzi[left][up].getIcon() == f.reginaBianca) {
						f.pezzi[left][up].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					}
				}
				if(down < f.n && down >=0 && !scaccoBianco(left, down)) {
					if(f.pezzi[left][down].getIcon() == null) {
						f.pezzi[left][down].setIcon(f.pallino);
			    		f.pezzi[left][down].setVisible(true);
					}
					else if(f.pezzi[left][down].getIcon() == f.alfiereBianco || f.pezzi[left][down].getIcon() == f.pedoneBianco || f.pezzi[left][down].getIcon() == f.torreBianca || f.pezzi[left][down].getIcon() == f.cavalloBianco || f.pezzi[left][down].getIcon() == f.reginaBianca) {
						f.pezzi[left][down].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					}
				}
			}
			if(right < f.n && right >=0) {
				if(f.pezzi[right][y].getIcon() == null && !scaccoBianco(right, y)) {
					f.pezzi[right][y].setIcon(f.pallino);
		    		f.pezzi[right][y].setVisible(true);
				}
				else if(f.pezzi[right][y].getIcon() == f.alfiereBianco || f.pezzi[right][y].getIcon() == f.pedoneBianco || f.pezzi[right][y].getIcon() == f.torreBianca || f.pezzi[right][y].getIcon() == f.cavalloBianco || f.pezzi[right][y].getIcon() == f.reginaBianca) {
					f.pezzi[right][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
				}
				if(up < f.n && up >=0 && !scaccoBianco(right, up)) {
					if(f.pezzi[right][up].getIcon() == null) {
						f.pezzi[right][up].setIcon(f.pallino);
			    		f.pezzi[right][up].setVisible(true);
					}
					else if(f.pezzi[right][up].getIcon() == f.alfiereBianco || f.pezzi[right][up].getIcon() == f.pedoneBianco || f.pezzi[right][up].getIcon() == f.torreBianca || f.pezzi[right][up].getIcon() == f.cavalloBianco || f.pezzi[right][up].getIcon() == f.reginaBianca) {
						f.pezzi[right][up].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					}
				}
				if(down < f.n && down >=0 && !scaccoBianco(right, down)) {
					if(f.pezzi[right][down].getIcon() == null) {
						f.pezzi[right][down].setIcon(f.pallino);
			    		f.pezzi[right][down].setVisible(true);
					}
					else if(f.pezzi[right][down].getIcon() == f.alfiereBianco || f.pezzi[right][down].getIcon() == f.pedoneBianco || f.pezzi[right][down].getIcon() == f.torreBianca || f.pezzi[right][down].getIcon() == f.cavalloBianco || f.pezzi[right][down].getIcon() == f.reginaBianca) {
						f.pezzi[right][down].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					}
				}
			}
			if(down < f.n && down >=0 && !scaccoBianco(x, down)) {
				if(f.pezzi[x][down].getIcon() == null) {
					f.pezzi[x][down].setIcon(f.pallino);
		    		f.pezzi[x][down].setVisible(true);
				}
				else if(f.pezzi[x][down].getIcon() == f.alfiereBianco || f.pezzi[x][down].getIcon() == f.pedoneBianco || f.pezzi[x][down].getIcon() == f.torreBianca || f.pezzi[x][down].getIcon() == f.cavalloBianco || f.pezzi[x][down].getIcon() == f.reginaBianca) {
					f.pezzi[x][down].setBorder(BorderFactory.createLineBorder(Color.red, 3));
				}
			}
			if(up < f.n && up >=0 && !scaccoBianco(x, up)) {
				if(f.pezzi[x][up].getIcon() == null) {
					f.pezzi[x][up].setIcon(f.pallino);
		    		f.pezzi[x][up].setVisible(true);
				}
				else if(f.pezzi[x][up].getIcon() == f.alfiereBianco || f.pezzi[x][up].getIcon() == f.pedoneBianco || f.pezzi[x][up].getIcon() == f.torreBianca || f.pezzi[x][up].getIcon() == f.cavalloBianco || f.pezzi[x][up].getIcon() == f.reginaBianca) {
					f.pezzi[x][up].setBorder(BorderFactory.createLineBorder(Color.red, 3));
				}
			}
		}
		else {
			int c=0;
			if(left < f.n && left >=0) {
				if(f.pezzi[left][y].getIcon() == null && !scaccoBianco(left, y)) {
					f.pezzi[left][y].setIcon(f.pallino);
		    		f.pezzi[left][y].setVisible(true);
		    		c++;
				}
				else if(f.pezzi[left][y].getIcon() == f.alfiereBianco || f.pezzi[left][y].getIcon() == f.pedoneBianco || f.pezzi[left][y].getIcon() == f.torreBianca || f.pezzi[left][y].getIcon() == f.cavalloBianco || f.pezzi[left][y].getIcon() == f.reginaBianca) {
					f.pezzi[left][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					c++;
				}
				if(up < f.n && up >=0 && !scaccoBianco(left, up)) {
					if(f.pezzi[left][up].getIcon() == null) {
						f.pezzi[left][up].setIcon(f.pallino);
			    		f.pezzi[left][up].setVisible(true);
			    		c++;
					}
					else if(f.pezzi[left][up].getIcon() == f.alfiereBianco || f.pezzi[left][up].getIcon() == f.pedoneBianco || f.pezzi[left][up].getIcon() == f.torreBianca || f.pezzi[left][up].getIcon() == f.cavalloBianco || f.pezzi[left][up].getIcon() == f.reginaBianca) {
						f.pezzi[left][up].setBorder(BorderFactory.createLineBorder(Color.red, 3));
						c++;
					}
				}
				if(down < f.n && down >=0 && !scaccoBianco(left, down)) {
					if(f.pezzi[left][down].getIcon() == null) {
						f.pezzi[left][down].setIcon(f.pallino);
			    		f.pezzi[left][down].setVisible(true);
			    		c++;
					}
					else if(f.pezzi[left][down].getIcon() == f.alfiereBianco || f.pezzi[left][down].getIcon() == f.pedoneBianco || f.pezzi[left][down].getIcon() == f.torreBianca || f.pezzi[left][down].getIcon() == f.cavalloBianco || f.pezzi[left][down].getIcon() == f.reginaBianca) {
						f.pezzi[left][down].setBorder(BorderFactory.createLineBorder(Color.red, 3));
						c++;
					}
				}
			}
			if(right < f.n && right >=0) {
				if(f.pezzi[right][y].getIcon() == null && !scaccoBianco(right, y)) {
					f.pezzi[right][y].setIcon(f.pallino);
		    		f.pezzi[right][y].setVisible(true);
		    		c++;
				}
				else if(f.pezzi[right][y].getIcon() == f.alfiereBianco || f.pezzi[right][y].getIcon() == f.pedoneBianco || f.pezzi[right][y].getIcon() == f.torreBianca || f.pezzi[right][y].getIcon() == f.cavalloBianco || f.pezzi[right][y].getIcon() == f.reginaBianca) {
					f.pezzi[right][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					c++;
				}
				if(up < f.n && up >=0 && !scaccoBianco(right, up)) {
					if(f.pezzi[right][up].getIcon() == null) {
						f.pezzi[right][up].setIcon(f.pallino);
			    		f.pezzi[right][up].setVisible(true);
			    		c++;
					}
					else if(f.pezzi[right][up].getIcon() == f.alfiereBianco || f.pezzi[right][up].getIcon() == f.pedoneBianco || f.pezzi[right][up].getIcon() == f.torreBianca || f.pezzi[right][up].getIcon() == f.cavalloBianco || f.pezzi[right][up].getIcon() == f.reginaBianca) {
						f.pezzi[right][up].setBorder(BorderFactory.createLineBorder(Color.red, 3));
						c++;
					}
				}
				if(down < f.n && down >=0 && !scaccoBianco(right, down)) {
					if(f.pezzi[right][down].getIcon() == null) {
						f.pezzi[right][down].setIcon(f.pallino);
			    		f.pezzi[right][down].setVisible(true);
			    		c++;
					}
					else if(f.pezzi[right][down].getIcon() == f.alfiereBianco || f.pezzi[right][down].getIcon() == f.pedoneBianco || f.pezzi[right][down].getIcon() == f.torreBianca || f.pezzi[right][down].getIcon() == f.cavalloBianco || f.pezzi[right][down].getIcon() == f.reginaBianca) {
						f.pezzi[right][down].setBorder(BorderFactory.createLineBorder(Color.red, 3));
						c++;
					}
				}
			}
			if(down < f.n && down >=0 && !scaccoBianco(x, down)) {
				if(f.pezzi[x][down].getIcon() == null) {
					f.pezzi[x][down].setIcon(f.pallino);
		    		f.pezzi[x][down].setVisible(true);
		    		c++;
				}
				else if(f.pezzi[x][down].getIcon() == f.alfiereBianco || f.pezzi[x][down].getIcon() == f.pedoneBianco || f.pezzi[x][down].getIcon() == f.torreBianca || f.pezzi[x][down].getIcon() == f.cavalloBianco || f.pezzi[x][down].getIcon() == f.reginaBianca) {
					f.pezzi[x][down].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					c++;
				}
			}
			if(up < f.n && up >=0 && !scaccoBianco(x, up)) {
				if(f.pezzi[x][up].getIcon() == null) {
					f.pezzi[x][up].setIcon(f.pallino);
		    		f.pezzi[x][up].setVisible(true);
		    		c++;
				}
				else if(f.pezzi[x][up].getIcon() == f.alfiereBianco || f.pezzi[x][up].getIcon() == f.pedoneBianco || f.pezzi[x][up].getIcon() == f.torreBianca || f.pezzi[x][up].getIcon() == f.cavalloBianco || f.pezzi[x][up].getIcon() == f.reginaBianca) {
					f.pezzi[x][up].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					c++;
				}
			}
			
			if(c == 0) {
				//scacco matto
			}
		}
    }
    
    public void checkReBianco() {
    	delete();
    	exIconPiece = f.pezzi[x][y].getIcon();
    	xPiece = x;
		yPiece = y;
		int left=x-1;
		int right=x+1;
		int up=y-1;
		int down=y+1;
		if(!scaccoNero(x, y)) {
			if(left < f.n && left >=0) {
				if(f.pezzi[left][y].getIcon() == null && !scaccoNero(left, y)) {
					f.pezzi[left][y].setIcon(f.pallino);
		    		f.pezzi[left][y].setVisible(true);
				}
				else if(f.pezzi[left][y].getIcon() == f.alfiereNero || f.pezzi[left][y].getIcon() == f.pedoneNero || f.pezzi[left][y].getIcon() == f.torreNera || f.pezzi[left][y].getIcon() == f.cavalloNero || f.pezzi[left][y].getIcon() == f.reginaNera) {
					f.pezzi[left][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
				}
				if(up < f.n && up >=0 && !scaccoNero(left, up)) {
					if(f.pezzi[left][up].getIcon() == null) {
						f.pezzi[left][up].setIcon(f.pallino);
			    		f.pezzi[left][up].setVisible(true);
					}
					else if(f.pezzi[left][up].getIcon() == f.alfiereNero || f.pezzi[left][up].getIcon() == f.pedoneNero || f.pezzi[left][up].getIcon() == f.torreNera || f.pezzi[left][up].getIcon() == f.cavalloNero || f.pezzi[left][up].getIcon() == f.reginaNera) {
						f.pezzi[left][up].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					}
				}
				if(down < f.n && down >=0 && !scaccoNero(left, down)) {
					if(f.pezzi[left][down].getIcon() == null) {
						f.pezzi[left][down].setIcon(f.pallino);
			    		f.pezzi[left][down].setVisible(true);
					}
					else if(f.pezzi[left][down].getIcon() == f.alfiereNero || f.pezzi[left][down].getIcon() == f.pedoneNero || f.pezzi[left][down].getIcon() == f.torreNera || f.pezzi[left][down].getIcon() == f.cavalloNero || f.pezzi[left][down].getIcon() == f.reginaNera) {
						f.pezzi[left][down].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					}
				}
			}
			if(right < f.n && right >=0) {
				if(f.pezzi[right][y].getIcon() == null && !scaccoNero(right, y)) {
					f.pezzi[right][y].setIcon(f.pallino);
		    		f.pezzi[right][y].setVisible(true);
				}
				else if(f.pezzi[right][y].getIcon() == f.alfiereNero || f.pezzi[right][y].getIcon() == f.pedoneNero || f.pezzi[right][y].getIcon() == f.torreNera || f.pezzi[right][y].getIcon() == f.cavalloNero || f.pezzi[right][y].getIcon() == f.reginaNera) {
					f.pezzi[right][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
				}
				if(up < f.n && up >=0 && !scaccoNero(right, up)) {
					if(f.pezzi[right][up].getIcon() == null) {
						f.pezzi[right][up].setIcon(f.pallino);
			    		f.pezzi[right][up].setVisible(true);
					}
					else if(f.pezzi[right][up].getIcon() == f.alfiereNero || f.pezzi[right][up].getIcon() == f.pedoneNero || f.pezzi[right][up].getIcon() == f.torreNera || f.pezzi[right][up].getIcon() == f.cavalloNero || f.pezzi[right][up].getIcon() == f.reginaNera) {
						f.pezzi[right][up].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					}
				}
				if(down < f.n && down >=0 && !scaccoNero(right, down)) {
					if(f.pezzi[right][down].getIcon() == null) {
						f.pezzi[right][down].setIcon(f.pallino);
			    		f.pezzi[right][down].setVisible(true);
					}
					else if(f.pezzi[right][down].getIcon() == f.alfiereNero || f.pezzi[right][down].getIcon() == f.pedoneNero || f.pezzi[right][down].getIcon() == f.torreNera || f.pezzi[right][down].getIcon() == f.cavalloNero || f.pezzi[right][down].getIcon() == f.reginaNera) {
						f.pezzi[right][down].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					}
				}
			}
			if(down < f.n && down >=0 && !scaccoNero(x, down)) {
				if(f.pezzi[x][down].getIcon() == null) {
					f.pezzi[x][down].setIcon(f.pallino);
		    		f.pezzi[x][down].setVisible(true);
				}
				else if(f.pezzi[x][down].getIcon() == f.alfiereNero || f.pezzi[x][down].getIcon() == f.pedoneNero || f.pezzi[x][down].getIcon() == f.torreNera || f.pezzi[x][down].getIcon() == f.cavalloNero || f.pezzi[x][down].getIcon() == f.reginaNera) {
					f.pezzi[x][down].setBorder(BorderFactory.createLineBorder(Color.red, 3));
				}
			}
			if(up < f.n && up >=0 && !scaccoNero(x, up)) {
				if(f.pezzi[x][up].getIcon() == null) {
					f.pezzi[x][up].setIcon(f.pallino);
		    		f.pezzi[x][up].setVisible(true);
				}
				else if(f.pezzi[x][up].getIcon() == f.alfiereNero || f.pezzi[x][up].getIcon() == f.pedoneNero || f.pezzi[x][up].getIcon() == f.torreNera || f.pezzi[x][up].getIcon() == f.cavalloNero || f.pezzi[x][up].getIcon() == f.reginaNera) {
					f.pezzi[x][up].setBorder(BorderFactory.createLineBorder(Color.red, 3));
				}
			}
		}
		else {
			int c=0;
			if(left < f.n && left >=0) {
				if(f.pezzi[left][y].getIcon() == null && !scaccoNero(left, y)) {
					f.pezzi[left][y].setIcon(f.pallino);
		    		f.pezzi[left][y].setVisible(true);
		    		c++;
				}
				else if(f.pezzi[left][y].getIcon() == f.alfiereNero || f.pezzi[left][y].getIcon() == f.pedoneNero || f.pezzi[left][y].getIcon() == f.torreNera || f.pezzi[left][y].getIcon() == f.cavalloNero || f.pezzi[left][y].getIcon() == f.reginaNera) {
					f.pezzi[left][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					c++;
				}
				if(up < f.n && up >=0 && !scaccoNero(left, up)) {
					if(f.pezzi[left][up].getIcon() == null) {
						f.pezzi[left][up].setIcon(f.pallino);
			    		f.pezzi[left][up].setVisible(true);
			    		c++;
					}
					else if(f.pezzi[left][up].getIcon() == f.alfiereNero || f.pezzi[left][up].getIcon() == f.pedoneNero || f.pezzi[left][up].getIcon() == f.torreNera || f.pezzi[left][up].getIcon() == f.cavalloNero || f.pezzi[left][up].getIcon() == f.reginaNera) {
						f.pezzi[left][up].setBorder(BorderFactory.createLineBorder(Color.red, 3));
						c++;
					}
				}
				if(down < f.n && down >=0 && !scaccoNero(left, down)) {
					if(f.pezzi[left][down].getIcon() == null) {
						f.pezzi[left][down].setIcon(f.pallino);
			    		f.pezzi[left][down].setVisible(true);
			    		c++;
					}
					else if(f.pezzi[left][down].getIcon() == f.alfiereNero || f.pezzi[left][down].getIcon() == f.pedoneNero || f.pezzi[left][down].getIcon() == f.torreNera || f.pezzi[left][down].getIcon() == f.cavalloNero || f.pezzi[left][down].getIcon() == f.reginaNera) {
						f.pezzi[left][down].setBorder(BorderFactory.createLineBorder(Color.red, 3));
						c++;
					}
				}
			}
			if(right < f.n && right >=0) {
				if(f.pezzi[right][y].getIcon() == null && !scaccoNero(right, y)) {
					f.pezzi[right][y].setIcon(f.pallino);
		    		f.pezzi[right][y].setVisible(true);
		    		c++;
				}
				else if(f.pezzi[right][y].getIcon() == f.alfiereNero || f.pezzi[right][y].getIcon() == f.pedoneNero || f.pezzi[right][y].getIcon() == f.torreNera || f.pezzi[right][y].getIcon() == f.cavalloNero || f.pezzi[right][y].getIcon() == f.reginaNera) {
					f.pezzi[right][y].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					c++;
				}
				if(up < f.n && up >=0 && !scaccoNero(right, up)) {
					if(f.pezzi[right][up].getIcon() == null) {
						f.pezzi[right][up].setIcon(f.pallino);
			    		f.pezzi[right][up].setVisible(true);
			    		c++;
					}
					else if(f.pezzi[right][up].getIcon() == f.alfiereNero || f.pezzi[right][up].getIcon() == f.pedoneNero || f.pezzi[right][up].getIcon() == f.torreNera || f.pezzi[right][up].getIcon() == f.cavalloNero || f.pezzi[right][up].getIcon() == f.reginaNera) {
						f.pezzi[right][up].setBorder(BorderFactory.createLineBorder(Color.red, 3));
						c++;
					}
				}
				if(down < f.n && down >=0 && !scaccoNero(right, down)) {
					if(f.pezzi[right][down].getIcon() == null) {
						f.pezzi[right][down].setIcon(f.pallino);
			    		f.pezzi[right][down].setVisible(true);
			    		c++;
					}
					else if(f.pezzi[right][down].getIcon() == f.alfiereNero || f.pezzi[right][down].getIcon() == f.pedoneNero || f.pezzi[right][down].getIcon() == f.torreNera || f.pezzi[right][down].getIcon() == f.cavalloNero || f.pezzi[right][down].getIcon() == f.reginaNera) {
						f.pezzi[right][down].setBorder(BorderFactory.createLineBorder(Color.red, 3));
						c++;
					}
				}
			}
			if(down < f.n && down >=0 && !scaccoNero(x, down)) {
				if(f.pezzi[x][down].getIcon() == null) {
					f.pezzi[x][down].setIcon(f.pallino);
		    		f.pezzi[x][down].setVisible(true);
		    		c++;
				}
				else if(f.pezzi[x][down].getIcon() == f.alfiereNero || f.pezzi[x][down].getIcon() == f.pedoneNero || f.pezzi[x][down].getIcon() == f.torreNera || f.pezzi[x][down].getIcon() == f.cavalloNero || f.pezzi[x][down].getIcon() == f.reginaNera) {
					f.pezzi[x][down].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					c++;
				}
			}
			if(up < f.n && up >=0 && !scaccoNero(x, up)) {
				if(f.pezzi[x][up].getIcon() == null) {
					f.pezzi[x][up].setIcon(f.pallino);
		    		f.pezzi[x][up].setVisible(true);
		    		c++;
				}
				else if(f.pezzi[x][up].getIcon() == f.alfiereNero || f.pezzi[x][up].getIcon() == f.pedoneNero || f.pezzi[x][up].getIcon() == f.torreNera || f.pezzi[x][up].getIcon() == f.cavalloNero || f.pezzi[x][up].getIcon() == f.reginaNera) {
					f.pezzi[x][up].setBorder(BorderFactory.createLineBorder(Color.red, 3));
					c++;
				}
			}
			
			if(c == 0) {
				//scacco matto
			}
		}
    }
    
    public boolean scaccoBianco(int X, int Y) {
    	int[][] caselleAttaccate = new int[126][2]; //126 stima del numero massimo che tutti i pezzi possono attaccare
    	int c=0;
    	for(int y=0; y< f.n; y++) {
    		for(int x=0; x<f.n; x++) {
    			if(f.pezzi[x][y].getIcon() == f.alfiereBianco) {
    				int east=x+1;
    				int west=x-1;
    				int north=y-1;
    				int south=y+1;
    		    	while(north>=0 && east<=7 && f.pezzi[east][north].getIcon() == null) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = north;
    		    		north--;
    		    		east++;
    		    	}
    		    	if(north>=0 && east<=7 && (f.pezzi[east][north].getIcon() == f.alfiereNero || f.pezzi[east][north].getIcon() == f.pedoneNero || f.pezzi[east][north].getIcon() == f.torreNera || f.pezzi[east][north].getIcon() == f.cavalloNero || f.pezzi[east][north].getIcon() == f.reginaNera || f.pezzi[east][north].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    	}
    		    	east=x+1;
    				west=x-1;
    				north=y-1;
    				south=y+1;
    		    	while(north>=0 && west>=0 && f.pezzi[west][north].getIcon() == null) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = north;
    		    		north--;
    		    		west--;
    		    		c++;
    		    	}
    		    	if(north>=0 && west>=0 && (f.pezzi[west][north].getIcon() == f.alfiereNero || f.pezzi[west][north].getIcon() == f.pedoneNero || f.pezzi[west][north].getIcon() == f.torreNera || f.pezzi[west][north].getIcon() == f.cavalloNero || f.pezzi[west][north].getIcon() == f.reginaNera || f.pezzi[west][north].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    	}
    		    	
    		    	east=x+1;
    				west=x-1;
    				north=y-1;
    				south=y+1;
    		    	while(south<=7 && east<=7 && f.pezzi[east][south].getIcon() == null) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    		south++;
    		    		east++;
    		    	}
    		    	if(south<=7 && east<=7 && (f.pezzi[east][south].getIcon() == f.alfiereNero || f.pezzi[east][south].getIcon() == f.pedoneNero || f.pezzi[east][south].getIcon() == f.torreNera || f.pezzi[east][south].getIcon() == f.cavalloNero || f.pezzi[east][south].getIcon() == f.reginaNera || f.pezzi[east][south].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    	}
    		    	east=x+1;
    				west=x-1;
    				north=y-1;
    				south=y+1;
    		    	while(south<=7 && west>=0 && f.pezzi[west][south].getIcon() == null) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    		south++;
    		    		west--;
    		    	}
    		    	if(south<=7 && west>=0 && (f.pezzi[west][south].getIcon() == f.alfiereNero || f.pezzi[west][south].getIcon() == f.pedoneNero || f.pezzi[west][south].getIcon() == f.torreNera || f.pezzi[west][south].getIcon() == f.cavalloNero || f.pezzi[west][south].getIcon() == f.reginaNera || f.pezzi[west][south].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    	}
    			}
    			if(f.pezzi[x][y].getIcon() == f.pedoneBianco) {
    				if(x != 7) {
    					caselleAttaccate[c][0] = x+1;
    		    		caselleAttaccate[c][1] = y-1;
    		    		c++;
    	        	}
    	        	if(x != 0) {
    	        		caselleAttaccate[c][0] = x-1;
    		    		caselleAttaccate[c][1] = y-1;
    		    		c++;
    	        	}
    			}
    			if(f.pezzi[x][y].getIcon() == f.torreBianca) {
    				int east=x+1;
    				int west=x-1;
    				int north=y-1;
    				int south=y+1;
    		    	while(north>=0 && f.pezzi[x][north].getIcon() == null) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    		north--;
    		    	}
    		    	if(north>=0 && (f.pezzi[x][north].getIcon() == f.alfiereNero || f.pezzi[x][north].getIcon() == f.pedoneNero || f.pezzi[x][north].getIcon() == f.torreNera || f.pezzi[x][north].getIcon() == f.cavalloNero || f.pezzi[x][north].getIcon() == f.reginaNera || f.pezzi[x][north].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    	}
    		    	
    		    	while(south<=7 && f.pezzi[x][south].getIcon() == null) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    		south++;
    		    	}
    		    	if(south<=7 && (f.pezzi[x][south].getIcon() == f.alfiereNero || f.pezzi[x][south].getIcon() == f.pedoneNero || f.pezzi[x][south].getIcon() == f.torreNera || f.pezzi[x][south].getIcon() == f.cavalloNero || f.pezzi[x][south].getIcon() == f.reginaNera || f.pezzi[x][south].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    	}
    		    	
    		    	while(east<=7 && f.pezzi[east][y].getIcon() == null) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    		east++;
    		    	}
    		    	if(east<=7 && (f.pezzi[east][y].getIcon() == f.alfiereNero || f.pezzi[east][y].getIcon() == f.pedoneNero || f.pezzi[east][y].getIcon() == f.torreNera || f.pezzi[east][y].getIcon() == f.cavalloNero || f.pezzi[east][y].getIcon() == f.reginaNera || f.pezzi[east][y].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    	}
    		    	
    		    	while(west>=0 && f.pezzi[west][y].getIcon() == null) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    		west--;
    		    	}
    		    	if(west>=0 && (f.pezzi[west][y].getIcon() == f.alfiereNero || f.pezzi[west][y].getIcon() == f.pedoneNero || f.pezzi[west][y].getIcon() == f.torreNera || f.pezzi[west][y].getIcon() == f.cavalloNero || f.pezzi[west][y].getIcon() == f.reginaNera || f.pezzi[west][y].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    	}
    			}
    			if(f.pezzi[x][y].getIcon() == f.cavalloBianco) {
    				int leftBig=x-2;
    				int leftSmall=x-1;
    				int rightBig=x+2;
    				int rightSmall=x+1;
    				
    				int upBig=y-2;
    				int upSmall=y-1;
    				int downBig=y+2;
    				int downSmall=y+1;
    				if(leftBig < f.n && leftBig >=0) {
    					if(upSmall < f.n && upSmall >=0) {
    						if(f.pezzi[leftBig][upSmall].getIcon() == null) {
    							caselleAttaccate[c][0] = leftBig;
    	    		    		caselleAttaccate[c][1] = upSmall;
    	    		    		c++;
    						}
    						else if(f.pezzi[leftBig][upSmall].getIcon() == f.alfiereNero || f.pezzi[leftBig][upSmall].getIcon() == f.pedoneNero || f.pezzi[leftBig][upSmall].getIcon() == f.torreNera || f.pezzi[leftBig][upSmall].getIcon() == f.cavalloNero || f.pezzi[leftBig][upSmall].getIcon() == f.reginaNera || f.pezzi[leftBig][upSmall].getIcon() == f.reNero) {
    							caselleAttaccate[c][0] = leftBig;
    	    		    		caselleAttaccate[c][1] = upSmall;
    	    		    		c++;
    						}
    					}
    					if(downSmall < f.n && downSmall >=0) {
    						if(f.pezzi[leftBig][downSmall].getIcon() == null) {
    							caselleAttaccate[c][0] = leftBig;
    	    		    		caselleAttaccate[c][1] = downSmall;
    	    		    		c++;
    						}
    						else if(f.pezzi[leftBig][downSmall].getIcon() == f.alfiereNero || f.pezzi[leftBig][downSmall].getIcon() == f.pedoneNero || f.pezzi[leftBig][downSmall].getIcon() == f.torreNera || f.pezzi[leftBig][downSmall].getIcon() == f.cavalloNero || f.pezzi[leftBig][downSmall].getIcon() == f.reginaNera || f.pezzi[leftBig][downSmall].getIcon() == f.reNero) {
    							caselleAttaccate[c][0] = leftBig;
    	    		    		caselleAttaccate[c][1] = downSmall;
    	    		    		c++;
    						}
    					}
    				}
    				if(rightBig < f.n && rightBig >=0) {
    					if(upSmall < f.n && upSmall >=0) {
    						if(f.pezzi[rightBig][upSmall].getIcon() == null) {
    							caselleAttaccate[c][0] = rightBig;
    	    		    		caselleAttaccate[c][1] = upSmall;
    	    		    		c++;
    						}
    						else if(f.pezzi[rightBig][upSmall].getIcon() == f.alfiereNero || f.pezzi[rightBig][upSmall].getIcon() == f.pedoneNero || f.pezzi[rightBig][upSmall].getIcon() == f.torreNera || f.pezzi[rightBig][upSmall].getIcon() == f.cavalloNero || f.pezzi[rightBig][upSmall].getIcon() == f.reginaNera || f.pezzi[rightBig][upSmall].getIcon() == f.reNero) {
    							caselleAttaccate[c][0] = rightBig;
    	    		    		caselleAttaccate[c][1] = upSmall;
    	    		    		c++;
    						}
    					}
    					if(downSmall < f.n && downSmall >=0) {
    						if(f.pezzi[rightBig][downSmall].getIcon() == null) {
    							caselleAttaccate[c][0] = rightBig;
    	    		    		caselleAttaccate[c][1] = downSmall;
    	    		    		c++;
    						}
    						else if(f.pezzi[rightBig][downSmall].getIcon() == f.alfiereNero || f.pezzi[rightBig][downSmall].getIcon() == f.pedoneNero || f.pezzi[rightBig][downSmall].getIcon() == f.torreNera || f.pezzi[rightBig][downSmall].getIcon() == f.cavalloNero || f.pezzi[rightBig][downSmall].getIcon() == f.reginaNera || f.pezzi[rightBig][downSmall].getIcon() == f.reNero) {
    							caselleAttaccate[c][0] = rightBig;
    	    		    		caselleAttaccate[c][1] = downSmall;
    	    		    		c++;
    						}
    					}
    				}
    				if(upBig < f.n && upBig >=0) {
    					if(rightSmall < f.n && rightSmall >=0) {
    						if(f.pezzi[rightSmall][upBig].getIcon() == null) {
    							caselleAttaccate[c][0] = rightBig;
    	    		    		caselleAttaccate[c][1] = upBig;
    	    		    		c++;
    						}
    						else if(f.pezzi[rightSmall][upBig].getIcon() == f.alfiereNero || f.pezzi[rightSmall][upBig].getIcon() == f.pedoneNero || f.pezzi[rightSmall][upBig].getIcon() == f.torreNera || f.pezzi[rightSmall][upBig].getIcon() == f.cavalloNero || f.pezzi[rightSmall][upBig].getIcon() == f.reginaNera || f.pezzi[rightSmall][upBig].getIcon() == f.reNero) {
    							caselleAttaccate[c][0] = rightBig;
    	    		    		caselleAttaccate[c][1] = upBig;
    	    		    		c++;
    						}
    					}
    					if(leftSmall < f.n && leftSmall >=0) {
    						if(f.pezzi[leftSmall][upBig].getIcon() == null) {
    							caselleAttaccate[c][0] = leftSmall;
    	    		    		caselleAttaccate[c][1] = upBig;
    	    		    		c++;
    						}
    						else if(f.pezzi[leftSmall][upBig].getIcon() == f.alfiereNero || f.pezzi[leftSmall][upBig].getIcon() == f.pedoneNero || f.pezzi[leftSmall][upBig].getIcon() == f.torreNera || f.pezzi[leftSmall][upBig].getIcon() == f.cavalloNero || f.pezzi[leftSmall][upBig].getIcon() == f.reginaNera || f.pezzi[leftSmall][upBig].getIcon() == f.reNero) {
    							caselleAttaccate[c][0] = leftSmall;
    	    		    		caselleAttaccate[c][1] = upBig;
    	    		    		c++;
    						}
    					}
    				}
    				if(downBig < f.n && downBig >=0) {
    					if(rightSmall < f.n && rightSmall >=0) {
    						if(f.pezzi[rightSmall][downBig].getIcon() == null) {
    							caselleAttaccate[c][0] = rightSmall;
    	    		    		caselleAttaccate[c][1] = downBig;
    	    		    		c++;
    						}
    						else if(f.pezzi[rightSmall][downBig].getIcon() == f.alfiereNero || f.pezzi[rightSmall][downBig].getIcon() == f.pedoneNero || f.pezzi[rightSmall][downBig].getIcon() == f.torreNera || f.pezzi[rightSmall][downBig].getIcon() == f.cavalloNero || f.pezzi[rightSmall][downBig].getIcon() == f.reginaNera || f.pezzi[rightSmall][downBig].getIcon() == f.reNero) {
    							caselleAttaccate[c][0] = rightSmall;
    	    		    		caselleAttaccate[c][1] = downBig;
    	    		    		c++;
    						}
    					}
    					if(leftSmall < f.n && leftSmall >=0) {
    						if(f.pezzi[leftSmall][downBig].getIcon() == null) {
    							caselleAttaccate[c][0] = leftSmall;
    	    		    		caselleAttaccate[c][1] = downBig;
    	    		    		c++;
    						}
    						else if(f.pezzi[leftSmall][downBig].getIcon() == f.alfiereNero || f.pezzi[leftSmall][downBig].getIcon() == f.pedoneNero || f.pezzi[leftSmall][downBig].getIcon() == f.torreNera || f.pezzi[leftSmall][downBig].getIcon() == f.cavalloNero || f.pezzi[leftSmall][downBig].getIcon() == f.reginaNera || f.pezzi[leftSmall][downBig].getIcon() == f.reNero) {
    							caselleAttaccate[c][0] = leftSmall;
    	    		    		caselleAttaccate[c][1] = downBig;
    	    		    		c++;
    						}
    					}
    				}
    			}
    			if(f.pezzi[x][y].getIcon() == f.reginaBianca) {
    				int east=x+1;
    				int west=x-1;
    				int north=y-1;
    				int south=y+1;
    		    	while(north>=0 && east<=7 && f.pezzi[east][north].getIcon() == null) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    		north--;
    		    		east++;
    		    	}
    		    	if(north>=0 && east<=7 && (f.pezzi[east][north].getIcon() == f.alfiereNero || f.pezzi[east][north].getIcon() == f.pedoneNero || f.pezzi[east][north].getIcon() == f.torreNera || f.pezzi[east][north].getIcon() == f.cavalloNero || f.pezzi[east][north].getIcon() == f.reginaNera || f.pezzi[east][north].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    	}
    		    	east=x+1;
    				west=x-1;
    				north=y-1;
    				south=y+1;
    		    	while(north>=0 && west>=0 && f.pezzi[west][north].getIcon() == null) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    		north--;
    		    		west--;
    		    	}
    		    	if(north>=0 && west>=0 && (f.pezzi[west][north].getIcon() == f.alfiereNero || f.pezzi[west][north].getIcon() == f.pedoneNero || f.pezzi[west][north].getIcon() == f.torreNera || f.pezzi[west][north].getIcon() == f.cavalloNero || f.pezzi[west][north].getIcon() == f.reginaNera || f.pezzi[west][north].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    	}
    		    	
    		    	east=x+1;
    				west=x-1;
    				north=y-1;
    				south=y+1;
    		    	while(south<=7 && east<=7 && f.pezzi[east][south].getIcon() == null) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    		south++;
    		    		east++;
    		    	}
    		    	if(south<=7 && east<=7 && (f.pezzi[east][south].getIcon() == f.alfiereNero || f.pezzi[east][south].getIcon() == f.pedoneNero || f.pezzi[east][south].getIcon() == f.torreNera || f.pezzi[east][south].getIcon() == f.cavalloNero || f.pezzi[east][south].getIcon() == f.reginaNera || f.pezzi[east][south].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    	}
    		    	east=x+1;
    				west=x-1;
    				north=y-1;
    				south=y+1;
    		    	while(south<=7 && west>=0 && f.pezzi[west][south].getIcon() == null) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    		south++;
    		    		west--;
    		    	}
    		    	if(south<=7 && west>=0 && (f.pezzi[west][south].getIcon() == f.alfiereNero || f.pezzi[west][south].getIcon() == f.pedoneNero || f.pezzi[west][south].getIcon() == f.torreNera || f.pezzi[west][south].getIcon() == f.cavalloNero || f.pezzi[west][south].getIcon() == f.reginaNera || f.pezzi[west][south].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    	}
    		    	east=x+1;
    				west=x-1;
    				north=y-1;
    				south=y+1;
    		    	while(north>=0 && f.pezzi[x][north].getIcon() == null) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    		north--;
    		    	}
    		    	if(north>=0 && (f.pezzi[x][north].getIcon() == f.alfiereNero || f.pezzi[x][north].getIcon() == f.pedoneNero || f.pezzi[x][north].getIcon() == f.torreNera || f.pezzi[x][north].getIcon() == f.cavalloNero || f.pezzi[x][north].getIcon() == f.reginaNera || f.pezzi[x][north].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    	}
    		    	
    		    	while(south<=7 && f.pezzi[x][south].getIcon() == null) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    		south++;
    		    	}
    		    	if(south<=7 && (f.pezzi[x][south].getIcon() == f.alfiereNero || f.pezzi[x][south].getIcon() == f.pedoneNero || f.pezzi[x][south].getIcon() == f.torreNera || f.pezzi[x][south].getIcon() == f.cavalloNero || f.pezzi[x][south].getIcon() == f.reginaNera || f.pezzi[x][south].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    	}
    		    	
    		    	while(east<=7 && f.pezzi[east][y].getIcon() == null) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    		east++;
    		    	}
    		    	if(east<=7 && (f.pezzi[east][y].getIcon() == f.alfiereNero || f.pezzi[east][y].getIcon() == f.pedoneNero || f.pezzi[east][y].getIcon() == f.torreNera || f.pezzi[east][y].getIcon() == f.cavalloNero || f.pezzi[east][y].getIcon() == f.reginaNera || f.pezzi[east][y].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    	}
    		    	
    		    	while(west>=0 && f.pezzi[west][y].getIcon() == null) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    		west--;
    		    	}
    		    	if(west>=0 && (f.pezzi[west][y].getIcon() == f.alfiereNero || f.pezzi[west][y].getIcon() == f.pedoneNero || f.pezzi[west][y].getIcon() == f.torreNera || f.pezzi[west][y].getIcon() == f.cavalloNero || f.pezzi[west][y].getIcon() == f.reginaNera || f.pezzi[west][y].getIcon() == f.reNero)) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    	}
    			}
    			if(f.pezzi[x][y].getIcon() == f.reBianco) {
    				int left=x-1;
    				int right=x+1;
    				int up=y-1;
    				int down=y+1;
    				if(!scaccoNero(x, y)) {
    					if(left < f.n && left >=0) {
    						if(f.pezzi[left][y].getIcon() == null) {
    							caselleAttaccate[c][0] = left;
    	    		    		caselleAttaccate[c][1] = y;
    	    		    		c++;
    						}
    						else if(f.pezzi[left][y].getIcon() == f.alfiereNero || f.pezzi[left][y].getIcon() == f.pedoneNero || f.pezzi[left][y].getIcon() == f.torreNera || f.pezzi[left][y].getIcon() == f.cavalloNero || f.pezzi[left][y].getIcon() == f.reginaNera) {
    							caselleAttaccate[c][0] = left;
    	    		    		caselleAttaccate[c][1] = y;
    	    		    		c++;
    						}
    						if(up < f.n && up >=0 && !scaccoNero(left, up)) {
    							if(f.pezzi[left][up].getIcon() == null) {
    								caselleAttaccate[c][0] = left;
        	    		    		caselleAttaccate[c][1] = up;
        	    		    		c++;
    							}
    							else if(f.pezzi[left][up].getIcon() == f.alfiereNero || f.pezzi[left][up].getIcon() == f.pedoneNero || f.pezzi[left][up].getIcon() == f.torreNera || f.pezzi[left][up].getIcon() == f.cavalloNero || f.pezzi[left][up].getIcon() == f.reginaNera) {
    								caselleAttaccate[c][0] = left;
        	    		    		caselleAttaccate[c][1] = up;
        	    		    		c++;
    							}
    						}
    						if(down < f.n && down >=0) {
    							if(f.pezzi[left][down].getIcon() == null) {
    								caselleAttaccate[c][0] = left;
        	    		    		caselleAttaccate[c][1] = down;
        	    		    		c++;
    							}
    							else if(f.pezzi[left][down].getIcon() == f.alfiereNero || f.pezzi[left][down].getIcon() == f.pedoneNero || f.pezzi[left][down].getIcon() == f.torreNera || f.pezzi[left][down].getIcon() == f.cavalloNero || f.pezzi[left][down].getIcon() == f.reginaNera) {
    								caselleAttaccate[c][0] = left;
        	    		    		caselleAttaccate[c][1] = down;
        	    		    		c++;
    							}
    						}
    					}
    					if(right < f.n && right >=0) {
    						if(f.pezzi[right][y].getIcon() == null) {
    							caselleAttaccate[c][0] = right;
    	    		    		caselleAttaccate[c][1] = y;
    	    		    		c++;
    						}
    						else if(f.pezzi[right][y].getIcon() == f.alfiereNero || f.pezzi[right][y].getIcon() == f.pedoneNero || f.pezzi[right][y].getIcon() == f.torreNera || f.pezzi[right][y].getIcon() == f.cavalloNero || f.pezzi[right][y].getIcon() == f.reginaNera) {
    							caselleAttaccate[c][0] = right;
    	    		    		caselleAttaccate[c][1] = y;
    	    		    		c++;
    						}
    						if(up < f.n && up >=0 && !scaccoNero(right, up)) {
    							if(f.pezzi[right][up].getIcon() == null) {
    								caselleAttaccate[c][0] = right;
        	    		    		caselleAttaccate[c][1] = y;
        	    		    		c++;
    							}
    							else if(f.pezzi[right][up].getIcon() == f.alfiereNero || f.pezzi[right][up].getIcon() == f.pedoneNero || f.pezzi[right][up].getIcon() == f.torreNera || f.pezzi[right][up].getIcon() == f.cavalloNero || f.pezzi[right][up].getIcon() == f.reginaNera) {
    								caselleAttaccate[c][0] = right;
        	    		    		caselleAttaccate[c][1] = y;
        	    		    		c++;
    							}
    						}
    						if(down < f.n && down >=0 && !scaccoNero(right, down)) {
    							if(f.pezzi[right][down].getIcon() == null) {
    								caselleAttaccate[c][0] = right;
        	    		    		caselleAttaccate[c][1] = down;
        	    		    		c++;
    							}
    							else if(f.pezzi[right][down].getIcon() == f.alfiereNero || f.pezzi[right][down].getIcon() == f.pedoneNero || f.pezzi[right][down].getIcon() == f.torreNera || f.pezzi[right][down].getIcon() == f.cavalloNero || f.pezzi[right][down].getIcon() == f.reginaNera) {
    								caselleAttaccate[c][0] = right;
        	    		    		caselleAttaccate[c][1] = down;
        	    		    		c++;
    							}
    						}
    					}
    					if(down < f.n && down >=0 && !scaccoNero(x, down)) {
    						if(f.pezzi[x][down].getIcon() == null) {
    							caselleAttaccate[c][0] = x;
    	    		    		caselleAttaccate[c][1] = down;
    	    		    		c++;
    						}
    						else if(f.pezzi[x][down].getIcon() == f.alfiereNero || f.pezzi[x][down].getIcon() == f.pedoneNero || f.pezzi[x][down].getIcon() == f.torreNera || f.pezzi[x][down].getIcon() == f.cavalloNero || f.pezzi[x][down].getIcon() == f.reginaNera) {
    							caselleAttaccate[c][0] = x;
    	    		    		caselleAttaccate[c][1] = down;
    	    		    		c++;
    						}
    					}
    					if(up < f.n && up >=0 && !scaccoNero(x, up)) {
    						if(f.pezzi[x][up].getIcon() == null) {
    							caselleAttaccate[c][0] = x;
    	    		    		caselleAttaccate[c][1] = up;
    	    		    		c++;
    						}
    						else if(f.pezzi[x][up].getIcon() == f.alfiereNero || f.pezzi[x][up].getIcon() == f.pedoneNero || f.pezzi[x][up].getIcon() == f.torreNera || f.pezzi[x][up].getIcon() == f.cavalloNero || f.pezzi[x][up].getIcon() == f.reginaNera) {
    							caselleAttaccate[c][0] = x;
    	    		    		caselleAttaccate[c][1] = up;
    	    		    		c++;
    						}
    					}
    				}
    			}
    		}
    	}
    	for(int k=0; k<c; k++) {
    		if(caselleAttaccate[k][0] == X && caselleAttaccate[k][1] == Y) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean scaccoNero(int X, int Y) {
    	int[][] caselleAttaccate = new int[126][2]; //126 stima del numero massimo che tutti i pezzi possono attaccare
    	int c=0;
    	for(int y=0; y< f.n; y++) {
    		for(int x=0; x<f.n; x++) {
    			if(f.pezzi[x][y].getIcon() == f.alfiereNero) {
    				int east=x+1;
    				int west=x-1;
    				int north=y-1;
    				int south=y+1;
    		    	while(north>=0 && east<=7 && f.pezzi[east][north].getIcon() == null) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = north;
    		    		north--;
    		    		east++;
    		    	}
    		    	if(north>=0 && east<=7 && (f.pezzi[east][north].getIcon() == f.alfiereBianco || f.pezzi[east][north].getIcon() == f.pedoneBianco || f.pezzi[east][north].getIcon() == f.torreBianca || f.pezzi[east][north].getIcon() == f.cavalloBianco || f.pezzi[east][north].getIcon() == f.reginaBianca || f.pezzi[east][north].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    	}
    		    	east=x+1;
    				west=x-1;
    				north=y-1;
    				south=y+1;
    		    	while(north>=0 && west>=0 && f.pezzi[west][north].getIcon() == null) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = north;
    		    		north--;
    		    		west--;
    		    		c++;
    		    	}
    		    	if(north>=0 && west>=0 && (f.pezzi[west][north].getIcon() == f.alfiereBianco || f.pezzi[west][north].getIcon() == f.pedoneBianco || f.pezzi[west][north].getIcon() == f.torreBianca || f.pezzi[west][north].getIcon() == f.cavalloBianco || f.pezzi[west][north].getIcon() == f.reginaBianca || f.pezzi[west][north].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    	}
    		    	
    		    	east=x+1;
    				west=x-1;
    				north=y-1;
    				south=y+1;
    		    	while(south<=7 && east<=7 && f.pezzi[east][south].getIcon() == null) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    		south++;
    		    		east++;
    		    	}
    		    	if(south<=7 && east<=7 && (f.pezzi[east][south].getIcon() == f.alfiereBianco || f.pezzi[east][south].getIcon() == f.pedoneBianco || f.pezzi[east][south].getIcon() == f.torreBianca || f.pezzi[east][south].getIcon() == f.cavalloBianco || f.pezzi[east][south].getIcon() == f.reginaBianca || f.pezzi[east][south].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    	}
    		    	east=x+1;
    				west=x-1;
    				north=y-1;
    				south=y+1;
    		    	while(south<=7 && west>=0 && f.pezzi[west][south].getIcon() == null) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    		south++;
    		    		west--;
    		    	}
    		    	if(south<=7 && west>=0 && (f.pezzi[west][south].getIcon() == f.alfiereBianco || f.pezzi[west][south].getIcon() == f.pedoneBianco || f.pezzi[west][south].getIcon() == f.torreBianca || f.pezzi[west][south].getIcon() == f.cavalloBianco || f.pezzi[west][south].getIcon() == f.reginaBianca || f.pezzi[west][south].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    	}
    			}
    			if(f.pezzi[x][y].getIcon() == f.pedoneNero) {
    				if(x != 7) {
    					caselleAttaccate[c][0] = x+1;
    		    		caselleAttaccate[c][1] = y-1;
    		    		c++;
    	        	}
    	        	if(x != 0) {
    	        		caselleAttaccate[c][0] = x-1;
    		    		caselleAttaccate[c][1] = y-1;
    		    		c++;
    	        	}
    			}
    			if(f.pezzi[x][y].getIcon() == f.torreNera) {
    				int east=x+1;
    				int west=x-1;
    				int north=y-1;
    				int south=y+1;
    		    	while(north>=0 && f.pezzi[x][north].getIcon() == null) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    		north--;
    		    	}
    		    	if(north>=0 && (f.pezzi[x][north].getIcon() == f.alfiereBianco || f.pezzi[x][north].getIcon() == f.pedoneBianco || f.pezzi[x][north].getIcon() == f.torreBianca || f.pezzi[x][north].getIcon() == f.cavalloBianco || f.pezzi[x][north].getIcon() == f.reginaBianca || f.pezzi[x][north].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    	}
    		    	
    		    	while(south<=7 && f.pezzi[x][south].getIcon() == null) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    		south++;
    		    	}
    		    	if(south<=7 && (f.pezzi[x][south].getIcon() == f.alfiereBianco || f.pezzi[x][south].getIcon() == f.pedoneBianco || f.pezzi[x][south].getIcon() == f.torreBianca || f.pezzi[x][south].getIcon() == f.cavalloBianco || f.pezzi[x][south].getIcon() == f.reginaBianca || f.pezzi[x][south].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    	}
    		    	
    		    	while(east<=7 && f.pezzi[east][y].getIcon() == null) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    		east++;
    		    	}
    		    	if(east<=7 && (f.pezzi[east][y].getIcon() == f.alfiereBianco || f.pezzi[east][y].getIcon() == f.pedoneBianco || f.pezzi[east][y].getIcon() == f.torreBianca || f.pezzi[east][y].getIcon() == f.cavalloBianco || f.pezzi[east][y].getIcon() == f.reginaBianca || f.pezzi[east][y].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    	}
    		    	
    		    	while(west>=0 && f.pezzi[west][y].getIcon() == null) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    		west--;
    		    	}
    		    	if(west>=0 && (f.pezzi[west][y].getIcon() == f.alfiereBianco || f.pezzi[west][y].getIcon() == f.pedoneBianco || f.pezzi[west][y].getIcon() == f.torreBianca || f.pezzi[west][y].getIcon() == f.cavalloBianco || f.pezzi[west][y].getIcon() == f.reginaBianca || f.pezzi[west][y].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    	}
    			}
    			if(f.pezzi[x][y].getIcon() == f.cavalloNero) {
    				int leftBig=x-2;
    				int leftSmall=x-1;
    				int rightBig=x+2;
    				int rightSmall=x+1;
    				
    				int upBig=y-2;
    				int upSmall=y-1;
    				int downBig=y+2;
    				int downSmall=y+1;
    				if(leftBig < f.n && leftBig >=0) {
    					if(upSmall < f.n && upSmall >=0) {
    						if(f.pezzi[leftBig][upSmall].getIcon() == null) {
    							caselleAttaccate[c][0] = leftBig;
    	    		    		caselleAttaccate[c][1] = upSmall;
    	    		    		c++;
    						}
    						else if(f.pezzi[leftBig][upSmall].getIcon() == f.alfiereBianco || f.pezzi[leftBig][upSmall].getIcon() == f.pedoneBianco || f.pezzi[leftBig][upSmall].getIcon() == f.torreBianca || f.pezzi[leftBig][upSmall].getIcon() == f.cavalloBianco || f.pezzi[leftBig][upSmall].getIcon() == f.reginaBianca || f.pezzi[leftBig][upSmall].getIcon() == f.reBianco) {
    							caselleAttaccate[c][0] = leftBig;
    	    		    		caselleAttaccate[c][1] = upSmall;
    	    		    		c++;
    						}
    					}
    					if(downSmall < f.n && downSmall >=0) {
    						if(f.pezzi[leftBig][downSmall].getIcon() == null) {
    							caselleAttaccate[c][0] = leftBig;
    	    		    		caselleAttaccate[c][1] = downSmall;
    	    		    		c++;
    						}
    						else if(f.pezzi[leftBig][downSmall].getIcon() == f.alfiereBianco || f.pezzi[leftBig][downSmall].getIcon() == f.pedoneBianco || f.pezzi[leftBig][downSmall].getIcon() == f.torreBianca || f.pezzi[leftBig][downSmall].getIcon() == f.cavalloBianco || f.pezzi[leftBig][downSmall].getIcon() == f.reginaBianca || f.pezzi[leftBig][downSmall].getIcon() == f.reBianco) {
    							caselleAttaccate[c][0] = leftBig;
    	    		    		caselleAttaccate[c][1] = downSmall;
    	    		    		c++;
    						}
    					}
    				}
    				if(rightBig < f.n && rightBig >=0) {
    					if(upSmall < f.n && upSmall >=0) {
    						if(f.pezzi[rightBig][upSmall].getIcon() == null) {
    							caselleAttaccate[c][0] = rightBig;
    	    		    		caselleAttaccate[c][1] = upSmall;
    	    		    		c++;
    						}
    						else if(f.pezzi[rightBig][upSmall].getIcon() == f.alfiereBianco || f.pezzi[rightBig][upSmall].getIcon() == f.pedoneBianco || f.pezzi[rightBig][upSmall].getIcon() == f.torreBianca || f.pezzi[rightBig][upSmall].getIcon() == f.cavalloBianco || f.pezzi[rightBig][upSmall].getIcon() == f.reginaBianca || f.pezzi[rightBig][upSmall].getIcon() == f.reBianco) {
    							caselleAttaccate[c][0] = rightBig;
    	    		    		caselleAttaccate[c][1] = upSmall;
    	    		    		c++;
    						}
    					}
    					if(downSmall < f.n && downSmall >=0) {
    						if(f.pezzi[rightBig][downSmall].getIcon() == null) {
    							caselleAttaccate[c][0] = rightBig;
    	    		    		caselleAttaccate[c][1] = downSmall;
    	    		    		c++;
    						}
    						else if(f.pezzi[rightBig][downSmall].getIcon() == f.alfiereBianco || f.pezzi[rightBig][downSmall].getIcon() == f.pedoneBianco || f.pezzi[rightBig][downSmall].getIcon() == f.torreBianca || f.pezzi[rightBig][downSmall].getIcon() == f.cavalloBianco || f.pezzi[rightBig][downSmall].getIcon() == f.reginaBianca || f.pezzi[rightBig][downSmall].getIcon() == f.reBianco) {
    							caselleAttaccate[c][0] = rightBig;
    	    		    		caselleAttaccate[c][1] = downSmall;
    	    		    		c++;
    						}
    					}
    				}
    				if(upBig < f.n && upBig >=0) {
    					if(rightSmall < f.n && rightSmall >=0) {
    						if(f.pezzi[rightSmall][upBig].getIcon() == null) {
    							caselleAttaccate[c][0] = rightBig;
    	    		    		caselleAttaccate[c][1] = upBig;
    	    		    		c++;
    						}
    						else if(f.pezzi[rightSmall][upBig].getIcon() == f.alfiereBianco || f.pezzi[rightSmall][upBig].getIcon() == f.pedoneBianco || f.pezzi[rightSmall][upBig].getIcon() == f.torreBianca || f.pezzi[rightSmall][upBig].getIcon() == f.cavalloBianco || f.pezzi[rightSmall][upBig].getIcon() == f.reginaBianca || f.pezzi[rightSmall][upBig].getIcon() == f.reBianco) {
    							caselleAttaccate[c][0] = rightBig;
    	    		    		caselleAttaccate[c][1] = upBig;
    	    		    		c++;
    						}
    					}
    					if(leftSmall < f.n && leftSmall >=0) {
    						if(f.pezzi[leftSmall][upBig].getIcon() == null) {
    							caselleAttaccate[c][0] = leftSmall;
    	    		    		caselleAttaccate[c][1] = upBig;
    	    		    		c++;
    						}
    						else if(f.pezzi[leftSmall][upBig].getIcon() == f.alfiereBianco || f.pezzi[leftSmall][upBig].getIcon() == f.pedoneBianco || f.pezzi[leftSmall][upBig].getIcon() == f.torreBianca || f.pezzi[leftSmall][upBig].getIcon() == f.cavalloBianco || f.pezzi[leftSmall][upBig].getIcon() == f.reginaBianca || f.pezzi[leftSmall][upBig].getIcon() == f.reBianco) {
    							caselleAttaccate[c][0] = leftSmall;
    	    		    		caselleAttaccate[c][1] = upBig;
    	    		    		c++;
    						}
    					}
    				}
    				if(downBig < f.n && downBig >=0) {
    					if(rightSmall < f.n && rightSmall >=0) {
    						if(f.pezzi[rightSmall][downBig].getIcon() == null) {
    							caselleAttaccate[c][0] = rightSmall;
    	    		    		caselleAttaccate[c][1] = downBig;
    	    		    		c++;
    						}
    						else if(f.pezzi[rightSmall][downBig].getIcon() == f.alfiereBianco || f.pezzi[rightSmall][downBig].getIcon() == f.pedoneBianco || f.pezzi[rightSmall][downBig].getIcon() == f.torreBianca || f.pezzi[rightSmall][downBig].getIcon() == f.cavalloBianco || f.pezzi[rightSmall][downBig].getIcon() == f.reginaBianca || f.pezzi[rightSmall][downBig].getIcon() == f.reBianco) {
    							caselleAttaccate[c][0] = rightSmall;
    	    		    		caselleAttaccate[c][1] = downBig;
    	    		    		c++;
    						}
    					}
    					if(leftSmall < f.n && leftSmall >=0) {
    						if(f.pezzi[leftSmall][downBig].getIcon() == null) {
    							caselleAttaccate[c][0] = leftSmall;
    	    		    		caselleAttaccate[c][1] = downBig;
    	    		    		c++;
    						}
    						else if(f.pezzi[leftSmall][downBig].getIcon() == f.alfiereBianco || f.pezzi[leftSmall][downBig].getIcon() == f.pedoneBianco || f.pezzi[leftSmall][downBig].getIcon() == f.torreBianca || f.pezzi[leftSmall][downBig].getIcon() == f.cavalloBianco || f.pezzi[leftSmall][downBig].getIcon() == f.reginaBianca || f.pezzi[leftSmall][downBig].getIcon() == f.reBianco) {
    							caselleAttaccate[c][0] = leftSmall;
    	    		    		caselleAttaccate[c][1] = downBig;
    	    		    		c++;
    						}
    					}
    				}
    			}
    			if(f.pezzi[x][y].getIcon() == f.reginaNera) {
    				int east=x+1;
    				int west=x-1;
    				int north=y-1;
    				int south=y+1;
    		    	while(north>=0 && east<=7 && f.pezzi[east][north].getIcon() == null) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    		north--;
    		    		east++;
    		    	}
    		    	if(north>=0 && east<=7 && (f.pezzi[east][north].getIcon() == f.alfiereBianco || f.pezzi[east][north].getIcon() == f.pedoneBianco || f.pezzi[east][north].getIcon() == f.torreBianca || f.pezzi[east][north].getIcon() == f.cavalloBianco || f.pezzi[east][north].getIcon() == f.reginaBianca || f.pezzi[east][north].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    	}
    		    	east=x+1;
    				west=x-1;
    				north=y-1;
    				south=y+1;
    		    	while(north>=0 && west>=0 && f.pezzi[west][north].getIcon() == null) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    		north--;
    		    		west--;
    		    	}
    		    	if(north>=0 && west>=0 && (f.pezzi[west][north].getIcon() == f.alfiereBianco || f.pezzi[west][north].getIcon() == f.pedoneBianco || f.pezzi[west][north].getIcon() == f.torreBianca || f.pezzi[west][north].getIcon() == f.cavalloBianco || f.pezzi[west][north].getIcon() == f.reginaBianca || f.pezzi[west][north].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    	}
    		    	
    		    	east=x+1;
    				west=x-1;
    				north=y-1;
    				south=y+1;
    		    	while(south<=7 && east<=7 && f.pezzi[east][south].getIcon() == null) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    		south++;
    		    		east++;
    		    	}
    		    	if(south<=7 && east<=7 && (f.pezzi[east][south].getIcon() == f.alfiereBianco || f.pezzi[east][south].getIcon() == f.pedoneBianco || f.pezzi[east][south].getIcon() == f.torreBianca || f.pezzi[east][south].getIcon() == f.cavalloBianco || f.pezzi[east][south].getIcon() == f.reginaBianca || f.pezzi[east][south].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    	}
    		    	east=x+1;
    				west=x-1;
    				north=y-1;
    				south=y+1;
    		    	while(south<=7 && west>=0 && f.pezzi[west][south].getIcon() == null) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    		south++;
    		    		west--;
    		    	}
    		    	if(south<=7 && west>=0 && (f.pezzi[west][south].getIcon() == f.alfiereBianco || f.pezzi[west][south].getIcon() == f.pedoneBianco || f.pezzi[west][south].getIcon() == f.torreBianca || f.pezzi[west][south].getIcon() == f.cavalloBianco || f.pezzi[west][south].getIcon() == f.reginaBianca || f.pezzi[west][south].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    	}
    		    	east=x+1;
    				west=x-1;
    				north=y-1;
    				south=y+1;
    		    	while(north>=0 && f.pezzi[x][north].getIcon() == null) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    		north--;
    		    	}
    		    	if(north>=0 && (f.pezzi[x][north].getIcon() == f.alfiereBianco || f.pezzi[x][north].getIcon() == f.pedoneBianco || f.pezzi[x][north].getIcon() == f.torreBianca || f.pezzi[x][north].getIcon() == f.cavalloBianco || f.pezzi[x][north].getIcon() == f.reginaBianca || f.pezzi[x][north].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = north;
    		    		c++;
    		    	}
    		    	
    		    	while(south<=7 && f.pezzi[x][south].getIcon() == null) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    		south++;
    		    	}
    		    	if(south<=7 && (f.pezzi[x][south].getIcon() == f.alfiereBianco || f.pezzi[x][south].getIcon() == f.pedoneBianco || f.pezzi[x][south].getIcon() == f.torreBianca || f.pezzi[x][south].getIcon() == f.cavalloBianco || f.pezzi[x][south].getIcon() == f.reginaBianca || f.pezzi[x][south].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = x;
    		    		caselleAttaccate[c][1] = south;
    		    		c++;
    		    	}
    		    	
    		    	while(east<=7 && f.pezzi[east][y].getIcon() == null) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    		east++;
    		    	}
    		    	if(east<=7 && (f.pezzi[east][y].getIcon() == f.alfiereBianco || f.pezzi[east][y].getIcon() == f.pedoneBianco || f.pezzi[east][y].getIcon() == f.torreBianca || f.pezzi[east][y].getIcon() == f.cavalloBianco || f.pezzi[east][y].getIcon() == f.reginaBianca || f.pezzi[east][y].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = east;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    	}
    		    	
    		    	while(west>=0 && f.pezzi[west][y].getIcon() == null) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    		west--;
    		    	}
    		    	if(west>=0 && (f.pezzi[west][y].getIcon() == f.alfiereBianco || f.pezzi[west][y].getIcon() == f.pedoneBianco || f.pezzi[west][y].getIcon() == f.torreBianca || f.pezzi[west][y].getIcon() == f.cavalloBianco || f.pezzi[west][y].getIcon() == f.reginaBianca || f.pezzi[west][y].getIcon() == f.reBianco)) {
    		    		caselleAttaccate[c][0] = west;
    		    		caselleAttaccate[c][1] = y;
    		    		c++;
    		    	}
    			}
    			if(f.pezzi[x][y].getIcon() == f.reNero) {
    				int left=x-1;
    				int right=x+1;
    				int up=y-1;
    				int down=y+1;
    					if(left < f.n && left >=0) {
    						if(f.pezzi[left][y].getIcon() == null) {
    							caselleAttaccate[c][0] = left;
    	    		    		caselleAttaccate[c][1] = y;
    	    		    		c++;
    						}
    						else if(f.pezzi[left][y].getIcon() == f.alfiereBianco || f.pezzi[left][y].getIcon() == f.pedoneBianco || f.pezzi[left][y].getIcon() == f.torreBianca || f.pezzi[left][y].getIcon() == f.cavalloBianco || f.pezzi[left][y].getIcon() == f.reginaBianca) {
    							caselleAttaccate[c][0] = left;
    	    		    		caselleAttaccate[c][1] = y;
    	    		    		c++;
    						}
    						if(up < f.n && up >=0) {
    							if(f.pezzi[left][up].getIcon() == null) {
    								caselleAttaccate[c][0] = left;
        	    		    		caselleAttaccate[c][1] = up;
        	    		    		c++;
    							}
    							else if(f.pezzi[left][up].getIcon() == f.alfiereBianco || f.pezzi[left][up].getIcon() == f.pedoneBianco || f.pezzi[left][up].getIcon() == f.torreBianca || f.pezzi[left][up].getIcon() == f.cavalloBianco || f.pezzi[left][up].getIcon() == f.reginaBianca) {
    								caselleAttaccate[c][0] = left;
        	    		    		caselleAttaccate[c][1] = up;
        	    		    		c++;
    							}
    						}
    						if(down < f.n && down >=0) {
    							if(f.pezzi[left][down].getIcon() == null) {
    								caselleAttaccate[c][0] = left;
        	    		    		caselleAttaccate[c][1] = down;
        	    		    		c++;
    							}
    							else if(f.pezzi[left][down].getIcon() == f.alfiereBianco || f.pezzi[left][down].getIcon() == f.pedoneBianco || f.pezzi[left][down].getIcon() == f.torreBianca || f.pezzi[left][down].getIcon() == f.cavalloBianco || f.pezzi[left][down].getIcon() == f.reginaBianca) {
    								caselleAttaccate[c][0] = left;
        	    		    		caselleAttaccate[c][1] = down;
        	    		    		c++;
    							}
    						}
    					}
    					if(right < f.n && right >=0) {
    						if(f.pezzi[right][y].getIcon() == null) {
    							caselleAttaccate[c][0] = right;
    	    		    		caselleAttaccate[c][1] = y;
    	    		    		c++;
    						}
    						else if(f.pezzi[right][y].getIcon() == f.alfiereBianco || f.pezzi[right][y].getIcon() == f.pedoneBianco || f.pezzi[right][y].getIcon() == f.torreBianca || f.pezzi[right][y].getIcon() == f.cavalloBianco || f.pezzi[right][y].getIcon() == f.reginaBianca) {
    							caselleAttaccate[c][0] = right;
    	    		    		caselleAttaccate[c][1] = y;
    	    		    		c++;
    						}
    						if(up < f.n && up >=0) {
    							if(f.pezzi[right][up].getIcon() == null) {
    								caselleAttaccate[c][0] = right;
        	    		    		caselleAttaccate[c][1] = y;
        	    		    		c++;
    							}
    							else if(f.pezzi[right][up].getIcon() == f.alfiereBianco || f.pezzi[right][up].getIcon() == f.pedoneBianco || f.pezzi[right][up].getIcon() == f.torreBianca || f.pezzi[right][up].getIcon() == f.cavalloBianco || f.pezzi[right][up].getIcon() == f.reginaBianca) {
    								caselleAttaccate[c][0] = right;
        	    		    		caselleAttaccate[c][1] = y;
        	    		    		c++;
    							}
    						}
    						if(down < f.n && down >=0) {
    							if(f.pezzi[right][down].getIcon() == null) {
    								caselleAttaccate[c][0] = right;
        	    		    		caselleAttaccate[c][1] = down;
        	    		    		c++;
    							}
    							else if(f.pezzi[right][down].getIcon() == f.alfiereBianco || f.pezzi[right][down].getIcon() == f.pedoneBianco || f.pezzi[right][down].getIcon() == f.torreBianca || f.pezzi[right][down].getIcon() == f.cavalloBianco || f.pezzi[right][down].getIcon() == f.reginaBianca) {
    								caselleAttaccate[c][0] = right;
        	    		    		caselleAttaccate[c][1] = down;
        	    		    		c++;
    							}
    						}
    					}
    					if(down < f.n && down >=0) {
    						if(f.pezzi[x][down].getIcon() == null) {
    							caselleAttaccate[c][0] = x;
    	    		    		caselleAttaccate[c][1] = down;
    	    		    		c++;
    						}
    						else if(f.pezzi[x][down].getIcon() == f.alfiereBianco || f.pezzi[x][down].getIcon() == f.pedoneBianco || f.pezzi[x][down].getIcon() == f.torreBianca || f.pezzi[x][down].getIcon() == f.cavalloBianco || f.pezzi[x][down].getIcon() == f.reginaBianca) {
    							caselleAttaccate[c][0] = x;
    	    		    		caselleAttaccate[c][1] = down;
    	    		    		c++;
    						}
    					}
    					if(up < f.n && up >=0) {
    						if(f.pezzi[x][up].getIcon() == null) {
    							caselleAttaccate[c][0] = x;
    	    		    		caselleAttaccate[c][1] = up;
    	    		    		c++;
    						}
    						else if(f.pezzi[x][up].getIcon() == f.alfiereBianco || f.pezzi[x][up].getIcon() == f.pedoneBianco || f.pezzi[x][up].getIcon() == f.torreBianca || f.pezzi[x][up].getIcon() == f.cavalloBianco || f.pezzi[x][up].getIcon() == f.reginaBianca) {
    							caselleAttaccate[c][0] = x;
    	    		    		caselleAttaccate[c][1] = up;
    	    		    		c++;
    						}
    					}
    			}
    		}
    	}
    	for(int k=0; k<c; k++) {
    		if(caselleAttaccate[k][0] == X && caselleAttaccate[k][1] == Y) {
    			return true;
    		}
    	}
    	return false;
    }

    public int[][] posReBianco(){
    	for(int y=0; y< f.n; y++) {
    		for(int x=0; x<f.n; x++) {
    			if(f.pezzi[x][y].getIcon() == f.reBianco) {
    				int[][] pos = new int[2][1];
    				pos[0][0] = x;
    				pos[1][0] = y;
    				return pos;
    			}
    		}
    	}
    	int[][] pos = new int[2][1];
		pos[0][0] = -1;
		pos[1][0] = -1;
    	return pos;
    }
    
    public int[][] posReNero(){
    	for(int y=0; y< f.n; y++) {
    		for(int x=0; x<f.n; x++) {
    			if(f.pezzi[x][y].getIcon() == f.reNero) {
    				int[][] pos = new int[2][1];
    				pos[0][0] = x;
    				pos[1][0] = y;
    				return pos;
    			}
    		}
    	}
    	int[][] pos = new int[2][1];
		pos[0][0] = -1;
		pos[1][0] = -1;
    	return pos;
    }
}

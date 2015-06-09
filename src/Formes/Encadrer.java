/******************************************************
Cours:  LOG121
Session: E2015
Projet: Squelette du laboratoire #1
��tudiant(e)s: Marc-Antoine H��bert

Professeur : Francis Cardinal
Nom du fichier: Rectangle.java
Date cr����: 2015-06-06
*******************************************************
Historique des modifications
*******************************************************
*@author Marc-Antoine H��bert
2015-06-06 Version initiale
*******************************************************/  
package Formes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe qui va cr��er un objet de type Rectangle selon les 
 * param��tres re��us et qui va donc permettre de dessiner 
 * un rectangle dans la fen��tre principale.
 */
public class Encadrer extends FormePrincipal{

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	
	public Encadrer(String [] tabCoord){
		if(Integer.parseInt(tabCoord[0]) < Integer.parseInt(tabCoord[2])){
			this.x1 = Integer.parseInt(tabCoord[0]);
			this.x2 = Integer.parseInt(tabCoord[2]);
		}
		else{
			this.x2 = Integer.parseInt(tabCoord[0]);
			this.x1 = Integer.parseInt(tabCoord[2]);
		}
		if(Integer.parseInt(tabCoord[1]) < Integer.parseInt(tabCoord[3])){
			this.y1 = Integer.parseInt(tabCoord[1]);
			this.y2 = Integer.parseInt(tabCoord[3]);
		}
		else{
			this.y2 = Integer.parseInt(tabCoord[1]);
			this.y1 = Integer.parseInt(tabCoord[3]);
		}
		
	}
	
	/**
	* Permet de dessiner la forme dans la fen��tre principale.
	* @param g
	*/
	public void dessinerForme(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		float dash1[] = {2.0f};
	    BasicStroke dashed =
	    new BasicStroke(1.0f,
	                        BasicStroke.CAP_BUTT,
	                        BasicStroke.JOIN_MITER,
	                        2.0f, dash1, 0.0f);
	    g2.setStroke(dashed);
		g2.setColor(Color.black);
		g2.drawRect(x1,y1,x2-x1,y2-y1);	
	}

	@Override
	public double calculeAire() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		this.x2 = x + (this.x2 - this.x1);
		this.y2 = y + (this.y2 - this.y1);
		this.x1 = x;
		this.y1 = y;
	}

	@Override
	public Encadrer getEncadree() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumSeq() {
		// TODO Auto-generated method stub
		return 0;
	}
	public double getDiagonale(){
		return Math.sqrt(((Math.pow((this.x2 - this.x1), 2)) + Math.pow((this.y2 - this.y1), 2)));
	}
	
	public int getPosition(String coord)
	{
		int coordToReturn;
		switch (coord) {
		case "x1":
			coordToReturn = this.x1;
			break;
		case "x2":
			coordToReturn = this.x2;
			break;
		case "y1":
			coordToReturn = this.y1;
			break;
		case "y2":
			coordToReturn =  this.y2;
			break;
		default:
			coordToReturn = 0;
			break;
			
		
		}
		return coordToReturn;
	}
	
	
}

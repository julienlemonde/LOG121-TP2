package Formes;
/******************************************************
Cours:  LOG121
Session: E2015
Projet: Laboratoire #2
Étudiant(e)s: Marc-Antoine Hébert
			  Alexandre Malo
			  Julien Lemonde
			  Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: Rectangle.java
Date créé: 2015-06-06
*******************************************************
Historique des modifications
*******************************************************
*@author Marc-Antoine Hébert
2015-06-06 Version initiale
*******************************************************/ 

import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe qui va créer un objet de type Rectangle selon les 
 * paramètres reçus et qui va donc permettre de dessiner 
 * un rectangle dans la fenêtre principale.
 */
public class Rectangle extends FormePrincipal{

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Encadrer Encadre;
	
	public Rectangle(ReponseTraite reponseServeurTraite, String [] tabCoord){
		numSeq = reponseServeurTraite.getID();
		nomForme = reponseServeurTraite.getTypeForme();
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
		
		Encadre = new Encadrer(tabCoord);
	}
	
	/**
	* Permet de dessiner la forme dans la fenêtre principale.
	* @param g
	*/
	public void dessinerForme(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillRect(x1,y1,x2-x1,y2-y1);	
	}
	public Encadrer getEncadree(){
		return this.Encadre;
	}
	public double calculeAire()
	{
		System.out.println("Rectangle: "+ ((x2-x1)*(y2-y1)));
		return ((x2-x1)*(y2-y1));
	}

	@Override
	public void setPosition(int x, int y) {
		this.x2 = x + (this.x2 - this.x1);
		this.y2 = y + (this.y2 - this.y1);
		this.x1 = x;
		this.y1 = y;
		this.Encadre.setPosition(x, y);
	}
	public double getDiagonale()
	{
		return this.Encadre.getDiagonale();
	}
	public int getNumSeq() {
		return numSeq;
	}
	public int getTypeForme(){
		return 200000 + numSeq;
	}
}

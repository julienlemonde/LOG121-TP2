/******************************************************
Cours:  LOG121
Session: E2015
Projet: Squelette du laboratoire #1
Étudiant(e)s: Marc-Antoine Hébert

Professeur : Francis Cardinal
Nom du fichier: Ligne.java
Date créé: 2015-06-06
*******************************************************
Historique des modifications
*******************************************************
*@author Marc-Antoine Hébert
2015-06-06 Version initiale
*******************************************************/  
package Formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe qui va créer un objet de type Ligne selon les 
 * paramètres reçus et qui va donc permettre de dessiner 
 * une ligne dans la fenêtre principale.
 */
public class Ligne extends FormePrincipal{

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Encadrer Encadre;
	
	public Ligne(Formes.ReponseTraite reponseRecu, String [] tabCoord){
		numSeq = reponseRecu.getID();
		nomForme = reponseRecu.getTypeForme();
		if(Integer.parseInt(tabCoord[0]) < Integer.parseInt(tabCoord[2])){
			this.x2 = Integer.parseInt(tabCoord[0]);
			this.x1 = Integer.parseInt(tabCoord[2]);
		}
		else{
			this.x1 = Integer.parseInt(tabCoord[0]);
			this.x2 = Integer.parseInt(tabCoord[2]);
		}
		if(Integer.parseInt(tabCoord[1]) < Integer.parseInt(tabCoord[3])){
			this.y2 = Integer.parseInt(tabCoord[1]);
			this.y1 = Integer.parseInt(tabCoord[3]);
		}
		else{
			this.y1 = Integer.parseInt(tabCoord[1]);
			this.y2 = Integer.parseInt(tabCoord[3]);
		}
		Encadre = new Encadrer(tabCoord);
	}
		
	/**
	* Permet de dessiner la forme dans la fenêtre principale.
	* @param g
	*/
	public void dessinerForme(Graphics g){		
		g.setColor(Color.GREEN);
		g.drawLine(x1,y1,x2,y2);			
	}
	public double calculeAire()
	{
		
		double distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
		System.out.println("Ligne: "+ distance);
		return 1 * distance;
	}

	@Override
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		this.x2 = x + (this.x1 - this.x2);
		this.y2 = y + (this.y1 - this.y2);
		this.x1 = x;
		this.y1 = y;
		this.Encadre.setPosition(x, y);
	}

	@Override
	public Encadrer getEncadree() {
		// TODO Auto-generated method stub
		return this.Encadre;
	}
	public int getNumSeq() {
		return numSeq;
	}
}

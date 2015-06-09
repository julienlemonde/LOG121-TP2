/******************************************************
Cours:  LOG121
Session: E2015
Projet: Squelette du laboratoire #1
Étudiant(e)s: Marc-Antoine Hébert

Professeur : Francis Cardinal
Nom du fichier: Cercle.java
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
 * Classe qui va créer un objet de type Cercle selon les 
 * paramètres reçus et qui va donc permettre de dessiner 
 * un cercle dans la fenêtre principale.
 */
public class Cercle extends FormePrincipal{

	private int x;
	private int y;
	private int rayon;
	private Encadrer Encadre;
	
	public Cercle(Formes.ReponseTraite reponseRecu, String [] tabCoord){
		numSeq = reponseRecu.getID();
		nomForme = reponseRecu.getTypeForme();
		x = Integer.parseInt(tabCoord[0]);
		y = Integer.parseInt(tabCoord[1]);
		rayon = Integer.parseInt(tabCoord[2]);
		String[] temp = new String[4];
		temp[0] = String.valueOf((Integer.parseInt(tabCoord[0])) - (this.rayon/2));
		temp[1] = String.valueOf((Integer.parseInt(tabCoord[1])) - (this.rayon/2));
		temp[2] = String.valueOf((Integer.parseInt(tabCoord[0])) + (this.rayon/2));
		temp[3] = String.valueOf((Integer.parseInt(tabCoord[1])) + (this.rayon/2));
		this.Encadre = new Encadrer(temp);
	}

	/**
	* Permet de dessiner la forme dans la fenêtre principale.
	* @param g 
	*/
	public void dessinerForme(Graphics g){ 		
		g.setColor(Color.BLUE);
		g.fillOval(x,y,rayon,rayon);
	}
	
	public double calculeAire()
	{
		System.out.println("Cercle: " + Math.PI * Math.pow(rayon/2, 2));
		return Math.PI * Math.pow(rayon/2, 2);
	}

	@Override
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
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
	public double getDiagonale()
	{
		return this.Encadre.getDiagonale();
	}
	
}

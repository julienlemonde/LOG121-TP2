/******************************************************
Cours:  LOG121
Session: E2015
Projet: Squelette du laboratoire #2
Étudiant(e)s: Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: Cercle.java
Date créé: 2013-05-03
*******************************************************
Description de la classe
Classe qui va créer un objet de type Cercle selon les 
paramètres reçus et qui va donc permettre de dessiner 
un cercle dans la fenêtre principale.
*******************************************************
*@author Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
2015-05-03 Version initiale
*******************************************************/ 
package Formes;

import java.awt.Color;
import java.awt.Graphics;

public class Cercle extends FormePrincipal{

	private int x;
	private int y;
	private int rayon;
	private Encadrer Encadre;
	
	/**
	 * Constructeur de la forme cercle
	 * @param reponseRecu Classe contenant les informations generales du cercle
	 * @param tabCoord Tableau contenant les coordonnees du cercle
	 */
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
	/**
	 * Methode pour calculer l'aire du cercle
	 */
	public double calculeAire()
	{
		return Math.PI * Math.pow(rayon/2, 2);
	}
	/**
	 * Accesseur pour changer la position de la forme
	 */
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
		this.Encadre.setPosition(x, y);
	}

	/**
	 * Retourne l'encadrer de la forme
	 */
	public Encadrer getEncadree() {
		// TODO Auto-generated method stub
		return this.Encadre;
	}
	/**
	 * Retourne le numero de sequence
	 */
	public int getNumSeq() {
		return numSeq;
	}
	/**
	 * Retourne la grande diagonale de l'encadrer du cercle
	 * @return Diagonale de la forme
	 */
	public double getDiagonale()
	{
		return this.Encadre.getDiagonale();
	}
	/**
	 * Retourne un int unique contenant le type de forme et le numero de sequence 3 pour cercle
	 * @return Numero unique d'identification des formes
	 */
	public int getTypeForme(){
		return 300000 + numSeq;
	}
}

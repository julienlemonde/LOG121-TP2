/******************************************************
Cours:  LOG121
Session: E2015
Projet: Squelette du laboratoire #2
Étudiant(e)s: Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: Ligne.java
Date créé: 2015-05-03
*******************************************************
Description de la classe
Classe qui va creer un objet de type Ligne selon les 
parametres recus et qui va donc permettre de dessiner 
une ligne dans la fenetre principale.
*******************************************************
*@author Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
2015-05-03 Version initiale
*******************************************************/
package Formes;

import java.awt.Color;
import java.awt.Graphics;



public class Ligne extends FormePrincipal{

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int oldx1;
	private int oldx2;
	private int oldy1;
	private int oldy2;
	private Encadrer Encadre;
	
	/**
	 * Constructeur de la ligne
	 * @param reponseRecu Classe contenant les caracteristiques de la ligne
	 * @param tabCoord Tableau contenant les positions de la ligne
	 */
	public Ligne(Formes.ReponseTraite reponseRecu, String [] tabCoord){
		numSeq = reponseRecu.getID();
		nomForme = reponseRecu.getTypeForme();
		
			this.x2 = Integer.parseInt(tabCoord[0]);
			this.x1 = Integer.parseInt(tabCoord[2]);
			this.y2 = Integer.parseInt(tabCoord[1]);
			this.y1 = Integer.parseInt(tabCoord[3]);
		
			// Garde en memoire les coordonnees d'origine afin de garder la bonne orientation en tout temps
			this.oldx1 = this.x1;
			this.oldx2 = this.x2;
			this.oldy1 = this.y1;
			this.oldy2 = this.y2;
		
		Encadre = new Encadrer(tabCoord);
	}
		
	/**
	* Permet de dessiner la forme dans la fen��tre principale.
	* @param g
	*/
	public void dessinerForme(Graphics g){		
		g.setColor(Color.GREEN);
		g.drawLine(x1,y1,x2,y2);			
	}
	/**
	 * Calcule l'aire de la ligne
	 */
	public double calculeAire()
	{
		
		double distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
		System.out.println("Ligne: "+ distance);
		return 1 * distance;
	}
	
	/**
	 * Mutateur pour deplacer la ligne selon des points x, y
	 */
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		
		this.Encadre.setPosition(x, y);
		
		//Verifie l'orientation de la ligne avant de changer les positions
		if(this.oldy1 < this.oldy2)
		{
			
			this.x1 = this.Encadre.getPosition("x1");
			this.y1 = this.Encadre.getPosition("y1");
			this.x2 = this.Encadre.getPosition("x2");
			this.y2 = this.Encadre.getPosition("y2");
		}
		else
		{
			this.x1 = this.Encadre.getPosition("x1");
			this.y1 = this.Encadre.getPosition("y2");
			this.x2 = this.Encadre.getPosition("x2");
			this.y2 = this.Encadre.getPosition("y1");
		}
	}
	/**
	 * Methode pour recevoir la longue diagonale de la ligne
	 * @return La valeur de la diagonale
	 */
	public double getDiagonale()
	{
		return this.Encadre.getDiagonale();
	}
	
	/**
	 * Accesseur de l'encadrer pour les lignes
	 */
	public Encadrer getEncadree() {
		// TODO Auto-generated method stub
		return this.Encadre;
	}
	/**
	 * Accesseur du numero de sequence
	 */
	public int getNumSeq() {
		return numSeq;
	}
	/**
	 * Retourne un int unique contenant le type de forme et le numero de sequence 5 pour ligne
	 * @return Numero unique d'identification des formes
	 */
	public int getTypeForme(){
		return 500000 + numSeq;
	}
}

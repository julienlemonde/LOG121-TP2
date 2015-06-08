/******************************************************
Cours:  LOG121
Session: E2015
Projet: Squelette du laboratoire #1
Étudiant(e)s: Marc-Antoine Hébert

Professeur : Francis Cardinal
Nom du fichier: Ovale.java
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
 * Classe qui va créer un objet de type Ovale selon les 
 * paramètres reçus et qui va donc permettre de dessiner 
 * une ovale dans la fenêtre principale.
 */
public class Ovale extends FormePrincipal{

	private int x;
	private int y;
	private int rayonH;
	private int rayonV;
	private Encadrer Encadre;
	
	public Ovale(Formes.ReponseTraite reponseRecu, String [] tabCoord){
		numSeq = reponseRecu.getID();
		nomForme = reponseRecu.getTypeForme();
		x = Integer.parseInt(tabCoord[0]);
		y = Integer.parseInt(tabCoord[1]);
		rayonH = Integer.parseInt(tabCoord[2]);
		rayonV = Integer.parseInt(tabCoord[3]);
		String[] temp = new String[4];
		temp[0] = String.valueOf((Integer.parseInt(tabCoord[0])) - this.rayonH/2);
		temp[1] = String.valueOf((Integer.parseInt(tabCoord[1])) - this.rayonV/2);
		temp[2] = String.valueOf((Integer.parseInt(tabCoord[0])) + this.rayonH/2);
		temp[3] = String.valueOf((Integer.parseInt(tabCoord[1])) + this.rayonV/2);
		this.Encadre = new Encadrer(temp);
	}
		
	/**
	* Permet de dessiner la forme dans la fenêtre principale.
	* @param g
	*/
	public void dessinerForme(Graphics g){
		g.setColor(Color.CYAN);
		g.fillOval(x,y,rayonH,rayonV);	
	}
	public double calculeAire()
	{
		System.out.println("Ovale: "+ Math.PI * rayonH/2 * rayonV/2);
		return Math.PI * rayonH/2 * rayonV/2;
	}

	@Override
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
		this.Encadre.setPosition(x , y);
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

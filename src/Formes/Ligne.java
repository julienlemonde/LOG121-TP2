/******************************************************
Cours:  LOG121
Session: E2015
Projet: Squelette du laboratoire #1
��tudiant(e)s: Marc-Antoine H��bert

Professeur : Francis Cardinal
Nom du fichier: Ligne.java
Date cr����: 2015-06-06
*******************************************************
Historique des modifications
*******************************************************
*@author Marc-Antoine H��bert
2015-06-06 Version initiale
*******************************************************/  
package Formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe qui va cr��er un objet de type Ligne selon les 
 * param��tres re��us et qui va donc permettre de dessiner 
 * une ligne dans la fen��tre principale.
 */
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
	
	public Ligne(Formes.ReponseTraite reponseRecu, String [] tabCoord){
		numSeq = reponseRecu.getID();
		nomForme = reponseRecu.getTypeForme();
		
			this.x2 = Integer.parseInt(tabCoord[0]);
			this.x1 = Integer.parseInt(tabCoord[2]);
			this.y2 = Integer.parseInt(tabCoord[1]);
			this.y1 = Integer.parseInt(tabCoord[3]);
		
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
	public double calculeAire()
	{
		
		double distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
		System.out.println("Ligne: "+ distance);
		return 1 * distance;
	}

	@Override
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		
		this.Encadre.setPosition(x, y);
		
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
	public double getDiagonale()
	{
		return this.Encadre.getDiagonale();
	}
	
	@Override
	public Encadrer getEncadree() {
		// TODO Auto-generated method stub
		return this.Encadre;
	}
	public int getNumSeq() {
		return numSeq;
	}
	public int getTypeForme(){
		return 500000 + numSeq;
	}
}

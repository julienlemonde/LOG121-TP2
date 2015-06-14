package Formes;
import java.awt.Color;
import java.awt.Graphics;

/******************************************************
Cours:  LOG121
Session: E2015
<<<<<<< HEAD
Projet: Laboratoire #2
Étudiant(e)s: Marc-Antoine Hébert
			  Alexandre Malo
			  Julien Lemonde
			  Jean-Michel Coupal
=======
Projet: Squelette du laboratoire #2
Étudiant(e)s: Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
>>>>>>> bbd277b40decbafc62d77589b24dd3bc4bd004db

Professeur : Francis Cardinal
Nom du fichier: Rectangle.java
Date créé: 2015-05-03
*******************************************************
Description de la classe
Classe qui va créer un objet de type Rectangle selon les 
 paramètres reçus et qui va donc permettre de dessiner 
 un rectangle dans la fenêtre principale.
*******************************************************
*@author Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
2015-05-03 Version initiale
*******************************************************/

public class Rectangle extends FormePrincipal{

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Encadrer Encadre;
	
	/**
	 * Constructeur de la forme rectangle
	 * @param reponseServeurTraite Classe contenant les caracteristiques de la forme rectangle
	 * @param tabCoord Tableau contenant les positions du rectangle
	 */
	public Rectangle(ReponseTraite reponseServeurTraite, String [] tabCoord){
		numSeq = reponseServeurTraite.getID();
		nomForme = reponseServeurTraite.getTypeForme();
		
			this.x1 = Integer.parseInt(tabCoord[0]);
			this.x2 = Integer.parseInt(tabCoord[2]);
			this.y1 = Integer.parseInt(tabCoord[1]);
			this.y2 = Integer.parseInt(tabCoord[3]);
<<<<<<< HEAD
		}
		else{
			this.y2 = Integer.parseInt(tabCoord[1]);
			this.y1 = Integer.parseInt(tabCoord[3]);
		}
=======
>>>>>>> bbd277b40decbafc62d77589b24dd3bc4bd004db
		
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
	/**
	 * Accesseur de l'encadrer de la forme rectangle
	 */
	public Encadrer getEncadree(){
		return this.Encadre;
	}
	/**
	 * Methode pour calculer l'aire du rectangle
	 */
	public double calculeAire()
	{
		return ((x2-x1)*(y2-y1));
	}

	/**
	 * Mutateur pour deplacer le rectangle selon x y
	 */
	public void setPosition(int x, int y) {
		this.x2 = x + (this.x2 - this.x1);
		this.y2 = y + (this.y2 - this.y1);
		this.x1 = x;
		this.y1 = y;
		this.Encadre.setPosition(x, y);
	}
	/**
	 * Accesseur de la longueur de la diagonale de l'encadrer du rectangle
	 * @return La longueur de la diagonale
	 */
	public double getDiagonale()
	{
		return this.Encadre.getDiagonale();
	}
	/**
	 * Accesseur du numero de sequence
	 */
	public int getNumSeq() {
		return numSeq;
	}
	/**
	 * Retourne un int unique contenant le type de forme et le numero de sequence 2 pour rectangle
	 * @return Numero unique d'identification des formes
	 */
	public int getTypeForme(){
		return 200000 + numSeq;
	}
}

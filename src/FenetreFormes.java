/******************************************************
Cours:  LOG121
Session: E2015
Projet: Laboratoire #2
Étudiant(e)s: Marc-Antoine Hébert
			  Alexandre Malo
			  Julien Lemonde
			  Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: FenetreFormes.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

import Formes.FormePrincipal;

/**
 * Cette fenêtre gère l'affichage des formes 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetreFormes extends JComponent{
	
	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500,500);
	
	private ListeDynamique liste;
	private ListeDynamique listeTriee;
		
	/**
	 * Constructeur
	 */
	public FenetreFormes(){
		liste = new ListeDynamique();
		listeTriee = new ListeDynamique();
	}
	
	/**
	 * Dessine la forme à l'aide du graphique de la forme
	 * @param g Graphique de la forme
	 */
	@Override 
	public void paintComponent(Graphics g){
		if(listeTriee.getNbELement() == 20){
			while (listeTriee.defileSansEnlever() != null){
				FormePrincipal forme = (FormePrincipal) listeTriee.defile();
				forme.dessinerForme(g);	
			}
		}
	}
	
	
	
	/**
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver 
	 * l'espace nécessaire à son affichage
	 */
	@Override 
	public Dimension getPreferredSize(){
		return dimension;
	}
	
	
	/**
	 * Ajoute les forme dans un tableau jusqu'à un total de 10,
	 * ensuite il efface la première pour la remplacer par 
	 * la nouvelle forme reçu
	 * @param forme Forme a ajouter dans le tableau
	 */
	public void ajouterForme(FormePrincipal forme){
		if(liste.getNbELement() <10)
		liste.enfile(forme);
		else
		{
			liste.vider();
			liste.enfile(forme);
		}
		this.repaint();
	}
	
	
	
	public void Trier(String methodeDeTri){
		try {
			this.listeTriee = TriSelonMenu.selection(methodeDeTri, liste);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		this.repaint();
	}

}

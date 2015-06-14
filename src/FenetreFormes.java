/******************************************************
Cours:  LOG121
Session: E2015
Projet: Squelette du laboratoire #2
Étudiant(e)s: Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: FenetreFormes.java
Date créé: 2015-05-03
*******************************************************
Description de la classe
Cette fenêtre gère l'affichage des formes 
 @author Patrice Boucher
 @Modification Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
 @date 2013/05/04
*******************************************************
*@author Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
2015-05-03 Version initiale
*******************************************************/  

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import Formes.FormePrincipal;

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
//		tabForme = new FormePrincipal[10];
//		index = 0;
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
		
	}
	/**
	 * Methode qui prend le menu qui a ete selectionner et trie la liste selon ce menu
	 * @param methodeDeTri Le nom du menu qui a ete selectionnee
	 */
	public void Trier(String methodeDeTri){
		try {
			if(this.liste.nbElement != 0)
				this.listeTriee = TriSelonMenu.selection(methodeDeTri, liste);
			else
			{
				JOptionPane.showOptionDialog(null,
		                   "Veuillez obtenir les formes avant de choisir parmis c'est options","Erreur Formes",
		                   JOptionPane.PLAIN_MESSAGE,
		                   JOptionPane.QUESTION_MESSAGE,
		                   null,
		                   null,
		                   null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.repaint();
	}


}

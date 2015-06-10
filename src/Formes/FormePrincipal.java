/******************************************************
Cours:  LOG121
Session: E2015
Projet: Laboratoire #2
Étudiant(e)s: Marc-Antoine Hébert
			  Alexandre Malo
			  Julien Lemonde
			  Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: FormePrincipal.java
Date créé: 2015-06-06
*******************************************************
Historique des modifications
*******************************************************
*@author Marc-Antoine Hébert
2015-06-06 Version initiale
*******************************************************/  
package Formes;

import java.awt.Graphics;

/**
 * 
 * Classe abstraite qui regroupe les formes
 *
 */
public abstract class FormePrincipal implements InterfaceForme {
	
	public FormePrincipal forme;
	
	protected int numSeq; 
	
	protected String nomForme; 
	
	public void dessinerForme(Graphics g) {}
	
	

}

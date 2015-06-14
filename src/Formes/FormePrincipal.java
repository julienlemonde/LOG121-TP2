/******************************************************
Cours:  LOG121
Session: E2015
Projet: Squelette du laboratoire #2
Étudiant(e)s: Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: FormePrincipal.java
Date créé: 2015-05-03
*******************************************************
Description de la classe
Classe abstraite qui regroup les formes
*******************************************************
*@author Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
2015-05-03 Version initiale
*******************************************************/
package Formes;

import java.awt.Graphics;

public abstract class FormePrincipal implements InterfaceForme {
	
	public FormePrincipal forme;
	
	protected int numSeq; 
	
	protected String nomForme; 
	
	public void dessinerForme(Graphics g) {}
	
	

}

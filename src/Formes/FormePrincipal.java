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

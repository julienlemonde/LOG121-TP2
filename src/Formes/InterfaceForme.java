/******************************************************
Cours:  LOG121
Session: E2015
Projet: Laboratoire #2
Étudiant(e)s: Marc-Antoine Hébert
			  Alexandre Malo
			  Julien Lemonde
			  Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: InterfaceForme.java
Date créé: 2015-06-06
*******************************************************
Historique des modifications
*******************************************************
*@author 
2015-06-06 Version initiale
*******************************************************/ 
package Formes;

import java.awt.Graphics;

public interface InterfaceForme {

	public void dessinerForme(Graphics g);
	public double calculeAire();
	public void setPosition(int x, int y);
	public int getNumSeq();
	public Encadrer getEncadree();
}

/******************************************************
Cours:  LOG121
Session: E2015
Projet: Squelette du laboratoire #2
Étudiant(e)s: Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: InterfaceForme.java
Date créé: 2015-06-01
*******************************************************
Description de la classe
Interface pour les types de formes
*******************************************************
*@author Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
2015-06-01 Version initiale
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

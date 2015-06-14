/******************************************************
Cours:  LOG121
Session: E2015
Projet: Squelette du laboratoire #2
Étudiant(e)s: Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: Connexion.java
Date créé: 2015-05-03
*******************************************************
Description de la classe
Cette classe représente l'application dans son ensemble. 
*******************************************************
@author Patrice Boucher
@Modification Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
@date 2013/05/04
*******************************************************/ 
public class ApplicationFormes{
	
	/**
	 * Main de l'application
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ApplicationFormes application = new ApplicationFormes();
	}
	
	/**
	 * Constructeur
	 */
	public ApplicationFormes(){
		CommBase comm = new CommBase();
		FenetrePrincipale fenetre = new FenetrePrincipale(comm);
		comm.setPropertyChangeListener(fenetre);
	}
}

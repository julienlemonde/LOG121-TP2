/******************************************************
Cours:  LOG121
Session: E2015
Projet: Squelette du laboratoire #1
Étudiant(e)s: Marc-Antoine Hébert

Professeur : Francis Cardinal
Nom du fichier: ApplicationFormes.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

/**
 * Cette classe représente l'application dans son ensemble. 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
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

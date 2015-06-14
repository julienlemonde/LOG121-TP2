/******************************************************
Cours:  LOG121
Session: E2015
Projet: Squelette du laboratoire #2
Étudiant(e)s: Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: CreateurForme.java
Date créé: 2015-05-03
*******************************************************
Description de la classe
Classe qui s'occupe de créer une nouvelle forme selon
la forme qu'elle a reçu
*******************************************************
@author Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
2015-05-03 Version initiale
*******************************************************/   

//import ca.etsmtl.log.util.IDLogger;
import Formes.Carre;
import Formes.Cercle;
import Formes.FormePrincipal;
import Formes.Ligne;
import Formes.Ovale;
import Formes.Rectangle;

/**
 * Classe qui s'occupe de créer une nouvelle forme selon
 * la forme qu'elle a reçu
 *
 */
public class CreateurForme {

	/**
	 * Methode static qui va prendre la forme du serveur et en crée une a partir des classes formes
	 * @param reponseServeurTraite Classe contenant la forme traiter par le serveur
	 * @return Une forme selon les parametres
	 */
	public static FormePrincipal creerForme(Formes.ReponseTraite reponseServeurTraite){
		//Cree un tableau avec la string de coordonnee recu
		String [] tabForme = reponseServeurTraite.getCoordonne().split(" ");
		
		FormePrincipal formeADessiner = null;
		switch (reponseServeurTraite.getTypeForme()) {
		case "RECTANGLE":
			formeADessiner = new Rectangle(reponseServeurTraite, tabForme);
			break;
		case "CARRE":
			formeADessiner= new Carre(reponseServeurTraite, tabForme);
			break;
		case "OVALE":
			formeADessiner = new Ovale(reponseServeurTraite, tabForme);
			break;
		case "LIGNE":
			formeADessiner = new Ligne(reponseServeurTraite, tabForme);
		break;
		case "CERCLE":
			formeADessiner = new Cercle(reponseServeurTraite, tabForme);
			break;
		
		default:
			break;
		}
		
		return formeADessiner;
		
		}	
	
}

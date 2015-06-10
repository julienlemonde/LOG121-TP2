/******************************************************
Cours:  LOG121
Session: E2015
Projet: Laboratoire #2
Étudiant(e)s: Marc-Antoine Hébert
			  Alexandre Malo
			  Julien Lemonde
			  Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: CreateurForme.java
Date créé: 2015-06-06
*******************************************************
Historique des modifications
*******************************************************
*@author Marc-Antoine Hébert
2015-06-06 Version initiale
*******************************************************/  

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

	public static FormePrincipal creerForme(Formes.ReponseTraite reponseServeurTraite){
		
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

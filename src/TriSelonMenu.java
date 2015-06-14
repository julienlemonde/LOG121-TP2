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

Professeur : Francis Cardinal
Nom du fichier: TriSelonMenu.java
Date créé: 2015-06-01
*******************************************************
Description de la classe
Classe Permettant de trie une liste dynamique selon un menu
*******************************************************
*@author Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
2015-06-01 Version initiale
*******************************************************/ 
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.temporal.JulianFields;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListResourceBundle;
>>>>>>> bbd277b40decbafc62d77589b24dd3bc4bd004db

Professeur : Francis Cardinal
Nom du fichier: TriSelonMenu.java
Date créé: 2015-06-06
*******************************************************
Historique des modifications
*******************************************************
*@author 
2015-06-06 Version initiale
*******************************************************/  

import java.lang.reflect.Method;
import Formes.FormePrincipal;


public class TriSelonMenu {
	
	private static final String
			
			MENU_ORDRE_NUMSEQCROIS = "app.frame.menus.order.numseqcrois",
			MENU_ORDRE_NUMSEQDECROIS = "app.frame.menus.order.numseqdecrois",
			MENU_ORDRE_AIRECROIS = "app.frame.menus.order.airecrois",
			MENU_ORDRE_AIREDECROIS = "app.frame.menus.order.airedecrois",
			MENU_ORDRE_TYPEFORME = "app.frame.menus.order.typeforme",
			MENU_ORDRE_TYPEFORMEINVERSE = "app.frame.menus.order.typeformeinverse",
			MENU_ORDRE_DISTANCEFORME = "app.frame.menus.order.distance";
	
			
	

	private static ListeDynamique listeDeFormeTriee = new ListeDynamique();
	
	/**
	 * Methode qui Trie une liste rentrer en paramètre selon le menu qui a ete selectionne
	 * @param MenuSelectionne String du menu selectionne
	 * @param listeRecu Liste de forme recu par le serveur
	 * @return Une liste de formes et d'encadrer trie et pres a etre affiche
	 * @throws Exception Exception concernant java.lang.reflect
	 */
	public static ListeDynamique selection(String MenuSelectionne, ListeDynamique listeRecu)throws Exception{
		
		//Cree une nouvelle liste et copie les formes de la liste recu par le serveur
		//Afin de ne pas modifier directement la liste
		ListeDynamique listeDeFormeRecu = new ListeDynamique();
		listeDeFormeRecu = CopierListe(listeDeFormeRecu, listeRecu);
		
		//Comparaison pour savoir laquelle des methodes de trie il faut executer selon le menu selectionne
		if (LangueConfig.getResource(MENU_ORDRE_NUMSEQCROIS).equals(MenuSelectionne)) {
			listeDeFormeTriee = numSeqCroissant(listeDeFormeRecu);
		} else if (LangueConfig.getResource(MENU_ORDRE_NUMSEQDECROIS).equals(MenuSelectionne)) {
			listeDeFormeTriee = numSeqDecroissant(listeDeFormeRecu);
		} else if (LangueConfig.getResource(MENU_ORDRE_AIRECROIS).equals(MenuSelectionne)) {
			listeDeFormeTriee = AireCroissant(listeDeFormeRecu);
		} else if (LangueConfig.getResource(MENU_ORDRE_AIREDECROIS).equals(MenuSelectionne)) {
			listeDeFormeTriee = AireDecroissant(listeDeFormeRecu);
		} else if (LangueConfig.getResource(MENU_ORDRE_TYPEFORME).equals(MenuSelectionne)) {
			listeDeFormeTriee = TypeDeForme(listeDeFormeRecu);
		} else if (LangueConfig.getResource(MENU_ORDRE_TYPEFORMEINVERSE).equals(MenuSelectionne)) {
			listeDeFormeTriee = TypeDeFormeInverse(listeDeFormeRecu);
		} else if (LangueConfig.getResource(MENU_ORDRE_DISTANCEFORME).equals(MenuSelectionne)) {
			listeDeFormeTriee = DistanceFormeDiagonale(listeDeFormeRecu);
<<<<<<< HEAD
		} 
		else {}
		
		return listeDeFormeTriee ;
	}
	private static ListeDynamique numSeqCroissant(ListeDynamique listATriee)throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "getNumSeq",true);
	}
	private static ListeDynamique numSeqDecroissant(ListeDynamique listATriee)throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "getNumSeq",false);
	}
	private static ListeDynamique AireCroissant(ListeDynamique listATriee)throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "calculeAire",true);
	}
	private static ListeDynamique AireDecroissant(ListeDynamique listATriee)throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "calculeAire", false);
	}
	private static ListeDynamique TypeDeForme(ListeDynamique listATriee) throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "getTypeForme", true); 
	}
	private static ListeDynamique TypeDeFormeInverse(ListeDynamique listATriee) throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "getTypeForme", false);
	}
=======
		} else {
		}
		//Retourne la liste prete a l'affichage
		return listeDeFormeTriee ;
	}
	/**
	 * Methode pour trier les formes selon le numero de sequence croissant
	 * @param listATriee Copie de la liste recu par le serveur
	 * @return Liste trier selon numero de sequence croissant
	 * @throws Exception java.lang.reflect
	 */
	private static ListeDynamique numSeqCroissant(ListeDynamique listATriee)throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "getNumSeq",true);
	}
	/**
	 * Methode pour trier les formes selon le numero de sequence decroissant
	 * @param listATriee Copie de la liste recu par le serveur
	 * @return Liste trier selon numero de sequence decroissant
	 * @throws Exception java.lang.reflect
	 */
	private static ListeDynamique numSeqDecroissant(ListeDynamique listATriee)throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "getNumSeq",false);
	}
	/**
	 * Methode pour trier les formes selon l'aire croissant
	 * @param listATriee Copie de la liste recu par le serveur
	 * @return Liste trier selon l'aire croissant
	 * @throws Exception java.lang.reflect
	 */
	private static ListeDynamique AireCroissant(ListeDynamique listATriee)throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "calculeAire",true);
	}
	/**
	 * Methode pour trier les formes selon l'aire decroissant
	 * @param listATriee Copie de la liste recu par le serveur
	 * @return Liste trier selon l'aire decroissant
	 * @throws Exception java.lang.reflect
	 */
	private static ListeDynamique AireDecroissant(ListeDynamique listATriee)throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "calculeAire", false);
	}
	/**
	 * Methode pour trier les formes selon le type de forme
	 * @param listATriee Copie de la liste recu par le serveur
	 * @return Liste trier selon le type de forme
	 * @throws Exception java.lang.reflect
	 */
	private static ListeDynamique TypeDeForme(ListeDynamique listATriee) throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "getTypeForme", true); 
	}
	/**
	 * Methode pour trier les formes selon le type de forme inverse
	 * @param listATriee Copie de la liste recu par le serveur
	 * @return Liste trier selon le type de forme inverse
	 * @throws Exception java.lang.reflect
	 */
	private static ListeDynamique TypeDeFormeInverse(ListeDynamique listATriee) throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "getTypeForme", false);
	}
	/**
	 * Methode pour trier les formes selon la longueur de la plus longue diagonale croissant
	 * @param listATriee Copie de la liste recu par le serveur
	 * @return Liste trier selon la longueur de la plus longue diagonale
	 * @throws Exception java.lang.reflect
	 */
>>>>>>> bbd277b40decbafc62d77589b24dd3bc4bd004db
	private static ListeDynamique DistanceFormeDiagonale(ListeDynamique listATriee)throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "getDiagonale", true);
	}
	/**
<<<<<<< HEAD
	 * 
	 * @param listATriee
	 * @return
=======
	 * Methode bien positionner les formes dans le Graphics. Elle ne trie pas la liste, elle creer les
	 * encadrer et positionne le tout
	 * @param listATriee Liste deja trier selon une des methodes de trie
	 * @return La liste prete a affichage
>>>>>>> bbd277b40decbafc62d77589b24dd3bc4bd004db
	 */
	private static ListeDynamique MettreToutBeau(ListeDynamique listATriee){
		int nbElement = listATriee.getNbELement();
		listATriee.PositionDebut();
		for (int i = 0; i < nbElement; i++) {
			int temp = i * 40;
			((FormePrincipal) (listATriee.defilePositionCourant())).setPosition(temp,temp);
			listATriee.enfile(((FormePrincipal) (listATriee.defilePositionCourant())).getEncadree());
			listATriee.suivant();
		}
		return listATriee;
		
	}
	
	/**
<<<<<<< HEAD
	 * 
	 * @param ListeARemplir
	 * @param ListeACopier
	 * @return
=======
	 * Methode pour copier les informations d'une liste dans une nouvelle
	 * @param ListeARemplir La nouvelle liste a remplir
	 * @param ListeACopier La liste contenant les informations que nous avons besoin
	 * @return Une liste contenant les informations de l'ancienne liste
>>>>>>> bbd277b40decbafc62d77589b24dd3bc4bd004db
	 */
	private static ListeDynamique CopierListe(ListeDynamique ListeARemplir, ListeDynamique ListeACopier){
		ListeARemplir = new ListeDynamique();
		int index = 0;
		while(index < ListeACopier.getNbELement())
		{
			ListeARemplir.enfile(ListeACopier.defilePositionCourant());
			ListeACopier.suivant();
			index++;
		}
		return ListeARemplir;
	}
<<<<<<< HEAD
	
	/**
	 * 
	 * @param listATriee
	 * @param ChoixMethode
	 * @param croissant
	 * @return
	 * @throws Exception
	 */
	private static ListeDynamique TrierSelonChoix(ListeDynamique listATriee, String ChoixMethode, boolean croissant) throws Exception{
=======
	/**
	 * Methode qui va trier une liste recue en parametre selon different parametre
	 * @param listATriee La liste devant etre trier
	 * @param ChoixMethode La methode des formes que nous voulons comparer
	 * @param isCroissant Indique si le trie se fait croissant ou decroissant
	 * @return Une liste prete pour l'affichage
	 * @throws Exception Java.lang.reflect
	 */
	private static ListeDynamique TrierSelonChoix(ListeDynamique listATriee, String ChoixMethode, boolean isCroissant)throws Exception{
>>>>>>> bbd277b40decbafc62d77589b24dd3bc4bd004db
		ListeDynamique listtrier = new ListeDynamique();
		FormePrincipal formeATrie;
		FormePrincipal formeAVerifier;
		double ValeurATrie;
		double ValeurAVerifier;
		
		while(listATriee.nbElement!=0){
			formeATrie = (FormePrincipal) listATriee.defile();
			
			if(listtrier.getNbELement()==0)
				listtrier.enfile(formeATrie);
			else
			{
<<<<<<< HEAD
				
				//Croissant
				if(croissant == true)
					listtrier.PositionDebut();
				//Décroissant
				if(croissant == false)
					listtrier.PositionFin();
				
				formeAVerifier = (FormePrincipal)listtrier.defilePositionCourant();
				Method methodeATrie = formeATrie.getClass().getDeclaredMethod(ChoixMethode);
				Method methodeAVerifier = formeAVerifier.getClass().getDeclaredMethod(ChoixMethode);
				try{
					ValeurATrie = (double) methodeATrie.invoke(formeATrie);
					ValeurAVerifier = (double) methodeAVerifier.invoke(formeAVerifier);
=======
			
				if(isCroissant)
				listtrier.PositionDebut();
				else
					listtrier.PositionFin();
				
				formeAVerifier = (FormePrincipal)listtrier.defilePositionCourant();
				
				Method methodeATrie = formeATrie.getClass().getDeclaredMethod(ChoixMethode, null);
				Method methodeAVerifier = formeAVerifier.getClass().getDeclaredMethod(ChoixMethode, null);
				try{
					//S'il n'y a pas d'erreur, il s'agit d'un double sinon un int qui doit etre caster en double
					ValeurATrie = (double) methodeATrie.invoke(formeATrie, null);
					ValeurAVerifier = (double) methodeAVerifier.invoke(formeAVerifier, null);
>>>>>>> bbd277b40decbafc62d77589b24dd3bc4bd004db
				}
				catch(ClassCastException e)
				{
					ValeurATrie = (double) (int)methodeATrie.invoke(formeATrie);
					ValeurAVerifier = (double) (int)methodeAVerifier.invoke(formeAVerifier);
				}
				
	
				while(ValeurATrie > ValeurAVerifier)
				{
					
<<<<<<< HEAD
					if(croissant == true)
=======
					if(isCroissant)
>>>>>>> bbd277b40decbafc62d77589b24dd3bc4bd004db
					{
						if(listtrier.getSuivantnull())
						{
							listtrier.insererApres(formeATrie);
							break;
						}
						listtrier.suivant();
					}
<<<<<<< HEAD
					
					if(croissant == false)
=======
					else
>>>>>>> bbd277b40decbafc62d77589b24dd3bc4bd004db
					{
						if(listtrier.getPrecedentnull())
						{
							listtrier.insererAvant(formeATrie);
							break;
						}
						listtrier.precedent();
					}
						
							
						formeAVerifier = (FormePrincipal)listtrier.defilePositionCourant();
						methodeAVerifier = formeAVerifier.getClass().getDeclaredMethod(ChoixMethode);
						try
						{
							ValeurAVerifier = (double) methodeAVerifier.invoke(formeAVerifier);
						}
						catch(ClassCastException e)
						{
							ValeurAVerifier = (double) (int)methodeAVerifier.invoke(formeAVerifier);
						}
						
						
					
				}
				if(ValeurATrie < ValeurAVerifier)
				{
<<<<<<< HEAD
					if(croissant == true)
						listtrier.insererAvant(formeATrie);
					if(croissant == false)
=======
					if(isCroissant)
						listtrier.insererAvant(formeATrie);
					else
>>>>>>> bbd277b40decbafc62d77589b24dd3bc4bd004db
						listtrier.insererApres(formeATrie);
						
				}
			}	
		}
<<<<<<< HEAD
		
		FormePrincipal test;
		listtrier.PositionDebut();
		for (int i = 0; i < 10; i++) {
			test = (FormePrincipal) listtrier.defilePositionCourant();
			System.out.println("-----------" + i);
			test.calculeAire();
			listtrier.suivant();
		}
=======
>>>>>>> bbd277b40decbafc62d77589b24dd3bc4bd004db
		listtrier = MettreToutBeau(listtrier);
		return listtrier;
	}
}

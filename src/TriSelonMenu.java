/******************************************************
Cours:  LOG121
Session: E2015
Projet: Laboratoire #2
Étudiant(e)s: Marc-Antoine Hébert
			  Alexandre Malo
			  Julien Lemonde
			  Jean-Michel Coupal

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
	
	
	public static ListeDynamique selection(String MenuSelectionne, ListeDynamique listeRecu)throws Exception{
		
		ListeDynamique listeDeFormeRecu = new ListeDynamique();
		listeDeFormeRecu = CopierListe(listeDeFormeRecu, listeRecu);
		
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
		} else {
		}
		return listeDeFormeTriee ;
	}
	//DONE!
	private static ListeDynamique numSeqCroissant(ListeDynamique listATriee)throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "getNumSeq","c");
	}
	//DONE!
	private static ListeDynamique numSeqDecroissant(ListeDynamique listATriee)throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "getNumSeq","d");
	}
	//DONE!
	private static ListeDynamique AireCroissant(ListeDynamique listATriee)throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "calculeAire","c");
	}
	//DONE!
	private static ListeDynamique AireDecroissant(ListeDynamique listATriee)throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "calculeAire", "d");
	}
	//DONE!
	private static ListeDynamique TypeDeForme(ListeDynamique listATriee) throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "getTypeForme", "c"); 
	}
	//DONE!
	private static ListeDynamique TypeDeFormeInverse(ListeDynamique listATriee) throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "getTypeForme", "d");
	}
	//A FAIRE
	private static ListeDynamique DistanceFormeDiagonale(ListeDynamique listATriee)throws Exception{
		return listATriee = TrierSelonChoix(listATriee, "getDiagonale", "c");
	}
	
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
	
	private static ListeDynamique TrierSelonChoix(ListeDynamique listATriee, String ChoixMethode, String ordre)throws Exception{
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
			
				if(ordre == "c")
				listtrier.PositionDebut();
				if(ordre == "d")
					listtrier.PositionFin();
				formeAVerifier = (FormePrincipal)listtrier.defilePositionCourant();
				Method methodeATrie = formeATrie.getClass().getDeclaredMethod(ChoixMethode);
				Method methodeAVerifier = formeAVerifier.getClass().getDeclaredMethod(ChoixMethode);
				try{
					ValeurATrie = (double) methodeATrie.invoke(formeATrie);
					ValeurAVerifier = (double) methodeAVerifier.invoke(formeAVerifier);
				}
				catch(ClassCastException e)
				{
					ValeurATrie = (double) (int)methodeATrie.invoke(formeATrie);
					ValeurAVerifier = (double) (int)methodeAVerifier.invoke(formeAVerifier);
				}
				
	
				while(ValeurATrie > ValeurAVerifier)
				{
					
					if(ordre == "c")
					{
						if(listtrier.getSuivantnull())
						{
							listtrier.insererApres(formeATrie);
							break;
						}
						listtrier.suivant();
					}
					if(ordre == "d")
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
					if(ordre == "c")
						listtrier.insererAvant(formeATrie);
					if(ordre == "d")
						listtrier.insererApres(formeATrie);
						
				}
			}	
		}
		
		FormePrincipal test;
		listtrier.PositionDebut();
		for (int i = 0; i < 10; i++) {
			test = (FormePrincipal) listtrier.defilePositionCourant();
			System.out.println("-----------" + i);
			test.calculeAire();
			listtrier.suivant();
		}
		listtrier = MettreToutBeau(listtrier);
		return listtrier;
	}
}

import java.lang.reflect.InvocationTargetException;
import java.time.temporal.JulianFields;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListResourceBundle;

import javax.swing.JButton;
import javax.swing.MenuSelectionManager;

import Formes.FormePrincipal;
import Formes.InterfaceForme;


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
	
	
	public static ListeDynamique selection(String MenuSelectionne, ListeDynamique listeRecu){
		
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
			TypeDeForme(listeDeFormeRecu);
		} else if (LangueConfig.getResource(MENU_ORDRE_TYPEFORMEINVERSE).equals(MenuSelectionne)) {
			TypeDeFormeInverse(listeDeFormeRecu);
		} else if (LangueConfig.getResource(MENU_ORDRE_DISTANCEFORME).equals(MenuSelectionne)) {
			listeDeFormeTriee = DistanceFormeDiagonale(listeDeFormeRecu);
		} else {
		}
		return listeDeFormeTriee ;
	}
	//DONE!
	private static ListeDynamique numSeqCroissant(ListeDynamique listATriee){
		ListeDynamique listtrier = new ListeDynamique();
		FormePrincipal formeATrie;
		FormePrincipal formeAVerifier;
		

		
		
		
		while(listATriee.nbElement!=0){
			formeATrie = (FormePrincipal) listATriee.defile();
			
			if(listtrier.getNbELement()==0)
				listtrier.enfile(formeATrie);
			else
			{
			

				listtrier.PositionDebut();
				formeAVerifier = (FormePrincipal)listtrier.defilePositionCourant();
	
				while(formeATrie.getNumSeq() > formeAVerifier.getNumSeq())
				{
					
						
						if(listtrier.getSuivantnull())
						{
							listtrier.enfile(formeATrie);
							break;
						}
						listtrier.suivant();
							
						formeAVerifier = (FormePrincipal)listtrier.defilePositionCourant();
						
					
				}
				if(formeATrie.getNumSeq() < formeAVerifier.getNumSeq())
				listtrier.insererAvant(formeATrie);
			}
			
			
		}
		FormePrincipal test;
		listtrier.PositionDebut();
		for (int i = 0; i < 10; i++) {
			test = (FormePrincipal) listtrier.defilePositionCourant();
			System.out.println("-----------" + i);
			System.out.println(test.getNumSeq());
			listtrier.suivant();
		}
		listtrier = MettreToutBeau(listtrier);
		return listtrier;
	}
	//DONE!
	private static ListeDynamique numSeqDecroissant(ListeDynamique listATriee){
		ListeDynamique listtrier = new ListeDynamique();
		FormePrincipal formeATrie;
		FormePrincipal formeAVerifier;
		
		while(listATriee.nbElement!=0){
			formeATrie = (FormePrincipal) listATriee.defile();
			
			if(listtrier.getNbELement()==0)
				listtrier.enfile(formeATrie);
			else
			{
				listtrier.PositionFin();
				formeAVerifier = (FormePrincipal)listtrier.defilePositionCourant();
				while(formeATrie.getNumSeq() > formeAVerifier.getNumSeq())
				{
					
						
						if(listtrier.getPrecedentnull())
						{
							listtrier.insererAvant(formeATrie);
							break;
						}
						listtrier.precedent();
							
						formeAVerifier = (FormePrincipal)listtrier.defilePositionCourant();
					
				}
				if(formeATrie.getNumSeq() < formeAVerifier.getNumSeq())
				listtrier.insererApres(formeATrie);
			}
			
			
		}
		FormePrincipal test;
		listtrier.PositionDebut();
		for (int i = 0; i < 10; i++) {
			test = (FormePrincipal) listtrier.defilePositionCourant();
			System.out.println("-----------" + i);
			System.out.println(test.getNumSeq());
			listtrier.suivant();
		}
		listtrier = MettreToutBeau(listtrier);
		return listtrier;
	}
	//DONE!
	private static ListeDynamique AireCroissant(ListeDynamique listATriee){
		ListeDynamique listtrier = new ListeDynamique();
		FormePrincipal formeATrie;
		FormePrincipal formeAVerifier;
		
		while(listATriee.nbElement!=0){
			formeATrie = (FormePrincipal) listATriee.defile();
			
			if(listtrier.getNbELement()==0)
				listtrier.enfile(formeATrie);
			else
			{
				listtrier.PositionDebut();
				formeAVerifier = (FormePrincipal)listtrier.defilePositionCourant();
				while(formeATrie.calculeAire() > formeAVerifier.calculeAire())
				{
					
						
						if(listtrier.getSuivantnull())
						{
							listtrier.enfile(formeATrie);
							break;
						}
						listtrier.suivant();
							
						formeAVerifier = (FormePrincipal)listtrier.defilePositionCourant();
					
				}
				if(formeATrie.calculeAire() < formeAVerifier.calculeAire())
				listtrier.insererAvant(formeATrie);
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
	//DONE!
	private static ListeDynamique AireDecroissant(ListeDynamique listATriee){
		ListeDynamique listtrier = new ListeDynamique();
		FormePrincipal formeATrie;
		FormePrincipal formeAVerifier;
		
		while(listATriee.nbElement!=0){
			formeATrie = (FormePrincipal) listATriee.defile();
			
			if(listtrier.getNbELement()==0)
				listtrier.enfile(formeATrie);
			else
			{
				listtrier.PositionFin();
				formeAVerifier = (FormePrincipal)listtrier.defilePositionCourant();
				while(formeATrie.calculeAire() > formeAVerifier.calculeAire())
				{
					
						
						if(listtrier.getPrecedentnull())
						{
							listtrier.insererAvant(formeATrie);
							break;
						}
						listtrier.precedent();
							
						formeAVerifier = (FormePrincipal)listtrier.defilePositionCourant();
					
				}
				if(formeATrie.calculeAire() < formeAVerifier.calculeAire())
				listtrier.insererApres(formeATrie);
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
	//A FAIRE
	private static ListeDynamique TypeDeForme(ListeDynamique listATriee){
		return listATriee;
	}
	//A FAIRE
	private static ListeDynamique TypeDeFormeInverse(ListeDynamique listATriee){
		return listATriee;
	}
	//DONE!
	private static ListeDynamique DistanceFormeDiagonale(ListeDynamique listATriee){
		ListeDynamique listtrier = new ListeDynamique();
		FormePrincipal formeATrie;
		FormePrincipal formeAVerifier;
		
		while(listATriee.nbElement!=0){
			formeATrie = (FormePrincipal) listATriee.defile();
			
			if(listtrier.getNbELement()==0)
				listtrier.enfile(formeATrie);
			else
			{
				listtrier.PositionDebut();
				formeAVerifier = (FormePrincipal)listtrier.defilePositionCourant();
				while(formeATrie.getEncadree().getDiagonale() > formeAVerifier.getEncadree().getDiagonale())
				{
					
						
						if(listtrier.getSuivantnull())
						{
							listtrier.enfile(formeATrie);
							break;
						}
						listtrier.suivant();
							
						formeAVerifier = (FormePrincipal)listtrier.defilePositionCourant();
					
				}
				if(formeATrie.getEncadree().getDiagonale() < formeAVerifier.getEncadree().getDiagonale())
				listtrier.insererAvant(formeATrie);
			}
			
			
		}
		FormePrincipal test;
		listtrier.PositionDebut();
		for (int i = 0; i < 10; i++) {
			test = (FormePrincipal) listtrier.defilePositionCourant();
			System.out.println("-----------" + i);
			double t = test.getEncadree().getDiagonale();
			System.out.println(t);
			listtrier.suivant();
		}
		listtrier = MettreToutBeau(listtrier);
		return listtrier;
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
	
	
	
}

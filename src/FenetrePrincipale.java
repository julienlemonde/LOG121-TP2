/******************************************************
Cours:  LOG121
Session: E2015
Projet: Squelette du laboratoire #2
Étudiant(e)s: Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: FenetrePrincipale.java
Date créé: 2015-05-03
*******************************************************
Description de la classe
Cette classe représente la fenêtre principale de l'application 
 @author Patrice Boucher
 @Modification Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
 @date 2013/05/04
*******************************************************
*@author Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
2015-06-01 Version initiale
*******************************************************/ 

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import Formes.FormePrincipal;

 
/**
 * Cette classe représente la fenêtre principale de l'application 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener{
	private static final long serialVersionUID = -1210804336046370508L;
	private FenetreFormes fenetreFormes;

	/**
	 * Constructeur
	 */
	public FenetrePrincipale(CommBase comm){
		MenuFenetre menu = new MenuFenetre(comm);
		menu.setPropertyChangeListener(this);
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH); 
		fenetreFormes = new FenetreFormes();		
		this.add(fenetreFormes, BorderLayout.CENTER); // Ajoute la fenêtre de forme à la fenêtre principale
		this.pack(); // Ajuste la dimension de la fenêtre principale selon celle de ses composants
		this.setVisible(true); // Rend la fenêtre principale visible.
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		this.addWindowListener( new WindowAdapter()
		 {
		   public void windowClosing(WindowEvent e)
		    {
		      if(CommBase.isActif()) 
		    	  Connexion.deconnexion(); //Ferme la connexion avec le serveur
		      System.exit(0);
		     }
		  });
	}
	
	
	
	// Appelé lorsque le sujet lance "firePropertyChanger"
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if(arg0.getPropertyName().equals("ENVOIE-TEST")){
			fenetreFormes.ajouterForme((FormePrincipal)arg0.getNewValue());
		}
		//Si l'argument recu est d'un bouton
		if(arg0.getPropertyName().equals("button")){
			fenetreFormes.Trier(arg0.getNewValue().toString());
		}
	}
	
	
}

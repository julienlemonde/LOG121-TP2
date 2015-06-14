/******************************************************
Cours:  LOG121
Session: E2015
Projet: Squelette du laboratoire #2
Étudiant(e)s: Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: MenuFenetre.java
Date créé: 2015-05-03
*******************************************************
Description de la classe
Cree le menu de la fenetre de l'application
*******************************************************
*@author Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
2015-05-03 Version initiale
*******************************************************/ 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;

import Formes.FormePrincipal;

public class MenuFenetre extends JMenuBar{
	

	private static final long serialVersionUID = 1536336192561843187L;
	private static final int  MENU_FICHIER_QUITTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_FICHIER_QUITTER_TOUCHE_RACC = KeyEvent.VK_Q;
	
	private static final int  MENU_FICHIER_OBTENIR_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_FICHIER_OBTENIR_TOUCHE_RACC = KeyEvent.VK_W;
	private PropertyChangeListener listener = null;
	
	
	private static final String
			MENU_FICHIER_TITRE = "app.frame.menus.file.title",
			MENU_FICHIER_OBTENIR = "app.frame.menus.file.obtain",
			MENU_FICHIER_QUITTER = "app.frame.menus.file.exit",
			
			MENU_ORDRE_TITRE = "app.frame.menus.order.title",
			MENU_ORDRE_NUMSEQCROIS = "app.frame.menus.order.numseqcrois",
			MENU_ORDRE_NUMSEQDECROIS = "app.frame.menus.order.numseqdecrois",
			MENU_ORDRE_AIRECROIS = "app.frame.menus.order.airecrois",
			MENU_ORDRE_AIREDECROIS = "app.frame.menus.order.airedecrois",
			MENU_ORDRE_TYPEFORME = "app.frame.menus.order.typeforme",
			MENU_ORDRE_TYPEFORMEINVERSE = "app.frame.menus.order.typeformeinverse",
			MENU_ORDRE_DISTANCEFORME = "app.frame.menus.order.distance",
			
			MENU_AIDE_TITRE = "app.frame.menus.help.title",
			MENU_AIDE_PROPOS = "app.frame.menus.help.about";
			
	private static final String MESSAGE_DIALOGUE_A_PROPOS = "app.frame.dialog.about";  

	private JMenuItem  obtenirMenuItem;
	private static JRadioButtonMenuItem numSeqCroisMenuRadioItem, numSeqDecroisMenuRadioItem, aireCroisMenuRadioItem, aireDecroisMenuRadioItem, typeFormeMenuRadioItem, typeFormeInverseMenuRadioItem, distanceFormeMenuRadioItem;
	private static final int DELAI_QUITTER_MSEC = 200;
	private String MenuSelectionner;
	private SwingWorker threadComm =null;
	private static boolean isActif = false;
	
 	   
	CommBase comm; // Thread pour envoyer le menu selectionner
	
	/**
	 * Constructeur
	 */
	public MenuFenetre(CommBase comm) {
		this.comm = comm;
		addMenuFichier();
		addMenuOrdre();
		addMenuAide();
	}
	public String getMenuSelected()
	{
		return MenuSelectionner;
	}
	
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}
	

	/** 
	 * Créer le menu "File". 
	 */
	protected void addMenuFichier() {
		JMenu menu = creerMenu(MENU_FICHIER_TITRE, new String[] { MENU_FICHIER_OBTENIR, MENU_FICHIER_QUITTER });
		menu.getItem(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.stop();
			    try {
						Thread.sleep(DELAI_QUITTER_MSEC);
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		obtenirMenuItem = menu.getItem(0);
		obtenirMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comm.start();
				
			
			}
		});
		
		menu.getItem(0).setAccelerator(
				KeyStroke.getKeyStroke(MENU_FICHIER_QUITTER_TOUCHE_RACC,
						MENU_FICHIER_QUITTER_TOUCHE_MASK));
		menu.getItem(1).setAccelerator(
				KeyStroke.getKeyStroke(MENU_FICHIER_OBTENIR_TOUCHE_RACC,
						MENU_FICHIER_OBTENIR_TOUCHE_MASK));
		add(menu);
	}

	/**
	 * Créer le menu "Ordre".
	 */
	protected void addMenuOrdre() {
		JMenu menu = creerMenuRadio(MENU_ORDRE_TITRE, new String[] {MENU_ORDRE_NUMSEQCROIS, MENU_ORDRE_NUMSEQDECROIS, MENU_ORDRE_AIRECROIS, MENU_ORDRE_AIREDECROIS, MENU_ORDRE_TYPEFORME, MENU_ORDRE_TYPEFORMEINVERSE, MENU_ORDRE_DISTANCEFORME});
		
		ActionListener radioActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractButton absButton = (AbstractButton) e.getSource();
				threadComm = new SwingWorker(){
					
					@Override
					protected Object doInBackground() throws Exception {
						
								if(listener!=null)
									firePropertyChange("button", null, absButton.getText()); //Donne la forme à l'observateur
										
						
						
						return 1;
					}
						
					};
				if(listener!=null)
			    threadComm.addPropertyChangeListener(listener); // La méthode "propertyChange" de ApplicationFormes sera donc appelée lorsque le SwinkWorker invoquera la méthode "firePropertyChanger" 		
				threadComm.execute(); // Lance le fil d'exécution parallèle.
				isActif = true;
			}
		};
		
		numSeqCroisMenuRadioItem.addActionListener(radioActionListener);
		numSeqDecroisMenuRadioItem.addActionListener(radioActionListener);
		aireCroisMenuRadioItem.addActionListener(radioActionListener);
		aireDecroisMenuRadioItem.addActionListener(radioActionListener);
		typeFormeMenuRadioItem.addActionListener(radioActionListener);
		typeFormeInverseMenuRadioItem.addActionListener(radioActionListener);
		distanceFormeMenuRadioItem.addActionListener(radioActionListener);
		
		add(menu);
	}
	
	
	/**
	 *  Créer le menu "Help". 
	 */
	private void addMenuAide() {
		JMenu menu = creerMenu(MENU_AIDE_TITRE, new String[] { MENU_AIDE_PROPOS });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,  LangueConfig.getResource(MESSAGE_DIALOGUE_A_PROPOS), 
						LangueConfig.getResource(MENU_AIDE_PROPOS), JOptionPane.INFORMATION_MESSAGE);
			}
		});
		add(menu);
	}


	
	/**
	 * Créer un élément de menu à partir d'un champs principal et ses éléments
	 * @param titleKey champs principal
	 * @param itemKeys éléments
	 * @return le menu
	 */
	private static JMenu creerMenu(String titleKey,String[] itemKeys) {
        JMenu menu = new JMenu(LangueConfig.getResource(titleKey));
        for(int i=0; i < itemKeys.length; ++i) {
           menu.add(new JMenuItem(LangueConfig.getResource(itemKeys[i])));
        }
        return menu;
   }
	
	
	/**
	 * Créer un élément de menu pour les méthodes de tri qui sont en JRadioButtonMenuItem
	 * @param titleKey champs principal
	 * @param itemKeys éléments
	 * @return le menu
	 */
	private static JMenu creerMenuRadio(String titleKey,String[] itemKeys) {
		ButtonGroup group = new ButtonGroup();
        JMenu menu = new JMenu(LangueConfig.getResource(titleKey));
        for(int i=0; i < itemKeys.length; ++i) {
        	JRadioButtonMenuItem button = new JRadioButtonMenuItem(LangueConfig.getResource(itemKeys[i]));
        	group.add(button);
            menu.add(button);
           
            switch (itemKeys[i]) {
			case MENU_ORDRE_NUMSEQCROIS:
				numSeqCroisMenuRadioItem = button;
				break;
			case MENU_ORDRE_NUMSEQDECROIS:
				numSeqDecroisMenuRadioItem = button;
				break;
			case MENU_ORDRE_AIRECROIS:
				aireCroisMenuRadioItem = button;
				break;
			case MENU_ORDRE_AIREDECROIS:
				aireDecroisMenuRadioItem = button;
				break;
			case MENU_ORDRE_TYPEFORME:
				typeFormeMenuRadioItem = button;
				break;
			case MENU_ORDRE_TYPEFORMEINVERSE:
				typeFormeInverseMenuRadioItem = button;
				break;
			case MENU_ORDRE_DISTANCEFORME:
				distanceFormeMenuRadioItem = button;
				break;
			default:
				break;
			}

        }
        return menu;
   }
}

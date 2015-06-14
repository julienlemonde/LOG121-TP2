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
>>>>>>> bbd277b40decbafc62d77589b24dd3bc4bd004db

Professeur : Francis Cardinal
Nom du fichier: LangueConfig.java
Date créé: 2015-05-03
*******************************************************
Description de la classe
Utilitaire pour obtenir un mot dans la langue de l'application
*******************************************************
*@author Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal
2015-06-01 Version initiale
*******************************************************/ 

import java.util.Locale;
import java.util.ResourceBundle;	

public class LangueConfig {
	
	static private final String PREFS_BUNDLE_BASENAME = "prefs";
	static private final String BUNDLE_BASENAME = "app", PREFERRED_LOCALE_KEY = "locale";
	private static ResourceBundle preferences, resources;
	static private Locale locale;
	
	static {
	      try {
	         preferences = ResourceBundle.getBundle(PREFS_BUNDLE_BASENAME);
	         locale = new Locale(preferences.getString(PREFERRED_LOCALE_KEY));
	      }
	      catch(java.util.MissingResourceException ex) {
	         System.err.println("ERROR: cannot find preferences properties file " + 
	                            BUNDLE_BASENAME);
	      }
	      try {
	         resources = ResourceBundle.getBundle(BUNDLE_BASENAME, locale);
	      }
	      catch(java.util.MissingResourceException ex) {
	         System.err.println("ERROR: cannot find properties file for " + BUNDLE_BASENAME);
	      }
	   };
	   
	   /**
	    * Retourne un mot (dans la langue de l'application) lié à un champs
	    * @param key champs
	    * @return
	    */
	   public static String getResource(String key) {
		      return (resources == null) ? null : resources.getString(key);
	   }
}

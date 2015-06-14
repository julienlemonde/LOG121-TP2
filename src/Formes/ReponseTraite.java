/******************************************************
Cours:  LOG121
Session: E2015
<<<<<<< HEAD
Projet: Laboratoire #2
Étudiant(e)s: Marc-Antoine Hébert
			  Alexandre Malo
			  Julien Lemonde
			  Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: ReponseTraite.java
Date créé: 2015-06-06
*******************************************************
Historique des modifications
*******************************************************
*@author 
2015-06-06 Version initiale
*******************************************************/
=======
Projet: Squelette du laboratoire #2
Étudiant(e)s: Julien Lemonde, Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: ReponseTraite.java
Date créé: 2015-06-01
*******************************************************
Description de la classe
Classe qui garde en memoire la reponse du serveur pouvant etre reprit plus tard
*******************************************************
*@author Julien Lemonde
2015-06-01 Version initiale
*******************************************************/
package Formes;
>>>>>>> bbd277b40decbafc62d77589b24dd3bc4bd004db

package Formes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReponseTraite {
	
	private int id;
	private String forme;
	private String coordonne;
	
	/**
	 * Constructeur de la reponse du serveur
	 * @param Balise Reponse non traiter provenant du serveur
	 */
	public ReponseTraite(String Balise)
	{
		//Definition de la facon dont la balise est constituer afin de sortir les informations
		Pattern p = Pattern.compile("(.*) <(.*)> (.*) </\\2>");
		Matcher m = p.matcher(Balise);
		
		//Si le pattern correspont avec la balise, Les valeurs vont etre rajoute au variable de la classe
		if(m.find())
		{
		id = Integer.parseInt(m.group(1));
		forme = m.group(2);
		coordonne = m.group(3);
		}
		
		
		
	}
	
	/**
	 * Accesseur du numero de sequence
	 * @return Retourne le numero de sequence en int
	 */
	public int getID()
	{
		return id;
	}
	/**
	 * Accesseur du type de forme
	 * @return Retourne le type de forme en string
	 */
	public String getTypeForme()
	{
		return forme;
	}
	/**
	 * Accesseur des coordonnes
	 * @return Retourne une string contenant les coordonnees, il ne s'agit pas encore d'un tableau
	 */
	public String getCoordonne()
	{
		return coordonne;
	}
	
	
	

}

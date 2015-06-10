/******************************************************
Cours:  LOG121
Session: E2015
Projet: Laboratoire #2
Étudiant(e)s: Marc-Antoine Hébert
			  Alexandre Malo
			  Julien Lemonde
			  Jean-Michel Coupal

Professeur : Francis Cardinal
Nom du fichier: ListeDynamique.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Marc-Antoine Hébert
2015-06-02 Version initiale
*******************************************************/
public class ListeDynamique{
    
	//Classe interne à la classe ListeDynamique
	 private class Noeud{
		 
		 public Object element;
		 public Noeud suivant;	 

		 public Noeud(Object element, Noeud lien){
			 this.element = element;
			 suivant = lien;
		 }
	 }    
	 
	 Noeud debut;
	 Noeud fin;
	 int nbElement;
	 Noeud positioncourant;
		 
	 
    /**
     * Constructeur par défaut
     */
    public ListeDynamique(){}
    
    /**
     * Met l'objet à la fin de la liste
     * @param la valeur à enfiler
     */
    public void enfile (Object element){

    	//Si la liste est vide on enfile au début de la liste
    	if(debut == null){
    		debut  = new Noeud(element, null);
    		positioncourant = debut;
    	    fin = debut;
    	}
    	
    	else {
	    	fin.suivant = new Noeud(element, null);
    	    fin = fin.suivant;
    	}
    	
    	nbElement++;
    }
    public void insererAvant(Object donnee) {
		// Cree un nouveau noeud pour copier la positionCourant
    	
		Noeud nouveau = new Noeud(positioncourant.element,positioncourant.suivant);
		// Place les nouvelles donnees dans la positionCourant
		
			if(positioncourant != fin)
			{
				positioncourant.element = donnee;
				positioncourant.suivant = nouveau;
			}
			else
			{
				fin = new Noeud(positioncourant.element, null);
				positioncourant.element = donnee;
				positioncourant.suivant = fin;
			}
			
			if(nbElement == 1)
			{
				fin = positioncourant.suivant;
				debut = positioncourant;
			}
		nbElement++;
    	
    	
	}
    
    public void insererApres(Object donnee)
    {
    	if(positioncourant != fin)
    	{
		Noeud nouveau = new Noeud(donnee,positioncourant.suivant);
		positioncourant.suivant = nouveau;
    	}
    	else
    	{
    		Noeud nouveau = new Noeud(donnee,null);
    		positioncourant.suivant = nouveau;
    		fin = nouveau;
    	}
		nbElement++;
    }
    
    public void suivant()
    {
    	if(positioncourant.suivant !=null)
    	positioncourant = positioncourant.suivant;
    	else
    		positioncourant = debut;
    }
    public void precedent()
    {
    	if(positioncourant == debut)
    		positioncourant = fin;
    	else
    	{
    		Noeud tempo = positioncourant;
    		positioncourant = debut;
    		while (positioncourant.suivant != tempo) {
			positioncourant = positioncourant.suivant;
    		}
		}
    }
    
    public void PositionDebut()
    {
    	positioncourant = debut;
    }
    public void PositionFin()
    {
    	positioncourant = fin;
    }
    

    /**
     * Retourne la valeur du début de la liste,
     * donc l'élément du début n'est plus dans la liste
     * @return le premier élément de la liste
     */
    public Object defile () {
    	Object element = null;

		element = debut.element;
		debut = debut.suivant;
		
		//S'il n'y a qu'un élément dans la liste
		if(nbElement == 1)
			fin = null;					
		
		nbElement--;
		
        return element;
    }
    
    
    
    /**
     * Retourne si la liste est vide
     * @return vrai si la liste est vide et faux sinon
     */
    public boolean estVide(){
        return debut == null;
    }
    
    /**
     * Permet de récupérer la valeur du début 
     * de la liste sans l'enlever de la liste
     * @return le premier de la liste    
     */
    public Object defileSansEnlever() {
    	
    	//S'il n'y a aucun élément dans la liste
    	if(nbElement == 0 )
    		return null;
    	else
    		return debut.element;
    }
    
    
    /**
     * Retourne le nombre d'éléments dans la liste
     * @return nombre d'éléments dans la liste
     */
    public int getNbELement(){
    	return nbElement;
    }
    public Object defilePositionCourant(){
    	if(nbElement == 0 )
    		return null;
    	else
    		return positioncourant.element;
    }
    
    public boolean getSuivantnull()
    {
    	boolean returnValue;
    	if(positioncourant.suivant == null)
    		returnValue = true;
    	else
    		returnValue = false;
    	
    	
    	
    	return returnValue;
    }
    public boolean getPrecedentnull()
    {
    	boolean returnValue;
    	if(positioncourant == debut)
    		returnValue = true;
    	else
    	{
    		returnValue = false;
    	}
		
    	return returnValue;
    }
    
    public Object defileFin(){
    	if(nbElement == 0 )
    		return null;
    	else
    		return fin.element;
    }
    
    
    /**
     * Vide la liste
     */
    public void vider() {
    	
    	debut = fin = null;
    	nbElement = 0;
    }
}
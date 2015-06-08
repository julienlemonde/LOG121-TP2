package Formes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReponseTraite {
	
	private int id;
	private String forme;
	private String coordonne;
	
	public ReponseTraite(String Balise)
	{
		Pattern p = Pattern.compile("(.*) <(.*)> (.*) </\\2>");
		Matcher m = p.matcher(Balise);
		
		if(m.find())
		{
		id = Integer.parseInt(m.group(1));
		forme = m.group(2);
		coordonne = m.group(3);
		}
		
		
		
	}
	
	
	public int getID()
	{
		return id;
	}
	public String getTypeForme()
	{
		return forme;
	}
	
	public String getCoordonne()
	{
		return coordonne;
	}
	
	
	

}

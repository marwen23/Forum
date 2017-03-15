package Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Entities.Content;
import Services.ContentServicesRemote;
import businessDelegate.ContentServicesDelegate;


public class UpdateContent {
	
	public static void main(String[] args)  {
		
		Content contentFound = ContentServicesDelegate.findContentById(2);
		contentFound.setTitle("the booooooooooo");
		
		contentFound.setTrailer("www.youtube.com");
		

		ContentServicesDelegate.updateContent(contentFound);

	}

}

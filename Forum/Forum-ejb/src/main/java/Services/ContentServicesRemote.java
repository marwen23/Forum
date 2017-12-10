package Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import Entities.Category;
import Entities.Content;
import Entities.Genre;


@Remote
public interface ContentServicesRemote {
	
	void addContent(String title, Genre genre, String description, String trailer, int yearReleased,Double rating, Category category);

	void addContentWeb(Content content);


	Content findContentById(Integer id);
	
	void deleteContent(Content content);



	void deleteContentById(Integer id);



	void updateContent(Content content);



	List<Content> findAllContents();



	Category findCategoryById(int id);




	List<Content> findContentByCategory(Category category);



	ArrayList<Content> listAlphabetically(ArrayList<Content> contents) ;

	ArrayList<Content> listByGenre(ArrayList<Content> contents);



	List <Content> findContentByTitle(String title);


}
